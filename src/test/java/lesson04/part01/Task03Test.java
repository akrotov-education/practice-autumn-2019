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

public class Task03Test {

    private static List<String> collect;

    static {
        String fileName = "./src/main/java/lesson04/part01/Task03.java";
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
    public void task03ifStringArrayCreated() {
        boolean isListCreated = false;
        for (String s : collect) {
            if (s.contains("String[]") && s.contains("= new String[10]"))
                isListCreated = true;
        }
        Assert.assertTrue("Программа должна создавать массив на 10 строк.",
                isListCreated);
    }
    @Test
    public void task03ifArrayIntCreated() {
        boolean isListCreated = false;
        for (String s : collect) {
            if (s.contains("int[]") && s.contains("= new int[10]"))
                isListCreated = true;
        }
        Assert.assertTrue("Программа должна создавать массив на 10 целых чисел.",
                isListCreated);
    }
    @Test
    public void task03KeyboardInputStrings() {
        boolean isInputExist = false;
        for (String s : collect) {
            if (s.contains(".readLine()")) {
                isInputExist = true;
                break;
            }
        }
        Assert.assertTrue("Программа должна считывать числа для массива с клавиатуры.",isInputExist);
    }
    @Test
    public void task03StringSizeToArray() {
        boolean isInputExist = false;
        for (String s : collect) {
            if (s.contains("listInt[i] = listString[i].length();")) {
                isInputExist = true;
                break;
            }
        }
        Assert.assertTrue("Программа должна в массив чисел записать длины строк из массива строк",isInputExist);
    }
    @Test
    public void task03CheckOut() {
        boolean isInputExist = false;
        for (String s : collect) {
            if (s.contains("System.out.println(listInt[i]);")) {
                isInputExist = true;
                break;
            }
        }
        Assert.assertTrue("Программа должна вывести на экран длины строк",isInputExist);
    }
}