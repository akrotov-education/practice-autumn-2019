package lesson01.part1;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import util.SystemOutGatewayUtil;

import java.io.ByteArrayOutputStream;

import static org.junit.Assert.*;

public class Task08Test {
    @Test
    public void test1 () {
        lesson01.part1.Task08.main(null);
        ByteArrayOutputStream outputArray = SystemOutGatewayUtil.getOutputArray();
        String s = outputArray.toString();
        Assert.assertTrue("Message", s.contains("2"));
    }

    @Test
    public void test2 () {
        int result = lesson01.part1.Task08.getMetreFromCentimetre(5690);
        Assert.assertTrue("Message", result == 56);
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