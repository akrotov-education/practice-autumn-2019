package lesson04.part01;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import util.SystemOutGatewayUtil;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import static org.junit.Assert.*;

public class Task19Test {
    @Test
    public void test1 () {
        try {
            Task19.main(null);
            ByteArrayOutputStream outputArray = SystemOutGatewayUtil.getOutputArray();
            String[] s = outputArray.toString().trim().split("\n");
            String[] result = new String[32];
            int index = 0;
            for(int i = 30; i >= 0; i--) {
                result[index] = "" + i;
                index++;
            }
            result[31] = "Бум!";
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