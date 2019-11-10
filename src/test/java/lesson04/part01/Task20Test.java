package lesson04.part01;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import util.SystemOutGatewayUtil;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import static org.junit.Assert.*;

public class Task20Test {
    @Test
    public void test1 () {
        try {
            int[] arr = {2, 5, 7, 12, 3, 8, 9, 0, 13, 6, 7, 33, 25, 6, 0, 19, 27, 24, 1, 4};
            String inp = "" + arr[0];
            for(int i = 1; i < arr.length; i++) {
                inp += System.lineSeparator() + arr[i];
            }
            ByteArrayInputStream inStr = new ByteArrayInputStream(inp.getBytes());
            System.setIn(inStr);
            Task20.main(null);
            ByteArrayOutputStream outputArray = SystemOutGatewayUtil.getOutputArray();
            String s = outputArray.toString().trim();
            String[] test = {"33", "27", "25", "24", "19", "13", "12", "9", "8", "7", "7", "6", "6", "5", "4", "3", "2", "1", "0", "0"};
            String[] res;
            if(s.split("\n").length > 1) {
                res = s.split("\n");
            }
            else {
                res = s.split(" ");
            }
            for(int i = 0; i < res.length; i++) {
                Assert.assertTrue("Message", res[i].trim().equals(test[i]));
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