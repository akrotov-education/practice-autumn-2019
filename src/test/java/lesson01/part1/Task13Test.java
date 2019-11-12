package lesson01.part1;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import util.SystemOutGatewayUtil;

import java.io.ByteArrayOutputStream;

import static org.junit.Assert.*;

public class Task13Test {
    @Test
    public void test1 () {
        lesson01.part1.Task13.main(null);
        ByteArrayOutputStream outputArray = SystemOutGatewayUtil.getOutputArray();
        String s = outputArray.toString();
        Assert.assertTrue("Message", s.contains("150.96"));
    }

    @Test
    public void test2 () {
        double result = lesson01.part1.Task13.getWeight(62);
        Assert.assertTrue("Message", Math.abs(result - 10.54) < 0.0001);
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