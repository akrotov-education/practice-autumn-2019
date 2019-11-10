package lesson04.part02;

import lesson04.part01.Task01;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import util.SystemOutGatewayUtil;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class Task24Test {
    @Test
    public void test1 () {
        try {
            Task24.main(null);
            ByteArrayOutputStream outputArray = SystemOutGatewayUtil.getOutputArray();
            String[] s = outputArray.toString().trim().split("\n");
            Assert.assertTrue("Message", s.length == 10);
        } catch(Exception e) {
            System.out.println("Exception!");
            Assert.assertTrue("Message", false);
        }
    }
    @Test
    public void test2() {
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("uer", "poyt");
        map.put("wwer", "i");
        map.put("09", "ter");
        String[] keys = {"uer", "wwer", "09"};
        Task24.printKeys(map);
        ByteArrayOutputStream outputArray = SystemOutGatewayUtil.getOutputArray();
        String[] s = outputArray.toString().trim().split("\n");
        for(int i = 0; i< s.length; i++) {
            Assert.assertTrue("Message", Arrays.asList(keys).indexOf(s[i].trim()) != -1);
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