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
public class Task15Test {

    public static String fileName = "./src/main/java/lesson01/part1/Task15.java";

    @Before
    public void before()
    {
        SystemOutGatewayUtil.setCustomOut();
    }

    @After
    public void after()
    {
        SystemOutGatewayUtil.setOriginalOut();
        SystemOutGatewayUtil.clearOutput();
    }

    @Test
    public void test15NotChange() {
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

            List<String> collect = stream.collect(Collectors.toList());
            boolean var = false;

            for (int i = 0; i < collect.size(); i++) {
                if (collect.get(i).contains("public static int number")) {
                    var = true;
                    break;
                }
            }

            Assert.assertTrue(
                    "У переменной number можно менять только значение",
                    var
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test15ScreenOutput() {
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

            List<String> collect = stream.collect(Collectors.toList());
            int a = 0;
            int b = 0;
            boolean var = false;

            for (int i = 0; i < collect.size(); i++)
                if (collect.get(i).contains("public static void main(String[] args)")) {
                    a = i + 1;
                    break;
                }
            for (int i = a; i < collect.size(); i++)
                if (collect.get(i).contains("}")) {
                    b = i;
                    break;
                }
            for (int i = a; i < b; i++) {
                if (collect.get(i).contains("System.out.print"))
                    var = true;
            }

            Assert.assertTrue(
                    "Программа должна выводить текст",
                    var
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test15ScreenOutputNumber() {
        Task15.main(null);
        SystemOutGatewayUtil.setOriginalOut();
        ByteArrayOutputStream outputArr = SystemOutGatewayUtil.getOutputArray();
        String s = outputArr.toString();
        boolean var = false;
        try {
            Double.parseDouble(s);
            var = true;
        } catch (Exception e) {

        }

        Assert.assertTrue(
                "Выводимый текст должен быть числом",
                var
        );
    }

    @Test
    public void test15NumberPow() {
        Task15.main(null);
        double number = Math.sqrt(Task15.number);
        SystemOutGatewayUtil.setOriginalOut();
        String str,str1=""+number;
        ByteArrayOutputStream outputArray = SystemOutGatewayUtil.getOutputArray(); //SystemOutGatewayUtil.getOutputArray();
        str = outputArray.toString();
        Assert.assertTrue("Вывод не верен", outputArray.toString().contains(str1));

    }
}