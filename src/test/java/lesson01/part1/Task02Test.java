package lesson01.part1;

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
        lesson01.part1.Task02.main(null);
        ByteArrayOutputStream outputArray = SystemOutGatewayUtil.getOutputArray();
        String s = outputArray.toString();
        String[] arr = s.split("\n");
        for(int i = 0; i < 3; i++) {
            Assert.assertTrue("Message", arr[i].contains("Hello"));
            Assert.assertTrue("Message", arr[i].contains("!"));
        }
        Assert.assertTrue("Message", arr.length == 3);
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