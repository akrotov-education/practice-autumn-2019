package lesson04.part01;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import util.SystemOutGatewayUtil;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import static org.junit.Assert.*;

public class Task04Test {
    @Test
    public void test1 () {
        try {
            int[] arr = {2, 5, 7, 12, 3, 8, 9, 0, 24, 1};
            String inp = "" + arr[0];
            for(int i = 1; i < arr.length; i++) {
                inp += System.lineSeparator() + arr[i];
            }
            ByteArrayInputStream inStr = new ByteArrayInputStream(inp.getBytes());
            System.setIn(inStr);
            Task04.main(null);
            ByteArrayOutputStream outputArray = SystemOutGatewayUtil.getOutputArray();
            String[] s = outputArray.toString().trim().split("\n");
            int[] result = {1, 24, 0, 9, 8, 3, 12, 7, 5, 2};
            for(int i = 0; i < result.length; i++) {
                Assert.assertTrue("Message", Integer.parseInt(s[i].trim()) == result[i]);
            }
        } catch(Exception e) {
            System.out.println("Exception!");
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