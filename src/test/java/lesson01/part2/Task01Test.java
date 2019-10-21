package lesson01.part2;

import lesson01.part1.Task01;
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

public class Task01Test {
    public static String fileName = "./src/main/java/lesson01/part2/Task01.java";
    public static boolean test1;
    public static boolean test2;
    public static boolean test3;
    public static boolean test4;
    public static boolean test5;

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
    public void test01VariableName() {
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

            List<String> collect = stream.collect(Collectors.toList());

            Assert.assertTrue("Variable name not found!", test1 = collect.get(26).contains("String name;"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test01VariableAge() {
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

            List<String> collect = stream.collect(Collectors.toList());

            Assert.assertTrue("Variable age not found!", test2 = collect.get(27).contains("int age;"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test01VariableWeight() {
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

            List<String> collect = stream.collect(Collectors.toList());

            Assert.assertTrue("Variable weight not found!", test3 = collect.get(28).contains("int weight;"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test01VariableMoney() {
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

            List<String> collect = stream.collect(Collectors.toList());

            Assert.assertTrue("Variable money not found!", test4 = collect.get(29).contains("int money;"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test01ObjectPerson() {
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

            List<String> collect = stream.collect(Collectors.toList());
            int number = 0;

            for (int i = 0; i < collect.size(); i++) {
                if (
                        collect.get(i).contains("Person person = new Person();") ||
                        collect.get(i).contains("String name;") ||
                        collect.get(i).contains("int age;") ||
                        collect.get(i).contains("int weight;") ||
                        collect.get(i).contains("int money;")
                )
                    number++;
            }



            Assert.assertTrue("Object person not found!", number == 5);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test01Number() {
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

            List<String> collect = stream.collect(Collectors.toList());

            Assert.assertTrue("Должно быть объявлено 5 переменных!",
                    test5 = collect.get(22).contains("Person person = new Person();"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
