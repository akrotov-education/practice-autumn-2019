package lesson01.part1;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import util.SystemOutGatewayUtil;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RunWith(JUnit4.class)

public class Task10Test {

    private static String fileName = "/Users/Xesavov/Documents/practice-autumn-2019/src/main/java/lesson01/part1/Task10.java";

    @Before
    public void setUp() throws Exception {
        SystemOutGatewayUtil.setCustomOut();
    }

    @After
    public void tearDown() throws Exception {
        SystemOutGatewayUtil.setOriginalOut();
    }

    @Test
    public void task10ifPrintWasUsed() {
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
    public void task10isOutputPositiveInteger() {
        Task10.main(null);
        ByteArrayOutputStream stream = SystemOutGatewayUtil.getOutputArray();
        String result = stream.toString();
        int value = 0;
        try {
            value = Integer.parseInt(result);
        } catch (Exception e) {
            System.out.println(e);
        }
        Assert.assertTrue("Выведенный текст должен быть целым положительным числом", value > 0);
    }

    @Test
    public void task10isOutputmod60is0() {
        Task10.main(null);
        ByteArrayOutputStream stream = SystemOutGatewayUtil.getOutputArray();
        String result = stream.toString();
        int value = 0;
        try {
            value = Integer.parseInt(result);
        } catch (Exception e) {
            System.out.println(e);
        }
        Assert.assertTrue("Выведенный текст должен быть целым положительным числом", value%60==0);
    }

    @Test
    public void task10isOutputCorrect() {
        Task10.main(null);
        ByteArrayOutputStream stream = SystemOutGatewayUtil.getOutputArray();
        String result = stream.toString();
        Assert.assertEquals("Должно получиться 1800 секунд.", "1800", result);
        stream.reset();
    }
}