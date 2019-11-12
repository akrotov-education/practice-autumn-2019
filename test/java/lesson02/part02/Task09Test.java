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
public class Task09Test {

    public static String fileName = "./src/main/java/lesson02/part02/Task09.java";
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
        Task09.main(null);

        ByteArrayOutputStream output = SystemOutGatewayUtil.getOutputArray();
        Assert.assertTrue("The program must output numbers", output.toString().length() > 0);
        String[] outLines = output.toString().split("\r\n");

        try {
            for (String line : outLines) {
                Integer.parseInt(line);
            }
        } catch (NumberFormatException e) {
            Assert.fail("Программа должна выводить числа на экран");
        }
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
                    Assert.fail("Метод main не должен вызывать System.out.println() или System.out.print()");
                }
            }
        } catch (IOException e) {
        }
    }

    @Test
    public void mainCallsDisplayClosestToTen() {
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

                if (line.contains("displayClosestToTen")) {
                    isCallingCompare = true;
                    break;
                }
            }

            Assert.assertTrue("Метод main должен вызывать метод displayClosestToTen", isCallingCompare);
        } catch (IOException e) {
        }
    }

    @Test
    public void displayClosestToTenCallsAbs() {
        try{
            Stream<String> stream = Files.lines(Paths.get(fileName));
            List<String> lines = stream.collect(Collectors.toList());
            int startLine = 0;
            for (int i = 0; i < lines.size(); i++) {
                if (lines.get(i).contains("public static void displayClosestToTen")) {
                    startLine = i;
                    break;
                }
            }
            Boolean isCallingAbs = false;
            for (int i = startLine; i < lines.size(); i++) {
                String line = lines.get(i);
                if (line.contains("}")) {
                    break;
                }
                if (line.contains("abs")) {
                    isCallingAbs = true;
                    break;
                }
            }
            Assert.assertTrue("Метод displayClosestToTen должен вызывать метод abs", isCallingAbs);
        } catch (IOException e) {
        }
    }

    @Test
    public void checkDisplayClosestToTen() {
        Task09.displayClosestToTen(8, 11);
        Task09.displayClosestToTen(7, 14);

        ByteArrayOutputStream output = SystemOutGatewayUtil.getOutputArray();
        String[] outLines = output.toString().split("\r\n");

        Assert.assertEquals("Метод displayClosestToTen должен выводить число на экран согласно заданию",
                "11", outLines[0]);
        Assert.assertEquals("Метод displayClosestToTen должен выводить число на экран согласно заданию",
                "7", outLines[1]);
    }
}