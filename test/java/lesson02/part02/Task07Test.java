package lesson02.part02;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import util.SystemOutGatewayUtil;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class Task07Test {
    public static String fileName = "./src/main/java/lesson02/part02/Task07.java";
    @Before
    public void setUp() {
        SystemOutGatewayUtil.setCustomOut();
    }

    @After
    public void tearDown() {
        SystemOutGatewayUtil.clearOutput();
        SystemOutGatewayUtil.setOriginalOut();

        Task07.Cat.count = 0;
    }

    @Test
    public void checkOutput() {
        Task07.main(null);

        ByteArrayOutputStream output = SystemOutGatewayUtil.getOutputArray();
        Assert.assertTrue("Программа должна выводить текст на экран", output.toString().length() > 0);
    }

    @Test
    public void NotChangeLine() {
        try {
            Stream<String> stream = Files.lines(Paths.get(fileName));
            List<String> collect = stream.collect(Collectors.toList());
            int ind = collect.indexOf("        System.out.println(\"The cat count is \" + Cat.count);");
            Assert.assertEquals("Нельзя изменять строку отвечающую за вывод в консоль", 23, ind);
        } catch (IOException e) {
        }
    }

    @Test
    public void checkCatFields() {
        Field[] fields = Task07.Cat.class.getDeclaredFields();
        Assert.assertTrue("Класс Cat должен содержать только одну переменную count",
                fields.length == 1 && fields[0].getName().contentEquals("count"));
    }

    @Test
    public void checkCountField() {
        try {
            Field field = Task07.Cat.class.getDeclaredField("count");
            String modifier = Modifier.toString(field.getModifiers());
            String type = field.getType().toString();

            Assert.assertEquals("Переменная count класса Cat должна быть статической, иметь модификатор доступа public",
                    "public static", modifier);
            Assert.assertEquals("Переменная count класса Cat должна иметь тип int",
                    "int", type);

            Assert.assertEquals("Переменная count класса Cat должна быть проинициализирована нулем",
                    0, Task07.Cat.count);
        } catch (NoSuchFieldException e) {
        }
    }

    @Test
    public void checkTwoCatInMain() {
        try{
            Stream<String> stream = Files.lines(Paths.get(fileName));
            List<String> lines = stream.collect(Collectors.toList());
            int startLine = 0;
            for (int i = 0; i < lines.size(); i++) {
                if (lines.get(i).contains("public static void main")) {
                    startLine = i;
                    break;
                }
            }

            int catsCount = 0;
            for (int i = startLine; i < lines.size(); i++) {
                String line = lines.get(i);

                if (line.contains("}")) {
                    break;
                }

                if (line.contains("new Cat()")) {
                    catsCount++;
                }
            }

            Assert.assertTrue("В методе main должно быть только две проинициализированные переменные типа Cat", catsCount == 2);
        }
        catch (IOException e) {
        }
    }

    @Test
    public void checkRelevantCatsCount() {
        Task07.main(null);
        Assert.assertEquals("Переменная count должна содержать актуальное количество созданных объектов-котов", 2, Task07.Cat.count);
    }
}