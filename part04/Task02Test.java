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


public class Task02Test {
    public static String fileName = "./src/main/java/lesson05/part04/Task02.java";

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
            String lineWithMethodCall = line.get(36);
            Assert.assertTrue("Класс School должен наследоваться от класса Building",
                    lineWithMethodCall.contains("class School extends Building"));
        } catch (IOException e) {
        }
    }

    @Test
    public void Methodreturnschool(){
        boolean isMethodPrints = false;
        try {
            Stream<String> stream = Files.lines(Paths.get(fileName));
            List<String> collect = stream.collect(Collectors.toList());
            int index1 = collect.indexOf("    public static Building getSchool() {");
            int index2 = collect.indexOf("    }");
            for (int i = index1; i < index2; i++) {
                if (collect.get(i).contains("return school;")) {
                    isMethodPrints = true;
                    break;
                }
            }
            Assert.assertTrue("Метод getSchool должен возвращать новую школу(School)", isMethodPrints);
        } catch (IOException e) {
        }
    }

    @Test
    public void Methodreturnbuilding(){
        boolean isMethodPrints = false;
        try {
            Stream<String> stream = Files.lines(Paths.get(fileName));
            List<String> collect = stream.collect(Collectors.toList());
            int index1 = collect.indexOf("    public static Building getBuilding() {");
            int index2 = collect.indexOf("    }");
            for (int i = index1; i < index2; i++) {
                if (collect.get(i).contains("return school;")) {
                    isMethodPrints = true;
                    break;
                }
            }
            Assert.assertTrue("Метод getBuilding должен возвращать новое здание(Building)", isMethodPrints);
        } catch (IOException e) {
        }
    }

    @Test
    public void Schoolstatic(){
        try {
            Stream<String> stream = Files.lines(Paths.get(fileName));
            List<String> line = stream.collect(Collectors.toList());
            String lineWithMethodCall = line.get(36);
            Assert.assertTrue("Класс School должен быть статическим.",
                    lineWithMethodCall.contains("static class School"));
        } catch (IOException e) {
        }
    }

    @Test
    public void Buildingstatic(){
        try {
            Stream<String> stream = Files.lines(Paths.get(fileName));
            List<String> line = stream.collect(Collectors.toList());
            String lineWithMethodCall = line.get(26);
            Assert.assertTrue("Класс Building должен быть статическим.",
                    lineWithMethodCall.contains("public static Building"));
        } catch (IOException e) {
        }
    }

}