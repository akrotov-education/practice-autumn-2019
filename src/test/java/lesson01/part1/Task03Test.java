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
public class Task03Test {
    @Before
    public void before() {
        SystemOutGatewayUtil.setCustomOut();
    }

    @After
    public void after() {
        SystemOutGatewayUtil.setOriginalOut();
    }

    @Test
    public void testYear() {
        Task03.main(null);

        ByteArrayOutputStream output = SystemOutGatewayUtil.getOutputArray();
        String year = output.toString();
        Assert.assertTrue("Expected 1921" ,
                year.contentEquals("1921") ||
                year.contentEquals("1921\n"));
    }
}
