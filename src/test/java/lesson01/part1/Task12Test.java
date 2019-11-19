package lesson01.part1;

import org.junit.After;
import org.junit.Before;
import util.SystemOutGatewayUtil;
import static org.junit.Assert.*;

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
public class Task12Test {
    public static String fileName = "./src/main/java/lesson01/part1/Task12.java";

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
    public void testOutput() {
        Task12.main(null);
        String str;
        ByteArrayOutputStream outputArray = SystemOutGatewayUtil.getOutputArray(); //SystemOutGatewayUtil.getOutputArray();
        str = outputArray.toString();
        Assert.assertTrue("Вывод не верен", outputArray.toString().contains("Яблоко"));

    }
    @Test
    public void testOutput2() {
        Task12.main(null);
        String str;
        ByteArrayOutputStream outputArray = SystemOutGatewayUtil.getOutputArray(); //SystemOutGatewayUtil.getOutputArray();
        str = outputArray.toString();
        Assert.assertTrue("Вывод не верен", outputArray.toString().contains("Персик"));
    }


    @Test
    public void test12OutputScreen() {
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

            List<String> collect = stream.collect(Collectors.toList());
            boolean var = false;

            for (int i = 0; i < collect.size(); i++) {
                if (collect.get(i).contains("System.out.print")) {
                    var = true;
                    break;
                }
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
    public void test12VariableInit() {
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

            List<String> collect = stream.collect(Collectors.toList());
            int b = 0;
            int a = 0;
            boolean var = false;

            for (int i = 0; i < collect.size(); i++)
                if (collect.get(i).contains("public static void main(String[] args)")) {
                    a = i + 1;
                    break;
                }

            if (
                    collect.get(a).contains("String apple = \"Яблоко\";") &&
                            collect.get(a + 1).contains("String porridge = \"Каша\";") &&
                            collect.get(a + 2).contains("String sausage = \"Колбаса\";") &&
                            collect.get(a + 3).contains("String peach = \"Персик\";")
            )
                var = true;

            Assert.assertTrue(
                    "Нельзя изменять строки с объявлением переменных",
                    var
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    @Test
    public void test12NotOutputScreenNotFruit() {
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

            List<String> collect = stream.collect(Collectors.toList());
            int a = 0;
            boolean var = false;

            for (int i = 0; i < collect.size(); i++)
                if (collect.get(i).contains("System.out.print")) {
                    a = i + 1;
                    break;
                }

            if (collect.get(a).contains("porridge") || collect.get(a).contains("sausage"))

                Assert.assertTrue(
                        "Программа не должна выводить переменные, значения которых не являются названиями фруктов",
                        var
                );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}