package lesson04.part02;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import util.SystemOutGatewayUtil;

import java.io.ByteArrayOutputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class Task30Test {
    @Test
    public void test1 () {
        try {
            Task30.main(null);
            ByteArrayOutputStream outputArray = SystemOutGatewayUtil.getOutputArray();
            String[] s = outputArray.toString().trim().split("\n");
            Integer.parseInt(s[0].trim());
            Integer.parseInt(s[1].trim());
            Assert.assertTrue("Message", true);
        } catch(Exception e) {
            Assert.assertTrue("Message", false);
        }
    }

    @Test
    public void test2() {
        ArrayList<String> list = new ArrayList<>();
        Task30.fill(list);
        Assert.assertTrue("Message", list.size() == 10000);
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