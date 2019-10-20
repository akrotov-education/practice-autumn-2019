package lesson02.part01;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import util.SystemOutGatewayUtil;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import static org.junit.Assert.*;

public class Task17Test {
    @Test
    public void test1 () {
        try {
            ByteArrayInputStream inStr = new ByteArrayInputStream(("Test" + System.lineSeparator() + "189").getBytes());
            System.setIn(inStr);
            Task17.main(null);
            ByteArrayOutputStream outputArray = SystemOutGatewayUtil.getOutputArray();
            String s = outputArray.toString();
            Assert.assertTrue("Message", s.contains("Test"));
            Assert.assertTrue("Message", s.contains("18"));
        }
        catch (Exception e) {
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