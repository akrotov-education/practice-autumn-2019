package lesson02.part02;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import util.SystemOutGatewayUtil;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class Task08Test {

    public static String fileName = "./src/main/java/lesson02/part02/Task08.java";
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
        Task08.main(null);
        ByteArrayOutputStream output = SystemOutGatewayUtil.getOutputArray();
        Assert.assertTrue("Программа должна выводить текст на экран", output.toString().length() > 0);
    }

    @Test
    public void mainDoesntCallPrint() {
        try{
            Stream<String> stream = Files.lines(Paths.get(fileName));
            List<String> lines = stream.collect(Collectors.toList());
            int startLine = 0;
            for (int i = 0; i < lines.size(); i++) {
                if (lines.get(i).contains("public static void main")) {
                    startLine = i;
                    break;
                }
            }

            for (int i = startLine; i < lines.size(); i++) {
                String line = lines.get(i);
                if (line.contains("}")) {
                    break;
                }
                if (line.contains("System.out.print")) {
                    Assert.fail("Метод main не должен вызывать System.out.println или System.out.print");
                }
            }
        } catch (IOException e) {
        }
    }

    @Test
    public void mainCallsCompare() {
        try{
            Stream<String> stream = Files.lines(Paths.get(fileName));
            List<String> lines = stream.collect(Collectors.toList());
            int startLine = 0;
            for (int i = 0; i < lines.size(); i++) {
                if (lines.get(i).contains("public static void main")) {
                    startLine = i;
                    break;
                }
            }

            Boolean isCallingCompare = false;
            for (int i = startLine; i < lines.size(); i++) {
                String line = lines.get(i);
                if (line.contains("}")) {
                    break;
                }
                if (line.contains("compare")) {
                    isCallingCompare = true;
                    break;
                }
            }

            Assert.assertTrue("Метод main должен вызывать метод compare", isCallingCompare);
        } catch (IOException e) {
        }
    }

    @Test
    public void checkCompareType() {
        try {
            String type = Task08.class.getMethod("compare", int.class).getReturnType().toString();
            Assert.assertEquals("Метод compare должен быть void",
                    "void", type);
        } catch (NoSuchMethodException e) {
        }
    }

    @Test
    public void checkCompareWork() {
        Task08.compare(4);
        Task08.compare(6);
        Task08.compare(5);
        ByteArrayOutputStream output = SystemOutGatewayUtil.getOutputArray();
        String[] outLines = output.toString().split("\r\n");
        Assert.assertEquals("Метод compare должен выводить текст на экран согласно заданию", "Число меньше 5", outLines[0]);
        Assert.assertEquals("Метод compare должен выводить текст на экран согласно заданию", "Число больше 5", outLines[1]);
        Assert.assertEquals("Метод compare должен выводить текст на экран согласно заданию", "Число равно 5", outLines[2]);
    }
}