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
            Assert.fail("Программа должна считывать число c клавиатуры");
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
        String[] outLines = output.toString().split("\r\n");
        Assert.assertEquals("Если введенный год является високосным, необходимо вывести текст: \"количество дней в году: 366\"",
                "количество дней в году: 366", outLines[0]);
    }

    @Test
    public void checkNormalYear() {
        SystemInGatewayUtil.provideInput("1999");
        try {
            Task14.main(null);
        } catch (Exception e) {
        }
        ByteArrayOutputStream output = SystemOutGatewayUtil.getOutputArray();
        String[] outLines = output.toString().split("\r\n");
        Assert.assertEquals("Если введенный год не является високосным, необходимо вывести текст: \"количество дней в году: 365\"",
                "количество дней в году: 365", outLines[0]);
    }
}