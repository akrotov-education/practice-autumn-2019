package part04.task16;

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

public class Task16Test {
    public static String fileName = "./src/main/java/lesson05/part04/task16/Task16.java";
    public static String H = "./src/main/java/lesson05/part04/task16/Hrivna.java";
    public static String M = "./src/main/java/lesson05/part04/task16/Money.java";
    public static String R = "./src/main/java/lesson05/part04/task16/Ruble.java";
    public static String U = "./src/main/java/lesson05/part04/task16/USD.java";

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
    public void Money(){
        try {
            Stream<String> stream = Files.lines(Paths.get(fileName));
            List<String> line = stream.collect(Collectors.toList());
            String lineWithMethodCall = line.get(43);
            String lineWithMethodCall2 = line.get(44);
            String lineWithMethodCall3 = line.get(45);
            String lineWithMethodCall4 = line.get(47);
            String lineWithMethodCall5 = line.get(48);
            Assert.assertTrue("В классе Money должно содержаться приватное поле amount типа double." +
                            "В классе Money должен быть реализован публичный конструктор с одним параметром типа double, который устанавливает " +
                            "значение переменной amount согласно переданному параметру." +
                            "В классе Money должен быть реализован публичный метод getAmount, который будет возвращать значение поля amount.",
                    lineWithMethodCall.contains("private double amount;")&
                            (lineWithMethodCall2.contains("public Money(double amount) {"))&
                            (lineWithMethodCall3.contains("this.amount = amount;"))&
                            (lineWithMethodCall4.contains("public double getAmount() {"))&
                            (lineWithMethodCall5.contains("return amount;")));
        } catch (IOException e) {
        }
    }

    @Test
    public void Currency(){
        try {
            Stream<String> stream = Files.lines(Paths.get(H));
            List<String> line = stream.collect(Collectors.toList());
            String lineWithMethodCall = line.get(3);
            String lineWithMethodCall2 = line.get(7);
            String lineWithMethodCall3 = line.get(8);
            String lineWithMethodCall4 = line.get(4);
            String lineWithMethodCall5 = line.get(5);
            Assert.assertTrue("Классы Hrivna, Ruble и USD должны быть потомками класса Money и существовать в отдельных файлах." +
                            "В классах Hrivna, Ruble и USD должен быть реализован метод getCurrencyName." +
                            "Метод getCurrencyName должен возвращать название соответствующей валюты(строку) в виде аббревиатуры(USD, UAH, RUB)." +
                            "В классах Hrivna, Ruble и USD должен быть реализован публичный конструктор с одним параметром типа double, который устанавливает значение\n" +
                            "поля amount класса Money путем вызова конструктора класса родителя c тем же параметром.",
                    lineWithMethodCall.contains("class Hrivna extends Money {")&
                            (lineWithMethodCall2.contains(" public String getCurrencyName(){"))&
                            (lineWithMethodCall3.contains(" return \"UAH\";"))&
                            (lineWithMethodCall4.contains("public Hrivna(double amount) {"))&
                            (lineWithMethodCall5.contains("super(amount);")));
            stream = Files.lines(Paths.get(R));
            line = stream.collect(Collectors.toList());
            lineWithMethodCall = line.get(3);
            lineWithMethodCall2 = line.get(7);
            lineWithMethodCall3 = line.get(8);
            lineWithMethodCall4 = line.get(4);
            lineWithMethodCall5 = line.get(5);
            Assert.assertTrue("Классы Hrivna, Ruble и USD должны быть потомками класса Money и существовать в отдельных файлах." +
                            "В классах Hrivna, Ruble и USD должен быть реализован метод getCurrencyName." +
                            "Метод getCurrencyName должен возвращать название соответствующей валюты(строку) в виде аббревиатуры(USD, UAH, RUB)." +
                            "В классах Hrivna, Ruble и USD должен быть реализован публичный конструктор с одним параметром типа double, который устанавливает значение\n" +
                            "поля amount класса Money путем вызова конструктора класса родителя c тем же параметром.",
                    lineWithMethodCall.contains("class Ruble extends Money {")&
                            (lineWithMethodCall2.contains(" public String getCurrencyName(){"))&
                            (lineWithMethodCall3.contains(" return \"RUB\";"))&
                            (lineWithMethodCall4.contains("public Ruble(double amount) {"))&
                            (lineWithMethodCall5.contains("super(amount);")));
            stream = Files.lines(Paths.get(U));
            line = stream.collect(Collectors.toList());
            lineWithMethodCall = line.get(3);
            lineWithMethodCall2 = line.get(7);
            lineWithMethodCall3 = line.get(8);
            lineWithMethodCall4 = line.get(4);
            lineWithMethodCall5 = line.get(5);
            Assert.assertTrue("Классы Hrivna, Ruble и USD должны быть потомками класса Money и существовать в отдельных файлах." +
                            "В классах Hrivna, Ruble и USD должен быть реализован метод getCurrencyName." +
                            "Метод getCurrencyName должен возвращать название соответствующей валюты(строку) в виде аббревиатуры(USD, UAH, RUB)." +
                            "В классах Hrivna, Ruble и USD должен быть реализован публичный конструктор с одним параметром типа double, который устанавливает значение\n" +
                            "поля amount класса Money путем вызова конструктора класса родителя c тем же параметром.",
                    lineWithMethodCall.contains("class USD extends Money {")&
                            (lineWithMethodCall2.contains(" public String getCurrencyName(){"))&
                            (lineWithMethodCall3.contains(" return \"USD\";"))&
                            (lineWithMethodCall4.contains("public USD(double amount) {"))&
                            (lineWithMethodCall5.contains("super(amount);")));
        } catch (IOException e) {
        }
    }

}