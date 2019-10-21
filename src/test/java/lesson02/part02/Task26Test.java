package lesson02.part02;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import util.SystemInGatewayUtil;
import util.SystemOutGatewayUtil;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RunWith(JUnit4.class)

public class Task26Test {
    private static String fileName = "./src/main/java/lesson02/part02/Task26.java";

    @Before
    public void setUp() throws Exception {
        SystemOutGatewayUtil.setCustomOut();
    }

    @After
    public void tearDown() throws Exception {
        SystemOutGatewayUtil.setOriginalOut();
        SystemInGatewayUtil.setOriginalIn();
    }

    @Test
    public void task26ifPrintWasUsed() {
        boolean isPrintUsed = false;
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            List<String> collect = stream.collect(Collectors.toList());
            for (String s : collect) {
                if (s.contains("System.out.println()") || s.contains("System.out.print()")) {
                    isPrintUsed = true;
                    break;
                }
            }
            Assert.assertTrue("Программа должна содержать консольный вывод.",
                    isPrintUsed);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void task26ifKeyboardInput() {
        boolean isInputExist = false;
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            List<String> collect = stream.collect(Collectors.toList());
            for (String s : collect) {
                if (s.contains("nextInt()") || s.contains("nextLine()") || s.contains("readLine()")) {
                    isInputExist = true;
                    break;
                }
            }
            Assert.assertTrue("Программа должна получать числа с клавиатуры",isInputExist);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void task26isNegativeEven() throws Exception {
        SystemInGatewayUtil.provideInput("-10\n");
        Task26.main(null);
        ByteArrayOutputStream stream = SystemOutGatewayUtil.getOutputArray();
        String result = stream.toString();
        Assert.assertEquals("Если число отрицательное и четное, вывести \"отрицательное четное число\".",
                "отрицательное четное число\n",result);
        stream.reset();
    }

    @Test
    public void task26isNegativeOdd() throws Exception {
        SystemInGatewayUtil.provideInput("-9\n");
        Task26.main(null);
        ByteArrayOutputStream stream = SystemOutGatewayUtil.getOutputArray();
        String result = stream.toString();
        Assert.assertEquals("Если число отрицательное и нечетное, вывести \"отрицательное нечетное число\".",
                "отрицательное нечетное число\n",result);
        stream.reset();
    }

    @Test
    public void task26isZero() throws Exception {
        SystemInGatewayUtil.provideInput("0\n");
        Task26.main(null);
        ByteArrayOutputStream stream = SystemOutGatewayUtil.getOutputArray();
        String result = stream.toString();
        Assert.assertEquals("Если число равно 0, вывести \"ноль\".",
                "ноль\n",result);
        stream.reset();
    }

    @Test
    public void task26isPositiveEven() throws Exception {
        SystemInGatewayUtil.provideInput("10\n");
        Task26.main(null);
        ByteArrayOutputStream stream = SystemOutGatewayUtil.getOutputArray();
        String result = stream.toString();
        Assert.assertEquals("Если число положительное и четное, вывести \"положительное четное число\".",
                "положительное четное число\n",result);
        stream.reset();
    }

    @Test
    public void task26isPositiveOdd() throws Exception {
        SystemInGatewayUtil.provideInput("11\n");
        Task26.main(null);
        ByteArrayOutputStream stream = SystemOutGatewayUtil.getOutputArray();
        String result = stream.toString();
        Assert.assertEquals("Если число положительное и нечетное, вывести \"положительное нечетное число\".",
                "положительное нечетное число\n",result);
        stream.reset();
    }
}