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

public class Task01Test {
    public static String fileName = "./src/main/java/lesson01/part2/Task01.java";

    @Before
    public void before(){
        SystemOutGatewayUtil.setCustomOut();
    }

    @After
    public void after(){
        SystemOutGatewayUtil.setOriginalOut();
    }

    @Test
    public void IsThereAName() {
        boolean isMethodPrints = false;
        try {
            Stream<String> stream = Files.lines(Paths.get(fileName));
            List<String> collect = stream.collect(Collectors.toList());
            int index = collect.indexOf("    public static class Person {");
            for (int i = index; i < collect.size(); i++) {
                if (collect.get(i).contains(" String name;")) {
                    isMethodPrints = true;
                    break;
                }
            }
            Assert.assertTrue("В классе Person надо объявить переменную name типа String", isMethodPrints);
        } catch (IOException e) {
        }
    }

    @Test
    public void IsThereAnAge() {
        boolean isMethodPrints = false;
        try {
            Stream<String> stream = Files.lines(Paths.get(fileName));
            List<String> collect = stream.collect(Collectors.toList());
            int index = collect.indexOf("    public static class Person {");
            for (int i = index; i < collect.size(); i++) {
                if (collect.get(i).contains(" int age;")) {
                    isMethodPrints = true;
                    break;
                }
            }
            Assert.assertTrue("В классе Person надо объявить переменную age типа int", isMethodPrints);
        } catch (IOException e) {
        }
    }



    @Test
    public void IsThereAWeight() {
        boolean isMethodPrints = false;
        try {
            Stream<String> stream = Files.lines(Paths.get(fileName));
            List<String> collect = stream.collect(Collectors.toList());
            int index = collect.indexOf("    public static class Person {");
            for (int i = index; i < collect.size(); i++) {
                if (collect.get(i).contains(" int weight;")) {
                    isMethodPrints = true;
                    break;
                }
            }
            Assert.assertTrue("В классе Person надо объявить переменную weight типа int", isMethodPrints);
        } catch (IOException e) {
        }
    }
    @Test
    public void IsThereAMoney() {
        boolean isMethodPrints = false;
        try {
            Stream<String> stream = Files.lines(Paths.get(fileName));
            List<String> collect = stream.collect(Collectors.toList());
            int index = collect.indexOf("    public static class Person {");
            for (int i = index; i < collect.size(); i++) {
                if (collect.get(i).contains(" int money;")) {
                    isMethodPrints = true;
                    break;
                }
            }
            Assert.assertTrue("В классе Person надо объявить переменную money типа int", isMethodPrints);
        } catch (IOException e) {
        }
    }

    @Test
    public void IsObjectInMain() {
        boolean is = false;
        try {
            Stream<String> stream = Files.lines(Paths.get(fileName));
            List<String> collect = stream.collect(Collectors.toList());
            int index1 = collect.indexOf("    public static void main(String[] args) {");
            int index2 = collect.indexOf("}");
            for (int i = index1; i < index2; i++) {
                if (collect.get(i).contains("Person person = new Person();")) {
                    is = true;
                    break;
                }
            }
            Assert.assertTrue("В методе main надо создать объект Person и сразу присвоить ссылку на него переменной person",
                    is);
        } catch (IOException e) {
        }
    }

    @Test
    public void FiveVar() {
        int is = 0;
        try {
            Stream<String> stream = Files.lines(Paths.get(fileName));
            List<String> collect = stream.collect(Collectors.toList());
            int index1 = collect.indexOf("    public static void main(String[] args) {");
            for (int i = 0; i < collect.size(); i++) {
                if ((collect.get(i).contains("Person person"))|(collect.get(i).contains("String name;"))|
                        (collect.get(i).contains("int age;"))|(collect.get(i).contains("int weight;"))|(collect.get(i).contains("int money;"))) {
                    is ++;
                }
            }
            Assert.assertEquals("Должно быть объявлено 5 переменных",
                    5, is);
        } catch (IOException e) {
        }
    }
}