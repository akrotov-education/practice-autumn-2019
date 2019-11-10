package lesson04.part01;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import util.SystemOutGatewayUtil;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Arrays;

import static org.junit.Assert.*;

public class Task11Test {
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
            Task11.main(null);
            ByteArrayOutputStream outputArray = SystemOutGatewayUtil.getOutputArray();
            String[] s = outputArray.toString().trim().split("\n");
            Integer[] arr3 = {12, 3, 9, 0, 12, 6, 33, 6, 0, 27, 24};
            Integer[] arr2 = {2, 12, 8, 0, 12, 6, 6, 0, 24};
            Integer[] arrOst = {5, 7, 7, 25, 19, 1, 5};
            for(int i = 0; i < arr3.length; i++) {
                Assert.assertTrue("Message", Arrays.asList(arr3).indexOf(Integer.parseInt(s[i].trim())) != -1);
            }
            int len = arr3.length + arr2.length;
            for(int i = arr3.length; i < len; i++) {
                Assert.assertTrue("Message", Arrays.asList(arr2).indexOf(Integer.parseInt(s[i].trim())) != -1);
            }
            int len2 = len + arrOst.length;
            for(int i = len; i < len2; i++) {
                Assert.assertTrue("Message", Arrays.asList(arrOst).indexOf(Integer.parseInt(s[i].trim())) != -1);
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