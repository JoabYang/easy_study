package com.joab.easy.study.zookeeper.demo;

import com.alibaba.fastjson.JSON;
import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.util.concurrent.CountDownLatch;

public class ZookeeperDemo {
    public static void main(String[] args) throws Exception {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        ZooKeeper zk = new ZooKeeper("192.168.201.153:2181,192.168.201.154:2181，192.168.201.155:2181", 5000, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                countDownLatch.countDown();
            }
        });
        countDownLatch.await();
        ZooKeeper.States state = zk.getState();
        System.out.println(state);

        // 父节点不存在，则子节点创建失败
//        zk.create("/joab/y", "1".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);

        /**
         *     czxid：         创建节点的zxid
         *     mzxid：         更新节点的zxid
         *     ctime：         创建节点的时间
         *     mtime：         更新节点的时间
         *     version：       版本号(乐观锁)
         *     cversion：      子节点版本号(乐观锁)
         *     aversion;       节点ACL版本号(乐观锁)
         *     ephemeralOwner：临时节点对应的sessionId
         *     dataLength：    数据长度
         *     numChildren：   子节点个数
         *     pzxid：         父节点zxid
         */
        Stat stat = zk.exists("/joaby", null);
        System.out.println(JSON.toJSONString(stat));

        if (stat != null) {
            zk.delete("/joaby", stat.getVersion());
        }

        String result = zk.create("/joaby", "1".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        System.out.println(result);

    }
}
