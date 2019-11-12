package lesson01.part2;

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
    public static String fileName = "./src/main/java/lesson01/part2/Task15.java";

    @Before
    public void before() {
        SystemOutGatewayUtil.setCustomOut();
    }

    @After
    public void after() {
        SystemOutGatewayUtil.setOriginalOut();
    }

    @Test
    public void ObjectMan() {
        int man = 0;
        try {
            Stream<String> stream = Files.lines(Paths.get(fileName));
            List<String> collect = stream.collect(Collectors.toList());
            int index = collect.indexOf("    public static void main(String[] args) {");
            int index2 = collect.indexOf("    }");
            for (int i = index; i < index2; i++) {
                if (collect.get(i).contains("man") & collect.get(i).contains("= new Man")) {
                    man++;
                }
            }
            Assert.assertEquals("В методе main надо создать объект типа Man и занести ссылку в переменную", 1, man);
        } catch (IOException e) {
        }
    }

    @Test
    public void ObjectWoman() {
        int man = 0;
        try {
            Stream<String> stream = Files.lines(Paths.get(fileName));
            List<String> collect = stream.collect(Collectors.toList());
            int index = collect.indexOf("    public static void main(String[] args) {");
            int index2 = collect.indexOf("    }");
            for (int i = index; i < index2; i++) {
                if (collect.get(i).contains("woman") & collect.get(i).contains("= new Woman")) {
                    man++;
                }
            }
            Assert.assertEquals("В методе main надо создать объект типа Woman и занести ссылку в переменную", 1, man);
        } catch (IOException e) {
        }
    }

    @Test
    public void ObjectManWife() {
        int man = 0;
        try {
            Stream<String> stream = Files.lines(Paths.get(fileName));
            List<String> collect = stream.collect(Collectors.toList());
            int index = collect.indexOf("    public static void main(String[] args) {");
            int index2 = collect.indexOf("    }");
            for (int i = index; i < index2; i++) {
                if (collect.get(i).contains("woman") & collect.get(i).contains("man.wife")) {
                    man++;
                }
            }
            Assert.assertEquals("В методе main сохранить ссылку на ранее созданный объект Woman в man.wife", 1, man);
        } catch (IOException e) {
        }
    }

    @Test
    public void ObjectWomanHusb() {
        int man = 0;
        try {
            Stream<String> stream = Files.lines(Paths.get(fileName));
            List<String> collect = stream.collect(Collectors.toList());
            int index = collect.indexOf("    public static void main(String[] args) {");
            int index2 = collect.indexOf("    }");
            for (int i = index; i < index2; i++) {
                if (collect.get(i).contains("man") & collect.get(i).contains("woman.husband")) {
                    man++;
                }
            }
            Assert.assertEquals("В методе main сохранить ссылку на ранее созданный объект Man в woman.husband", 1, man);
        } catch (IOException e) {
        }
    }

    @Test
    public void ManThreeVar() {
        boolean is = true;
        try {
            Stream<String> stream = Files.lines(Paths.get(fileName));
            List<String> collect = stream.collect(Collectors.toList());
            int ind = collect.indexOf("    public static class Man {");
            if ((collect.get(ind + 1).contains("public")) &
                    (collect.get(ind + 2).contains("public")) &
                    (collect.get(ind + 3).contains("public")) &
                    (collect.get(ind + 4).contains("}"))) {
                is = false;
                Assert.assertEquals("Класс Man должен содержать 3 переменные", false, is);
            }
        }
        catch(IOException e){
        }
    }

    @Test
    public void WomanThreeVar() {
        boolean is = true;
        try {
            Stream<String> stream = Files.lines(Paths.get(fileName));
            List<String> collect = stream.collect(Collectors.toList());
            int ind = collect.indexOf("    public static class Woman {");
            if ((collect.get(ind + 1).contains("public")) &
                    (collect.get(ind + 2).contains("public")) &
                    (collect.get(ind + 3).contains("public")) &
                    (collect.get(ind + 4).contains("}"))) {
                is = false;
                Assert.assertEquals("Класс Woman должен содержать 3 переменные", false, is);
            }
        }
        catch(IOException e){
        }
    }
}