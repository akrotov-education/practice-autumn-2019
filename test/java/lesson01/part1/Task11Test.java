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

public class Task11Test {
    public static String fileName = "./src/main/java/lesson01/part1/Task11.java";

    @Before
    public void before() {
        SystemOutGatewayUtil.setCustomOut();
    }

    @After
    public void after() {
        SystemOutGatewayUtil.setOriginalOut();
    }

    @Test
    public void MethodContainsLinePublicStatic() {
        try {
            Stream<String> stream = Files.lines(Paths.get(fileName));
            List<String> line = stream.collect(Collectors.toList());
            String lineWithMethodCall = line.get(28);
            Assert.assertTrue("Метод getVolume(int, int, int) должен быть публичным и статическим",
                    lineWithMethodCall.contains("public static") &
                            lineWithMethodCall.contains("getVolume"));
        } catch (IOException e) {
        }
    }

    @Test
    public void IsOutputLong() {
        try {
            Stream<String> stream = Files.lines(Paths.get(fileName));
            List<String> line = stream.collect(Collectors.toList());
            String lineWithMethodCall = line.get(28);
            Assert.assertTrue("Метод getVolume(int, int, int) должен возвращать значение типа long",
                    lineWithMethodCall.contains("long getVolume(int"));
        } catch (IOException e) {
        }
    }

    @Test
    public void IsMethodPrint() {
        boolean isMethodPrints = false;
        try {
            Stream<String> stream = Files.lines(Paths.get(fileName));
            List<String> collect = stream.collect(Collectors.toList());
            int index1 = collect.indexOf("        public static long getVolume(int a, int b, int c) {");
            int index2 = collect.indexOf("    public static void main(String[] args) {");
            for (int i = index1; i < index2; i++) {
                if (collect.get(i).contains("System.out.print") || collect.get(i).contains("System.out.println")) {
                    isMethodPrints = true;
                    break;
                }
            }
            Assert.assertFalse("Метод getVolume(int, int, int) не должен ничего выводить на экран", isMethodPrints);
        } catch (IOException e) {
        }
    }

    @Test
    public void EqualsRightResult() {
        Task11.main(null);
        ByteArrayOutputStream stream = SystemOutGatewayUtil.getOutputArray();
        String result = stream.toString();
        Assert.assertEquals("Метод должен  возвращать 250000" ,250000, Integer.parseInt(result));
    }

}