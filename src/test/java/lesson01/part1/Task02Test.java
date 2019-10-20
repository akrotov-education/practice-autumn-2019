package lesson01.part1;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import util.SystemOutGatewayUtil;

import java.io.ByteArrayOutputStream;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class Task02Test {
    @Before
    public void before() {
        SystemOutGatewayUtil.setCustomOut();
    }

    @After
    public void after() {
        SystemOutGatewayUtil.setOriginalOut();
    }

    @Test
    public void testOutput() {
        Task02.main(null);

        ByteArrayOutputStream output = SystemOutGatewayUtil.getOutputArray();
        String[] strArr = output.toString().split("\n");

        Assert.assertEquals("Need to print 3 times", strArr.length, 3);
        for (String str : strArr) {
            Assert.assertEquals(str, "Hello World!");
        }
    }
}
