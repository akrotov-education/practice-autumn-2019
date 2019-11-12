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

public class Task03Test {
    public static String fileName = "./src/main/java/lesson02/part1/Task03.java";

    @Before
    public void before(){
        SystemOutGatewayUtil.setCustomOut();
    }

    @After
    public void after(){
        SystemOutGatewayUtil.setOriginalOut();
    }

    @Test
    public void IsMethodReturn() {
        boolean is = false;
        try {
            Stream<String> stream = Files.lines(Paths.get(fileName));
            List<String> collect = stream.collect(Collectors.toList());
            int ind = collect.indexOf("    public static double convertEurToUsd(int eur, double course) {");
            for (int i = ind; i < collect.size(); i++) {
                if (collect.get(i).contains("return (eur*course)")) {
                    is = true;
                    break;
                }
            }
            Assert.assertEquals("Метод convertEurToUsd должен умножать евро на курс и возвращать полученный результат",
                    true, is);
        } catch (IOException e) {
        }
    }

    @Test
    public void IsMethodCallTwoTimes() {
        int is = 0;
        try {
            Stream<String> stream = Files.lines(Paths.get(fileName));
            List<String> collect = stream.collect(Collectors.toList());
            int ind = collect.indexOf("    public static void main(String[] args) {");
            int ind2 = collect.indexOf("    public static double convertEurToUsd(int eur, double course) {");
            for (int i = ind; i < collect.size(); i++) {
                if (collect.get(i).contains("convertEurToUsd(")) {
                    is ++;
                }
            }
            Assert.assertEquals("Метод main должен 2 раза вызвать метод convertEurToUsd с любыми параметрами",
                    2, is);
        } catch (IOException e) {
        }
    }

    @Test
    public void EqualsRightResult() {
        lesson02.part01.Task03.main(null);
        ByteArrayOutputStream stream = SystemOutGatewayUtil.getOutputArray();
        String result = stream.toString();
        Assert.assertEquals("Метод main должен выводить результаты вызовов на экран, каждый раз с новой строки" ,
                "30.0\r\n150.0\r\n", result);
    }

    @Test
    public void IsMethodOutput() {
        boolean is = false;
        try {
            Stream<String> stream = Files.lines(Paths.get(fileName));
            List<String> collect = stream.collect(Collectors.toList());
            int ind = collect.indexOf("    public static double convertEurToUsd(int eur, double course) {");
            for (int i = ind; i < collect.size(); i++) {
                if (collect.get(i).contains("System.out.print")) {
                    is = true;
                    break;
                }
            }
            Assert.assertEquals("Метод convertEurToUsd не должен ничего выводить на экран",
                    false, is);
        } catch (IOException e) {
        }
    }
}