package lesson05.part03;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import util.ReadFuncBodyUtil;
import util.SystemInGatewayUtil;
import util.SystemOutGatewayUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task16Test {
    public static String fileName = "./src/main/java/lesson05/part03/Task16.java";
    public static List<String> collect;
    public static List<String> task16;
    public static List<String> mainFunc;
    public static List<String> buttonInterface;

    static {
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

            collect = stream.collect(Collectors.toList());
            int numberMainFunc = -1;
            int numberButtonInterface = -1;
            int numberTask16Class = -1;

            for (int i = 0; i < collect.size(); i++) {
                if (collect.get(i).contains("interface Button extends SimpleObject")) {
                    numberButtonInterface = i;
                }
            }

            for (int i = 0; i < collect.size(); i++) {
                if (collect.get(i).contains("public static void main(String[] args)")) {
                    numberMainFunc = i;
                }
            }

            for (int i = 0; i < collect.size(); i++) {
                if (collect.get(i).contains("public class Task16")) {
                    numberTask16Class = i;
                }
            }

            mainFunc = ReadFuncBodyUtil.getFuncBody(collect, numberMainFunc);
            buttonInterface = ReadFuncBodyUtil.getFuncBody(collect, numberButtonInterface);
            task16 = ReadFuncBodyUtil.getFuncBody(collect, numberTask16Class);
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
    public void test16SimpleObjectInsideTask16Class() {
        boolean isInside = false;

        for (String list: task16) {
            if (list.contains("interface SimpleObject")) {
                isInside = true;
            }
        }

        Assert.assertTrue(
                "Интерфейс SimpleObject должен быть объявлен внутри класса Task16.",
                isInside
        );
    }

    @Test
    public void test16ButtonInsideTask16Class() {
        boolean isInside = false;

        for (String list: task16) {
            if (list.contains("interface Button")) {
                isInside = true;
            }
        }

        Assert.assertTrue(
                "Интерфейс Button должен быть объявлен внутри класса Task16.",
                isInside
        );
    }

    public boolean checkCodeMain() {
        boolean test = false;
        int a = 0;

        for (int i = 0; i < collect.size(); i++)
            if (collect.get(i).contains("public static void main(String[] args)")) {
                a = i;
                break;
            }

        test = collect.get(a).equals("    public static void main(String[] args) throws Exception {") &&
                collect.get(a + 1).equals("        System.out.println(SimpleObject.NAME);") &&
                collect.get(a + 2).equals("        System.out.println(Button.NAME);") &&
                collect.get(a + 3).equals("    }");

        return test;
    }

    @Test
    public void test16NoChangeMain() {
        Assert.assertTrue(
                "Метод main менять нельзя.",
                checkCodeMain()
        );
    }

    @Test
    public void test16DeclareNAME() {
        boolean isNAME = false;

        for (String list: buttonInterface) {
            if (list.contains("final String NAME = \"Submit\";")) {
                isNAME = true;
            }
        }

        Assert.assertTrue(
                "В интерфейсе Button должно остаться объявление константы NAME.",
                isNAME
        );
    }

    @Test
    public void test16RightOnPress() {
        int onPressCount = 0;
        int rightOnPressCount = 0;

        for (String list: buttonInterface) {
            if (list.contains("void onPress();") || list.contains("String onPress(Object o);")) {
                rightOnPressCount++;
            }

            if (list.contains("onPress")) {
                onPressCount++;
            }
        }

        Assert.assertTrue(
                "В интерфейсе Button должно остаться корректное объявление метода onPress.",
                onPressCount == 2 && rightOnPressCount == 2
        );
    }
}
