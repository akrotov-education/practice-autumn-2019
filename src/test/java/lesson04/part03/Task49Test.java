package lesson04.part03;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import util.ReadFuncBodyUtil;
import util.SystemOutGatewayUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task49Test {
    public static String fileName = "./src/main/java/lesson04/part03/Task49.java";
    public static List<String> collect;
    public static List<String> classString;
    public static List<String> mainFunc;
    public static List<String> divideByZeroFunc;

    static {
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

            collect = stream.collect(Collectors.toList());
            int numberDivideByZeroFunc = 0;
            int numberClass = 0;
            int numberMain = 0;

            for (int i = 0; i < collect.size(); i++) {
                if (collect.get(i).contains("public static void divideByZero()")) {
                    numberDivideByZeroFunc = i;
                }
            }

            for (int i = 0; i < collect.size(); i++) {
                if (collect.get(i).contains("public class Task49")) {
                    numberClass = i;
                }
            }

            for (int i = 0; i < collect.size(); i++) {
                if (collect.get(i).contains("public static void main(String[] args)")) {
                    numberMain = i;
                }
            }

            classString = ReadFuncBodyUtil.getFuncBody(collect, numberClass);
            mainFunc = ReadFuncBodyUtil.getFuncBody(collect, numberMain);
            divideByZeroFunc = ReadFuncBodyUtil.getFuncBody(collect, numberDivideByZeroFunc);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Before
    public void before() {
        SystemOutGatewayUtil.setCustomOut();
    }

    @Test
    public void test49CheckDivideByZeroMethod() {
        boolean isMethod = false;
        for (String s : classString) {
            if (s.contains("public static void divideByZero()"))
                isMethod = true;
        }
        Assert.assertTrue(
                "В классе должен быть метод public static void divideByZero()",
                isMethod
        );
    }

    @Test
    public void test49CheckDivZero() {
        boolean isDivZero = false;

        for (String s : divideByZeroFunc) {
            if (s.contains("/0") || s.contains("/ 0")) {
                isDivZero = true;
            }
        }
        Assert.assertTrue(
                "Метод divideByZero должен содержать операцию деления любого целого числа на ноль",
                isDivZero
        );
    }

    @Test
    public void test49CheckSout() {
        boolean isSout = false;

        for (String s : divideByZeroFunc) {
            if (s.contains("System.out.print")) {
                isSout = true;
            }
        }
        Assert.assertTrue(
                "Метод divideByZero должен вызывать System.out.println или System.out.print",
                isSout
        );
    }

    @Test
    public void test49MainTryCatch() {
        boolean isMainTryCatch = false;
        boolean checkTry = false;
        for (String s: mainFunc) {
            if (s.contains("try")) {
                checkTry = true;
            }

            if (s.contains("catch") && checkTry) {
                isMainTryCatch = true;
            }
        }

        Assert.assertTrue(
                "Метод main должен содержать блок try..catch",
                isMainTryCatch
        );
    }

    @Test
    public void test49CheckException() {
        boolean isException = false;
        boolean checkTry = false;

        for (String s: mainFunc) {
            if (s.contains("try")) {
                checkTry = true;
            }

            if (s.contains("catch") && checkTry && (s.contains("ArithmeticException") || s.contains("Exception"))) {
                isException = true;
            }
        }

        Assert.assertTrue(
                "Метод main должен отлавливать любые исключения метода divideByZero",
                isException
        );
    }

    @Test
    public void test49StackTrace() {
        boolean isStackTrace = false;
        boolean checkTry = false;
        boolean checkCatch = false;

        for (String s: mainFunc) {
            if (s.contains("try")) {
                checkTry = true;
            }

            if (s.contains("catch") && checkTry && (s.contains("ArithmeticException") || s.contains("Exception"))) {
                checkCatch = true;
            }

            if (s.contains(".printStackTrace();") && checkCatch) {
                isStackTrace = true;
            }
        }

        Assert.assertTrue(
                "Программа должна выводить стек-трейс пойманого исключения",
                isStackTrace
        );
    }
}
