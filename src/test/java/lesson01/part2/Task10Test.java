package lesson01.part2;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import util.SystemOutGatewayUtil;

import java.io.ByteArrayOutputStream;

import static org.junit.Assert.*;

public class Task10Test {
    @Test
    public void test1 () {
        lesson01.part2.Task10.main(null);
        ByteArrayOutputStream outputArray = SystemOutGatewayUtil.getOutputArray();
        String[] s = outputArray.toString().split("\n");
        try {
            int[] results = new int[3];
            for(int i = 0; i < 3; i++)
                results[i] = Integer.parseInt(s[i].replaceAll("\\s", ""));
            Assert.assertTrue("Message", true);
        }
        catch (NumberFormatException e) {
            Assert.assertTrue("Message", false);
        }
    }

    @Test
    public void test2 () {
        int res1 = lesson01.part2.Task10.min(9, 15);
        int res2 = lesson01.part2.Task10.min(81, -12);
        Assert.assertTrue("Message", res1 == 9);
        Assert.assertTrue("Message", res2 == -12);
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