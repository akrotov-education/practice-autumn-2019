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

public class Task19Test {
    public static String fileName = "./src/main/java/lesson02/part01/Task19.java";

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
    public void test19OutputScreen() throws Exception {
        String name = "kek";
        SystemInGatewayUtil.provideInput(name);
        Task19.main(null);
        SystemOutGatewayUtil.setOriginalOut();
        ByteArrayOutputStream outputArr = SystemOutGatewayUtil.getOutputArray();
        String s = outputArr.toString();

        Assert.assertTrue(
                "Программа должна выводить текст",
                !s.isEmpty()
        );
    }

    @Test
    public void test19ReadKeyboard() throws Exception {
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

            List<String> collect = stream.collect(Collectors.toList());
            int a = 0;
            int b = 0;
            boolean var = false;

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
                    var = true;
            }

            Assert.assertTrue(
                    "Программа должна считывать данные с клавиатуры",
                    var
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test19ContainsName() throws Exception {
        String name = "kek";
        SystemInGatewayUtil.provideInput(name);
        Task19.main(null);
        SystemOutGatewayUtil.setOriginalOut();
        ByteArrayOutputStream outputArr = SystemOutGatewayUtil.getOutputArray();
        String s = outputArr.toString();

        Assert.assertTrue(
                "Выведенный текст должен содержать введенное имя",
                s.contains(name + " ")
        );
    }

    @Test
    public void test19RightString() throws Exception {
        String name = "kek";
        SystemInGatewayUtil.provideInput(name);
        Task19.main(null);
        SystemOutGatewayUtil.setOriginalOut();
        ByteArrayOutputStream outputArr = SystemOutGatewayUtil.getOutputArray();
        String s = outputArr.toString();

        Assert.assertTrue(
                "Выведенный тест должен полностью соответствовать заданию",
                s.equals(name + " зарабатывает $5,000. Ха-ха-ха!") ||
                        s.equals(name + " зарабатывает $5,000. Ха-ха-ха!\n")
        );
    }
}