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

public class Task11Test {
    public static String fileName = "./src/main/java/lesson05/part03/Task11.java";
    public static List<String> collect;
    public static List<String> mainFunc;
    public static List<String> englishTranslatorClass;

    static {
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

            collect = stream.collect(Collectors.toList());
            int numberMainFunc = -1;
            int numberenglishTranslatorClass = -1;

            for (int i = 0; i < collect.size(); i++) {
                if (collect.get(i).contains("public static void main(String[] args)")) {
                    numberMainFunc = i;
                }
            }

            for (int i = 0; i < collect.size(); i++) {
                if (collect.get(i).contains("static class EnglishTranslator")) {
                    numberenglishTranslatorClass = i;
                }
            }

            mainFunc = ReadFuncBodyUtil.getFuncBody(collect, numberMainFunc);
            englishTranslatorClass = ReadFuncBodyUtil.getFuncBody(collect, numberenglishTranslatorClass);
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
    public void test11EnglishTranslatorInsideTask11() {
        boolean isInside = false;
        Class[] intfs = Task11.class.getClasses();
        for (int i = 0; i < intfs.length; i++) {
            if (intfs[i].toString().contains("EnglishTranslator")) {
                isInside = true;
            }
        }

        Assert.assertTrue(
                "Класс EnglishTranslator должен быть объявлен внутри класса Task11.",
                isInside
        );
    }

    @Test
    public void test11EnglishTranslatorExtendTranslator() {
        Assert.assertTrue(
                "Класс EnglishTranslator должен наследоваться от класса Translator.",
                Task11.EnglishTranslator.class.getSuperclass().toString().contains("Translator")
        );
    }

    @Test
    public void test11EnglishTranslatorMethods() {
        boolean isGetLanguage = false;

        for (String list: englishTranslatorClass) {
            if (list.contains("getLanguage() {")) {
                isGetLanguage = true;
            }
        }

        Assert.assertTrue(
                "В классе EnglishTranslator должны быть реализованы все унаследованные от класса Translator абстрактные методы.",
                isGetLanguage
        );
    }

    @Test
    public void test11ReturnLanguage() {
        Assert.assertTrue(
                "Метод getLanguage должен возвращать строку, которая позволит выполнить условие задачи.",
                new Task11.EnglishTranslator().getLanguage().equals("английского")
        );
    }

    @Test
    public void test11SoutMain() throws Exception {
        boolean isCallTranslate = false;

        for (String  list: mainFunc) {
            if (list.contains("englishTranslator.translate()")) {
                isCallTranslate = true;
            }
        }

        Task11.main(null);
        SystemOutGatewayUtil.setOriginalOut();
        ByteArrayOutputStream outputArr = SystemOutGatewayUtil.getOutputArray();
        String s = outputArr.toString();

        Assert.assertTrue(
                "Метод main должен выводить на экран строку \"Я переводчик с английского\" путем вызова метода translate у объекта типа EnglishTranslator.",
                isCallTranslate && s.equals("Я переводчик с английского\n")
        );
    }
}
