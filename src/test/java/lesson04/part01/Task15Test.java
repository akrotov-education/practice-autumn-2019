package lesson04.part01;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import util.SystemOutGatewayUtil;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import static org.junit.Assert.*;

public class Task15Test {
    @Test
    public void test1 () {
        try {
            int[] arr = {4, 6, 12, 9, 0, 5, 34, 6, 89, -1};
            String inp = "" + arr[0];
            for(int i = 1; i < arr.length; i++) {
                inp += System.lineSeparator() + arr[i];
            }
            ByteArrayInputStream inStr = new ByteArrayInputStream(inp.getBytes());
            System.setIn(inStr);
            Task15.main(null);
            ByteArrayOutputStream outputArray = SystemOutGatewayUtil.getOutputArray();
            String[] s = outputArray.toString().trim().split("\n");
            String[] result = {"-1", "89", "6", "34", "5", "0", "9", "12", "6", "4"};
            for(int i = 0; i < s.length; i++) {
                Assert.assertTrue("Message", s[i].trim().equals(result[i]));
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