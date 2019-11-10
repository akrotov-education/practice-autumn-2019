package lesson01.part2;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import util.SystemOutGatewayUtil;

import java.io.ByteArrayOutputStream;

import static org.junit.Assert.*;

public class Task03Test {
    @Test
    public void test1 () {
        lesson01.part2.Task03.main(null);
        ByteArrayOutputStream outputArray = SystemOutGatewayUtil.getOutputArray();
        String s = outputArray.toString().replaceAll("\\D", "");
        Assert.assertTrue("Message", Integer.parseInt(s) == 800);
    }

    @Test
    public void test2 () {
        lesson01.part2.Task03.hackSalary(950);
        ByteArrayOutputStream outputArray = SystemOutGatewayUtil.getOutputArray();
        String s = outputArray.toString().replaceAll("\\D", "");
        Assert.assertTrue("Message", Integer.parseInt(s) == 1050);
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