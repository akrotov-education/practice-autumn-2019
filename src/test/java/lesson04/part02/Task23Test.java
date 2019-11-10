package lesson04.part02;

import lesson04.part01.Task01;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import util.SystemOutGatewayUtil;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import static org.junit.Assert.*;

public class Task23Test {
    @Test
    public void test1 () {
        try {
            Task23.main(null);
            ByteArrayOutputStream outputArray = SystemOutGatewayUtil.getOutputArray();
            String[] s = outputArray.toString().trim().split("\n");
            Assert.assertTrue("Message", s.length == 10);
            for(int i = 0; i < s.length; i++) {
                String[] str = s[i].split("-");
                Assert.assertTrue("Message", str.length == 2);
                Assert.assertTrue("Message", str[1].trim().equals(str[0].trim().toUpperCase()));
            }
        } catch(Exception e) {
            System.out.println("Exception!");
            Assert.assertTrue("Message", false);
        }
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