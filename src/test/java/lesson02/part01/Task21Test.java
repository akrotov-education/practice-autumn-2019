package lesson02.part01;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import util.SystemOutGatewayUtil;

import java.io.ByteArrayOutputStream;

import static org.junit.Assert.*;

public class Task21Test {
    @Test
    public void test1 () {
        Task21.main(null);
        ByteArrayOutputStream outputArray = SystemOutGatewayUtil.getOutputArray();
        String[] s = outputArray.toString().split("\n");
        Assert.assertTrue("Message", s.length == 10);
        for(int i = 0; i < s.length; i++) {
            Assert.assertTrue("Message", s[i].startsWith("Я хочу"));
            Assert.assertTrue("Message", s[i].contains("изучаю Java"));
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