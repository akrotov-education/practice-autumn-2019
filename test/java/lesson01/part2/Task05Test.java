package lesson01.part2;

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

public class Task05Test {
    public static String fileName = "./src/main/java/lesson01/part2/Task05.java";

    @Before
    public void before(){
        SystemOutGatewayUtil.setCustomOut();
    }

    @After
    public void after(){
        SystemOutGatewayUtil.setOriginalOut();
    }

    @Test
    public void IsTextOut(){
        Task05.main(null);
        ByteArrayOutputStream stream = SystemOutGatewayUtil.getOutputArray();
        String result = stream.toString();
        Assert.assertNotNull("Программа должна выводить текст", result);
        stream.reset();
    }

    @Test
    public void CreateObj() {
        int is =0;
        try {
            Stream<String> stream = Files.lines(Paths.get(fileName));
            List<String> collect = stream.collect(Collectors.toList());
            int index = collect.indexOf("    public static void main(String[] args) {");
            int index2 = collect.indexOf("    }");
            for (int i = index; i < index2; i++) {
                if (collect.get(i).contains("Cat()")) {
                    is ++;
                }
            }
            Assert.assertEquals(" методе main должно быть только две переменные типа Cat", 2, is);
        } catch (IOException e) {
        }
    }

    @Test
    public void IsReturn() {
        boolean is = false;
        int ii = 0;
        try {
            Stream<String> stream = Files.lines(Paths.get(fileName));
            List<String> collect = stream.collect(Collectors.toList());
            int index = collect.indexOf("    public static void main(String[] args) {");
            for (int i = index; i < collect.size(); i++) {
                if ((collect.get(i).contains("Cat"))&(collect.get(i).contains("new Cat()"))) {
                    is = true;
                    ii = i;
                    break;
                }
            }
            Assert.assertTrue("Переменным сразу должны быть присвоены значения (1)", is);
        } catch (IOException e) {
        }

        is = false;
        try {
            Stream<String> stream = Files.lines(Paths.get(fileName));
            List<String> collect = stream.collect(Collectors.toList());
            for (int i = ii; i < collect.size(); i++) {
                if ((collect.get(i).contains("Cat"))&(collect.get(i).contains("new Cat()"))) {
                    is = true;
                    break;
                }
            }
            Assert.assertTrue("Переменным сразу должны быть присвоены значения (2)", is);
        } catch (IOException e) {
        }
    }

    @Test
    public void NoVarInClass() {
        boolean is = false;
        try {
            Stream<String> stream = Files.lines(Paths.get(fileName));
            List<String> collect = stream.collect(Collectors.toList());
            int index = collect.indexOf("    public static class Cat {");
            for (int i = index+1; i < collect.size(); i++) {
                if (collect.get(i).contains("Cat")) {
                    is = true;
                    break;
                }
            }
            Assert.assertFalse("В классе Cat не должно быть переменных", is);
        } catch (IOException e) {
        }
    }

    @Test
    public void NoMethodsInClass() {
        boolean is = false;
        try {
            Stream<String> stream = Files.lines(Paths.get(fileName));
            List<String> collect = stream.collect(Collectors.toList());
            int index = collect.indexOf("    public static class Cat {");
            for (int i = index+1; i < collect.size(); i++) {
                if (collect.get(i).contains("(")) {
                    is = true;
                    break;
                }
            }
            Assert.assertFalse("В классе Cat не должно быть методов", is);
        } catch (IOException e) {
        }
    }

}