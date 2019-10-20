package lesson01.part2;

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
        try {
            lesson01.part2.Task12.main(null);
            ByteArrayOutputStream outputArray = SystemOutGatewayUtil.getOutputArray();
            String[] s = outputArray.toString().split("\n");
            int[] results = new int[2];
            for(int i = 0; i < 2; i++)
                results[i] = Integer.parseInt(s[i].replaceAll("\\s", ""));
            Assert.assertTrue("Message", true);
        }
        catch (Exception e) {
            Assert.assertTrue("Message", false);
        }
    }

    @Test
    public void test2() {
        int res1 = lesson01.part2.Task12.min(9, 15);
        int res2 = lesson01.part2.Task12.min(81, -12);
        Assert.assertTrue("Message", res1 == 9);
        Assert.assertTrue("Message", res2 == -12);
    }

    @Test
    public void test3 () {
        int res1 = lesson01.part2.Task12.min(2, 5, 22, 65);
        int res2 = lesson01.part2.Task12.min(45, -15, 20, 13);
        int res3 = lesson01.part2.Task12.min(3, 10, 1, 0);
        Assert.assertTrue("Message", res1 == 2);
        Assert.assertTrue("Message", res2 == -15);
        Assert.assertTrue("Message", res3 == 0);
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