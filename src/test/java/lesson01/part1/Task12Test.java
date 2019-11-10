package lesson01.part1;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import util.SystemOutGatewayUtil;

import java.io.ByteArrayOutputStream;

import static org.junit.Assert.*;

public class Task12Test {
    @Test
    public void test1 () {
        lesson01.part1.Task12.main(null);
        ByteArrayOutputStream outputArray = SystemOutGatewayUtil.getOutputArray();
        String s = outputArray.toString();
        Assert.assertTrue("Message", s.contains("Яблоко"));
        Assert.assertTrue("Message", s.contains("Персик"));
        Assert.assertFalse("Message", s.contains("Каша"));
        Assert.assertFalse("Message", s.contains("Колбаса"));
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