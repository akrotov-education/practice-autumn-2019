package lesson01.part2;

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
        lesson01.part2.Task11.main(null);
        ByteArrayOutputStream outputArray = SystemOutGatewayUtil.getOutputArray();
        String[] s = outputArray.toString().split("\n");
        try {
            int[] results = new int[4];
            for(int i = 0; i < 4; i++)
                results[i] = Integer.parseInt(s[i].replaceAll("\\s", ""));
            Assert.assertTrue("Message", true);
        }
        catch (NumberFormatException e) {
            Assert.assertTrue("Message", false);
        }
    }

    @Test
    public void test2 () {
        int res1 = lesson01.part2.Task11.min(2, 5, 22);
        int res2 = lesson01.part2.Task11.min(45, -15, 20);
        int res3 = lesson01.part2.Task11.min(3, 10, 1);
        Assert.assertTrue("Message", res1 == 2);
        Assert.assertTrue("Message", res2 == -15);
        Assert.assertTrue("Message", res3 == 1);
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