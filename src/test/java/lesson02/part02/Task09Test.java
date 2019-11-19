package lesson02.part02;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import util.SystemOutGatewayUtil;

import java.io.ByteArrayOutputStream;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class Task09Test {
    @Before
    public void setUp() {
        SystemOutGatewayUtil.setCustomOut();
    }

    @After
    public void tearDown() {
        SystemOutGatewayUtil.clearOutput();
        SystemOutGatewayUtil.setOriginalOut();
    }

    @Test
    public void checkOutput() {
        Task09.main(null);

        ByteArrayOutputStream output = SystemOutGatewayUtil.getOutputArray();
        Assert.assertTrue("The program must output numbers", output.toString().length() > 0);
        String[] outLines = output.toString().split("\n");

        try {
            for (String line : outLines) {
                Integer.parseInt(line);
            }
        } catch (NumberFormatException e) {
            Assert.fail("The program must output numbers");
        }
    }


    @Test
    public void checkDisplayClosestToTen() {
        Task09.displayClosestToTen(8, 11);
        Task09.displayClosestToTen(7, 14);

        ByteArrayOutputStream output = SystemOutGatewayUtil.getOutputArray();
        String[] outLines = output.toString().split("\n");

        Assert.assertEquals("Method displayClosestToTen works incorrect",
                "11",
                outLines[0]
        );
        Assert.assertEquals("Method displayClosestToTen works incorrect",
                "7",
                outLines[1]
        );
    }
}