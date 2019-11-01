package lesson02.part01;

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

public class Task04Test {
    public static String fileName = "./src/main/java/lesson02/part1/Task04.java";

    @Before
    public void before(){
        SystemOutGatewayUtil.setCustomOut();
    }

    @After
    public void after(){
        SystemOutGatewayUtil.setOriginalOut();
    }

    @Test
    public void IsMethodIncrease() {
        boolean is = false;
        try {
            Stream<String> stream = Files.lines(Paths.get(fileName));
            List<String> collect = stream.collect(Collectors.toList());
            int ind = collect.indexOf("    public static double addTenPercent(int i) {");
            int ind2 = collect.indexOf("    }");
            for (int i = ind; i < ind2; i++) {
                if (collect.get(i).contains("i*1.1")) {
                    is = true;
                    break;
                }
            }
            Assert.assertEquals("Метод addTenPercent должен увеличивать переданное число на 10% процентов", true, is);
        } catch (IOException e) {
        }
    }

    @Test
    public void IsMainCall() {
        boolean is = false;
        try {
            Stream<String> stream = Files.lines(Paths.get(fileName));
            List<String> collect = stream.collect(Collectors.toList());
            int ind = collect.indexOf("    public static void main(String[] args) {");
            for (int i = ind; i < collect.size(); i++) {
                if (collect.get(i).contains("addTenPercent(")) {
                    is = true;
                    break;
                }
            }
            Assert.assertEquals("Метод main должен вызывать метод addTenPercent", true, is);
        } catch (IOException e) {
        }
    }

    @Test
    public void IsMainPrint() {
        boolean is = false;
        try {
            Stream<String> stream = Files.lines(Paths.get(fileName));
            List<String> collect = stream.collect(Collectors.toList());
            int ind = collect.indexOf("    public static void main(String[] args) {");
            for (int i = ind; i < collect.size(); i++) {
                if (collect.get(i).contains("System.out.print(")) {
                    is = true;
                    break;
                }
            }
            Assert.assertEquals("Метод main должен выводить результаты вызова на экран", true, is);
        } catch (IOException e) {
        }
    }

    @Test
    public void IsMethodPrint() {
        boolean is = false;
        try {
            Stream<String> stream = Files.lines(Paths.get(fileName));
            List<String> collect = stream.collect(Collectors.toList());
            int ind = collect.indexOf("    public static double addTenPercent(int i) {");
            int ind2 = collect.indexOf("    }");
            for (int i = ind; i < ind2; i++) {
                if (collect.get(i).contains("System.out.print(")) {
                    is = true;
                    break;
                }
            }
            Assert.assertEquals("Метод addTenPercent не должен ничего выводить на экран", true, is);
        } catch (IOException e) {
        }
    }

}