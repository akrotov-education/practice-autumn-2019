package lesson01.part1;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import util.SystemOutGatewayUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.*;

public class Task15Test{
        public static String fileName = "./src/main/java/lesson01/part1/Task15.java";

        @Before
        public void before(){
            SystemOutGatewayUtil.setCustomOut();
        }

        @After
        public void after(){
            SystemOutGatewayUtil.setOriginalOut();
        }

    @Test
    public void PubStatNumber(){
        try {
            Stream<String> stream = Files.lines(Paths.get(fileName));
            List<String> line = stream.collect(Collectors.toList());
            String lineWithMethodCall = line.get(18);
            Assert.assertTrue("У переменной number можно менять только значение",
                    lineWithMethodCall.contains("public static int number ="));
        } catch (IOException e) {
        }
    }

    @Test
    public void IsMethodPrint() {
        boolean isMethodPrints = false;
        try {
            Stream<String> stream = Files.lines(Paths.get(fileName));
            List<String> collect = stream.collect(Collectors.toList());
            for (int i = 0; i < collect.size(); i++) {
                if (collect.get(i).contains("System.out.print") || collect.get(i).contains("System.out.println")) {
                    isMethodPrints = true;
                    break;
                }
            }
            Assert.assertTrue("Программа должна выводить текст", isMethodPrints);
        } catch (IOException e) {
        }
    }
    @Test
    public void IsOutputNumber(){
        try {
            Stream<String> stream = Files.lines(Paths.get(fileName));
            List<String> line = stream.collect(Collectors.toList());
            String lineWithMethodCall = line.get(21);
            Assert.assertTrue("Выводимый текст должен быть числом",
                    lineWithMethodCall.contains("System.out.print(Math"));
            //если юзаем какой-то метод Math. , значит результатом будет число
        } catch (IOException e) {
        }
    }

    @Test
    public void IsOutputPow(){
        try {
            Stream<String> stream = Files.lines(Paths.get(fileName));
            List<String> line = stream.collect(Collectors.toList());
            String lineWithMethodCall = line.get(21);
            Assert.assertTrue("Выводимый текст должен быть квадратом переменной number",
                    lineWithMethodCall.contains("Math.pow(number,2)"));
        } catch (IOException e) {
        }
    }
}