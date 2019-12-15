package lesson05.part03;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import util.SystemInGatewayUtil;
import util.SystemOutGatewayUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task07Test {
    public static String fileName = "./src/main/java/lesson05/part03/Task07.java";
    public static List<String> collect;

    static {
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

            collect = stream.collect(Collectors.toList());
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
    public void test07SimpleObjectInterface() {
        int numberStringObject = -1;

        for (int i = 0; i < collect.size(); i++) {
            if (collect.get(i).contains("class StringObject implements SimpleObject<String>")) {
                numberStringObject = i;
            }
        }

        Assert.assertTrue(
                "Класс StringObject должен реализовывать интерфейс SimpleObject.",
                numberStringObject > -1
        );
    }

    @Test
    public void test07Parameter() {
        Assert.assertTrue(
                "Интерфейс SimpleObject в классе StringObject должен быть реализован с параметром типа String.",
                new Task07.StringObject().getInstance() instanceof Task07.SimpleObject
        );
    }

    public boolean checkCodeStringObject() {
        boolean test = false;

        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

            List<String> collect = stream.collect(Collectors.toList());
            int a = 0;

            for (int i = 0; i < collect.size(); i++)
                if (collect.get(i).contains("public SimpleObject<String> getInstance()")) {
                    a = i;
                    break;
                }
            test = collect.get(a).contains("getInstance()") &&
                    collect.get(a).contains("{");

        } catch (Exception e) {
            e.printStackTrace();
        }

        return test;
    }

    @Test
    public void test07Realization() {
        Assert.assertTrue(
                "В классе StringObject реализовать метод getInstance интерфейса SimpleObject.",
                checkCodeStringObject()
        );
    }

    @Test
    public void test07NoChangeCountClassAndInterface() {
        int countClassAndInterface = 0;

        for (String list: collect) {
            if (list. contains("class") || list.contains("interface")) {
                countClassAndInterface++;
            }
        }
        Assert.assertTrue(
                "Дополнительные классы или интерфейсы создавать нельзя.",
                countClassAndInterface == 3
        );
    }
}
