package lesson05.part03;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import util.ReadFuncBodyUtil;
import util.SystemInGatewayUtil;
import util.SystemOutGatewayUtil;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task20Test {
    public static String fileName = "./src/main/java/lesson05/part03/Task20.java";
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
    public void test20Implements() {
        boolean isImplements = false;

        for (String list: collect) {
            if (list.contains("class User implements DBObject")) {
                isImplements = true;
            }
        }

        Assert.assertTrue(
                "Интерфейс DBObject должен быть реализован в классе User.",
                isImplements
        );
    }

    @Test
    public void test20InitializeIdAndNameReturnUser() {
        Assert.assertTrue(
                "Метод initializeIdAndName должен возвращать корректный объект типа User, объект на котором производится вызов метода(\"этот\" объект).",
                (new Task20.User().initializeIdAndName(10, "Sergey")) instanceof Task20.User
        );
    }

    @Test
    public void test20Variables() {
        int id = 10;
        String name = "Sergey";
        Task20.User user =  new Task20.User().initializeIdAndName(id, name);
        Assert.assertTrue(
                "Метод initializeIdAndName должен устанавливать значения полей id и name согласно переданным ему параметрам.",
                user.id == id && user.name == name
        );
    }

    @Test
    public void test20CheckSout() throws Exception {
        int id = 1;
        String name = "Neo";
        Task20.User user =  new Task20.User().initializeIdAndName(id, name);
        Task20.main(null);
        SystemOutGatewayUtil.setOriginalOut();
        ByteArrayOutputStream outputArr = SystemOutGatewayUtil.getOutputArray();
        String s = outputArr.toString();

        Assert.assertTrue(
                "Программа должна выводить на экран: \"The user's name is Neo, id = 1\"",
                s.equals("The user's name is Neo, id = 1\n")
        );
    }

    public boolean checkCodeToString() {
        boolean test = false;
        int a = 0;

        for (int i = 0; i < collect.size(); i++)
            if (collect.get(i).contains("String toString()")) {
                a = i;
                break;
            }

        test = collect.get(a).equals("        public String toString() {") &&
                collect.get(a + 1).equals("            return String.format(\"The user's name is %s, id = %d\", name, id);") &&
                collect.get(a + 2).equals("        }");

        return test;
    }

    @Test
    public void test20NoChangeToStringMethod() {
        Assert.assertTrue(
                "Метод toString не менять.",
                checkCodeToString()
        );
    }

    public boolean checkCodeMainFunc() {
        boolean test = false;
        int a = 0;

        for (int i = 0; i < collect.size(); i++)
            if (collect.get(i).contains("public static void main(String[] args")) {
                a = i;
                break;
            }

        test = collect.get(a).equals("    public static void main(String[] args) throws Exception {") &&
                collect.get(a + 1).equals("        System.out.println(Matrix.NEO);") &&
                collect.get(a + 2).equals("    }");

        return test;
    }

    @Test
    public void test20NoChangeMainFunc() {
        Assert.assertTrue(
                "Метод main не менять.",
                checkCodeMainFunc()
        );
    }
}
