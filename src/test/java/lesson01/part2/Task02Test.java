package lesson01.part2;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import util.SystemOutGatewayUtil;

import java.io.ByteArrayOutputStream;

import static org.junit.Assert.*;

public class Task02Test {
    @Test
    public void test1 () {
        lesson01.part2.Task02.main(null);
        ByteArrayOutputStream outputArray = SystemOutGatewayUtil.getOutputArray();
        String s = outputArray.toString();
        String[] arr = s.split("\n");
        int[] answers = {2, 1, 0};
        for(int i = 0; i < 3; i++) {
            int result = Integer.parseInt(arr[i].replaceAll("\\s", ""));
            Assert.assertTrue("Message", result == answers[i]);
        }
    }

    @Test
    public void test2 () {
        lesson01.part2.Task02.div(13, 3);
        ByteArrayOutputStream outputArray = SystemOutGatewayUtil.getOutputArray();
        String s = outputArray.toString().replaceAll("\\s", "");
        int result = Integer.parseInt(s);
        Assert.assertTrue("Message", result == 4);
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