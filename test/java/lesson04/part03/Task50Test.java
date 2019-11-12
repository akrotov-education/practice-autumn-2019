package lesson04.part03;

import lesson02.part01.Task17;
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

public class Task50Test {
    public static String fileName = "./src/main/java/lesson04/part03/Task50.java";
    public static List<String> collect;
    public static List<String> mainFunc;
    public static List<String> readDataFunc;

    static {
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

            collect = stream.collect(Collectors.toList());
            int numberReadDataFunc = 0;
            int numberMain = 0;

            for (int i = 0; i < collect.size(); i++) {
                if (collect.get(i).contains("public static void readData()")) {
                    numberReadDataFunc = i;
                }
            }

            for (int i = 0; i < collect.size(); i++) {
                if (collect.get(i).contains("public static void main(String[] args)")) {
                    numberMain = i;
                }
            }

            mainFunc = ReadFuncBodyUtil.getFuncBody(collect, numberMain);
            readDataFunc = ReadFuncBodyUtil.getFuncBody(collect, numberReadDataFunc);
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
    public void test50ReadKeyboard() {
        boolean isReadLine = false;
        for (String s : readDataFunc) {
            if (s.contains(".readLine()"))
            isReadLine = true;
        }
        Assert.assertTrue(
                "Программа должна считывать данные с клавиатуры",
                isReadLine
        );
    }

    public boolean checkCode(String funcName) {
        boolean test = false;

        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

            List<String> collect = stream.collect(Collectors.toList());
            int a = 0;

            for (int i = 0; i < collect.size(); i++)
                if (collect.get(i).contains(" void " + funcName)) {
                    a = i;
                    break;
                }
            test = collect.get(a).equals("  public static void " + funcName + "(String[] args) {") &&
                    collect.get(a + 1).equals("    readData();") &&
                    collect.get(a + 2).equals("  }");

        } catch (Exception e) {
            e.printStackTrace();
        }

        return test;
    }

    @Test
    public void test50NoChangeMain() {
        Assert.assertTrue(
                "Метод main не изменять",
                checkCode("main")
        );
    }

    @Test
    public void test50NotThrowException() {
        boolean isSout = false;

        for (String s : mainFunc) {
            if (s.contains("throw new") && s.contains("Exception();")) {
                isSout = true;
            }
        }

        Assert.assertFalse(
                "Метод main не должен кидать исключений",
                isSout
        );
    }

    @Test
    public void test50MainTryCatch() {
        boolean isReadDataTryCatch = false;
        boolean checkTry = false;
        for (String s: readDataFunc) {
            if (s.contains("try")) {
                checkTry = true;
            }

            if (s.contains("catch") && checkTry) {
                isReadDataTryCatch = true;
            }
        }

        Assert.assertTrue(
                "Метод readData должен содержать блок try..catch",
                isReadDataTryCatch
        );
    }

    @Test
    public void test50InputString() {
        String str = "kek";
        SystemInGatewayUtil.provideInput(1 + "\n" + 2 + "\n" + str);
        Task50.main(null);
        SystemOutGatewayUtil.setOriginalOut();
        ByteArrayOutputStream outputArr = SystemOutGatewayUtil.getOutputArray();
        String s = outputArr.toString();

        Assert.assertTrue(
                "Если пользователь ввел текст, а не число, программа должна вывести все ранее введенные числа",
                s.equals("1\r\n2\r\n")
        );
    }
}
