package lesson01.part2;

import lesson01.part1.Task04;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import util.SystemOutGatewayUtil;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.*;

public class Task02Test {
    public static String fileName = "./src/main/java/lesson01/part2/Task02.java";

    @Before
    public void before(){
        SystemOutGatewayUtil.setCustomOut();
    }

    @After
    public void after(){
        SystemOutGatewayUtil.setOriginalOut();
    }

    @Test
    public void IsThereDiv() {
        boolean is = false;
        try {
            Stream<String> stream = Files.lines(Paths.get(fileName));
            List<String> collect = stream.collect(Collectors.toList());
            int index = collect.indexOf("    public static void div(int a, int b) {");
            for (int i = index; i < collect.size(); i++) {
                if (collect.get(i).contains("div")) {
                    is = true;
                    break;
                }
            }
            Assert.assertTrue("Функция div должна делить а на b", is);
        } catch (IOException e) {
        }
    }

    @Test
    public void IsOutput() {
        boolean is = false;
        try {
            Stream<String> stream = Files.lines(Paths.get(fileName));
            List<String> collect = stream.collect(Collectors.toList());
            int index = collect.indexOf("    public static void div(int a, int b) {");
            for (int i = index; i < collect.size(); i++) {
                if (collect.get(i).contains("System.out")) {
                    is = true;
                    break;
                }
            }
            Assert.assertTrue("Функция div должна выводить результат деления на экран", is);
        } catch (IOException e) {
        }
    }

    @Test
    public void IsCallThreeTimes() {
        int is = 0;
        try {
            Stream<String> stream = Files.lines(Paths.get(fileName));
            List<String> collect = stream.collect(Collectors.toList());
            int index = collect.indexOf("    public static void main(String[] args) {");
            int index2 = collect.indexOf("    }");
            for (int i = index; i < index2; i++) {
                if (collect.get(i).contains("div(")) {
                    is ++;
                }
            }
            Assert.assertEquals("Функция main должна вызывать функцию div 3 раза", 3, is);
        } catch (IOException e) {
        }
    }

    @Test
    public void IsOutputInMain() {
        boolean is = false;
        try {
            Stream<String> stream = Files.lines(Paths.get(fileName));
            List<String> collect = stream.collect(Collectors.toList());
            int index = collect.indexOf("    public static void main(String[] args) {");
            int index2 = collect.indexOf("    }");
            for (int i = index; i < index2; i++) {
                if (collect.get(i).contains("System.out")) {
                    is = true;
                    break;
                }
            }
            Assert.assertFalse("Функция main не должна вызывать команду вывода текста на экран", is);
        } catch (IOException e) {
        }
    }

    @Test
    public void EqualsRightResult(){
        Task02.main(null);
        ByteArrayOutputStream stream = SystemOutGatewayUtil.getOutputArray();
        String result = stream.toString();
        Assert.assertEquals("Программа должна вывести три числа: 2 1 0. Каждое число в отдельной строке",
                ("2" + System.lineSeparator() + "1" + System.lineSeparator() + "0" + System.lineSeparator()), result);
    }
}