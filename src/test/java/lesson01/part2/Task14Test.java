package lesson01.part2;

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
        lesson01.part2.Task14.main(null);
        ByteArrayOutputStream outputArray = SystemOutGatewayUtil.getOutputArray();
        String[] s = outputArray.toString().split("\n");
        Assert.assertTrue("Message", s.length == 2);
    }

    @Test
    public void test2 () {
        lesson01.part2.Task14.print3("Test str");
        ByteArrayOutputStream outputArray = SystemOutGatewayUtil.getOutputArray();
        String[] s = outputArray.toString().split("Test str");
        Assert.assertTrue("Message", s.length - 1 == 3);
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