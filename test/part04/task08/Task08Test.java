package part04.task08;

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

public class Task08Test {
    public static String fileName = "./src/main/java/lesson05/part04/task08.Task08.java";
    public static String SB = "./src/main/java/lesson05/part04/task08.SuspensionBridge.java";
    public static String WB = "./src/main/java/lesson05/part04/task08.WaterBridge.java";
    public static String B = "./src/main/java/lesson05/part04/task08.Bridge.java";

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
    public void BridgeFile(){
        try {
            Stream<String> stream = Files.lines(Paths.get(B));
            List<String> line = stream.collect(Collectors.toList());
            String lineWithMethodCall = line.get(2);
            String lineWithMethodCall2 = line.get(3);
            Assert.assertTrue("Интерфейс Bridge должен быть создан в отдельном файле, в нем должен быть определен метод int getCarsCount().",
                    lineWithMethodCall.contains("public interface Bridge")&
                            (lineWithMethodCall2.contains(" int getCarsCount();")));
        } catch (IOException e) {
        }
    }

    @Test
    public void BridgesFiles() {
        try {
            Stream<String> stream = Files.lines(Paths.get(SB));
            List<String> line = stream.collect(Collectors.toList());
            String lineWithMethodCall = line.get(2);
            Assert.assertTrue("Класс SuspensionBridge должен быть создан в отдельном файле и реализовывать интерфейс Bridge.",
                    lineWithMethodCall.contains("class SuspensionBridge implements lesson05.part04.task08.Bridge"));
            stream = Files.lines(Paths.get(WB));
            line = stream.collect(Collectors.toList());
            lineWithMethodCall = line.get(2);
            Assert.assertTrue("Класс WaterBridge должен быть создан в отдельном файле и реализовывать интерфейс Bridge.",
                    lineWithMethodCall.contains("class WaterBridge implements lesson05.part04.task08.Bridge"));
        } catch (IOException e) {
        }
    }

    @Test
    public void BridgesMethod() {
        try {
            Stream<String> stream = Files.lines(Paths.get(SB));
            List<String> line = stream.collect(Collectors.toList());
            String lineWithMethodCall = line.get(2);
            String lineWithMethodCall2 = line.get(3);
            Assert.assertTrue("Метод getCarsCount() должен возвращать различные значения типа int для различных классов, " +
                            "но всегда фиксированное(константное) значение для разных объектов одного и того же класса.",
                    lineWithMethodCall.contains("public int getCarsCount() {")&
                            (lineWithMethodCall2.contains("return 200;")));
            stream = Files.lines(Paths.get(WB));
            line = stream.collect(Collectors.toList());
            lineWithMethodCall = line.get(2);
            lineWithMethodCall2 = line.get(3);
            Assert.assertTrue("Метод getCarsCount() должен возвращать различные значения типа int для различных классов, " +
                            "но всегда фиксированное(константное) значение для разных объектов одного и того же класса.",
                    lineWithMethodCall.contains("public int getCarsCount() {")&
                    (lineWithMethodCall2.contains("return 100;")));
        } catch (IOException e) {
        }
    }

    @Test
    public void PrintBridges() {
        try {
            Stream<String> stream = Files.lines(Paths.get(fileName));
            List<String> line = stream.collect(Collectors.toList());
            String lineWithMethodCall = line.get(25);
            String lineWithMethodCall2 = line.get(26);
            Assert.assertTrue("В классе Solution должен быть реализован публичный(public) метод println c одним параметром типа Bridge.",
                    (lineWithMethodCall.contains(" println(new lesson05.part04.task08.WaterBridge());"))&
                            (lineWithMethodCall2.contains(" println(new lesson05.part04.task08.SuspensionBridge());")));
        } catch (IOException e) {
        }
    }
}