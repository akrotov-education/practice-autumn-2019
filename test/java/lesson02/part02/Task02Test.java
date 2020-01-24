package lesson02.part02;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import util.SystemOutGatewayUtil;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.*;

public class Task02Test {
    public static String fileName = "./src/main/java/lesson02/part02/Task02.java";

    @Before
    public void setUp() {
        SystemOutGatewayUtil.setCustomOut();
    }

    @After
    public void tearDown() {
        SystemOutGatewayUtil.clearOutput();
        SystemOutGatewayUtil.setOriginalOut();

        Task02.Apple.applesPrice = 0;
    }

    @Test
    public void checkOutput() {
        Task02.main(null);

        ByteArrayOutputStream output = SystemOutGatewayUtil.getOutputArray();
        Assert.assertTrue("Программа должна выводить текст на экран", output.toString().length() > 0);
    }

    @Test
    public void checkAdjustAgeOutput() {
        Task02.Apple.addPrice(50);

        ByteArrayOutputStream output = SystemOutGatewayUtil.getOutputArray();
        Assert.assertTrue("Метод addPrice класса Apple не должен выводить текст на экран", output.toString().length() == 0);
    }

    @Test
    public void checkClassField() {
        Assert.assertEquals("Переменная applesPrice класса Apple должна бытьи проинициализирована нулем",
                0, Task02.Apple.applesPrice);
        Field field;
        try {
            field = Task02.Apple.class.getField("applesPrice");
            Assert.assertTrue("Переменная applesPrice класса Apple должна быть статической, иметь тип int",
                    field.toString().contains("static int")
            );
        } catch (NoSuchFieldException e) {
            Assert.fail("Переменная applesPrice класса Apple должна быть статической, иметь тип int");
        }
    }

    @Test
    public void mainCallAddPriceTwice() {
        try {
            Stream<String> stream = Files.lines(Paths.get(fileName));
            List<String> lines = stream.collect(Collectors.toList());
            int startLine = 0;
            for (int i = 0; i < lines.size(); i++) {
                if (lines.get(i).contains("public static void main")) {
                    startLine = i;
                    break;
                }
            }
            int callsCount = 0;
            for (int i = startLine; i < lines.size(); i++) {
                String line = lines.get(i);
                if (line.contains("}")) {
                    break;
                }
                if (line.contains("addPrice")) {
                    callsCount++;
                }
            }
            Assert.assertTrue("Метод main должен вызывать метод addPrice только два раза", callsCount == 2);
        } catch (IOException e) {
        }

    }

    @Test
    public void checkAddPriceWork() {
        Task02.Apple.addPrice(50);
        Assert.assertEquals("Метод addPrice класса Apple должен увеличивать стоимость яблок на переданное значение",
                50, Task02.Apple.applesPrice);
    }
}