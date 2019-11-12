package lesson01.part1;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import util.SystemOutGatewayUtil;

import java.io.ByteArrayOutputStream;

import static org.junit.Assert.*;

public class Task05Test {
    @Test
    public void test1 () {
        lesson01.part1.Task05.main(null);
        ByteArrayOutputStream outputArray = SystemOutGatewayUtil.getOutputArray();
        String s = outputArray.toString();
        Assert.assertTrue("Message", s.contains("9 умножить на 3 равно 27"));
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