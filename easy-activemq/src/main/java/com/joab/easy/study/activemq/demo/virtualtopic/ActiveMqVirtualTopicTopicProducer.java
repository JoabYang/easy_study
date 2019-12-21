package com.joab.easy.study.activemq.demo.virtualtopic;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @author: yangjianbo
 * @Date: Created in 2019/12/17 15:17
 */
public class ActiveMqVirtualTopicTopicProducer {
    public static void main(String[] args) {
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://192.168.201.153:61616");
        Connection connection = null;
        try {
            // 创建连接
            connection = connectionFactory.createConnection("admin", "admin");
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
            Topic topic = session.createTopic("VirtualTopic.myTopic");

            // 创建生产者
            MessageProducer producer = session.createProducer(topic);

            // 创建消息内容: text object stream bytes map
//            for (int i = 0; i < 10; i++) {
                TextMessage message = session.createTextMessage("hello world" + 1);
                // 发送消息
                producer.send(message);
//            }

            // 提交
//            session.commit();
            // 关闭
            session.close();
        } catch (JMSException e) {
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
}
