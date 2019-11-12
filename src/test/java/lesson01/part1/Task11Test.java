package lesson01.part1;

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
        lesson01.part1.Task11.main(null);
        ByteArrayOutputStream outputArray = SystemOutGatewayUtil.getOutputArray();
        String s = outputArray.toString().replaceAll("\\s", "");
        long result = Long.parseLong(s);
        Assert.assertTrue("Message", result == 250000);
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