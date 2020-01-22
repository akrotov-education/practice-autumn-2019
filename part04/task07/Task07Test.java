package part04.task07;

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

public class Task07Test {
    public static String fileName = "./src/main/java/lesson05/part04/task07.Task07.java";
    public static String BH = "./src/main/java/lesson05/part04/task07.BelarusianHen.java";
    public static String MH = "./src/main/java/lesson05/part04/task07.MoldovanHen.java";
    public static String UH = "./src/main/java/lesson05/part04/task07.UkrainianHen.java";
    public static String RH = "./src/main/java/lesson05/part04/task07.RussianHen.java";

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
    public void Abstract(){
        try {
            Stream<String> stream = Files.lines(Paths.get(fileName));
            List<String> line = stream.collect(Collectors.toList());
            String lineWithMethodCall = line.get(49);
            Assert.assertTrue("Класс Hen должен быть абстрактным",
                    lineWithMethodCall.contains("abstract class Hen"));
        } catch (IOException e) {
        }
    }

    @Test
    public void AbstractcontainsMethod(){
        try {
            Stream<String> stream = Files.lines(Paths.get(fileName));
            List<String> line = stream.collect(Collectors.toList());
            String lineWithMethodCall = line.get(50);
            Assert.assertTrue("Класс Hen должен содержать абстрактный метод int getCountOfEggsPerMonth().",
                    lineWithMethodCall.contains("abstract int getCountOfEggsPerMonth();"));
        } catch (IOException e) {
        }
    }

    @Test
    public void AbstractcontainsMethod2(){
        try {
            Stream<String> stream = Files.lines(Paths.get(fileName));
            List<String> line = stream.collect(Collectors.toList());
            String lineWithMethodCall = line.get(51);
            String lineWithMethodCall2 = line.get(52);
            Assert.assertTrue("Класс Hen должен содержать абстрактный метод int getCountOfEggsPerMonth().",
                    (lineWithMethodCall.contains("String getDescription() {"))&
                            (lineWithMethodCall2.contains("return \"Я - курица.\";")));
        } catch (IOException e) {
        }
    }

    @Test
    public void HensExtends(){
        try {
            Stream<String> stream = Files.lines(Paths.get(RH));
            List<String> line = stream.collect(Collectors.toList());
            String lineWithMethodCall = line.get(2);
            Assert.assertTrue("Каждый класс Hen должен наследоваться от Hen и быть создан в отдельом файле",
                    (lineWithMethodCall.contains("class RussianHen extends lesson05.part04.task07.Task07.Hen")));
            stream = Files.lines(Paths.get(UH));
            line = stream.collect(Collectors.toList());
            lineWithMethodCall = line.get(2);
            Assert.assertTrue("Каждый класс Hen должен наследоваться от Hen и быть создан в отдельом файле",
                    (lineWithMethodCall.contains("class UkrainianHen extends lesson05.part04.task07.Task07.Hen")));
            stream = Files.lines(Paths.get(MH));
            line = stream.collect(Collectors.toList());
            lineWithMethodCall = line.get(2);
            Assert.assertTrue("Каждый класс Hen должен наследоваться от Hen и быть создан в отдельом файле",
                    (lineWithMethodCall.contains("class MoldovanHen extends lesson05.part04.task07.Task07.Hen")));
            stream = Files.lines(Paths.get(BH));
            line = stream.collect(Collectors.toList());
            lineWithMethodCall = line.get(2);
            Assert.assertTrue("Каждый класс Hen должен наследоваться от Hen и быть создан в отдельом файле",
                    (lineWithMethodCall.contains("class BelarusianHen extends lesson05.part04.task07.Task07.Hen")));
        } catch (IOException e) {
        }
    }

    @Test
    public void HensEggs(){
        try {
            Stream<String> stream = Files.lines(Paths.get(RH));
            List<String> line = stream.collect(Collectors.toList());
            String lineWithMethodCall = line.get(3);
            Assert.assertTrue("Каждый класс Hen должен реализовывать метод getCountOfEggsPerMonth," +
                            " который должен возвращать количество яиц в месяц от данного типа куриц",
                    (lineWithMethodCall.contains("int getCountOfEggsPerMonth(){")));
            stream = Files.lines(Paths.get(UH));
            line = stream.collect(Collectors.toList());
            lineWithMethodCall = line.get(3);
            Assert.assertTrue("Каждый класс Hen должен реализовывать метод getCountOfEggsPerMonth," +
                            " который должен возвращать количество яиц в месяц от данного типа куриц",
                    (lineWithMethodCall.contains("int getCountOfEggsPerMonth(){")));
            stream = Files.lines(Paths.get(MH));
            line = stream.collect(Collectors.toList());
            lineWithMethodCall = line.get(3);
            Assert.assertTrue("Каждый класс Hen должен реализовывать метод getCountOfEggsPerMonth," +
                            " который должен возвращать количество яиц в месяц от данного типа куриц",
                    (lineWithMethodCall.contains("int getCountOfEggsPerMonth(){")));
            stream = Files.lines(Paths.get(BH));
            line = stream.collect(Collectors.toList());
            lineWithMethodCall = line.get(3);
            Assert.assertTrue("Каждый класс Hen должен реализовывать метод getCountOfEggsPerMonth," +
                            " который должен возвращать количество яиц в месяц от данного типа куриц",
                    (lineWithMethodCall.contains("int getCountOfEggsPerMonth(){")));
        } catch (IOException e) {
        }
    }

    @Test
    public void HensDescription(){
        try {
            Stream<String> stream = Files.lines(Paths.get(RH));
            List<String> line = stream.collect(Collectors.toList());
            String lineWithMethodCall = line.get(6);
            String lineWithMethodCall1 = line.get(7);
            Assert.assertTrue((lineWithMethodCall.contains("String getDescription(){"))&
                    (lineWithMethodCall1.contains("return \"Я - курица.\" + \" Моя страна - \" + RUSSIA + " +
                            "\". Я несу \" + getCountOfEggsPerMonth() + \" яиц в месяц.\";")));
            stream = Files.lines(Paths.get(UH));
            line = stream.collect(Collectors.toList());
            lineWithMethodCall = line.get(6);
            lineWithMethodCall1 = line.get(7);
            Assert.assertTrue((lineWithMethodCall.contains("String getDescription(){"))&
                    (lineWithMethodCall1.contains("return \"Я - курица.\" + \" Моя страна - \" + UKRAINE + " +
                            "\". Я несу \" + getCountOfEggsPerMonth() + \" яиц в месяц.\";")));
            stream = Files.lines(Paths.get(MH));
            line = stream.collect(Collectors.toList());
            lineWithMethodCall = line.get(6);
            lineWithMethodCall1 = line.get(7);
            Assert.assertTrue((lineWithMethodCall.contains("String getDescription(){"))&
                    (lineWithMethodCall1.contains("return \"Я - курица.\" + \" Моя страна - \" + MOLDOVA + " +
                            "\". Я несу \" + getCountOfEggsPerMonth() + \" яиц в месяц.\";")));
            stream = Files.lines(Paths.get(BH));
            line = stream.collect(Collectors.toList());
            lineWithMethodCall = line.get(6);
            lineWithMethodCall1 = line.get(7);
            Assert.assertTrue((lineWithMethodCall.contains("String getDescription(){"))&
                    (lineWithMethodCall1.contains("return \"Я - курица.\" + \" Моя страна - \" + BELARUS + " +
                            "\". Я несу \" + getCountOfEggsPerMonth() + \" яиц в месяц.\";")));
        } catch (IOException e) {
        }
    }

}