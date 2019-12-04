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

public class Task46Test {
    public static String fileName = "./src/main/java/lesson04/part03/task46/Task46.java";
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
    public void test46Method1() {
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
    public void test46CheckException() {
        boolean isException = false;
        for (String s : mainFunc) {
            if (s.contains("catch") && (s.contains("Exception1") || s.contains("Exception")))
                isException = true;
        }
        Assert.assertTrue(
                "Метод main должен перехватывать исключение Exception1, Exception2, Exception3",
                isException
        );
    }

    public boolean checkCode(String funcName) {
        boolean test = false;

        int a = 0;

        for (int i = 0; i < collect.size(); i++) {
            if (collect.get(i).contains("  public static void " + funcName + "() throws Exception1, Exception2, Exception3")) {
                a = i;
                break;
            }
        }
        test = collect.get(a).equals("  public static void " + funcName + "() throws Exception1, Exception2, Exception3 {") &&
                collect.get(a + 1).equals("    int i = (int) (Math.random() * 3);") &&
                collect.get(a + 2).equals("    if (i == 0) {") &&
                collect.get(a + 3).equals("      throw new Exception1();") &&
                collect.get(a + 4).equals("    } else if (i == 1) {") &&
                collect.get(a + 5).equals("      throw new Exception2();") &&
                collect.get(a + 6).equals("    } else if (i == 2) {") &&
                collect.get(a + 7).equals("      throw new Exception3();") &&
                collect.get(a + 8).equals("    }") &&
                collect.get(a + 9).equals("  }");

        return test;
    }

    @Test
    public void test46NoChangeMethod() {
        Assert.assertTrue(
                "Метод method1 не изменять",
                checkCode("method1")
        );
    }
}
