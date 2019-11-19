package lesson02.part02;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import util.SystemOutGatewayUtil;

import java.io.ByteArrayOutputStream;

@RunWith(JUnit4.class)
public class Task18Test {
    @Before
    public void setUp() {
        SystemOutGatewayUtil.setCustomOut();
    }

    @After
    public void tearDown() {
        SystemOutGatewayUtil.setOriginalOut();
        SystemOutGatewayUtil.clearOutput();
    }

    @Test
    public void checkInput() {

        try {
            Task18.main(null);
        } catch (Exception e) {
            Assert.fail("The program should read numbers from keyboard");
        }
    }

    @Test
    public void checkOutput() {

        try {
            Task18.main(null);
        } catch (Exception e) {
            e.printStackTrace();
        }

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
    public void checkMin() {

        try {
            Task18.main(null);
        } catch (Exception e) {
            e.printStackTrace();
        }

        ByteArrayOutputStream output = SystemOutGatewayUtil.getOutputArray();
        String[] outLines = output.toString().split("\n");

        Assert.assertEquals("The program should display minimum of two values",
                "1",
                outLines[0]
        );
    }

    @Test
    public void checkMinEquals() {

        try {
            Task18.main(null);
        } catch (Exception e) {
            e.printStackTrace();
        }

        ByteArrayOutputStream output = SystemOutGatewayUtil.getOutputArray();
        String[] outLines = output.toString().split("\n");

        Assert.assertEquals("The program should display one of two equal values",
                "2",
                outLines[0]
        );
    }
}