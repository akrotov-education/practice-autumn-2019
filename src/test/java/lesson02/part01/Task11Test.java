package lesson02.part01;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import util.SystemOutGatewayUtil;

import java.io.ByteArrayOutputStream;

import static org.junit.Assert.*;

public class Task11Test {
    @Test
    public void test1 () {
        Task11.main(null);
        ByteArrayOutputStream outputArray = SystemOutGatewayUtil.getOutputArray();
        String[] s = outputArray.toString().split("\n");
        Assert.assertTrue("Message", s.length == 2);
        try {
            int[] results = new int[2];
            results[0] = Integer.parseInt(s[0].replaceAll("\\s", ""));
            results[1] = Integer.parseInt(s[1].replaceAll("\\s", ""));
            Assert.assertTrue("Message", true);
        }
        catch (Exception e) {
            Assert.assertTrue("Message", false);
        }
    }

    @Test
    public void test2 () {
        int result = Task11.convertToSeconds(9);
        Assert.assertTrue("Message", result == 32400);
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