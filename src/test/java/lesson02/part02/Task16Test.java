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
public class Task16Test {
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
        SystemInGatewayUtil.provideInput("1.3");

        try {
            Task16.main(null);
        } catch (Exception e) {
            Assert.fail("The program should read float value from keyboard");
        }
    }

    @Test
    public void checkGreen() {
        SystemInGatewayUtil.provideInput("1.3");

        try {
            Task16.main(null);
        } catch (Exception e) {
            e.printStackTrace();
        }

        ByteArrayOutputStream output = SystemOutGatewayUtil.getOutputArray();
        String[] outLines = output.toString().split("\n");
        Assert.assertEquals("The program should return that is glowing green",
                "зеленый",
                outLines[0]
        );
    }

    @Test
    public void checkYellow() {
        SystemInGatewayUtil.provideInput("3.3");

        try {
            Task16.main(null);
        } catch (Exception e) {
            e.printStackTrace();
        }

        ByteArrayOutputStream output = SystemOutGatewayUtil.getOutputArray();
        String[] outLines = output.toString().split("\n");
        Assert.assertEquals("The program should return that is glowing yellow",
                "жёлтый",
                outLines[0]
        );
    }

    @Test
    public void checkRed() {
        SystemInGatewayUtil.provideInput("4.5");

        try {
            Task16.main(null);
        } catch (Exception e) {
            e.printStackTrace();
        }

        ByteArrayOutputStream output = SystemOutGatewayUtil.getOutputArray();
        String[] outLines = output.toString().split("\n");
        Assert.assertEquals("The program should return that is glowing red",
                "красный",
                outLines[0]
        );
    }
}