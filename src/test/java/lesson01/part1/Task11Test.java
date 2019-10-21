package lesson01.part1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import util.SystemOutGatewayUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task11Test {
    public static String fileName = "./src/main/java/lesson01/part1/Task11.java";

    @Before
    public void before() {
        SystemOutGatewayUtil.setCustomOut();
    }

    @Test
    public void test11PublicStaticGetVolume() {
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

            List<String> collect = stream.collect(Collectors.toList());
            boolean var = false;

            for (int i = 0; i < collect.size(); i++) {
                if (collect.get(i).contains("public static") && collect.get(i).contains("getVolume(int a, int b, int c)")) {
                    var = true;
                    break;
                }
            }

            Assert.assertTrue(
                    "Метод getVolume(int, int, int) должен быть публичным и статическим",
                    var
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test11ReturnLong() {
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

            List<String> collect = stream.collect(Collectors.toList());
            boolean var = false;

            for (int i = 0; i < collect.size(); i++) {
                if (collect.get(i).contains("public static long getVolume(int a, int b, int c)")){
                    var = true;
                    break;
                }
            }

            Assert.assertTrue(
                    "Метод getVolume(int, int, int) должен возвращать значение типа long",
                    var
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test11GetVolumeNotOutputScreen() {
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

            List<String> collect = stream.collect(Collectors.toList());
            int b = 0;
            int a = 0;
            boolean var = true;

            for (int i = 0; i < collect.size(); i++)
                if (collect.get(i).contains("public static long getVolume(int a, int b, int c)")) {
                    a = i + 1;
                    break;
                }
            for (int i = a; i < collect.size(); i++)
                if (collect.get(i).contains("}")) {
                    b = i;
                    break;
                }
            for (int i = a; i < b; i++) {
                if (collect.get(i).contains("System.out.print"))
                    var = false;
            }
            Assert.assertTrue(
                    "Метод getVolume(int, int, int) не должен ничего выводить на экран",
                    var
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test11Litr() {
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

            List<String> collect = stream.collect(Collectors.toList());
            int b = 0;
            int a = 0;
            boolean var = false;

            for (int i = 0; i < collect.size(); i++)
                if (collect.get(i).contains("public static long getVolume(int a, int b, int c)")) {
                    a = i + 1;
                    break;
                }
            for (int i = a; i < collect.size(); i++)
                if (collect.get(i).contains("}")) {
                    b = i;
                    break;
                }
            for (int i = a; i < b; i++) {
                if (collect.get(i).contains("/0.001"))
                    var = true;
            }
            Assert.assertTrue(
                    "Метод getVolume(int, int, int) должен правильно возвращать количество воды, которое необходимо для наполнения бассейна в литрах",
                    var
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
