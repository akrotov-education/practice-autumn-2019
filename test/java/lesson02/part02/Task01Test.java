package lesson02.part02;

import lesson02.part01.Task09;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import util.SystemOutGatewayUtil;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class Task01Test {

    public static String fileName = "./src/main/java/lesson02/part02/Task01.java";

    @Before
    public void setUp() {
        SystemOutGatewayUtil.setCustomOut();
    }

    @After
    public void tearDown() {
        SystemOutGatewayUtil.clearOutput();
        SystemOutGatewayUtil.setOriginalOut();
    }

    @Test
    public void checkOutput() {
        Task01.main(null);
        ByteArrayOutputStream output = SystemOutGatewayUtil.getOutputArray();
        Assert.assertTrue("Программа должна выводить текст на экран", output.toString().length() > 0);
    }

    @Test
    public void checkAdjustAgeOutput() {
        Task01.Person person = new Task01.Person();
        person.adjustAge(20);
        ByteArrayOutputStream output = SystemOutGatewayUtil.getOutputArray();
        Assert.assertTrue("Метод adjustAge класса Person должен выводить текст на экран", output.toString().length() > 0);
    }

    @Test
    public void checkAdjustAgeParams() {
        Method method;
        try {
            method = Task01.Person.class.getMethod("adjustAge", int.class);
            Assert.assertTrue("Метод adjustAge класса Person должен иметь тип возвращаемого значения void",
                    method.toString().contains("void"));
        } catch (NoSuchMethodException e) {
            Assert.fail("Метод adjustAge класса Person должен иметь только один параметр age типа int");
        }
    }

    @Test
    public void mainCallAdjustAgeOnce() {
        try {
            Stream<String> stream = Files.lines(Paths.get(fileName));
            List<String> lines = stream.collect(Collectors.toList());
            int startLine = 0;
            for (int i = 0; i < lines.size(); i++) {
                if (lines.get(i).contains("public static void main")) {
                    startLine = i;
                    break;
                }
            }

            int callsCount = 0;
            for (int i = startLine; i < lines.size(); i++) {
                String line = lines.get(i);
                if (line.contains("}")) {
                    break;
                }

                if (line.contains("adjustAge")) {
                    callsCount++;
                }
            }
            Assert.assertTrue("Метод main должен вызывать метод adjustAge только один раз", callsCount == 1);
        } catch (IOException e) {
        }
    }

    @Test
    public void checkAdjusting() {
        Task01.Person person = new Task01.Person();
        person.adjustAge(20);
        Assert.assertEquals("Метод adjustAge класса Person должен увеличивать возраст человека (Person) на 20",
                40,person.age);
    }
}