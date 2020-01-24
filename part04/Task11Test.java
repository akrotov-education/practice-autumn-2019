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

public class Task11Test {
    public static String fileName = "./src/main/java/lesson05/part04/Task11.java";

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
    public void MethodObjParam(){
        try {
            Stream<String> stream = Files.lines(Paths.get(fileName));
            List<String> line = stream.collect(Collectors.toList());
            String lineWithMethodCall = line.get(27);
            Assert.assertTrue("Класс Solution должен содержать реализацию метода printMainInfo с одним параметром типа Object.",
                    lineWithMethodCall.contains("void printMainInfo(Object object)"));
        } catch (IOException e) { }
    }

    @Test
    public void MethodStatic(){
        try {
            Stream<String> stream = Files.lines(Paths.get(fileName));
            List<String> line = stream.collect(Collectors.toList());
            String lineWithMethodCall = line.get(27);
            Assert.assertTrue("Метод printMainInfo должен быть статическим.",
                    lineWithMethodCall.contains("static void printMainInfo(Object object)"));
        } catch (IOException e) { }
    }

    @Test
    public void MethodPublic(){
        try {
            Stream<String> stream = Files.lines(Paths.get(fileName));
            List<String> line = stream.collect(Collectors.toList());
            String lineWithMethodCall = line.get(27);
            Assert.assertTrue("Метод printMainInfo должен иметь самый широкий уровень доступа(public).",
                    lineWithMethodCall.contains("public static void printMainInfo(Object object)"));
        } catch (IOException e) { }
    }

    @Test
    public void Neededobj() {
        boolean isdrawable = false;
        boolean ismovable = false;
        try {
            Stream<String> stream = Files.lines(Paths.get(fileName));
            List<String> collect = stream.collect(Collectors.toList());
            for (int i = 28; i < 35; i++) {
                if (collect.get(i).contains("if (object instanceof Drawable){") &
                        collect.get(i+1).contains("((Drawable) object).draw();")) {
                    isdrawable = true;
                    break;
                }
                if (collect.get(i).contains("if (object instanceof Movable){") &
                        collect.get(i+1).contains("((Movable) object).move();")) {
                    ismovable = true;
                    break;
                }
            }
            Assert.assertTrue(" Метод printMainInfo должен вызывать у переданного ему в качестве " +
                    "параметра объекта метод draw, если этот объект реализует интерфейс Drawable.", isdrawable);
            Assert.assertTrue("Метод printMainInfo должен вызывать у переданного ему в качестве " +
                    "параметра объекта метод move, если этот объект реализует интерфейс Movable.", ismovable);
        } catch (IOException e) { }
    }


}