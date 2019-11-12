package lesson04.part02;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import util.ReadFuncBodyUtil;
import util.SystemOutGatewayUtil;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task32Test {
    public static String fileName = "./src/main/java/lesson04/part02/Task32.java";
    public static List<String> collect;
    public static List<String> mainFunc;

    static {
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

            collect = stream.collect(Collectors.toList());
            int numberHMainFunc = 0;

            for (int i = 0; i < collect.size(); i++) {
                if (collect.get(i).contains("public static void main(String[] args)")) {
                    numberHMainFunc = i;
                }
            }

            mainFunc = ReadFuncBodyUtil.getFuncBody(collect, numberHMainFunc);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Before
    public void before() {
        SystemOutGatewayUtil.setCustomOut();
    }

    @After
    public void after() {
        SystemOutGatewayUtil.setOriginalOut();
    }

    @Test
    public void test32ThreeMethods() {
        Method a[] = Task32.class.getMethods();
        int number = 0;

        for (Method s : a) {
            if (s.toString().contains("lesson04.part02.Task32")) {
                number++;
            }
        }

        Assert.assertTrue(
                "Класс должен содержать только три метода",
                number == 3
        );
    }

    @Test
    public void test32NoSout() {
        Task32.main(null);

        ByteArrayOutputStream outputArr = SystemOutGatewayUtil.getOutputArray();
        String s = outputArr.toString();

        Assert.assertTrue(
                "Программа не должна выводить текст на экран",
                s.isEmpty() || s.equals(null)
        );
    }

    @Test
    public void test32NoReadKeyboard() {
        boolean isReadLine = false;
        for (String s : collect) {
            if (s.contains(".readLine()"))
                isReadLine = true;
        }

        Assert.assertFalse(
                "Программа не должна считывать значения с клавиатуры",
                isReadLine
        );
    }

    @Test
    public void test32CheckSet() {
        boolean isSet = false;
        int numberSet = 0;
        int numberVar = 0;
        String variable = "";

        for (int i = 0; i < collect.size(); i++) {
            if (collect.get(i).contains("public static Set<Integer> createSet()")) {
                numberSet = i;
            }
        }

        List<String> createSetFunc = ReadFuncBodyUtil.getFuncBody(collect, numberSet);

        for (int i = 0; i < createSetFunc.size(); i++) {
            if (createSetFunc.get(i).contains("Set<Integer>")) {
                numberVar = i;
            }
            ;
        }

        variable = createSetFunc.get(numberVar).split("=")[0].split(" ")[1].trim();

        for (String s : createSetFunc) {
            if (s.contains("return") && s.contains(variable)) {
                isSet = true;
            }
        }

        Set<Integer> set = Task32.createSet();

        Assert.assertTrue(
                "Метод createSet() должен создавать и возвращать множество Set состоящих из 20 различных чисел",
                isSet && (set.size() == 20)
        );
    }

    @Test
    public void test32RemoveAllNumbersGreaterThan10() {
        Set<Integer> set = Task32.createSet();
        Set<Integer> setRemoved = Task32.removeAllNumbersGreaterThan10(set);
        boolean isGreaterThan10 = false;

        for (Integer num : setRemoved) {
            if (num > 10) {
                isGreaterThan10 = true;
            }
        }

        Assert.assertFalse(
                "Метод removeAllNumbersGreaterThan10() должен удалять из множества все числа больше 10",
                isGreaterThan10
        );
    }
}
