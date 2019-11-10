package lesson04.part01;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import util.SystemInGatewayUtil;
import util.SystemOutGatewayUtil;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.*;

public class Task05Test {
    private static List<String> collect;

    static {
        String fileName = "./src/main/java/lesson04/part01/Task05.java";
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
    public void task05ifListCreated() {
        boolean isListCreated = false;
        for (String s : collect) {
            if (s.contains("int[] list") && s.contains("= new int[15];"))
                isListCreated = true;
        }
        Assert.assertTrue("Программа должна создавать массив на 15 целых чисел",
                isListCreated);
    }
    @Test
    public void task05KeyboardInput() {
        boolean isInputExist = false;
        for (String s : collect) {
            if (s.contains("for (int i = 0; i < list.length; i++)") || s.contains("list[i] = Integer.parseInt")) {
                isInputExist = true;
                break;
            }
        }
        Assert.assertTrue("Программа должна считывать числа для массива с клавиатуры.",isInputExist);
    }
    @Test
    public void task05OutForChet() {
        boolean isInputExist = false;
        for (String s : collect) {
            if (s.contains("if (kolchet > kolnechet)")
                    || s.contains("System.out.println(\"В домах с четными номерами проживает больше жителей.\")")) {
                isInputExist = true;
                break;
            }
        }
        Assert.assertTrue("Программа должна вывести сообщение \"В домах с четными номерами проживает больше жителей.\",\n" +
                "если сумма четных элементов массива больше суммы нечетных.",isInputExist);
    }
    @Test
    public void task05OutForNeChet() {
        boolean isInputExist = false;
        for (String s : collect) {
            if (s.contains("else if (kolchet < kolnechet)")
                    || s.contains("В домах с нечетными номерами проживает больше жителей.")) {
                isInputExist = true;
                break;
            }
        }
        Assert.assertTrue("Программа должна вывести сообщение \"В домах с нечетными номерами проживает больше жителей.\"," +
                "если сумма четных элементов массива больше суммы нечетных.",isInputExist);
    }
}