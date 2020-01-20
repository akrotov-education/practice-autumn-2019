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

public class Task04Test {
    public static String fileName = "./src/main/java/lesson01/part2/Task04.java";

    @Before
    public void before(){
        SystemOutGatewayUtil.setCustomOut();
    }

    @After
    public void after(){
        SystemOutGatewayUtil.setOriginalOut();
    }

    @Test
    public void IsTextOut(){
        Task04.main(null);
        ByteArrayOutputStream stream = SystemOutGatewayUtil.getOutputArray();
        String result = stream.toString();
        Assert.assertNotNull("Программа должна выводить текст", result);
        stream.reset();
    }

    @Test
    public void CallOneTime() {
        int is = 0;
        try {
            Stream<String> stream = Files.lines(Paths.get(fileName));
            List<String> collect = stream.collect(Collectors.toList());
            int index = collect.indexOf("    public static void main(String[] args) {");
            for (int i = index; i < collect.size(); i++) {
                if (collect.get(i).contains("int ")) {
                    is ++;
                }
            }
            Assert.assertEquals("В программе должны быть только две переменные: a и b типа int", 2, is);
        } catch (IOException e) {
        }
    }

    @Test
    public void IsReturn() {
        boolean is = false;
        try {
            Stream<String> stream = Files.lines(Paths.get(fileName));
            List<String> collect = stream.collect(Collectors.toList());
            int index = collect.indexOf("    public static void main(String[] args) {");
            for (int i = index; i < collect.size(); i++) {
                if (collect.get(i).contains("int a =")) {
                    is = true;
                    break;
                }
            }
            Assert.assertTrue("Переменным сразу должны быть присвоены значения (a)", is);
        } catch (IOException e) {
        }
        is = false;
        try {
            Stream<String> stream = Files.lines(Paths.get(fileName));
            List<String> collect = stream.collect(Collectors.toList());
            int index = collect.indexOf("    public static void main(String[] args) {");
            for (int i = index; i < collect.size(); i++) {
                if (collect.get(i).contains("int b =")) {
                    is = true;
                    break;
                }
            }
            Assert.assertTrue("Переменным сразу должны быть присвоены значения (b)", is);
        } catch (IOException e) {
        }
    }

    @Test
    public void IsOutputSum() {
        boolean is = false;
        try {
            Stream<String> stream = Files.lines(Paths.get(fileName));
            List<String> collect = stream.collect(Collectors.toList());
            int index = collect.indexOf("    public static void main(String[] args) {");
            for (int i = index; i < collect.size(); i++) {
                if (collect.get(i).contains("System.out.println(a+b);")) {
                    is = true;
                    break;
                }
            }
            Assert.assertTrue("Метод main должен выводить на экран сумму переменных a и b", is);
        } catch (IOException e) {
        }
    }

    @Test
    public void IsOutputMultiply() {
        boolean is = false;
        try {
            Stream<String> stream = Files.lines(Paths.get(fileName));
            List<String> collect = stream.collect(Collectors.toList());
            int index = collect.indexOf("    public static void main(String[] args) {");
            for (int i = index; i < collect.size(); i++) {
                if (collect.get(i).contains("System.out.println(a*b);")) {
                    is = true;
                    break;
                }
            }
            Assert.assertTrue("Метод main должен выводить на экран произведение переменных a и b", is);
        } catch (IOException e) {
        }
    }

    @Test
    public void EqualsRightResult() {
        Task04.main(null);
        ByteArrayOutputStream stream = SystemOutGatewayUtil.getOutputArray();
        String result = stream.toString();
        Assert.assertEquals("Каждое значение должно быть выведено с новой строки" ,
                "12\r\n35\r\n", result);
    }
}