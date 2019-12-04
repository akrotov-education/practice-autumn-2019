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

import static org.junit.Assert.*;

public class Task04Test {
    private static List<String> collect;

    static {
        String fileName = "./src/main/java/lesson04/part01/Task04.java";
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
    public void task04ifListCreated() {
        boolean isListCreated = false;
        for (String s : collect) {
            if (s.contains("int[]") && s.contains("= new int[10];"))
                isListCreated = true;
        }
        Assert.assertTrue("Программа должна создавать массив на 10 целых чисел",
                isListCreated);
    }
    @Test
    public void task04KeyboardInput() {
        boolean isInputExist = false;
        for (String s : collect) {
            if (s.contains("[i] = Integer.parseInt")) {
                isInputExist = true;
                break;
            }
        }
        Assert.assertTrue("Программа должна считывать числа для массива с клавиатуры.",isInputExist);
    }
    @Test
    public void task04OutArrayOnScreen() {
        boolean isInputExist = false;
        for (String s : collect) {
            if ((s.contains("System.out.println(arr[i])"))) {
                isInputExist = true;
                break;
            }
        }
        Assert.assertTrue("Программа должна выводить 10 строчек, каждую с новой строки.\n" +
                "Массив должен быть выведен на экран в обратном порядке.",isInputExist);
    }

}