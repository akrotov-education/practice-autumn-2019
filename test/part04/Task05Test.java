package part04;

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

public class Task05Test {
    public static String fileName = "./src/main/java/lesson05/part04/Task05.java";

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
    public void MethodExtends(){
        try {
            Stream<String> stream = Files.lines(Paths.get(fileName));
            List<String> line = stream.collect(Collectors.toList());
            String lineWithMethodCall = line.get(35);
            Assert.assertTrue("Класс GrayMouse должен наследоваться от класса Mouse.",
                    lineWithMethodCall.contains("class GrayMouse extends Mouse"));
        } catch (IOException e) { }
    }

    @Test
    public void MethodExtends2(){
        try {
            Stream<String> stream = Files.lines(Paths.get(fileName));
            List<String> line = stream.collect(Collectors.toList());
            String lineWithMethodCall = line.get(38);
            Assert.assertTrue("Класс Jerry должен наследоваться от класса GrayMouse.",
                    lineWithMethodCall.contains("class Jerry extends GrayMouse"));
        } catch (IOException e) { }
    }

    @Test
    public void threeobjects(){
        try {
            Stream<String> stream = Files.lines(Paths.get(fileName));
            List<String> line = stream.collect(Collectors.toList());
            String lineWithMethodCall = line.get(16);
            Assert.assertTrue("В переменной obj должен храниться объект который будет одновременно являться и Mouse, и GrayMouse, и Jerry",
                    lineWithMethodCall.contains("Object obj = new Jerry();"));
        } catch (IOException e) { }
    }

    @Test
    public void MethodPrints(){
        try {
            Stream<String> stream = Files.lines(Paths.get(fileName));
            List<String> line = stream.collect(Collectors.toList());
            String lineWithMethodCall = line.get(22);
            Assert.assertTrue("Метод main должен вызывать метод printClasses.",
                    lineWithMethodCall.contains("printClasses(obj, mouse, grayMouse, jerry);"));
        } catch (IOException e) { }
    }

}