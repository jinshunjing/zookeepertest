package org.jim.zk;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

public class ZKBase {

    private ZooKeeper zk;

    public ZKBase(ZooKeeper zk) {
        this.zk = zk;
    }

    public void exists(String path) throws InterruptedException, KeeperException {
        Stat stat = zk.exists(path, false);
        if (null == stat) {
            System.out.println("Null Stat for " + path);
        } else {
            System.out.println(stat.getVersion());
            System.out.println(stat.getAversion());
            System.out.println(stat.getCversion());

            System.out.println(stat.getCzxid());
            System.out.println(stat.getMzxid());
            System.out.println(stat.getPzxid());

            System.out.println(stat.getCtime());
            System.out.println(stat.getMtime());

            System.out.println(stat.getDataLength());
            System.out.println(stat.getNumChildren());
            System.out.println(stat.getEphemeralOwner());
        }
    }

    public void save(String path) throws InterruptedException, KeeperException {
        String result = zk.create(path, new byte[0], ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        System.out.println(result);
    }

    public void saveSequential(String path, String data) throws InterruptedException, KeeperException {
        String result = zk.create(path, data.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT_SEQUENTIAL);
        System.out.println(result);
    }

    public void remove(String path) throws InterruptedException, KeeperException {
        int version = 0;
        zk.delete(path, version);
    }
}
