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

public class Task12Test {
    public static String fileName = "./src/main/java/lesson05/part03/Task12.java";
    public static List<String> collect;
    public static List<String> mainFunc;

    static {
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

            collect = stream.collect(Collectors.toList());
            int numberMainFunc = -1;

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
        SystemInGatewayUtil.setOriginalIn();
        SystemOutGatewayUtil.clearOutput();
    }

    @Test
    public void test12Sout() throws Exception {
        Task12.main(null);
        SystemOutGatewayUtil.setOriginalOut();
        ByteArrayOutputStream outputArr = SystemOutGatewayUtil.getOutputArray();
        String s = outputArr.toString();

        Assert.assertTrue(
                "Программа должна выводить на экран фразу - \"Я переводчик с английского\"",
                s.equals("Я переводчик с английского\n")
        );
    }

    @Test
    public void test12TranslateReturn() {
        Assert.assertTrue(
                "Метод translate должен возвращать строку - \"Я переводчик с английского\"",
                new Task12.Translator().translate().toString().contains("Я переводчик с английского")
        );
    }

    @Test
    public void test12SoutMain() {
        boolean isRigthCall = false;

        for (String list: mainFunc) {
            if (list.contains("System.out.println(translator.translate());")) {
                isRigthCall = true;
            }
        }

        Assert.assertTrue(
                "Метод main должен выводить на экран результат вызова метода translate у объекта типа Translator.",
                isRigthCall
        );
    }
}
