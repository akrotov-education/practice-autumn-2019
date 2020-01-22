package part04.task12;

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


public class Task12Test {
    public static String fileName = "./src/main/java/lesson05/part04/task12/Task12.java";
    public static String M = "./src/main/java/lesson05/part04/task12/Mouse.java";
    public static String Mon = "./src/main/java/lesson05/part04/task12/Monitor.java";
    public static String K = "./src/main/java/lesson05/part04/task12/Keyboard.java";
    public static String C = "./src/main/java/lesson05/part04/task12/Computer.java";
    public static String CI = "./src/main/java/lesson05/part04/task12/CompItem.java";

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
    public void CompItem(){
        try {
            Stream<String> stream = Files.lines(Paths.get(fileName));
            List<String> line = stream.collect(Collectors.toList());
            String lineWithMethodCall = line.get(2);
            String lineWithMethodCall2 = line.get(3);
            Assert.assertTrue("Интерфейс CompItem должен существовать в отдельном файле." +
                            "В интерфейсе CompItem должен быть объявлен метод getName() с типом возвращаемого значения String и без параметров.",
                    lineWithMethodCall.contains("public interface CompItem{")&
                            (lineWithMethodCall2.contains("String getName();")));
        } catch (IOException e) {
        }
    }

    @Test
    public void MouseMonitorKeyboard(){
        try {
            Stream<String> stream = Files.lines(Paths.get(K));
            List<String> line = stream.collect(Collectors.toList());
            String lineWithMethodCall = line.get(3);
            String lineWithMethodCall1 = line.get(5);
            Stream<String> stream2 = Files.lines(Paths.get(M));
            List<String> line2 = stream2.collect(Collectors.toList());
            String lineWithMethodCall2 = line2.get(3);
            String lineWithMethodCall21 = line2.get(5);
            Stream<String> stream3 = Files.lines(Paths.get(Mon));
            List<String> line3 = stream3.collect(Collectors.toList());
            String lineWithMethodCall3 = line3.get(3);
            String lineWithMethodCall31 = line3.get(5);
            Assert.assertTrue("Классы Keyboard, Monitor и Mouse должны реализовывать интерфейс CompItem, а также существовать в отдельных файлах.",
                    lineWithMethodCall.contains("public class Keyboard implements CompItem {")&
                            (lineWithMethodCall2.contains("public class Mouse implements CompItem {"))&
                            (lineWithMethodCall3.contains("public class Monitor implements CompItem {")));

            Assert.assertTrue("Метод getName в классах реализующих интерфейс CompItem должен возвращать простое имя класса.",
                    lineWithMethodCall1.contains("return getClass().getSimpleName();")&
                            (lineWithMethodCall21.contains("return getClass().getSimpleName();"))&
                            (lineWithMethodCall31.contains("return getClass().getSimpleName();")));
        } catch (IOException e) {
        }
    }

    @Test
    public void Computer(){
        try {
            Stream<String> stream = Files.lines(Paths.get(fileName));
            List<String> line = stream.collect(Collectors.toList());
            String lineWithMethodCall = line.get(6);
            String lineWithMethodCall2 = line.get(7);
            String lineWithMethodCall3 = line.get(8);
            Assert.assertTrue("Класс Computer должен содержать по одному приватному полю типа " +
                            "Keyboard, Mouse, Monitor, а также существовать в отдельном файле.",
                    lineWithMethodCall.contains("private Keyboard keyboard;")&
                            (lineWithMethodCall2.contains("private Mouse mouse;")&
                            (lineWithMethodCall3.contains("private Monitor monitor;"))));
        } catch (IOException e) {
        }
    }

    @Test
    public void ComputerConstr(){
        try {
            Stream<String> stream = Files.lines(Paths.get(C));
            List<String> line = stream.collect(Collectors.toList());
            String lineWithMethodCall = line.get(10);
            Assert.assertTrue("Конструктор класса Computer должен принимать 3 " +
                            "параметра(keyboard, mouse, monitor) и корректно инициализировать соответствующие поля класса.",
                    lineWithMethodCall.contains("public Computer(Keyboard keyboard, Mouse mouse, Monitor monitor) {"));
        } catch (IOException e) {
        }
    }

    @Test
    public void Пуееукы(){
        try {
            Stream<String> stream = Files.lines(Paths.get(C));
            List<String> line = stream.collect(Collectors.toList());
            String lineWithMethodCall = line.get(16);
            String lineWithMethodCall2 = line.get(20);
            String lineWithMethodCall3 = line.get(24);
            Assert.assertTrue("Для полей keyboard, mouse и monitor Computer должны быть созданы " +
                            "геттеры(getKeyboard, getMouse, getMonitor), которые будут возвращать соответствующие поля класса Computer.",
                    (lineWithMethodCall.contains(" public Keyboard getKeyboard() {"))&
                            (lineWithMethodCall2.contains("public Mouse getMouse() {"))&
                            (lineWithMethodCall3.contains("public Monitor getMonitor() {")));
        } catch (IOException e) {
        }
    }
}