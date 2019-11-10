package lesson04.part02;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import util.ReadFuncBodyUtil;
import util.SystemOutGatewayUtil;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task34Test {
    public static String fileName = "./src/main/java/lesson04/part02/Task34.java";
    public static List<String> collect;
    public static List<String> mainFunc;

    static {
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

            collect = stream.collect(Collectors.toList());
            int numberMainFunc = 0;

            for (int i = 0; i < collect.size(); i++) {
                if (collect.get(i).contains("public static void main(String[] args)")) {
                    numberMainFunc = i;
                }
            }

            mainFunc = ReadFuncBodyUtil.getFuncBody(collect, numberMainFunc);
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
        SystemOutGatewayUtil.clearOutput();
    }

    @Test
    public void test34Sout() {
        Task34.main(null);
        SystemOutGatewayUtil.setOriginalOut();
        ByteArrayOutputStream outputArr = SystemOutGatewayUtil.getOutputArray();
        String s = outputArr.toString();

        Assert.assertTrue(
                "Программа не должна выводить текст на экран",
                s.isEmpty() || s.equals(null)
        );
    }

    @Test
    public void test34ReadKeyboard() {
        boolean isReadKeyboard = false;

        for (String s: collect) {
            if (s.contains(".readLine()")) {
                isReadKeyboard = true;
            }
        }

        Assert.assertFalse(
            "Программа не должна считывать значения с клавиатуры",
            isReadKeyboard
        );
    }

    @Test
    public void test34CreateMap() {
        boolean isRightMap = false;
        Map<String, Integer> map = null;

        try {
            map = Task34.createMap();
            isRightMap = true;
        } catch (Exception e){

        }

        Assert.assertTrue(
                "Метод createMap() должен создавать и возвращать словарь Map с типом элементов String, Integer состоящих из 10 записей по принципу «фамилия» - «зарплата",
                isRightMap && (map.size() == 10)
        );
    }

    @Test
    public void test34RemoveItemFromMap() {
        boolean isLess500 = true;
        Map<String, Integer> map = Task34.createMap();
        Task34.removeItemFromMap(map);

        for (Map.Entry<String, Integer> entry: map.entrySet()) {
            if (entry.getValue() < 500) {
                isLess500 = false;
            }
        }

        Assert.assertTrue(
            "Метод removeItemFromMap() должен удалять из словаря всех людей, у которых зарплата ниже 500",
            isLess500
        );
    }
}
