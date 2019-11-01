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
public class Task09Test {
    public static String fileName = "./src/main/java/lesson01/part1/Task09.java";

    @Before
    public void before(){
        SystemOutGatewayUtil.setCustomOut();
    }

    @After
    public void after(){
        SystemOutGatewayUtil.setOriginalOut();
    }

    @Test
    public void ifKeyboardInput() {
        boolean isInputExist = false;
        try {
            Stream<String> stream = Files.lines(Paths.get(fileName));
            List<String> collect = stream.collect(Collectors.toList());
            for (String s : collect) {
                if (s.contains("Scanner")) {
                    isInputExist = true;
                    break;
                }
            }
            Assert.assertFalse("Программа не должна считывать данные с клавиатуры",isInputExist);
        } catch (IOException e) {
        }
    }

    @Test
    public void MethodContainsLinePublicStatic(){
        try {
            Stream<String> stream = Files.lines(Paths.get(fileName));
            List<String> line = stream.collect(Collectors.toList());
            String lineWithMethodCall = line.get(27);
            Assert.assertTrue("Метод sumDigitsInNumber(int) должен быть публичным и статическим",
                    lineWithMethodCall.contains("public static") &
                            lineWithMethodCall.contains("sumDigitsInNumber"));
        } catch (IOException e) {
        }
    }

    @Test
    public void MethodContainsLineInt(){
        try {
            Stream<String> stream = Files.lines(Paths.get(fileName));
            List<String> line = stream.collect(Collectors.toList());
            String lineWithMethodCall = line.get(27);
            Assert.assertTrue("Метод sumDigitsInNumber должен возвращать значение типа int",
                    lineWithMethodCall.contains("sumDigitsInNumber(int number)"));
        } catch (IOException e) {
        }
    }

    @Test
    public void IsMethodPrint() {
        boolean isMethodPrints = false;
        try {
            Stream<String> stream = Files.lines(Paths.get(fileName));
            List<String> collect = stream.collect(Collectors.toList());
            int index = collect.indexOf("    public static int sumDigitsInNumber(int number) {");
            collect.get(28);
            for (int i = index; i < collect.size(); i++) {
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
    public void EqualsRightResult() {
        Task09.main(null);
        ByteArrayOutputStream stream = SystemOutGatewayUtil.getOutputArray();
        String result = stream.toString();
        Assert.assertEquals("Метод sumDigitsInNumber должен правильно возвращать сумму всех цифр в числе number",
                15, Integer.parseInt(result), 1);
    }

}