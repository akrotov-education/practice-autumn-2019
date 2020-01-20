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

public class Task08Test {
    public static String fileName = "./src/main/java/lesson01/part2/Task08.java";

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
            Assert.assertEquals("Программа не должна выводить текст на экран", false, is);
        } catch (IOException e) {
        }
    }

    @Test
    public void TenVar() {
        int is = 0;
        try {
            Stream<String> stream = Files.lines(Paths.get(fileName));
            List<String> collect = stream.collect(Collectors.toList());
            int ind = collect.indexOf("    public static void main(String[] args) {");
            int ind2 = collect.indexOf("    }");
            for (int i = ind; i < ind2; i++) {
                if (collect.get(i).contains("Cat ")) {
                    is ++;
                }
            }
            Assert.assertEquals("В методе main должно быть 10 переменных типа Cat", 10, is);
        } catch (IOException e) {
        }
    }

    @Test
    public void EightVar() {
        int is = 0;
        try {
            Stream<String> stream = Files.lines(Paths.get(fileName));
            List<String> collect = stream.collect(Collectors.toList());
            int ind = collect.indexOf("    public static void main(String[] args) {");
            int ind2 = collect.indexOf("    }");
            for (int i = ind; i < ind2; i++) {
                if (collect.get(i).contains("= new Cat()")) {
                    is ++;
                }
            }
            Assert.assertEquals("В методе main 8 переменных должны быть проинициализированы", 8, is);
        } catch (IOException e) {
        }
    }

    @Test
    public void NullInClass() {
        try {
            Stream<String> stream = Files.lines(Paths.get(fileName));
            List<String> collect = stream.collect(Collectors.toList());
            int ind = collect.indexOf("    public static class Cat {");
            int ind2 = collect.indexOf("    }");
            for (int i = ind; i < ind2; i++) {
                Assert.assertNull("В классе Cat не должно быть переменных или методов", collect.get(i));
            }
        } catch (IOException e) {
        }
    }
}