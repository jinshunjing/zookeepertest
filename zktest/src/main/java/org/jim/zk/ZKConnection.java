package org.jim.zk;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;

public class ZKConnection {

    public static ZooKeeper connect() throws IOException {
        String hostPort = "localhost:2181";
        int timeout = 10_000;
        ZooKeeper zk = new ZooKeeper(hostPort, timeout, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                System.out.println(watchedEvent.getPath());
                System.out.println(watchedEvent.getState());
                System.out.println(watchedEvent.getType());
                System.out.println(watchedEvent.getWrapper());
            }
        });
        return zk;
    }

}
