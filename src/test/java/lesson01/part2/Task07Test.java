package lesson01.part2;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import util.SystemOutGatewayUtil;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task07Test {
    public static String fileName = "./src/main/java/lesson01/part2/Task07.java";

    @Before
    public void before() {
        SystemOutGatewayUtil.setCustomOut();
    }

    @Test
    public void test07OutputScreen() {
        Task07.main(null);
        SystemOutGatewayUtil.setOriginalOut();
        ByteArrayOutputStream outputArr = SystemOutGatewayUtil.getOutputArray();
        String s = outputArr.toString();

        Assert.assertTrue(
                "Программа должна выводить на экран число 19",
                s.contains("19\n")
        );
    }

    @Test
    public void test07InitVariables() {
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

            List<String> collect = stream.collect(Collectors.toList());
            int a = 0;

            for (int i = 0; i < collect.size(); i++)
                if (collect.get(i).contains("public static void main(String[] args)")) {
                    a = i + 1;
                    break;
                }

            Assert.assertTrue(
                    "Нельзя изменять строки с объявлением переменных",
                    collect.get(a).contains("int x = 1;") && collect.get(a+1).contains("int y = 0;")
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test07Print() {
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

            List<String> collect = stream.collect(Collectors.toList());

            Assert.assertTrue(
                    "Нельзя изменять строку отвечающую за вывод в консоль",
                    collect.get(26).contains("System.out.println(y);")
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test07RightComments() {
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

            List<String> collect = stream.collect(Collectors.toList());

            Assert.assertTrue(
                    "Нужно закомментировать некоторые строки и не менять остальные",
                    !collect.get(20).contains("//") &&
                            collect.get(21).contains("//") &&
                            !collect.get(22).contains("//") &&
                            collect.get(23).contains("//") &&
                            !collect.get(24).contains("//")
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
