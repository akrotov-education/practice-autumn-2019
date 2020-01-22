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

import static org.junit.Assert.*;

public class Task15Test {
    public static String fileName = "./src/main/java/lesson05/part04/Task15.java";

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
    public void Orca(){
        try {
            Stream<String> stream = Files.lines(Paths.get(fileName));
            List<String> line = stream.collect(Collectors.toList());
            String lineWithMethodCall = line.get(53);
            Assert.assertTrue("Косатка(Orca) является животным океана(потомком OceanAnimal) и умеет плавать(поддерживает интерфейс Swimmable)",
                    lineWithMethodCall.contains("class Orca extends OceanAnimal implements Swimmable{"));
        } catch (IOException e) { }
    }

    @Test
    public void Whale(){
        try {
            Stream<String> stream = Files.lines(Paths.get(fileName));
            List<String> line = stream.collect(Collectors.toList());
            String lineWithMethodCall = line.get(60);
            Assert.assertTrue("Кит(Whale) является животным океана(потомком OceanAnimal) и умеет плавать(поддерживает интерфейс Swimmable)",
                    lineWithMethodCall.contains("class Whale extends OceanAnimal implements Swimmable"));
        } catch (IOException e) { }
    }

    @Test
    public void Otter(){
        try {
            Stream<String> stream = Files.lines(Paths.get(fileName));
            List<String> line = stream.collect(Collectors.toList());
            String lineWithMethodCall = line.get(67);
            Assert.assertTrue("Выдра(Otter) умеет ходить(поддерживает интерфейс Walkable) и плавать(поддерживает интерфейс Swimmable)",
                    lineWithMethodCall.contains("class Otter implements Walkable, Swimmable{"));
        } catch (IOException e) { }
    }

    @Test
    public void Otterisnot(){
        try {
            Stream<String> stream = Files.lines(Paths.get(fileName));
            List<String> line = stream.collect(Collectors.toList());
            String lineWithMethodCall = line.get(67);
            Assert.assertFalse("Выдра(Otter) НЕ является животным океана(потомком OceanAnimal).",
                    lineWithMethodCall.contains("class Otter extends OceanAnimal"));
        } catch (IOException e) { }
    }

    @Test
    public void WhaleOrcaarenot(){
        try {
            Stream<String> stream = Files.lines(Paths.get(fileName));
            List<String> line = stream.collect(Collectors.toList());
            String lineWithMethodCall = line.get(53);
            Assert.assertFalse("Кит(Whale) НЕ умеет ходить(не поддерживают интерфейс Walkable).",
                    lineWithMethodCall.contains("implements Wolkable"));
            String lineWithMethodCall2 = line.get(60);
            Assert.assertFalse("Косатка(Orca) НЕ умеет ходить(не поддерживают интерфейс Walkable).",
                    lineWithMethodCall2.contains("implements Wolkable"));
        } catch (IOException e) { }
    }
}