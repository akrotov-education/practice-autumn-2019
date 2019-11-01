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
public class Task19Test {
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
        SystemInGatewayUtil.provideInput("1\n2\n5\n0");

        try {
            Task19.main(null);
        } catch (Exception e) {
            Assert.fail("Программа должна считывать числа c клавиатуры");
        }
    }

    @Test
    public void checkMax() {
        SystemInGatewayUtil.provideInput("1\n2\n0\n5");
        try {
            Task19.main(null);
        } catch (Exception e) {
            e.printStackTrace();
        }

        SystemInGatewayUtil.provideInput("-1\n2\n5\n0");
        try {
            Task19.main(null);
        } catch (Exception e) {
            e.printStackTrace();
        }

        SystemInGatewayUtil.provideInput("1\n7\n5\n0");
        try {
            Task19.main(null);
        } catch (Exception e) {
            e.printStackTrace();
        }

        SystemInGatewayUtil.provideInput("9\n2\n5\n0");
        try {
            Task19.main(null);
        } catch (Exception e) {
            e.printStackTrace();
        }

        ByteArrayOutputStream output = SystemOutGatewayUtil.getOutputArray();
        String[] outLines = output.toString().split("\r\n");

        Assert.assertEquals("Программа должна выводить на экран максимальное из четырёх чисел",
                "5",
                outLines[0]
        );
        Assert.assertEquals("Программа должна выводить на экран максимальное из четырёх чисел",
                "5",
                outLines[1]
        );
        Assert.assertEquals("Программа должна выводить на экран максимальное из четырёх чисел",
                "7",
                outLines[2]
        );
        Assert.assertEquals("Программа должна выводить на экран максимальное из четырёх чисел",
                "9",
                outLines[3]
        );
    }

    @Test
    public void checkMaxEqual() {
        SystemInGatewayUtil.provideInput("1\n5\n0\n5");
        try {
            Task19.main(null);
        } catch (Exception e) {
            e.printStackTrace();
        }

        SystemInGatewayUtil.provideInput("-1\n2\n2\n0");
        try {
            Task19.main(null);
        } catch (Exception e) {
            e.printStackTrace();
        }

        SystemInGatewayUtil.provideInput("7\n7\n7\n7");
        try {
            Task19.main(null);
        } catch (Exception e) {
            e.printStackTrace();
        }

        ByteArrayOutputStream output = SystemOutGatewayUtil.getOutputArray();
        String[] outLines = output.toString().split("\r\n");

        Assert.assertEquals("Если максимальных чисел несколько, необходимо вывести любое из них",
                "5",
                outLines[0]
        );
        Assert.assertEquals("Если максимальных чисел несколько, необходимо вывести любое из них",
                "2",
                outLines[1]
        );
        Assert.assertEquals("Если максимальных чисел несколько, необходимо вывести любое из них",
                "7",
                outLines[2]
        );
    }
}