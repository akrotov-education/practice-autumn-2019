package lesson01.part2;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import util.SystemOutGatewayUtil;

import java.io.ByteArrayOutputStream;

import static org.junit.Assert.*;

public class Task04Test {
    @Test
    public void test1 () {
        lesson01.part2.Task04.main(null);
        ByteArrayOutputStream outputArray = SystemOutGatewayUtil.getOutputArray();
        String s = outputArray.toString();
        String[] arr = s.split("\n");
        try {
            int result1 = Integer.parseInt(arr[0].replaceAll("\\s", ""));
            int result2 = Integer.parseInt(arr[1].replaceAll("\\s", ""));
            Assert.assertTrue("Message", true);
        }
        catch (NumberFormatException e) {
            Assert.assertTrue("Message", false);
        }
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