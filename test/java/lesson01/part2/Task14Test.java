package lesson01.part2;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import util.SystemOutGatewayUtil;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.*;

public class Task14Test {
    public static String fileName = "./src/main/java/lesson01/part2/Task14.java";

    @Before
    public void before(){
        SystemOutGatewayUtil.setCustomOut();
    }

    @After
    public void after(){
        SystemOutGatewayUtil.setOriginalOut();
    }

    @Test
    public void IsOutput() {
        boolean is = false;
        try {
            Stream<String> stream = Files.lines(Paths.get(fileName));
            List<String> collect = stream.collect(Collectors.toList());
            for (int i = 0; i < collect.size(); i++) {
                if (collect.get(i).contains("System.out.print")) {
                    is = true;
                    break;
                }
            }
            Assert.assertEquals("Программа должна выводить текст на экран", true, is);
        } catch (IOException e) {
        }
    }

    @Test
    public void IsPrintMain() {
        boolean is = false;
        try {
            Stream<String> stream = Files.lines(Paths.get(fileName));
            List<String> collect = stream.collect(Collectors.toList());
            int index = collect.indexOf("    public static void main(String[] args) {");
            for (int i = index; i < collect.size(); i++) {
                if ((collect.get(i).contains("System.out.print"))|collect.get(i).contains("System.out.println")) {
                    is = true;
                    break;
                }
            }
            Assert.assertFalse("Метод main не должен вызывать функцию System.out.println или System.out.print", is);
        } catch (IOException e) {
        }
    }

    @Test
    public void IsPrintMethod() {
        boolean is = false;
        try {
            Stream<String> stream = Files.lines(Paths.get(fileName));
            List<String> collect = stream.collect(Collectors.toList());
            int index = collect.indexOf("    public static void print3(String s) {");
            int index1 = collect.indexOf("    }");
            for (int i = index; i < index1; i++) {
                if (collect.get(i).contains("System.out.print")) {
                    is = true;
                    break;
                }
            }
            Assert.assertTrue("Метод print3 должен выводить текст на экран", is);
        } catch (IOException e) {
        }
    }

    @Test
    public void CallFourTimes() {
        int is = 0;
        try {
            Stream<String> stream = Files.lines(Paths.get(fileName));
            List<String> collect = stream.collect(Collectors.toList());
            int index = collect.indexOf("    public static void main(String[] args) {");
            for (int i = index; i < collect.size(); i++) {
                if (collect.get(i).contains("print3(")) {
                    is ++;
                }
            }
            Assert.assertEquals("Метод main должен вызывать min 2 раза", 2, is);
        } catch (IOException e) {
        }
    }

    @Test
    public void EqualsRightResult() {
        Task14.print3("o");
        ByteArrayOutputStream stream = SystemOutGatewayUtil.getOutputArray();
        String result = stream.toString();
        Assert.assertEquals("Метод print3 должен выводить переданную строку (слово) на экран три раза, но в одной строке",
                "o o o", result);
    }

}