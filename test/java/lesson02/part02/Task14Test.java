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
public class Task14Test {
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
        SystemInGatewayUtil.provideInput("1999");

        try {
            Task14.main(null);
        } catch (Exception e) {
            Assert.fail("The program should read value from keyboard");
        }
    }

    @Test
    public void checkLeapYear() {
        SystemInGatewayUtil.provideInput("2020");
        try {
            Task14.main(null);
        } catch (Exception e) {
            e.printStackTrace();
        }

        ByteArrayOutputStream output = SystemOutGatewayUtil.getOutputArray();
        String[] outLines = output.toString().split("\n");
        Assert.assertEquals("The program should display correct value for leap year",
                "количество дней в году: 366",
                outLines[0]
        );
    }

    @Test
    public void checkNormalYear() {
        SystemInGatewayUtil.provideInput("1999");
        try {
            Task14.main(null);
        } catch (Exception e) {
            e.printStackTrace();
        }

        ByteArrayOutputStream output = SystemOutGatewayUtil.getOutputArray();
        String[] outLines = output.toString().split("\n");
        Assert.assertEquals("The program should display correct value for not leap year",
                "количество дней в году: 365",
                outLines[0]
        );
    }
}