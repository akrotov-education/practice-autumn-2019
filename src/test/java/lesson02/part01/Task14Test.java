package lesson02.part01;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import util.SystemOutGatewayUtil;

import java.io.ByteArrayOutputStream;

import static org.junit.Assert.*;

public class Task14Test {
    @Test
    public void test1 () {
        Task14.main(null);
        ByteArrayOutputStream outputArray = SystemOutGatewayUtil.getOutputArray();
        String[] s = outputArray.toString().split("\n");
        Assert.assertTrue("Message", s.length == 7);
        Assert.assertTrue("Message", s[0].contains("Red"));
        Assert.assertTrue("Message", s[1].contains("Orange"));
        Assert.assertTrue("Message", s[2].contains("Yellow"));
        Assert.assertTrue("Message", s[3].contains("Green"));
        Assert.assertTrue("Message", s[4].contains("Blue"));
        Assert.assertTrue("Message", s[5].contains("Indigo"));
        Assert.assertTrue("Message", s[6].contains("Violet"));
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