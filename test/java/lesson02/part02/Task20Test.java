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
            Assert.fail("Программа должна считывать числа c клавиатуры");
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
        Assert.assertTrue("Программа должна выводить числа на экран", output.toString().length() > 0);
        String[] outLines = output.toString().split("\n")[0].split(" ");

        try {
            for (String line : outLines) {
                Integer.parseInt(line);
            }
        } catch (NumberFormatException e) {
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

        Assert.assertTrue("Программа должна выводить три числа разделенных пробелами",
                outLines.length == 1 && outLines[0].split(" ").length == 3
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
        String[] outStrNums = output.toString().split("\n")[0].split(" ");

        Assert.assertTrue("Программа должна выводить числа в порядке убывания",
                Integer.parseInt(outStrNums[0]) > Integer.parseInt(outStrNums[1]) &&
                        Integer.parseInt(outStrNums[1]) > Integer.parseInt(outStrNums[2])
        );
    }
}