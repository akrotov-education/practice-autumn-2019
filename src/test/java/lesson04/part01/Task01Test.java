package lesson04.part01;

import lesson02.part02.Task03;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import util.SystemOutGatewayUtil;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import static org.junit.Assert.*;

public class Task01Test {
    @Test
    public void test1 () {
        try {
            int[] arr = {2, 5, 7, 12, 3, 8, 9, 0, 12, 6, 7, 33, 25, 6, 0, 19, 27, 24, 1, 5};
            String inp = "" + arr[0];
            for(int i = 1; i < arr.length; i++) {
                inp += System.lineSeparator() + arr[i];
            }
            ByteArrayInputStream inStr = new ByteArrayInputStream(inp.getBytes());
            System.setIn(inStr);
            Task01.main(null);
            ByteArrayOutputStream outputArray = SystemOutGatewayUtil.getOutputArray();
            String s = outputArray.toString().trim();
            Assert.assertTrue("Message", Integer.parseInt(s) == 33);
        } catch(Exception e) {
            System.out.println("Exception!");
            Assert.assertTrue("Message", false);
        }
    }
    @Test
    public void test2 () {
        int[] arr = {4, 6, 12, 9, 0, 5, 34, 6, 89, 0, -1, 4, 5, 17, 23, 31, 29, 20, 0, 1};
        int max = Task01.max(arr);
        Assert.assertTrue("Message", max == 89);
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