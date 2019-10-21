package lesson01.part1;

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

    private static String fileName = "/Users/Xesavov/Documents/practice-autumn-2019/src/main/java/lesson01/part1/Task09.java";

    @Before
    public void setUp() throws Exception {
        SystemOutGatewayUtil.setCustomOut();
    }

    @After
    public void tearDown() throws Exception {
        SystemOutGatewayUtil.setOriginalOut();
    }

    @Test
    public void task09ifKeyboardInput() {
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

    @Test
    public void task09ifMethodWorksCorrect() {
        int actual = Task09.sumDigitsInNumber(546);
        Assert.assertEquals("Сумма чисел 546 равна 15", 15, actual);
    }
}