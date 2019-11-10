package lesson04.part01;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import util.SystemOutGatewayUtil;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class Task12Test {
    @Test
    public void test1 () {
        try {
            Task12.main(null);
            ArrayList<String> list = new ArrayList<>();
            list.add("мама");
            list.add("мыла");
            list.add("раму");
            ByteArrayOutputStream outputArray = SystemOutGatewayUtil.getOutputArray();
            String[] s = outputArray.toString().trim().split("\n");
            for(int i = 0; i < s.length; i++) {
                if(i % 2 == 1)
                    Assert.assertTrue("Message", s[i].contains("именно"));
                else
                    Assert.assertTrue("Message", list.indexOf(s[i].trim()) != -1);
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