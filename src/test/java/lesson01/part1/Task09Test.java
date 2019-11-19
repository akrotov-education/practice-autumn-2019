package lesson01.part1;

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
public class Task09Test {
    private static String fileName = "./src/main/java/lesson01/part1/Task09.java";

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
    public void testsumDigitsInNumber() {
        int actual = Task09.sumDigitsInNumber(546);
        Assert.assertEquals("Метод sumDigitsInNumber должен возвращать 15", 15, actual);
    }

    @Test
    public void testOutput() {
        Task09.main(null);
        String str, str1;
        ByteArrayOutputStream outputArray = SystemOutGatewayUtil.getOutputArray(); //SystemOutGatewayUtil.getOutputArray();
        str = outputArray.toString();
        Assert.assertTrue("Вывод не верен", outputArray.toString().contains("15"));

    }

    @Test
    public void testKeyboardInput() {
        boolean isInputExist = false;
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            List<String> collect = stream.collect(Collectors.toList());
            for (String s : collect) {
                if (s.contains("nextInt()") || s.contains("nextLine()") || s.contains("readLine()")) {
                    isInputExist = true;
                    break;
                }
            }
            Assert.assertFalse("Программа не должна получать числа с клавиатуры",isInputExist);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void task09ifMethodIsStatic() {
        boolean isMethodPublic = false;
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            List<String> collect = stream.collect(Collectors.toList());
            for (String s : collect) {
                if (s.contains("public static int sumDigitsInNumber(int number)")) {
                    isMethodPublic = true;
                    break;
                }
            }
            Assert.assertTrue("Метод должен быть публичным и статическим",isMethodPublic);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void task09ifMethodReturnsInt() {
        boolean isMethodPublic = false;
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            List<String> collect = stream.collect(Collectors.toList());
            for (String s : collect) {
                if (s.contains("public static int sumDigitsInNumber(int number)")) {
                    isMethodPublic = true;
                    break;
                }
            }
            Assert.assertTrue("Метод должен возвращать значение типа int",isMethodPublic);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void task09ifMethodPrints() {
        boolean isMethodPrints = false;
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            List<String> collect = stream.collect(Collectors.toList());
            int index = collect.indexOf("    public static int sumDigitsInNumber(int number) {");
            for (int i = index; i < collect.size(); i++) {
                if (collect.get(i).contains("System.out.print") || collect.get(i).contains("System.out.println")) {
                    isMethodPrints = true;
                    break;
                }
            }
            Assert.assertFalse("Метод ничего не должен печатать",isMethodPrints);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}