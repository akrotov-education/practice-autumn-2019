package lesson02.part01;

import lesson01.part2.Task01;
import lesson01.part2.Task04;
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

public class Task01Test {
    public static String fileName = "./src/main/java/lesson02/part1/Task01.java";

    @Before
    public void before(){
        SystemOutGatewayUtil.setCustomOut();
    }

    @After
    public void after(){
        SystemOutGatewayUtil.setOriginalOut();
    }

    @Test
    public void IsDiv() {
        boolean is = false;
        try {
            Stream<String> stream = Files.lines(Paths.get(fileName));
            List<String> collect = stream.collect(Collectors.toList());
            int ind = collect.indexOf("        public static void div( int a, int b){");
            int ind2 = collect.indexOf("        }");
            for (int i = ind; i < ind2; i++) {
                if (collect.get(i).contains("a/b")) {
                    is = true;
                    break;
                }
            }
            Assert.assertEquals("Функция div должна делить а на b", true, is);
        } catch (IOException e) {
        }
    }

    @Test
    public void IsPrint() {
        boolean is = false;
        try {
            Stream<String> stream = Files.lines(Paths.get(fileName));
            List<String> collect = stream.collect(Collectors.toList());
            int ind = collect.indexOf("        public static void div( int a, int b){");
            int ind2 = collect.indexOf("        }");
            for (int i = ind; i < ind2; i++) {
                if (collect.get(i).contains("System.out.print")) {
                    is = true;
                    break;
                }
            }
            Assert.assertEquals("Функция div должна выводить результат деления на экран", true, is);
        } catch (IOException e) {
        }
    }

    @Test
    public void CallMethodThreeTimes() {
        int is = 0;
        try {
            Stream<String> stream = Files.lines(Paths.get(fileName));
            List<String> collect = stream.collect(Collectors.toList());
            int index = collect.indexOf("    public static void main(String[] args) {");
            int index2 = collect.indexOf("        public static void div( int a, int b){");
            for (int i = index; i < index2; i++) {
                if (collect.get(i).contains("div")) {
                    is++;
                }
            }
            Assert.assertEquals("Функция main должна вызывать функцию div 3 раза", 3, is);
        } catch (IOException e) {
        }
    }

    @Test
    public void IsMainPrint() {
        boolean is = false;
        try {
            Stream<String> stream = Files.lines(Paths.get(fileName));
            List<String> collect = stream.collect(Collectors.toList());
            int ind = collect.indexOf("    public static void main(String[] args) {");
            int ind2 = collect.indexOf("        public static void div( int a, int b){");
            for (int i = ind; i < ind2; i++) {
                if (collect.get(i).contains("System.out.print")) {
                    is = true;
                    break;
                }
            }
            Assert.assertEquals("Функция main не должна вызывать команду вывода текста на экран", false, is);
        } catch (IOException e) {
        }
    }

    @Test
    public void EqualsRightResult() {
        lesson02.part01.Task01.main(null);
        ByteArrayOutputStream stream = SystemOutGatewayUtil.getOutputArray();
        String result = stream.toString();
        Assert.assertEquals("Программа должна вывести три числа: 2 1 0. Каждое число в отдельной строке" ,
                "2\r\n1\r\n0\r\n", result);
    }
}