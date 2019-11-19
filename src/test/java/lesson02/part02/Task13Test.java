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
public class Task13Test {
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
            Task13.main(null);
        } catch (Exception e) {
            Assert.fail("The program should read value from keyboard");
        }
    }

    @Test
    public void checkOutput() {
        try {
            Task13.main(null);
        } catch (Exception e) {
            e.printStackTrace();
        }

        ByteArrayOutputStream output = SystemOutGatewayUtil.getOutputArray();
        Assert.assertTrue("The program must output text", output.toString().length() > 0);
    }

    @Test
    public void checkFrom1To7() {
        try {
            Task13.main(null);
        } catch (Exception e) {
            e.printStackTrace();
        }

        ByteArrayOutputStream output = SystemOutGatewayUtil.getOutputArray();
        String[] outLines = output.toString().split("\n");
        Assert.assertEquals("The program should display name of the day",
                "вторник",
                outLines[0]
        );
    }

    @Test
    public void checkOutOfRange() {
        try {
            Task13.main(null);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            Task13.main(null);
        } catch (Exception e) {
            e.printStackTrace();
        }

        ByteArrayOutputStream output = SystemOutGatewayUtil.getOutputArray();
        String[] outLines = output.toString().split("\n");
        Assert.assertEquals("The program should display error message",
                "такого дня недели не существует",
                outLines[0]
        );
        Assert.assertEquals("The program should display error message",
                "такого дня недели не существует",
                outLines[1]
        );
    }
}