package lesson02.part01;

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

public class Task14Test {
    public static String fileName = "./src/main/java/lesson02/part01/Task14.java";

    @Before
    public void before() {
        SystemOutGatewayUtil.setCustomOut();
    }

    @After
    public void after() {
        SystemOutGatewayUtil.setOriginalOut();
        SystemOutGatewayUtil.clearOutput();
    }

    @Test
    public void test14OutputScreen() {
        Task14.main(null);
        SystemOutGatewayUtil.setOriginalOut();
        ByteArrayOutputStream outputArr = SystemOutGatewayUtil.getOutputArray();
        String s = outputArr.toString();
        Assert.assertTrue("Программа должна выводить текст", !s.isEmpty());
    }

    @Test
    public void test14Objects() {
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            List<String> collect = stream.collect(Collectors.toList());
            int a = 0, b = 0, number = 0;
            for (int i = 0; i < collect.size(); i++) {
                if (collect.get(i).contains("public static void main(String[] args)")) {
                    a = i + 1;
                }
                if (collect.get(i).contains("}")) {
                    b = i;
                    break;
                }
            }

            for (int i = a; i < b; i++) {
                if (    collect.get(i).contains("new Red();") ||
                        collect.get(i).contains("new Orange();") ||
                        collect.get(i).contains("new Yellow();") ||
                        collect.get(i).contains("new Green();") ||
                        collect.get(i).contains("new Blue();") ||
                        collect.get(i).contains("new Indigo();") ||
                        collect.get(i).contains("new Violet();"))
                    number++;
            }

            Assert.assertTrue("Нужно создать 7 различных объектов, отвечающих за цвета", number == 7);
        } catch (IOException e) {
        }
    }

    @Test
    public void test14Rainbow() {
        Task14.main(null);
        SystemOutGatewayUtil.setOriginalOut();
        ByteArrayOutputStream outputArr = SystemOutGatewayUtil.getOutputArray();
        String s = outputArr.toString();
        Assert.assertTrue("Порядок создания объектов должен соответствовать порядку цветов в радуге", s.contains(
                        "Red\r\n" + "Orange\r\n" + "Yellow\r\n" + "Green\r\n" + "Blue\r\n" + "Indigo\r\n" + "Violet\r\n"));
    }

    public boolean checkCode(String color) {
        boolean test = false;
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            List<String> collect = stream.collect(Collectors.toList());
            int a = 0;
            for (int i = 0; i < collect.size(); i++)
                if (collect.get(i).contains("public static class " + color + " {")) {
                    a = i;
                    break;
                }
            test = collect.get(a).equals("    public static class " + color + " {") &&
                    collect.get(a + 1).equals("        public " + color + "() {") &&
                    collect.get(a + 2).equals("            System.out.println(\"" + color + "\");") &&
                    collect.get(a + 3).equals("        }") &&
                    collect.get(a + 4).equals("    }");
        } catch (IOException e) {
        }
        return test;
    }

    @Test
    public void test14NotChangeClasses() {
        boolean test1 = checkCode("Red");
        boolean test2 = checkCode("Orange");
        boolean test3 = checkCode("Yellow");
        boolean test4 = checkCode("Green");
        boolean test5 = checkCode("Blue");
        boolean test6 = checkCode("Indigo");
        boolean test7 = checkCode("Violet");
        Assert.assertTrue("В классе Cat не должно быть методов",
                test1 && test2 && test3 && test4 && test5 && test6 && test7);
    }
}