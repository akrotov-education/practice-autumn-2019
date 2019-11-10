package lesson02.part01;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import util.SystemOutGatewayUtil;

import java.io.ByteArrayOutputStream;

import static org.junit.Assert.*;

public class Task09Test {
    @Test
    public void test1 () {
        Task09.main(null);
        ByteArrayOutputStream outputArray = SystemOutGatewayUtil.getOutputArray();
        String s = outputArray.toString();
        String[] arr = s.split("\n");
        Assert.assertTrue("Message", arr.length == 5);
        int[] results = {1, 3, 6, 10, 15};
        for(int i = 0; i < arr.length; i++) {
            int res = Integer.parseInt(arr[i].replaceAll("\\s", ""));
            Assert.assertTrue("Message", res == results[i]);
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