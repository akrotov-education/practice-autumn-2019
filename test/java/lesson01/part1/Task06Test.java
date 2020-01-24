package lesson01.part1;

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
public class Task06Test {
    public static String fileName = "./src/main/java/lesson01/part1/Task06.java";

    @Before
    public void before(){
        SystemOutGatewayUtil.setCustomOut();
    }

    @After
    public void after(){
        SystemOutGatewayUtil.setOriginalOut();
    }


    @Test
    public void MethodContainsLineFormule(){
        try {
            Stream<String> stream = Files.lines(Paths.get(fileName));
            List<String> line = stream.collect(Collectors.toList());
            String lineWithMethodCall = line.get(25);
            Assert.assertTrue("Строка должна содержать 2*3.14*radius",
                    lineWithMethodCall.contains("2*3.14*radius"));
        } catch (IOException e) {
        }
    }

    @Test
    public void MainContainsLineCallParam(){
        try {
            Stream<String> stream = Files.lines(Paths.get(fileName));
            List<String> line = stream.collect(Collectors.toList());
            String lineWithMethodCall = line.get(21);
            Assert.assertTrue("Строка должна содержать printCircleLength(5);",
                    lineWithMethodCall.contains("printCircleLength(5);"));
        } catch (IOException e) {
        }
    }

    @Test
    public void EqualsRightResult() {
        Task06.printCircleLength(5);
        ByteArrayOutputStream stream = SystemOutGatewayUtil.getOutputArray();
        String result = stream.toString();
        Assert.assertEquals("Программа должна выводить 31.400000000000002",
                31.400000000000002, Double.parseDouble(result), 0.00000000001);
    }

    @Test
    public void IsMethodPrint() {
    boolean isMethodPrints = false;
        try {
            Stream<String> stream = Files.lines(Paths.get(fileName));
            List<String> collect = stream.collect(Collectors.toList());
            //int index = collect.indexOf("public static void main(String[] args) {");
            //int index2 = collect.indexOf(" public static void printCircleLength(int radius) {");
            for (int i = 20; i < 25; i++) {
                if (collect.get(i).contains("System.out.print") || collect.get(i).contains("System.out.println")) {
                    isMethodPrints = true;
                    break;
                }
            }
            Assert.assertFalse("Метод ничего не должен печатать", isMethodPrints);
        } catch (IOException e) {
        }
}

}