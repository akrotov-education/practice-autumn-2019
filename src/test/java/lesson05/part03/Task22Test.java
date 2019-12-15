package lesson05.part03;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import util.ReadFuncBodyUtil;
import util.SystemInGatewayUtil;
import util.SystemOutGatewayUtil;

import java.io.IOException;
import java.lang.reflect.Modifier;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task22Test {
    public static String fileName = "./src/main/java/lesson05/part03/Task22.java";
    public static List<String> collect;
    public static List<String> task22;
    public static List<String> mainFunc;
    public static List<String> stringObject;

    static {
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

            collect = stream.collect(Collectors.toList());
            int numberMainFunc = -1;
            int numberStringObject = -1;
            int numberTask22Class = -1;

            for (int i = 0; i < collect.size(); i++) {
                if (collect.get(i).contains("public class Task22")) {
                    numberTask22Class = i;
                }
            }

            for (int i = 0; i < collect.size(); i++) {
                if (collect.get(i).contains("public static class StringObject implements SimpleObject<String>")) {
                    numberStringObject = i;
                }
            }


            for (int i = 0; i < collect.size(); i++) {
                if (collect.get(i).contains("public static void main(String[] args)")) {
                    numberMainFunc = i;
                }
            }

            mainFunc = ReadFuncBodyUtil.getFuncBody(collect, numberMainFunc);
            stringObject = ReadFuncBodyUtil.getFuncBody(collect, numberStringObject);
            task22 = ReadFuncBodyUtil.getFuncBody(collect, numberTask22Class);
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
    public void test22ImplementsSimpleObject() {
        boolean isImplements = false;

        for (String list: collect) {
            if (list.contains("class StringObject implements SimpleObject")) {
                isImplements = true;
            }
        }

        Assert.assertTrue(
                "Класс StringObject должен реализовывать интерфейс SimpleObject.",
                isImplements
        );
    }

    @Test
    public void test22SimpleObjectString() {
        boolean isString = false;

        for (String list: collect) {
            if (list.contains("class StringObject implements SimpleObject<String>")) {
                isString = true;
            }
        }

        Assert.assertTrue(
                "Интерфейс SimpleObject в классе StringObject должен быть реализован с параметром типа String.",
                isString
        );
    }

    @Test
    public void test22GetInstance() {
        boolean isGetInstance = false;

        for (String list: stringObject) {
            if (list.contains("getInstance() {")) {
                isGetInstance = true;
            }
        }

        Assert.assertTrue(
                "В классе StringObject реализовать метод getInstance интерфейса SimpleObject.",
                isGetInstance
        );
    }

    @Test
    public void test22IsStringObject() {
       boolean is = false;

       for (String list: task22) {
           if (list.contains("class StringObject")) {
               is = true;
           }
       }

        Assert.assertTrue(
                "Класс StringObject должен существовать в классе Solution.",
                is
        );
    }

    @Test
    public void test22IsStatic() {
        Assert.assertTrue(
                "Класс StringObject должен быть статическим.",
                Modifier.toString(Task22.StringObject.class.getModifiers()).contains("static")
        );
    }
}
