package org.jim.zk.test;

import org.jim.zk.ZKConnection;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class TestZKConnection {

    @Before
    public void setUp() throws Exception {
        Thread.sleep(3_000L);
        System.out.println();
    }

    @After
    public void tearDown() throws Exception {
        System.out.println();
        Thread.sleep(3_000L);
    }

    @Test
    public void testConnect() throws Exception {
        ZKConnection.connect();
    }

}
