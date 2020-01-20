package lesson01.part2;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import util.SystemOutGatewayUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.*;

public class Task11Test {
    public static String fileName = "./src/main/java/lesson01/part2/Task11.java";

    @Before
    public void before(){
        SystemOutGatewayUtil.setCustomOut();
    }

    @After
    public void after(){
        SystemOutGatewayUtil.setOriginalOut();
    }

    @Test
    public void IsOutput() {
        boolean is = false;
        try {
            Stream<String> stream = Files.lines(Paths.get(fileName));
            List<String> collect = stream.collect(Collectors.toList());
            for (int i = 0; i < collect.size(); i++) {
                if (collect.get(i).contains("System.out.print")) {
                    is = true;
                    break;
                }
            }
            Assert.assertEquals("Программа должна выводить текст на экран", true, is);
        } catch (IOException e) {
        }
    }

    @Test
    public void IsReturn() {
        boolean is = false;
        try {
            Stream<String> stream = Files.lines(Paths.get(fileName));
            List<String> collect = stream.collect(Collectors.toList());
            int index = collect.indexOf("    public static int min(int a, int b, int c) {");
            int index2 = collect.indexOf("    }");
            for (int i = index; i < index2; i++) {
                if (collect.get(i).contains("System.out.print")) {
                    is = true;
                    break;
                }
            }
            Assert.assertFalse("Метод min не должен выводить текст на экран", is);
        } catch (IOException e) {
        }
    }

    @Test
    public void CallFourTimes() {
        int is = 0;
        try {
            Stream<String> stream = Files.lines(Paths.get(fileName));
            List<String> collect = stream.collect(Collectors.toList());
            int index = collect.indexOf("    public static void main(String[] args) {");
            for (int i = index; i < collect.size(); i++) {
                if (collect.get(i).contains("min(")) {
                    is ++;
                }
            }
            Assert.assertEquals("Метод main должен вызывать min 4 раза", 4, is);
        } catch (IOException e) {
        }
    }

    @Test
    public void CallFourTimesPrintln() {
        int is = 0;
        try {
            Stream<String> stream = Files.lines(Paths.get(fileName));
            List<String> collect = stream.collect(Collectors.toList());
            int index = collect.indexOf("    public static void main(String[] args) {");
            for (int i = index; i < collect.size(); i++) {
                if (collect.get(i).contains("println(min")) {
                    is ++;
                }
            }
            Assert.assertEquals("Метод main должен выводить на экран результат работы метода min. Каждый раз с новой строки.",
                    4, is);
        } catch (IOException e) {
        }
    }

    @Test
    public void EqualsRightResult() {
        Assert.assertEquals("Метод min должен возвращать минимальное значение из чисел a, b, c", 2,
                Task11.min(2,3, 4));
        Assert.assertEquals("Метод min должен возвращать минимальное значение из чисел a, b, c", 2,
                Task11.min(2,2, 2));
        Assert.assertEquals("Метод min должен возвращать минимальное значение из чисел a, b, c", -1,
                Task11.min(-1,3, 0));
    }
}