package lesson02.part01;

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
            ByteArrayInputStream inStr = new ByteArrayInputStream(("Test").getBytes());
            System.setIn(inStr);
            Task19.main(null);
            ByteArrayOutputStream outputArray = SystemOutGatewayUtil.getOutputArray();
            String s = outputArray.toString();
            Assert.assertTrue("Message", s.contains("Test зарабатывает $5,000. Ха-ха-ха!"));
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