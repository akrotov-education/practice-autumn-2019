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

public class Task03Test {
    public static String fileName = "./src/main/java/lesson05/part04/Task03.java";

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
    public void ifKeyboardInput() {
        boolean isInputExist = false;
        try {
            Stream<String> stream = Files.lines(Paths.get(fileName));
            List<String> collect = stream.collect(Collectors.toList());
            for (String s : collect) {
                if (s.contains("Scanner")) {
                    isInputExist = true;
                    break;
                }
            }
            Assert.assertTrue("Программа не должна получать числа с клавиатуры", isInputExist);
        } catch (IOException e) { }
    }

    @Test
    public void Breakwhennull(){
        try {
            Stream<String> stream = Files.lines(Paths.get(fileName));
            List<String> line = stream.collect(Collectors.toList());
            String lineWithMethodCall = line.get(30);
            Assert.assertTrue("Программа должна прекращать считывать данные после ввода пустой строки",
                    lineWithMethodCall.contains("if (s.isEmpty()) break;"));
        } catch (IOException e) { }
    }

    @Test
    public void print(){
        try {
            Stream<String> stream = Files.lines(Paths.get(fileName));
            List<String> line = stream.collect(Collectors.toList());
            String lineWithMethodCall = line.get(31);
            Assert.assertTrue("Программа должна выводить на экран описание каждого кота (cat.toString).",
                    lineWithMethodCall.contains("System.out.println(Task03.CatFactory.getCatByKey(s).toString());"));
        } catch (IOException e) { }
    }

    @Test
    public void Catobj() {
        boolean isMethodPrints = false;
        try {
            Stream<String> stream = Files.lines(Paths.get(fileName));
            List<String> collect = stream.collect(Collectors.toList());
            for (int i = 35; i < 50; i++) {
                if (collect.get(i).contains("new MaleCat") &
                        collect.get(i).contains("new FemaleCat") &
                        collect.get(i).contains("new Cat")) {
                    isMethodPrints = true;
                    break;
                }
            }
            Assert.assertFalse("Программа должна создавать объект класса Cat для каждого введенного имени " +
                    "кота(строки считанной с клавиатуры) c помощью метода getCatByKey", isMethodPrints);
        } catch (IOException e) { }
    }
}