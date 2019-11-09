package lesson04.part03;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import util.SystemOutGatewayUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import util.ReadFuncBodyUtil;

public class Task45Test {
    public static String fileName = "./src/main/java/lesson04/part03/Task45.java";
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

    @Test
    public void test45Method1() {
        boolean isMethod = false;
        for (String s : mainFunc) {
            if (s.contains("method1();"))
                isMethod = true;
        }
        Assert.assertTrue(
                "Метод main должен вызывать метод method1",
                isMethod
        );
    }

    @Test
    public void test45NullPointerException() {
        boolean isNullPointerException = false;
        for (String s : mainFunc) {
            if (s.contains("catch") && s.contains("NullPointerException"))
                isNullPointerException = true;
        }
        Assert.assertTrue(
                "Метод main должен перехватывать исключение NullPointerException",
                isNullPointerException
        );
    }

    @Test
    public void test45FileNotFoundException() {
        boolean isFileNotFoundException = false;
        for (String s : mainFunc) {
            if (s.contains("catch") && s.contains("FileNotFoundException"))
                isFileNotFoundException = true;
        }
        Assert.assertTrue(
                "Метод main должен перехватывать исключение FileNotFoundException",
                isFileNotFoundException
        );
    }

    @Test
    public void test45NotArithmeticException() {
        boolean isNotArithmeticException = false;
        for (String s : mainFunc) {
            if (s.contains("catch") && s.contains("ArithmeticException"))
                isNotArithmeticException = true;
        }
        Assert.assertFalse(
                "Метод main не должен перехватывать исключение ArithmeticException",
                isNotArithmeticException
        );
    }

    @Test
    public void test45NotURISyntaxException() {
        boolean isNotURISyntaxException = false;
        for (String s : mainFunc) {
            if (s.contains("catch") && s.contains("URISyntaxException"))
                isNotURISyntaxException = true;
        }
        Assert.assertFalse(
                "Метод main не должен перехватывать исключение URISyntaxException",
                isNotURISyntaxException
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
            test = collect.get(a).equals("  public static void " + funcName + "() throws NullPointerException, ArithmeticException, FileNotFoundException, URISyntaxException {") &&
                    collect.get(a + 1).equals("    int i = (int) (Math.random() * 4);") &&
                    collect.get(a + 2).equals("    if (i == 0) {") &&
                    collect.get(a + 3).equals("      throw new NullPointerException();") &&
                    collect.get(a + 4).equals("    } else if (i == 1) {") &&
                    collect.get(a + 5).equals("      throw new ArithmeticException();") &&
                    collect.get(a + 6).equals("    } else if (i == 2) {") &&
                    collect.get(a + 7).equals("      throw new FileNotFoundException();") &&
                    collect.get(a + 8).equals("    } else if (i == 3) {") &&
                    collect.get(a + 9).equals("      throw new URISyntaxException(\"\", \"\");") &&
                    collect.get(a + 10).equals("    }") &&
                    collect.get(a + 11).equals("  }");

        } catch (Exception e) {
            e.printStackTrace();
        }

        return test;
    }

    @Test
    public void test45NotChangeMethod1() {
        Assert.assertTrue(
                "Метод method1 не изменять",
                checkCode("method1")
        );
    }
}
