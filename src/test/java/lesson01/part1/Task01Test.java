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
public class Task01Test {
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
        Task01.main(null);
        ByteArrayOutputStream output = SystemOutGatewayUtil.getOutputArray();

        String strOutput = output.toString();
        Assert.assertTrue("Invalid output: Expected 'Hello World!'",
                strOutput.equals("Hello World!\n") ||
                strOutput.equals("Hello World!"));
    }
}
