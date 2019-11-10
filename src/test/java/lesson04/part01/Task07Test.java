package lesson04.part01;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import util.SystemOutGatewayUtil;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import static org.junit.Assert.*;

public class Task07Test {
    @Test
    public void test1 () {
        try {
            String[] arr = {"uytre", "jg", "hgare", "f", "hhr"};
            String inp = arr[0];
            for(int i = 1; i < arr.length; i++) {
                inp += System.lineSeparator() + arr[i];
            }
            ByteArrayInputStream inStr = new ByteArrayInputStream(inp.getBytes());
            System.setIn(inStr);
            Task07.main(null);
            ByteArrayOutputStream outputArray = SystemOutGatewayUtil.getOutputArray();
            String s = outputArray.toString().trim();
            String[] contain = {"uytre", "hgare"};
            String[] noContain = {"jg", "f", "hhr"};
            for(int i = 0; i < contain.length; i++) {
                Assert.assertTrue("Message", s.contains(contain[i]));
            }
            for(int i = 0; i < noContain.length; i++) {
                Assert.assertFalse("Message", s.contains(noContain[i]));
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