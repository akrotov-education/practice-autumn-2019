package lesson02.part01;

import lesson01.part2.Task06;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import util.SystemOutGatewayUtil;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.*;

public class Task10Test {

    public static String fileName = "./src/main/java/lesson02/part1/Task10.java";

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
    public void IsMethod() {
        int is = 0;
        try {
            Stream<String> stream = Files.lines(Paths.get(fileName));
            List<String> collect = stream.collect(Collectors.toList());
            int ind = collect.indexOf("public class Task10 {");
            for (int i = ind; i < collect.size(); i++) {
                if (collect.get(i).contains("writeToConsole(String")) {
                    is ++;
                    break;
                }
            }
            Assert.assertEquals("Нужно добавить метод writeToConsole, у которого аргумент имеет тип String", 1, is);
        } catch (IOException e) {
        }
    }

    @Test
    public void IsMethodVoid() {
        int is = 0;
        try {
            Stream<String> stream = Files.lines(Paths.get(fileName));
            List<String> collect = stream.collect(Collectors.toList());
            int ind = collect.indexOf("public class Task10 {");
            for (int i = ind; i < collect.size(); i++) {
                if (collect.get(i).contains("void writeToConsole(String")) {
                    is ++;
                    break;
                }
            }
            Assert.assertEquals("Метод writeToConsole должен быть void", 1, is);
        } catch (IOException e) {
        }
    }

    @Test
    public void IsMethodStatic() {
        int is = 0;
        try {
            Stream<String> stream = Files.lines(Paths.get(fileName));
            List<String> collect = stream.collect(Collectors.toList());
            int ind = collect.indexOf("public class Task10 {");
            for (int i = ind; i < collect.size(); i++) {
                if (collect.get(i).contains("static void writeToConsole(String")) {
                    is ++;
                    break;
                }
            }
            Assert.assertEquals("Метод writeToConsole должен быть static", 1, is);
        } catch (IOException e) {
        }
    }

    @Test
    public void IsMethodPublic() {
        int is = 0;
        try {
            Stream<String> stream = Files.lines(Paths.get(fileName));
            List<String> collect = stream.collect(Collectors.toList());
            int ind = collect.indexOf("public class Task10 {");
            for (int i = ind; i < collect.size(); i++) {
                if (collect.get(i).contains("public static void writeToConsole(String")) {
                    is ++;
                    break;
                }
            }
            Assert.assertEquals("Метод writeToConsole должен быть public", 1, is);
        } catch (IOException e) {
        }
    }

    @Test
    public void IsTherePrinting() {
        int is = 0;
        try {
            Stream<String> stream = Files.lines(Paths.get(fileName));
            List<String> collect = stream.collect(Collectors.toList());
            int ind = collect.indexOf("public class Task10 {");
            for (int i = ind; i < collect.size(); i++) {
                if (collect.get(i).contains("System.out.print(\"printing: \"+s);")) {
                    is ++;
                    break;
                }
            }
            Assert.assertEquals("Метод writeToConsole должен добавлять к началу строки \"printing: \" и выводить полученный результат на экран.", 1, is);
        } catch (IOException e) {
        }
    }

    @Test
    public void EqualsRightResult(){
        Task10.main(null);
        ByteArrayOutputStream stream = SystemOutGatewayUtil.getOutputArray();
        String result = stream.toString();
        Assert.assertEquals("Программа должна выводить \"printing: Hello world!\"",
                result, "printing: Hello world!");
        stream.reset();
    }

}