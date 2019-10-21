package lesson02.part02;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import util.SystemInGatewayUtil;
import util.SystemOutGatewayUtil;

import java.io.ByteArrayOutputStream;

@RunWith(JUnit4.class)
public class Task20Test {
    @Before
    public void setUp() {
        SystemOutGatewayUtil.setCustomOut();
    }

    @After
    public void tearDown() {
        SystemInGatewayUtil.setOriginalIn();
        SystemOutGatewayUtil.setOriginalOut();
        SystemOutGatewayUtil.clearOutput();
    }

    @Test
    public void checkInput() {
        SystemInGatewayUtil.provideInput("1\n2\n5");

        try {
            Task20.main(null);
        } catch (Exception e) {
            Assert.fail("The program should read numbers from keyboard");
        }
    }

    @Test
    public void checkOutput() {
        SystemInGatewayUtil.provideInput("1\n2\n5");

        try {
            Task20.main(null);
        } catch (Exception e) {
            e.printStackTrace();
        }

        ByteArrayOutputStream output = SystemOutGatewayUtil.getOutputArray();
        Assert.assertTrue("The program must output numbers", output.toString().length() > 0);
        String[] outLines = output.toString().split("\n")[1].split(" ");

        try {
            for (String line : outLines) {
                Integer.parseInt(line);
            }
        } catch (NumberFormatException e) {
            Assert.fail("The program must output numbers");
        }
    }

    @Test
    public void checkCorrectOutput() {
        SystemInGatewayUtil.provideInput("1\n2\n5");

        try {
            Task20.main(null);
        } catch (Exception e) {
            e.printStackTrace();
        }

        ByteArrayOutputStream output = SystemOutGatewayUtil.getOutputArray();
        String[] outLines = output.toString().split("\n");

        Assert.assertTrue("The program should display 3 values in one line divided by space",
                outLines.length == 2 && outLines[1].split(" ").length == 3
        );
    }

    @Test
    public void checkDescendOutput() {
        SystemInGatewayUtil.provideInput("2\n10\n0");

        try {
            Task20.main(null);
        } catch (Exception e) {
            e.printStackTrace();
        }

        ByteArrayOutputStream output = SystemOutGatewayUtil.getOutputArray();
        String[] outStrNums = output.toString().split("\n")[1].split(" ");

        Assert.assertTrue("The program should display 3 values in one line divided by space",
                Integer.parseInt(outStrNums[0]) > Integer.parseInt(outStrNums[1]) &&
                        Integer.parseInt(outStrNums[1]) > Integer.parseInt(outStrNums[2])
        );
    }
}