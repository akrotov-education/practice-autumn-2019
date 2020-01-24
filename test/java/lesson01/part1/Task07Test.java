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
public class Task07Test {
    public static String fileName = "./src/main/java/lesson01/part1/Task07.java";

    @Before
    public void before(){
        SystemOutGatewayUtil.setCustomOut();
    }

    @After
    public void after(){
        SystemOutGatewayUtil.setOriginalOut();
    }

    @Test
    public void MethodContainsLinePublicStatic(){
        try {
            Stream<String> stream = Files.lines(Paths.get(fileName));
            List<String> line = stream.collect(Collectors.toList());
            String lineWithMethodCall = line.get(27);
            Assert.assertTrue("Метод convertCelsiusToFahrenheit(int) должен быть публичным и статическим",
                    lineWithMethodCall.contains("public static ") &
                            lineWithMethodCall.contains("convertCelsiusToFahrenheit(int"));
        } catch (IOException e) {
        }
    }

    @Test
    public void MethodContainsLineDouble(){
        try {
            Stream<String> stream = Files.lines(Paths.get(fileName));
            List<String> line = stream.collect(Collectors.toList());
            String lineWithMethodCall = line.get(27);
            Assert.assertTrue("Метод convertCelsiusToFahrenheit должен возвращать значение типа double",
                    lineWithMethodCall.contains("double convertCelsiusToFahrenheit(int"));
        } catch (IOException e) {
        }
    }

    @Test
    public void IsMethodPrint() {
        boolean isMethodPrints = false;
        try {
            Stream<String> stream = Files.lines(Paths.get(fileName));
            List<String> collect = stream.collect(Collectors.toList());
            //int index = collect.indexOf("public static double convertCelsiusToFahrenheit(int celsius) {");
            for (int i = 27; i < 31; i++) {
                if (collect.get(i).contains("System.out.print") || collect.get(i).contains("System.out.println")) {
                    isMethodPrints = true;
                    break;
                }
            }
            Assert.assertFalse("Метод ничего не должен печатать", isMethodPrints);
        } catch (IOException e) {
        }
    }

    @Test
    public void EqualsRightResult(){
        Task07.main(null);
        Task07.convertCelsiusToFahrenheit(41);
        ByteArrayOutputStream stream = SystemOutGatewayUtil.getOutputArray();
        String result = stream.toString();
        Assert.assertEquals("Программа должна выводить 105.8",
                105.8, Double.parseDouble(result), 0.0000001);
    }

}