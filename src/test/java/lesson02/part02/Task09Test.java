package test.java.lesson02.part02;


import main.java.lesson02.part02.Task09;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import test.java. util.SystemOutGatewayUtil;

import java.io.ByteArrayOutputStream;

import static org.junit.Assert.*;

public class Task09Test {
    @Test
    public void test1 () {
        Task09.main(null);
        ByteArrayOutputStream outputArray = SystemOutGatewayUtil.getOutputArray();
        String s = outputArray.toString().replaceAll("\\s", "");
        SystemOutGatewayUtil.clearOutput();

        try {
            Integer.parseInt(s);
        }
        catch (Exception e) {
            Assert.assertTrue("Message", false);
        }
    }

    @Test
    public void test2 () {
        Task09.displayClosestToTen(11, 2);
        ByteArrayOutputStream outputArray = SystemOutGatewayUtil.getOutputArray();
        String s = outputArray.toString().replaceAll("\\s", "");
        Assert.assertEquals( 11,Integer.parseInt(s));
    }
    @Test
    public void test3 () {
        Assert.assertTrue("Message", Task09.abs(-45) == 45);
        Assert.assertTrue("Message", Task09.abs(15) == 15);
    }

    @Before
    public void before() {
        SystemOutGatewayUtil.setCustomOut();
    }

    @After
    public void after() {
        SystemOutGatewayUtil.getOutputArray();
    }
}