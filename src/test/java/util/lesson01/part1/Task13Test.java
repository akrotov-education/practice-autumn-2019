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
public class Task13Test {
    public static String fileName = "./src/main/java/lesson01/part1/Task13.java";

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
    public void test13PublicStaticGetVolume() {
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

            List<String> collect = stream.collect(Collectors.toList());
            boolean var = false;

            for (int i = 0; i < collect.size(); i++) {
                if (collect.get(i).contains("public static") && collect.get(i).contains("getWeight(int earthWeight)")) {
                    var = true;
                    break;
                }
            }

            Assert.assertTrue(
                    "Метод getWeight(int) должен быть публичным и статическим",
                    var
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test13ReturnDouble() {
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

            List<String> collect = stream.collect(Collectors.toList());
            boolean var = false;

            for (int i = 0; i < collect.size(); i++) {
                if (collect.get(i).contains("public static double getWeight(int earthWeight)")){
                    var = true;
                    break;
                }
            }

            Assert.assertTrue(
                    "Метод getWeight должен возвращать значение типа double",
                    var
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test13OutputScreenGetWeight() {
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

            List<String> collect = stream.collect(Collectors.toList());
            int b = 0;
            int a = 0;
            boolean var = true;

            for (int i = 0; i < collect.size(); i++)
                if (collect.get(i).contains("public static double getWeight(int earthWeight)")) {
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
                    "Метод getWeight не должен ничего выводить на экран",
                    var
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}