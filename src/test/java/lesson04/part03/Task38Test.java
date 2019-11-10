package lesson04.part03;

import lesson04.part01.Task01;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import util.SystemOutGatewayUtil;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import static org.junit.Assert.*;

public class Task38Test {
    @Test
    public void test1 () {
        try {
            Task38.main(null);
            ByteArrayOutputStream outputArray = SystemOutGatewayUtil.getOutputArray();
            String[] s = outputArray.toString().trim().split(": ");
            Assert.assertTrue("Message", s.length == 3);
        } catch(Exception e) {
            System.out.println("Exception!");
            Assert.assertTrue("Message", false);
        }
    }

    @Test
    public void test2() {
        Task38.log("hi");
        ByteArrayOutputStream outputArray = SystemOutGatewayUtil.getOutputArray();
        String[] s = outputArray.toString().trim().split(": ");
        Assert.assertTrue("Message", s[0].contains("Task38Test"));
        Assert.assertTrue("Message", s[1].contains("test2"));
        Assert.assertTrue("Message", s[2].contains("hi"));
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