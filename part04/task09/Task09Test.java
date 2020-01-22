package part04.task09;

import org.junit.After;
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

import static org.junit.Assert.*;

public class Task09Test {
    public static String fileName = "./src/main/java/lesson05/part04/task09.Task09.java";
    public static String W = "./src/main/java/lesson05/part04/task09.Wine.java";
    public static String D = "./src/main/java/lesson05/part04/task09.Drink.java";
    public static String B = "./src/main/java/lesson05/part04/task09.BubbblyWine.java";

    @Before
    public void setUp() throws Exception {
        SystemOutGatewayUtil.setCustomOut();
    }

    @After
    public void tearDown() throws Exception {
        SystemOutGatewayUtil.setOriginalOut();
        SystemOutGatewayUtil.clearOutput();
    }

    @Test
    public void DrinkFile(){
        try {
            Stream<String> stream = Files.lines(Paths.get(D));
            List<String> line = stream.collect(Collectors.toList());
            String lineWithMethodCall = line.get(2);
            String lineWithMethodCall2 = line.get(4);
            Assert.assertTrue("Абстрактный класс Drink должен быть создан в отдельном файле." +
                            "В классе Drink должен быть реализован метод public void taste(), который выводит на экран строку - \"Вкусно\".",
                    lineWithMethodCall.contains("abstract class Drink{")&
                            (lineWithMethodCall2.contains("System.out.println(\"Вкусно\");")));
        } catch (IOException e) {
        }
    }

    @Test
    public void WineFile(){
        try {
            Stream<String> stream = Files.lines(Paths.get(W));
            List<String> line = stream.collect(Collectors.toList());
            String lineWithMethodCall = line.get(3);
            String lineWithMethodCall2 = line.get(5);
            Assert.assertTrue("Класс Wine должен быть создан в отдельном файле и быть потомком класса Drink. " +
                            "В классе Wine должен быть реализован метод public String getHolidayName(), который возвращает строку - \"День Рождения\".",
                    lineWithMethodCall.contains("class Wine extends Drink {")&
                            (lineWithMethodCall2.contains("return \"День Рождения\";")));
        } catch (IOException e) {
        }
    }

    @Test
    public void BubblyWineFile(){
        try {
            Stream<String> stream = Files.lines(Paths.get(B));
            List<String> line = stream.collect(Collectors.toList());
            String lineWithMethodCall = line.get(4);
            String lineWithMethodCall2 = line.get(6);
            Assert.assertTrue("Класс BubblyWine должен быть создан в отдельном файле и быть потомком класса Wine." +
                            " В классе BubblyWine должен быть реализован метод public String getHolidayName(), который возвращает строку - \"Новый Год\".",
                    lineWithMethodCall.contains("class BubblyWine extends Wine {")&
                            (lineWithMethodCall2.contains("return \"Новый Год\";")));
        } catch (IOException e) {
        }
    }




}