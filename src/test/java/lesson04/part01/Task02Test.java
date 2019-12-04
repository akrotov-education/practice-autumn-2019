package lesson04.part01;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import util.SystemInGatewayUtil;
import util.SystemOutGatewayUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task02Test {
    private static List<String> collect;

    static {
        String fileName = "./src/main/java/lesson04/part01/Task02.java";
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            collect = stream.collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Before
    public void setUp() throws Exception {
        SystemOutGatewayUtil.setCustomOut();
    }
    @After
    public void tearDown() throws Exception {
        SystemOutGatewayUtil.setOriginalOut();
        SystemInGatewayUtil.setOriginalIn();
        SystemOutGatewayUtil.clearOutput();
    }
    @Test
    public void task02ifStringListCreated() {
        boolean isListCreated = false;
        for (String s : collect) {
            if (s.contains("String[]") && s.contains("= new String[10]"))
                isListCreated = true;
        }
        Assert.assertTrue("Программа должна создавать массив на 10 строк.",
                isListCreated);
    }
    @Test
    public void task02InputStringsToList() {
        boolean inp = false;
        for (String s : collect) {
            if (s.contains("int i = 0; i < 8; i++") || s.contains("[i] = reader.readLine()"))
                inp = true;
        }
        Assert.assertTrue("Программа должна считывать 8 строк для массива с клавиатуры", inp);
    }
    @Test
    public void task02CheckOutput() {
        boolean checkout = false;
        for (String s : collect) {
            if (s.contains("System.out.println(arr[i])")) {
                checkout = true;
            } else if (s.contains("int i = arr.length-1; i >= 0; i--")) {
                checkout = true;
            }
        }
        Assert.assertTrue("Программа должна выводить на экран 10 строк, каждую с новой строки." +
                        "Программа должна выводить на экран массив (10 элементов) в обратном порядке.",
                checkout);
    }
}