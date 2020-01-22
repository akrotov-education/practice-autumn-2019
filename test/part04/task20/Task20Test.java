package part04.task20;

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

public class Task20Test {
    public static String fileName = "./src/main/java/lesson05/part04/task20/Task20.java";
    public static String S = "./src/main/java/lesson05/part04/task12/Singleton.java";

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
    public void Singleton(){
        try {
            Stream<String> stream = Files.lines(Paths.get(S));
            List<String> line = stream.collect(Collectors.toList());
            String lineWithMethodCall = line.get(2);
            Assert.assertTrue("Класс Singleton должен быть создан в отдельном файле.",
                    lineWithMethodCall.contains("public class Singleton {"));
            String lineWithMethodCall1 = line.get(3);
            Assert.assertTrue("Класс Singleton не должен позволять создавать объекты своего типа извне класса." +
                            "Класс Singleton должен содержать приватное статическое поле instance типа Singleton.",
                    lineWithMethodCall1.contains(" private static Singleton INSTANCE = new Singleton();"));
            String lineWithMethodCall2 = line.get(6);
            Assert.assertTrue("В классе Singleton должен быть реализован публичный статический метод getInstance возвращающий значение поля instance.",
                    lineWithMethodCall2.contains("public static Singleton getInstance() {"));
            String lineWithMethodCall3 = line.get(6);
            Assert.assertTrue("В классе Singleton должен быть реализован публичный статический метод getInstance возвращающий значение поля instance.",
                    lineWithMethodCall3.contains("public static Singleton getInstance() {"));
        } catch (IOException e) {
        }
    }
}