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

public class Task04Test {
    public static String fileName = "./src/main/java/lesson01/part2/Task04.java";

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
    public void test04OutputScreen() {
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

            List<String> collect = stream.collect(Collectors.toList());
            boolean var = false;
            for (int i = 25; i < 27; i++)
                var = collect.get(i).contains("System.out.print") ? false : true;
            Assert.assertTrue(
                    "Программа должна выводить текст на экран!",
                    var
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test04Output() {
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

            List<String> collect = stream.collect(Collectors.toList());
            int a = 0;
            int b = 0;
            boolean test1 = false;
            boolean test2 = false;
            int number = 0;

            for (int i = 0; i < collect.size(); i++) {
                if (collect.get(i).contains("public static void main(String[] args)"))
                    a = i + 1;
                if (collect.get(i).contains("}")) {
                    b = i;
                }
            }

            for (int i = a; i < b; i++) {
                if (collect.get(i).contains("int a"))
                    test1 = true;
                if (collect.get(i).contains("int b"))
                    test2 = true;
                if (collect.get(i).contains("int") && !collect.get(i).contains("print"))
                    number++;
            }

            Assert.assertTrue(
                    "В программе должны быть только две переменные: a и b типа int",
                    number == 2 && test1 && test2
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test04ABInit() {
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

            List<String> collect = stream.collect(Collectors.toList());
            int a = 0;
            int b = 0;
            boolean test1 = false;
            boolean test2 = false;

            for (int i = 0; i < collect.size(); i++) {
                if (collect.get(i).contains("public static void main(String[] args)"))
                    a = i + 1;
                if (collect.get(i).contains("}")) {
                    b = i;
                }
            }

            for (int i = a; i < b; i++) {
                if (collect.get(i).contains("int a = "))
                    test1 = true;
                if (collect.get(i).contains("int b = "))
                    test2 = true;
            }

            Assert.assertTrue("Переменным сразу должны быть присвоены значения!", test1 && test2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test04ABSum() {
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

            List<String> collect = stream.collect(Collectors.toList());

            Assert.assertTrue(
                    "Метод main должен выводить на экран сумму переменных a и b!",
                    collect.get(28).contains("a + b")
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test04Plus100() {
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

            List<String> collect = stream.collect(Collectors.toList());

            Assert.assertTrue(
                    "Метод main должен выводить на экран произведение переменных a и b!",
                    collect.get(30).contains("%d * %d")
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test04Println() {
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

            List<String> collect = stream.collect(Collectors.toList());
            Assert.assertTrue(
                    "Каждое значение должно быть выведено с новой строки!",
                    collect.get(28).contains("System.out.println") ||
                            collect.get(28).contains("a + b + \"\\n\"")
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
