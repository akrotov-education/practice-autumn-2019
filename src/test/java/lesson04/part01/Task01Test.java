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

public class Task01Test {
    private static List<String> collect;

    static {
        String fileName = "./src/main/java/lesson04/part01/Task01.java";
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
    public void task01ifListIntCreated() {
        boolean isListCreated = false;
        for (String s : collect) {
            if (s.contains("int[]") && s.contains("= new int[20]"))
                isListCreated = true;
        }
        Assert.assertTrue("Метод initializeArray должен создавать массив из 20 целых чисел.",
                isListCreated);
    }
    @Test
    public void task01KeyboardInputToList() {
        boolean isInputExist = false;
        for (String s : collect) {
            if (s.contains("[i] = Integer.parseInt")) {
                isInputExist = true;
                break;
            }
        }
        Assert.assertTrue("Метод initializeArray должен считать 20 чисел и вернуть их в виде массива.",isInputExist);
    }
    @Test
    public void task01MaxElement() {
        boolean isInputExist = false;
        for (String s : collect) {
            if (s.contains("if (num > max)") || (s.contains("max = num")) && (s.contains("return max;"))) {
                isInputExist = true;
                break;
            }
        }
        Assert.assertTrue("Метод max должен возвращать максимальный элемент из переданного массива.",isInputExist);
    }
    @Test
    public void task01MainHaveNoChanges() {
        boolean MainNoCganges = false;
        for (String s : collect) {
            if (s.contains("public static void main(String[] args) throws Exception {") ||
                s.contains("int[] array = initializeArray();") ||
                s.contains("int max = max(array);") ||
                s.contains("System.out.println(max);")
            ) {
                MainNoCganges = true;
                break;
            }
        }
        Assert.assertTrue("Метод main изменять нельзя.", MainNoCganges);
    }
}
