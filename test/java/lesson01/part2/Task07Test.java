package lesson01.part2;

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

public class Task07Test {
    public static String fileName = "./src/main/java/lesson01/part2/Task07.java";

    @Before
    public void before(){
        SystemOutGatewayUtil.setCustomOut();
    }

    @After
    public void after(){
        SystemOutGatewayUtil.setOriginalOut();
    }

    @Test
    public void EqualsRightResult(){
        Task07.main(null);
        ByteArrayOutputStream stream = SystemOutGatewayUtil.getOutputArray();
        String result = stream.toString();
        Assert.assertEquals("Программа должна выводить на экран число 19",
                19, Integer.parseInt(result));
        stream.reset();
    }

    @Test
    public void ChangeLine1() {
        try {
            Stream<String> stream = Files.lines(Paths.get(fileName));
            List<String> collect = stream.collect(Collectors.toList());
            int index = collect.indexOf("        int x = 1;");
            Assert.assertEquals("Нельзя изменять строки с объявлением переменных (x)", 17, index);
        } catch (IOException e) {
        }

        try {
            Stream<String> stream = Files.lines(Paths.get(fileName));
            List<String> collect = stream.collect(Collectors.toList());
            int index = collect.indexOf("        int y = 0;");
            Assert.assertEquals("Нельзя изменять строки с объявлением переменных (y)", 18, index);
        } catch (IOException e) {
        }
    }

    @Test
    public void ChangeLine2() {
        try {
            Stream<String> stream = Files.lines(Paths.get(fileName));
            List<String> collect = stream.collect(Collectors.toList());
            int index = collect.indexOf("        System.out.print(y);");
            Assert.assertEquals("Нельзя изменять строки с объявлением переменных (вывод в консоль)", 26, index);
        } catch (IOException e) {
        }
    }

    @Test
    public void RightComments() {
        try {
            Stream<String> stream = Files.lines(Paths.get(fileName));
            List<String> collect = stream.collect(Collectors.toList());
            Assert.assertTrue("Нужно закомментировать некоторые строки и не менять остальные",
                    !collect.get(20).contains("//")&&collect.get(21).contains("//")&&
                    !collect.get(22).contains("//")&&collect.get(23).contains("//")&&!collect.get(24).contains("//"));
        } catch (IOException e) {
        }
    }

}