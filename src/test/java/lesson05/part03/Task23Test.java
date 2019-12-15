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

public class Task23Test {
    public static String fileName = "./src/main/java/lesson05/part03/Task23.java";
    public static List<String> collect;
    public static List<String> mainFunc;
    public static List<String> screenClass;

    static {
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

            collect = stream.collect(Collectors.toList());
            int numberMainFunc = -1;
            int numberScreenClass = -1;

            for (int i = 0; i < collect.size(); i++) {
                if (collect.get(i).contains("class Screen implements Updatable")) {
                    numberScreenClass = i;
                }
            }

            for (int i = 0; i < collect.size(); i++) {
                if (collect.get(i).contains("public static void main(String[] args)")) {
                    numberMainFunc = i;
                }
            }

            mainFunc = ReadFuncBodyUtil.getFuncBody(collect, numberMainFunc);
            screenClass = ReadFuncBodyUtil.getFuncBody(collect, numberScreenClass);
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
    public void test23UpdatableExtendsSelectable() {
        boolean isExtends = false;

        for (String list: collect) {
            if (list.contains("interface Updatable extends Selectable")) {
                isExtends = true;
            }
        }

        Assert.assertTrue(
                "Интерфейс Updatable должен наследовать(extends) интерфейс Selectable.",
                isExtends
        );
    }

    @Test
    public void test23ScreenImplementsUpdatable() {
        boolean isImplements = false;

        for (String list: collect) {
            if (list.contains("class Screen implements Updatable")) {
                isImplements = true;
            }
        }

        Assert.assertTrue(
                "Класс Screen должен реализовывать(implements) интерфейс Updatable.",
                isImplements
        );
    }

    @Test
    public void test23OnSelect() {
        boolean isOnSelect = false;

        for (String list: screenClass) {
            if (list.contains("public void onSelect() {")) {
                isOnSelect = true;
            }
        }

        Assert.assertTrue(
                "В классе Screen должен быть реализован метод onSelect интерфейса Selectable.",
                isOnSelect
        );
    }

    @Test
    public void test23Refresh() {
        boolean isFefresh = false;

        for (String list: screenClass) {
            if (list.contains("public void refresh() {")) {
                isFefresh = true;
            }
        }

        Assert.assertTrue(
                "В классе Screen должен быть реализован метод refresh интерфейса Updatable.",
                isFefresh
        );
    }
}
