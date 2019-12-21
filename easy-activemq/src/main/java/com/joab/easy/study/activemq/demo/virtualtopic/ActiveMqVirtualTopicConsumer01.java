package com.joab.easy.study.activemq.demo.virtualtopic;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.io.IOException;

/**
 * @author: yangjianbo
 * @Date: Created in 2019/12/17 15:17
 */
public class ActiveMqVirtualTopicConsumer01 {

    public static void main(String[] args) {
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://192.168.201.153:61616");
        Connection connection = null;
        try {
            // 创建连接
            connection = connectionFactory.createConnection("admin", "admin");
//            connection.setClientID("0");

            // 开启连接
            connection.start();

            // 创建会话
            // param1: true代表事物会话，false代表非事物会话
            // param2: Session.AUTO_ACKNOWLEDGE: 非事物会话自动确认
            //         Session.CLIENT_ACKNOWLEDGE: 客户端手动确认
            //         Session.DUPS_OK_ACKNOWLEDGE: 客户端手动确认
            Session session = connection.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE);

            // 创建消息类型: createQueue(point to point)
            //               createTopic(pub/sub)
            Queue queue = session.createQueue("Consumer.0.VirtualTopic.myTopic");

            // 创建消费者（no clientId）
            consumeWithoutClientId(session, queue);
            // 创建消费者（clientId）
//            consumeWithClientId(session, topic);

            // 接收消息
//            TextMessage receive = (TextMessage) subscriber.receive();
//            System.out.println(receive.getText());

            System.in.read();
            // 提交
//            session.commit();
            // 关闭
            session.close();
        } catch (JMSException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        }


    }

    // 创建消费者（no clientId）
    private static void consumeWithoutClientId(Session session, Destination destination) throws JMSException {
        MessageConsumer consumer = session.createConsumer(destination);
        while (true) {
            consumer.setMessageListener(new Listener());
        }
    }

    // 创建消费者（clientId）
    private static void consumeWithClientId(Session session, Topic topic) throws JMSException {
        TopicSubscriber subscriber = session.createDurableSubscriber(topic, "j-1");
        while (true) {
            subscriber.setMessageListener(new Listener());
        }
    }

    static class Listener implements MessageListener {
        @Override
        public void onMessage(Message message) {
            TextMessage textMessage = (TextMessage) message;
            try {
                System.out.println(textMessage.getText());
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }
    }
}
