package lesson01.part1;

import lesson01.part2.Task03;
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

public class Task14Test {
    public static String fileName = "./src/main/java/lesson01/part1/Task14.java";

    @Before
    public void before() {
        SystemOutGatewayUtil.setCustomOut();
    }

    @Test
    public void test14VariableNotChange() {
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

            List<String> collect = stream.collect(Collectors.toList());
            boolean test1 = collect.get(18).contains("public static int a = 1;");
            boolean test2 = collect.get(19).contains("public static int b = 3;");
            boolean test3 = collect.get(20).contains("public static int c = 9;");
            boolean test4 = collect.get(21).contains("public static int d = 27;");

            Assert.assertTrue(
                    "Значения переменных: a, b, c, d не изменяй",
                    test1 && test2 && test3 && test4
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test14RightSing() {
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

            List<String> collect = stream.collect(Collectors.toList());
            int a = 0;
            boolean test1 = false;
            boolean test2 = false;
            boolean test3 = false;
            boolean test4 = false;

            for (int i = 0; i < collect.size(); i++)
                if (collect.get(i).contains("int result")) {
                    a = i;
                    break;
                }

            if (collect.get(a).contains("-a") || collect.get(a).contains("- a"))
                test1 = true;
            if (collect.get(a).contains("+b") || collect.get(a).contains("+ b"))
                test2 = true;
            if (collect.get(a).contains("-c") || collect.get(a).contains("- c"))
                test3 = true;
            if (collect.get(a).contains("+d") || collect.get(a).contains("+ d"))
                test4 = true;

            Assert.assertTrue(
                    "Знаки плюс и минус должны быть расставлены правильно",
                    test1 && test2 && test3 && test4
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test14ScreenOutput() {
        Task14.main(null);
        SystemOutGatewayUtil.setOriginalOut();
        ByteArrayOutputStream outputArr = SystemOutGatewayUtil.getOutputArray();
        String s = outputArr.toString();
        Assert.assertTrue(
                "В результате работы программы на экран нужно вывести число 20",
                s.contains("20") || s.contains("20\n")
        );
    }

    @Test
    public void test14Sign() {
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

            List<String> collect = stream.collect(Collectors.toList());
            int a = 0;
            boolean test1 = false;
            boolean test2 = false;
            boolean test3 = false;
            boolean test4 = false;

            for (int i = 0; i < collect.size(); i++)
                if (collect.get(i).contains("int result")) {
                    a = i;
                    break;
                }

            if (collect.get(a).contains("-a") || collect.get(a).contains("- a") || collect.get(a).contains("+a") || collect.get(a).contains("+ a"))
                test1 = true;
            if (collect.get(a).contains("+b") || collect.get(a).contains("+ b") || collect.get(a).contains("-b") || collect.get(a).contains("- b"))
                test2 = true;
            if (collect.get(a).contains("-c") || collect.get(a).contains("- c") || collect.get(a).contains("+c") || collect.get(a).contains("+ c"))
                test3 = true;
            if (collect.get(a).contains("+d") || collect.get(a).contains("+ d") || collect.get(a).contains("-d") || collect.get(a).contains("- d"))
                test4 = true;

            Assert.assertTrue(
                    "Перед каждой из переменных: a, b, c, d в строке с объявлением переменной result должен стоять один знак плюс либо минус",
                    test1 && test2 && test3 && test4
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
