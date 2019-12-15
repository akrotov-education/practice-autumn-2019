package lesson05.part03;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import util.SystemInGatewayUtil;
import util.SystemOutGatewayUtil;

import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task13Test {
    public static String fileName = "./src/main/java/lesson05/part03/Task13.java";
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
    public void test13ClassFoxImplements() {
        int numberFox = -1;

        for (int i = 0; i < collect.size(); i++) {
            if (collect.get(i).contains("class Fox implements Animal")) {
                numberFox = i;
            }
        }

        Assert.assertTrue(
                "Интерфейс Animal должен быть реализован в классе Fox.",
                numberFox > -1
        );
    }

    @Test
    public void test13FoxOneMethod() {
        Method[] methods = Task13.Fox.class.getMethods();
        int foxClassMethodsCount = 0;
        for (Method list: methods) {
            if (list.toString().contains("Fox.")) {
                foxClassMethodsCount++;
            }
        }


        Assert.assertTrue(
                "В классе Fox должен быть реализован только один метод(getName).",
                foxClassMethodsCount == 1
        );
    }

    @Test
    public void test13AnimalInterfaceDeclareMethodGetColor() {
        Method[] methods = Task13.Animal.class.getMethods();
        boolean isGetColorMethod = false;
        for (Method list: methods) {
            if (list.toString().contains("Animal.getColor")) {
                isGetColorMethod = true;
            }
        }
        Assert.assertTrue(
                "В интерфейсе Animal должен быть объявлен метод getColor.",
                isGetColorMethod
        );
    }

    @Test
    public void test13NoChangeCountClassAndInterface() {
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
