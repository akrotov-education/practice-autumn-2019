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

public class Task06Test {
    public static String fileName = "./src/main/java/lesson02/part1/Task06.java";

    @Before
    public void before(){
        SystemOutGatewayUtil.setCustomOut();
    }

    @After
    public void after(){
        SystemOutGatewayUtil.setOriginalOut();
    }

    @Test
    public void IsInput() {
        boolean is = false;
        try {
            Stream<String> stream = Files.lines(Paths.get(fileName));
            List<String> collect = stream.collect(Collectors.toList());
            for (int i = 0; i < collect.size(); i++) {
                if (collect.get(i).contains("Scanner")) {
                    is = true;
                    break;
                }
            }
            Assert.assertEquals("Программа не должна считывать данные с клавиатуры", false, is);
        } catch (IOException e) {
        }
    }
    @Test
    public void IsMainCallOneTimes() {
        int is = 0;
        try {
            Stream<String> stream = Files.lines(Paths.get(fileName));
            List<String> collect = stream.collect(Collectors.toList());
            int ind = collect.indexOf("    public static void main(String[] args) {");
            for (int i = ind; i < collect.size(); i++) {
                if (collect.get(i).contains("System.out.print")) {
                    is ++;
                }
            }
            Assert.assertEquals("Метод main должен содержать только один вызов System.out.println", 1, is);
        } catch (IOException e) {
        }
    }

    @Test
    public void RightSequenceBrackets() {
        int is = 0;
        try {
            Stream<String> stream = Files.lines(Paths.get(fileName));
            List<String> collect = stream.collect(Collectors.toList());
            int ind = collect.indexOf("    public static void main(String[] args) {");
            for (int i = ind; i < collect.size(); i++) {
                if (collect.get(i).contains("2 * (3 + 4 * (5 + 6 * 7))")) {
                    is ++;
                }
            }
            Assert.assertEquals("Последовательность цифр и арифметических операций изменять нельзя. " +
                    "Количество круглых скобок должно остаться прежним (2 открывающие и 2 закрывающие).", 1, is);
        } catch (IOException e) {
        }
    }

    @Test
    public void EqualsRightResult() {
        lesson02.part01.Task06.main(null);
        ByteArrayOutputStream stream = SystemOutGatewayUtil.getOutputArray();
        String result = stream.toString();
        Assert.assertEquals("Название месяца должно выводиться на английском языке и заглавными буквами",
                382, Integer.parseInt(result));
    }

}