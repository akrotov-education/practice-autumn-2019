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

public class Task29Test {
    private static String fileName = "./src/main/java/lesson02/part02/Task29.java";

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
    public void task29ifKeyboardInput() {
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
    public void task29ifPrintWasUsed() {
        boolean isPrintUsed = false;
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            List<String> collect = stream.collect(Collectors.toList());
            for (String s : collect) {
                if (s.contains("System.out.println") || s.contains("System.out.print")) {
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
    public void task29PositiveCountOutput() throws Exception {
        SystemInGatewayUtil.provideInput("0\n1\n2\n");
        Task29.main(null);
        ByteArrayOutputStream stream = SystemOutGatewayUtil.getOutputArray();
        String result = stream.toString();
        Assert.assertTrue("Программа должна выводить количество положительных чисел в исходном наборе.",
                result.contains("количество положительных чисел:"));
        stream.reset();
    }

    @Test
    public void task29NegativeCountOutput() throws Exception {
        SystemInGatewayUtil.provideInput("0\n1\n2\n");
        Task29.main(null);
        ByteArrayOutputStream stream = SystemOutGatewayUtil.getOutputArray();
        String result = stream.toString();
        Assert.assertTrue("Программа должна выводить количество отрицательных чисел в исходном наборе.",
                result.contains("количество отрицательных чисел:"));
        stream.reset();
    }

    @Test
    public void task29NegativeCountShouldBeDisplayed() throws Exception {
        SystemInGatewayUtil.provideInput("1\n2\n3\n");
        Task29.main(null);
        ByteArrayOutputStream stream = SystemOutGatewayUtil.getOutputArray();
        String result = stream.toString();
        Assert.assertTrue("Если отрицательных чисел нет, программа должна писать, что их 0.",
                result.contains("количество отрицательных чисел: 0"));
        stream.reset();
    }

    @Test
    public void task29PositiveCountShouldBeDisplayed() throws Exception {
        SystemInGatewayUtil.provideInput("-1\n-2\n-3\n");
        Task29.main(null);
        ByteArrayOutputStream stream = SystemOutGatewayUtil.getOutputArray();
        String result = stream.toString();
        Assert.assertTrue("Если положительных чисел нет, программа должна писать, что их 0.",
                result.contains("количество положительных чисел: 0"));
        stream.reset();
    }

    @Test
    public void task29ZeroMustBeCountedAsZero() throws Exception {
        SystemInGatewayUtil.provideInput("0\n0\n0\n");
        Task29.main(null);
        ByteArrayOutputStream stream = SystemOutGatewayUtil.getOutputArray();
        String result = stream.toString();
        Assert.assertTrue("Если отрицательных чисел нет, программа должна писать, что их 0.",
                result.contains("количество отрицательных чисел: 0") || result.contains("количество положительных чисел: 0"));
        stream.reset();
    }
}