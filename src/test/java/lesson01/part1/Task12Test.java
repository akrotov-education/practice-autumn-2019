package lesson01.part1;

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

public class Task12Test {
    public static String fileName = "./src/main/java/lesson01/part1/Task12.java";

    @Before
    public void before() {
        SystemOutGatewayUtil.setCustomOut();
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
    public void test12OutputScreenTwoStringFruit() {
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
            for (int i = a; i < collect.size(); i++)
                if (collect.get(i).contains("}")) {
                    b = i;
                    break;
                }
            for (int i = a; i < b; i++) {
                if (
                        collect.get(i).contains("System.out.println(apple + \"\\n\" + peach);") ||
                        collect.get(i).contains("System.out.print(apple + \"\\n\" + peach);") ||
                        (collect.get(i).contains("System.out.println(apple);") &&
                                collect.get(i + 1).contains("System.out.println(peach);"))
                )
                    var = true;
            }
            Assert.assertTrue(
                    "Выводимый текст должен состоять из 2 строк. " +
                            "Программа должна выводить переменные, значения которых являются названиями фруктов",
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
