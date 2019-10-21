package lesson02.part01;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import util.SystemInGatewayUtil;
import util.SystemOutGatewayUtil;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task18Test {
    public static String fileName = "./src/main/java/lesson02/part01/Task18.java";

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
    public void test18OutputScreen() throws Exception {
        String name = "kek";
        int num1 = 15;
        int num2 = 12;
        SystemInGatewayUtil.provideInput(name + "\n" + num1 + "\n" + num2);
        Task18.main(null);
        SystemOutGatewayUtil.setOriginalOut();
        ByteArrayOutputStream outputArr = SystemOutGatewayUtil.getOutputArray();
        String s = outputArr.toString();

        Assert.assertTrue(
                "Программа должна выводить текст",
                !s.isEmpty()
        );
    }

    @Test
    public void test18ReadKeyboard() {
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

            List<String> collect = stream.collect(Collectors.toList());
            int a = 0;
            int b = 0;
            int number = 0;

            for (int i = 0; i < collect.size(); i++) {
                if (collect.get(i).contains("public static void main(String[] args)")) {
                    a = i + 1;
                }
                if (collect.get(i).contains("}")) {
                    b = i;
                    break;
                }
            }

            for (int i = a; i < b; i++) {
                if (collect.get(i).contains(".readLine()"))
                    number++;
            }

            Assert.assertTrue(
                    "Программа должна считывать данные с клавиатуры",
                    number == 3
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test18ContainsVariables() throws Exception {
        String name = "kek";
        int num1 = 15;
        int num2 = 12;
        SystemInGatewayUtil.provideInput(name + "\n" + num1 + "\n" + num2);
        Task18.main(null);
        SystemOutGatewayUtil.setOriginalOut();
        ByteArrayOutputStream outputArr = SystemOutGatewayUtil.getOutputArray();
        String s = outputArr.toString();

        Assert.assertTrue(
                "Программа должна считывать данные с клавиатуры",
                s.contains(name + " ") && s.contains(" " + num1 + " ") && s.contains(" " + num2 + " ")
        );
    }

    @Test
    public void test18RightString() throws Exception {
        String name = "kek";
        int num1 = 15;
        int num2 = 12;
        SystemInGatewayUtil.provideInput(name + "\n" + num1 + "\n" + num2);
        Task18.main(null);
        SystemOutGatewayUtil.setOriginalOut();
        ByteArrayOutputStream outputArr = SystemOutGatewayUtil.getOutputArray();
        String s = outputArr.toString();

        Assert.assertTrue(
                "Выведенный тест должен полностью соответствовать заданию",
                s.equals(name + " получает " + num1 + " через " + num2 + " лет.") ||
                        s.equals(name + " получает " + num1 + " через " + num2 + " лет.\n")
        );
    }
}