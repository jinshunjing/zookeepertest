package org.jim.zk.test;

import org.jim.zk.ZKBase;
import org.jim.zk.ZKConnection;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestZKBase {

    private ZKBase zkBase;

    @Before
    public void setUp() throws Exception {
        Thread.sleep(3_000L);
        System.out.println();
        System.out.println();
        zkBase = new ZKBase(ZKConnection.connect());
    }

    @After
    public void tearDown() throws Exception {
        System.out.println();
        System.out.println();
        Thread.sleep(3_000L);
    }

    @Test
    public void testExists() throws Exception {
        String path = "/test";
        zkBase.exists(path);
    }

    @Test
    public void testSave() throws Exception {
        String path = "/test";
        zkBase.save(path);
    }

    @Test
    public void testRemove() throws Exception {
        String path = "/test";
        zkBase.remove(path);

        Thread.sleep(3_000L);

        zkBase.exists(path);
    }

    @Test
    public void testDemo1() throws Exception {
        String parent = "/test";
        zkBase.save(parent);

        String child = "/room";
        String data = "Apple";
        zkBase.saveSequential(parent + child, data);
    }
}
