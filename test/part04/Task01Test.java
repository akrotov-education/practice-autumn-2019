package part04;

import lesson05.part04.Task01;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import util.SystemOutGatewayUtil;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class Task01Test {

    public static String fileName = "./src/main/java/lesson05/part04/Task01.java";

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
    public void MethodImplements(){
        try {
            Stream<String> stream = Files.lines(Paths.get(fileName));
            List<String> line = stream.collect(Collectors.toList());
            String lineWithMethodCall = line.get(28);
            Assert.assertTrue("Класс Cat должен реализовывать интерфейс CanMove",
                    lineWithMethodCall.contains("Cat implements CanMove"));
        } catch (IOException e) {
        }
    }

    @Test
    public void MethodExtends(){
        try {
            Stream<String> stream = Files.lines(Paths.get(fileName));
            List<String> line = stream.collect(Collectors.toList());
            String lineWithMethodCall = line.get(28);
            Assert.assertTrue("Класс Cat должен быть родителем(родительским классом) класса TomCat",
                    lineWithMethodCall.contains("class TomCat extends Cat"));
        } catch (IOException e) {
        }
    }

    @Test
    public void threeobjectsincat(){
        try {
            Stream<String> stream = Files.lines(Paths.get(fileName));
            List<String> line = stream.collect(Collectors.toList());
            String lineWithMethodCall = line.get(28);
            Assert.assertTrue(
                    "В переменной cat должен храниться объект который будет одновременно являться и CanMove, и Cat, и Tomcat",
                    lineWithMethodCall.contains("Task01.Cat cat = new Task01.TomCat();"));
        } catch (IOException e) {
        }
    }

    @Test
    public void IsTextOut(){
        Task01.main(null);
        ByteArrayOutputStream stream = SystemOutGatewayUtil.getOutputArray();
        String result = stream.toString();
        Assert.assertEquals("Программа должна выводить на экран: \"Bingo!\"", "Bingo!\r\n",  result);
        stream.reset();
    }
}