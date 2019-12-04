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
public class Task15Test {
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
        SystemInGatewayUtil.provideInput("1\n2\n3");

        try {
            Task15.main(null);
        } catch (Exception e) {
            Assert.fail("The program should read value from keyboard");
        }
    }

    @Test
    public void triangleExists() {
        SystemInGatewayUtil.provideInput("2\n2\n1");

        try {
            Task15.main(null);
        } catch (Exception e) {
            e.printStackTrace();
        }

        ByteArrayOutputStream output = SystemOutGatewayUtil.getOutputArray();
        String[] outLines = output.toString().split("\n");
        Assert.assertEquals("The program should display that triangle exists",
                "Треугольник существует.",
                outLines[0]
        );
    }

    @Test
    public void triangleNotExists() {
        SystemInGatewayUtil.provideInput("1\n2\n3");

        try {
            Task15.main(null);
        } catch (Exception e) {
            e.printStackTrace();
        }

        ByteArrayOutputStream output = SystemOutGatewayUtil.getOutputArray();
        String[] outLines = output.toString().split("\n");
        Assert.assertEquals("The program should display that triangle doesn't exists",
                "Треугольник не существует.",
                outLines[0]
        );
    }
}