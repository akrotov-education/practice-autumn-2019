package lesson01.part1;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import util.SystemOutGatewayUtil;

import java.io.ByteArrayOutputStream;

import static org.junit.Assert.*;

public class Task07Test {
    @Test
    public void test1 () {
        lesson01.part1.Task07.main(null);
        ByteArrayOutputStream outputArray = SystemOutGatewayUtil.getOutputArray();
        String s = outputArray.toString();
        Assert.assertTrue("Message", s.contains("105.8"));
    }

    @Test
    public void test2 () {
        double result = lesson01.part1.Task07.convertCelsiusToFahrenheit(22);
        Assert.assertTrue("Message", Math.abs(result - 71.6) < 0.0001);
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