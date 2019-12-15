package lesson05.part03;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import util.ReadFuncBodyUtil;
import util.SystemInGatewayUtil;
import util.SystemOutGatewayUtil;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task21Test {
    public static String fileName = "./src/main/java/lesson05/part03/Task21.java";
    public static List<String> collect;
    public static List<String> mainFunc;
    public static List<String> hobbyClass;

    static {
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

            collect = stream.collect(Collectors.toList());
            int numberMainFunc = -1;
            int numberHobbyClass = -1;

            for (int i = 0; i < collect.size(); i++) {
                if (collect.get(i).contains("static class Hobby implements Desire, Dream")) {
                    numberHobbyClass = i;
                }
            }

            for (int i = 0; i < collect.size(); i++) {
                if (collect.get(i).contains("public static void main(String[] args)")) {
                    numberMainFunc = i;
                }
            }

            mainFunc = ReadFuncBodyUtil.getFuncBody(collect, numberMainFunc);
            hobbyClass = ReadFuncBodyUtil.getFuncBody(collect, numberHobbyClass);
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
        SystemInGatewayUtil.setOriginalIn();
        SystemOutGatewayUtil.clearOutput();
    }

    @Test
    public void test21ImplementsDesire() {
        boolean isImplements = false;

        for (String list: collect) {
            if (list.contains("class Hobby implements Desire")) {
                isImplements = true;
            }
        }

        Assert.assertTrue(
                "Интерфейс Desire должен быть реализован в классе Hobby.",
                isImplements
        );
    }

    @Test
    public void test21ImplementsDream() {
        boolean isImplements = false;

        for (String list: collect) {
            if (list.contains("class Hobby implements") && list.contains("Dream")) {
                isImplements = true;
            }
        }

        Assert.assertTrue(
                "Интерфейс Dream должен быть реализован в классе Hobby.",
                isImplements
        );
    }

    @Test
    public void test21HobbyStaticVariable() {
        boolean isStatic = false;

        for (String list: hobbyClass) {
            if (list.contains("static int INDEX")) {
                isStatic = true;
            }
        }

        Assert.assertTrue(
                "Класс Hobby должен содержать статическую переменную INDEX.",
                isStatic
        );
    }

    @Test
    public void test21ToString() {
        int index = Task21.Hobby.INDEX;
        Object str = new Task21.Hobby().toString();

        Assert.assertTrue(
                "Метод toString в классе Hobby должен инкрементировать и возвращать переменную INDEX в виде строки.",
                str instanceof String && Integer.parseInt((String) str) == (index + 1)
        );
    }
}
