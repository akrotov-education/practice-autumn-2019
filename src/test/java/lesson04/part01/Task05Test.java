package lesson04.part01;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import util.SystemOutGatewayUtil;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import static org.junit.Assert.*;

public class Task05Test {
    @Test
    public void test1 () {
        try {
            int[] arr = {2, 5, 7, 12, 3, 8, 9, 0, 12, 6, 7, 33, 25, 6, 0};
            String inp = "" + arr[0];
            for(int i = 1; i < arr.length; i++) {
                inp += System.lineSeparator() + arr[i];
            }
            ByteArrayInputStream inStr = new ByteArrayInputStream(inp.getBytes());
            System.setIn(inStr);
            Task05.main(null);
            ByteArrayOutputStream outputArray = SystemOutGatewayUtil.getOutputArray();
            String s = outputArray.toString().trim();
            Assert.assertTrue("Message", s.equals("В домах с нечетными номерами проживает больше жителей."));
        } catch(IOException e) {
            System.out.println("IOException!");
            Assert.assertTrue("Message", false);
        }
    }

    @Test
    public void test2 () {
        try {
            int[] arr = {22, 5, 7, 2, 13, 8, 9, 0, 12, 6, 7, 3, 25, 6, 0};
            String inp = "" + arr[0];
            for(int i = 1; i < arr.length; i++) {
                inp += System.lineSeparator() + arr[i];
            }
            ByteArrayInputStream inStr = new ByteArrayInputStream(inp.getBytes());
            System.setIn(inStr);
            Task05.main(null);
            ByteArrayOutputStream outputArray = SystemOutGatewayUtil.getOutputArray();
            String s = outputArray.toString().trim();
            Assert.assertTrue("Message", s.equals("В домах с четными номерами проживает больше жителей."));
        } catch(IOException e) {
            System.out.println("IOException!");
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