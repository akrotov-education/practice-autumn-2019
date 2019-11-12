package lesson01.part2;

import lesson01.part1.Task01;
import lesson01.part1.Task08;
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

public class Task03Test {
    public static String fileName = "./src/main/java/lesson01/part2/Task03.java";

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
        Task03.main(null);
        ByteArrayOutputStream stream = SystemOutGatewayUtil.getOutputArray();
        String result = stream.toString();
        Assert.assertNotNull("Программа должна выводить текст", result);
        stream.reset();
    }

    @Test
    public void IsOutputInMain() {
        boolean is = false;
        try {
            Stream<String> stream = Files.lines(Paths.get(fileName));
            List<String> collect = stream.collect(Collectors.toList());
            int index = collect.indexOf("    public static void main(String[] args) {");
            int index2 = collect.indexOf("    }");
            for (int i = index; i < index2; i++) {
                if ((collect.get(i).contains("System.out.println"))|(collect.get(i).contains("System.out.print"))) {
                    is = true;
                    break;
                }
            }
            Assert.assertFalse("Метод main не должен вызывать System.out.println или System.out.print", is);
        } catch (IOException e) {
        }
    }

    @Test
    public void IsReturn() {
        boolean is = false;
        try {
            Stream<String> stream = Files.lines(Paths.get(fileName));
            List<String> collect = stream.collect(Collectors.toList());
            int index = collect.indexOf("    public static void hackSalary(int a) {");
            int index2 = collect.indexOf("    }");
            for (int i = index; i < index2; i++) {
                if (collect.get(i).contains("return")) {
                    is = true;
                    break;
                }
            }
            Assert.assertFalse("Метод hackSalary не должен возвращать результат", is);
        } catch (IOException e) {
        }
    }

    @Test
    public void CallOneTime() {
        int is = 0;
        try {
            Stream<String> stream = Files.lines(Paths.get(fileName));
            List<String> collect = stream.collect(Collectors.toList());
            int index = collect.indexOf("    public static void main(String[] args) {");
            int index2 = collect.indexOf("    }");
            for (int i = index; i < index2; i++) {
                if (collect.get(i).contains("hackSalary")) {
                    is ++;
                }
            }
            Assert.assertEquals("Метод main должен вызвать метод hackSalary только один раз", 1, is);
        } catch (IOException e) {
        }
    }

    @Test
    public void EqualsRightResult() {
        Task03.main(null);
        ByteArrayOutputStream stream = SystemOutGatewayUtil.getOutputArray();
        String result = stream.toString();
        Assert.assertEquals("Метод должен возвращать правильную надпись" ,
                "Твоя зарплата составляет: 800 долларов в месяц", result);
    }
}