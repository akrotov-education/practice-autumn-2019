package lesson01.part1;

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

public class Task13Test {
    public static String fileName = "./src/main/java/lesson01/part1/Task13.java";

    @Before
    public void before(){
        SystemOutGatewayUtil.setCustomOut();
    }

    @After
    public void after(){
        SystemOutGatewayUtil.setOriginalOut();
    }

    @Test
    public void MethodContainsLinePublicStatic() {
        try {
            Stream<String> stream = Files.lines(Paths.get(fileName));
            List<String> line = stream.collect(Collectors.toList());
            String lineWithMethodCall = line.get(30);
            Assert.assertTrue("Метод getWeight(int) должен быть публичным и статическим",
                    lineWithMethodCall.contains("public static") &
                            lineWithMethodCall.contains("getWeight"));
        } catch (IOException e) {
        }
    }

    @Test
    public void IsOutputLong() {
        try {
            Stream<String> stream = Files.lines(Paths.get(fileName));
            List<String> line = stream.collect(Collectors.toList());
            String lineWithMethodCall = line.get(30);
            Assert.assertTrue("Метод getWeight(int) должен возвращать значение типа double",
                    lineWithMethodCall.contains("double getWeight(int"));
        } catch (IOException e) {
        }
    }

    @Test
    public void IsMethodPrint() {
        boolean isMethodPrints = false;
        try {
            Stream<String> stream = Files.lines(Paths.get(fileName));
            List<String> collect = stream.collect(Collectors.toList());
            int index = collect.indexOf("    public static double getWeight(int earthWeight) {");
            for (int i = index; i < collect.size(); i++) {
                if (collect.get(i).contains("System.out.print") || collect.get(i).contains("System.out.println")) {
                    isMethodPrints = true;
                    break;
                }
            }
            Assert.assertFalse("Метод getWeight не должен ничего выводить на экран", isMethodPrints);
        } catch (IOException e) {
        }
    }

    @Test
    public void EqualsRightResult() {
        Task13.main(null);
        ByteArrayOutputStream stream = SystemOutGatewayUtil.getOutputArray();
        String result = stream.toString();
        Assert.assertEquals("Метод должен  возвращать 150.96" ,150.96, Double.parseDouble(result), 1);
    }

}