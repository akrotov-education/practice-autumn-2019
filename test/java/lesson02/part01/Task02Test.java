package lesson02.part01;

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

public class Task02Test {
    public static String fileName = "./src/main/java/lesson02/part1/Task02.java";

    @Before
    public void before(){
        SystemOutGatewayUtil.setCustomOut();
    }

    @After
    public void after(){
        SystemOutGatewayUtil.setOriginalOut();
    }

    @Test
    public void IsMethod() {
        boolean is = false;
        try {
            Stream<String> stream = Files.lines(Paths.get(fileName));
            List<String> collect = stream.collect(Collectors.toList());
            for (int i = 17; i < collect.size(); i++) {
                if (collect.get(i).contains("printString(String args)")) {
                    is = true;
                    break;
                }
            }
            Assert.assertEquals("Нужно добавить метод printString, у которого аргумент имеет тип String", true, is);
        } catch (IOException e) {
        }
    }

    @Test
    public void IsMethodVoid() {
        boolean is = false;
        try {
            Stream<String> stream = Files.lines(Paths.get(fileName));
            List<String> collect = stream.collect(Collectors.toList());
            for (int i = 17; i < collect.size(); i++) {
                if (collect.get(i).contains("void printString(String args)")) {
                    is = true;
                    break;
                }
            }
            Assert.assertEquals("Метод printString должен быть void", true, is);
        } catch (IOException e) {
        }
    }

    @Test
    public void IsMethodStatic() {
        boolean is = false;
        try {
            Stream<String> stream = Files.lines(Paths.get(fileName));
            List<String> collect = stream.collect(Collectors.toList());
            for (int i = 17; i < collect.size(); i++) {
                if (collect.get(i).contains("static")|collect.get(i).contains("printString")) {
                    is = true;
                    break;
                }
            }
            Assert.assertEquals("Метод printString должен быть static", true, is);
        } catch (IOException e) {
        }
    }

    @Test
    public void IsMethodPublic() {
        boolean is = false;
        try {
            Stream<String> stream = Files.lines(Paths.get(fileName));
            List<String> collect = stream.collect(Collectors.toList());
            for (int i = 17; i < collect.size(); i++) {
                if (collect.get(i).contains("public")|collect.get(i).contains("printString")) {
                    is = true;
                    break;
                }
            }
            Assert.assertEquals("Метод printString должен быть public", true, is);
        } catch (IOException e) {
        }
    }

    @Test
    public void IsMethodPrint() {
        boolean is = false;
        try {
            Stream<String> stream = Files.lines(Paths.get(fileName));
            List<String> collect = stream.collect(Collectors.toList());
            int ind = collect.indexOf("public static void printString(String args) {");
            int ind2 = collect.indexOf("    }");
            for (int i = ind; i < ind2; i++) {
                if (collect.get(i).contains("System.out.print")) {
                    is = true;
                    break;
                }
            }
            Assert.assertEquals("Метод printString должен выводить переданный текст на экран", true, is);
        } catch (IOException e) {
        }
    }

    @Test
    public void EqualsRightResult() {
        lesson02.part01.Task02.main(null);
        ByteArrayOutputStream stream = SystemOutGatewayUtil.getOutputArray();
        String result = stream.toString();
        Assert.assertEquals("Программа должна вывести \"Hello, Amigo;\"" ,
                "Hello, Amigo;\r\n", result);
    }
}