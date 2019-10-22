package lesson01.part2;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import util.SystemOutGatewayUtil;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task08Test {
    public static String fileName = "./src/main/java/lesson01/part2/Task08.java";

    @Before
    public void before() {
        SystemOutGatewayUtil.setCustomOut();
    }

    @Test
    public void test08NotOutputScreen() {
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

            List<String> collect = stream.collect(Collectors.toList());
            boolean var = true;

            for (int i = 0; i < collect.size(); i++) {
                if (collect.get(i).contains("System.out.print")) {
                    var = false;
                    break;
                }
            }

            Assert.assertTrue(
                    "Программа не должна выводить текст на экран",
                    var
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test08InitVariables() {
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

            List<String> collect = stream.collect(Collectors.toList());
            int a = 0;
            int b = 0;
            int mCount = 0;
            Pattern p = Pattern.compile("^[Cat ].+;");
            Matcher m;

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
                m = p.matcher(collect.get(i));
                if (m.find())
                    mCount++;
            }
            Assert.assertTrue(
                    "В методе main должно быть 10 переменных типа Cat",
                    mCount == 10
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test08InitObject() {
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

            List<String> collect = stream.collect(Collectors.toList());
            int a = 0;
            int b = 0;
            int count = 0;

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
                if (collect.get(i).contains("new Cat();")) count++;
            }

            Assert.assertTrue(
                    "В методе main 8 переменных должны быть проинициализированы",
                    count == 8
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test08ClassCatNotVar() {
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

            List<String> collect = stream.collect(Collectors.toList());
            int b = 0;
            int a = 0;
            boolean var = true;

            for (int i = 0; i < collect.size(); i++)
                if (collect.get(i).contains("public static class Cat")) {
                    b = i;
                    break;
                }
            for (int i = b; i < collect.size(); i++)
                if (collect.get(i).contains("}")) {
                    a = i;
                    break;
                }
            for (int i = b; i < a + 1; i++) {
                if (collect.get(i).contains(";"))
                    var = false;
            }

            Assert.assertTrue(
                    "В классе Cat не должно быть переменных",
                    var
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test08ClassCatNotMethod() {
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

            List<String> collect = stream.collect(Collectors.toList());
            int b = 0;
            int a = 0;
            boolean var = true;

            for (int i = 0; i < collect.size(); i++)
                if (collect.get(i).contains("public static class Cat")) {
                    b = i;
                    break;
                }
            for (int i = b; i < collect.size(); i++)
                if (collect.get(i).contains("}")) {
                    a = i;
                    break;
                }
            for (int i = b + 1; i < a + 1; i++) {
                if (collect.get(i).contains("{"))
                    var = false;
            }
            Assert.assertTrue(
                    "В классе Cat не должно быть методов",
                    var
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
