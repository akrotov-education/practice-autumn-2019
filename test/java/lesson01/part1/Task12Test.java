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

public class Task12Test {
    public static String fileName = "./src/main/java/lesson01/part1/Task12.java";

    @Before
    public void before(){
        SystemOutGatewayUtil.setCustomOut();
    }

    @After
    public void after(){
        SystemOutGatewayUtil.setOriginalOut();
    }

    @Test
    public void IsTextOut(){
        Task12.main(null);
        ByteArrayOutputStream stream = SystemOutGatewayUtil.getOutputArray();
        String result = stream.toString();
        Assert.assertNotNull("Программа должна выводить текст", result);
        stream.reset();
    }

    @Test
    public void CommentLine(){
        try {
            Stream<String> stream = Files.lines(Paths.get(fileName));
            List<String> line = stream.collect(Collectors.toList());
            String l0 = line.get(17);
            Assert.assertTrue("Нельзя изменять строки с объявлением переменных", l0.contains("String apple = \"Яблоко\";"));
            String l1 = line.get(18);
            Assert.assertTrue("Нельзя изменять строки с объявлением переменных", l1.contains("String porridge = \"Каша\";"));
            String l2 = line.get(19);
            Assert.assertTrue("Нельзя изменять строки с объявлением переменных", l2.contains("String sausage = \"Колбаса\";"));
            String l3 = line.get(20);
            Assert.assertTrue("Нельзя изменять строки с объявлением переменных", l3.contains("String peach = \"Персик\";"));
        } catch (IOException e) {
        }
    }
    @Test
    public void IsOutputTwoLines(){
        Task12.main(null);
        ByteArrayOutputStream stream = SystemOutGatewayUtil.getOutputArray();
        String result = stream.toString();
        Assert.assertEquals("Текст должен состоять из 2 строк", "Яблоко\nПерсик", result);
        stream.reset();
    }

    @Test
    public void IsFruit(){
        Task12.main(null);
        ByteArrayOutputStream stream = SystemOutGatewayUtil.getOutputArray();
        String result = stream.toString();
        Assert.assertTrue("Программа должна выводить переменные, значения которых являются названиями " +
                "фруктов (нет яблока)", result.contains("Яблоко"));
        Assert.assertTrue("Программа должна выводить переменные, значения которых являются названиями " +
                "фруктов (нет персика)",  result.contains("Персик"));
        stream.reset();
    }

    @Test
    public void IfNotFruit(){
        Task12.main(null);
        ByteArrayOutputStream stream = SystemOutGatewayUtil.getOutputArray();
        String result = stream.toString();
        Assert.assertFalse("Программа не должна выводить переменные, " +
                "значения которых не являются названиями фруктов (Каша)", result.contains("Каша"));
        Assert.assertFalse("Программа не должна выводить переменные, " +
                "значения которых не являются названиями фруктов (Колбаса)", result.contains("Колбаса"));
        stream.reset();
    }
}