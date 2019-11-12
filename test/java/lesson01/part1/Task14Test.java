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

public class Task14Test {
    public static String fileName = "./src/main/java/lesson01/part1/Task14.java";

    @Before
    public void before(){
        SystemOutGatewayUtil.setCustomOut();
    }

    @After
    public void after(){
        SystemOutGatewayUtil.setOriginalOut();
    }

    @Test
    public void ChangeLine(){
        try {
            Stream<String> stream = Files.lines(Paths.get(fileName));
            List<String> line = stream.collect(Collectors.toList());
            String l1 = line.get(18);
            Assert.assertEquals("Значения переменных нельзя изменять (a)",
                    l1, "    public static int a = 1;");
            String l2 = line.get(19);
            Assert.assertEquals("Значения переменных нельзя изменять (b)",
                    l2, "    public static int b = 3;");
            String l3 = line.get(20);
            Assert.assertEquals("Значения переменных нельзя изменять (с)",
                    l3, "    public static int c = 9;");
            String l4 = line.get(21);
            Assert.assertEquals("Значения переменных нельзя изменять (в)",
                    l4, "    public static int d = 27;");
        } catch (IOException e) {
        }
    }

    @Test
    public void SignsBeforeNums(){
        try {
            Stream<String> stream = Files.lines(Paths.get(fileName));
            List<String> line = stream.collect(Collectors.toList());
            String l = line.get(24);
            Assert.assertTrue("Перед переменной a в строке с объявлением переменной result должен стоять один знак плюс либо минус",
                    (l.contains("+ a"))|(l.contains("- a")));
            String l2 = line.get(24);
            Assert.assertTrue("Перед переменной b в строке с объявлением переменной result должен стоять один знак плюс либо минус",
                    l.contains(("+ b"))|(l.contains("- b")));
            String l3 = line.get(24);
            Assert.assertTrue("Перед переменной c в строке с объявлением переменной result должен стоять один знак плюс либо минус",
                    (l.contains("+ c"))|(l.contains("- c")));
            String l4 = line.get(24);
            Assert.assertTrue("Перед переменной d в строке с объявлением переменной result должен стоять один знак плюс либо минус",
                    l.contains(("+ d"))|(l.contains("- d")));
        } catch (IOException e) {
        }
    }

    @Test
    public void EqualsRightResult() {
        Task14.main(null);
        ByteArrayOutputStream stream = SystemOutGatewayUtil.getOutputArray();
        String result = stream.toString();
        Assert.assertEquals("Метод должен  возвращать 20" ,20, Integer.parseInt(result));
    }

    @Test
    public void RightSigns(){
        try {
            Stream<String> stream = Files.lines(Paths.get(fileName));
            List<String> line = stream.collect(Collectors.toList());
            String l = line.get(24);
            Assert.assertTrue("Знаки плюс и минус должны быть расставлены правильно: - a + b - c + d",
                    (l.contains("- a"))&(l.contains("+ b"))&(l.contains("- c"))&(l.contains("+ d")));
        } catch (IOException e) {
        }
    }

}