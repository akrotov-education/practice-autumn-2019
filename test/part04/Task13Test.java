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


public class Task13Test {
    public static String fileName = "./src/main/java/lesson05/part04/task13.java";

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
            Stream<String> stream = Files.lines(Paths.get(fileName));
            List<String> line = stream.collect(Collectors.toList());
            String lineWithMethodCall = line.get(70);
            String lineWithMethodCall2 = line.get(72);
            Assert.assertTrue("Классы Cartoon и Thriller должны быть статическими и существовать внутри класса Solution.",
                    lineWithMethodCall.contains("static class Cartoon extends Movie") &
                            (lineWithMethodCall2.contains("static class Thriller extends Movie {")));
        } catch (IOException e) {
        }
    }

    @Test
    public void cartoon(){
        try {
            Stream<String> stream = Files.lines(Paths.get(fileName));
            List<String> line = stream.collect(Collectors.toList());
            String lineWithMethodCall = line.get(55);
            String lineWithMethodCall2 = line.get(56);
            Assert.assertTrue("Метод MovieFactory.getMovie должен возвращать объект типа Cartoon в случае передачи ему строки \"cartoon\" в качестве параметра.",
                    lineWithMethodCall.contains(" if (\"cartoon\".equals(key)) {") &
                            (lineWithMethodCall2.contains(" movie = new Cartoon();")));
        } catch (IOException e) {
        }
    }

    @Test
    public void thriller(){
        try {
            Stream<String> stream = Files.lines(Paths.get(fileName));
            List<String> line = stream.collect(Collectors.toList());
            String lineWithMethodCall = line.get(58);
            String lineWithMethodCall2 = line.get(59);
            Assert.assertTrue("Метод MovieFactory.getMovie должен возвращать объект типа Thriller в случае передачи ему строки \"thriller\" в качестве параметра.",
                    lineWithMethodCall.contains(" if (\"thriller\".equals(key)) {") &
                            (lineWithMethodCall2.contains("movie = new Thriller();")));
        } catch (IOException e) {
        }
    }

    @Test
    public void IsInput() {
        boolean is = false;
        try {
            Stream<String> stream = Files.lines(Paths.get(fileName));
            List<String> collect = stream.collect(Collectors.toList());
            for (int i = 0; i < 47; i++) {
                if (collect.get(i).contains("readLine")) {
                    is = true;
                    break;
                }
            }
            Assert.assertTrue("Метод main должен считывать строки с клавиатуры.", is);
        } catch (IOException e) {
        }
    }

    @Test
    public void notrightinput(){
        try {
            Stream<String> stream = Files.lines(Paths.get(fileName));
            List<String> line = stream.collect(Collectors.toList());
            String lineWithMethodCall = line.get(39);
            String lineWithMethodCall2 = line.get(40);
            Assert.assertTrue("Метод main должен прекращать считывать строки с клавиатуры в случае, если " +
                            "была введена некорректная строка(не \"cartoon\", не \"thriller\" или не \"soapOpera\")." +
                            "Для каждой введенной строки (в том числе для некорректной) необходимо вызвать метод MovieFactory.getMovie.",
                    lineWithMethodCall.contains("if (s.equals(\"soapOpera\") || s.equals(\"cartoon\") || s.equals(\"thriller\")) {") &
                            (lineWithMethodCall2.contains(" movie = MovieFactory.getMovie(s);")));
        } catch (IOException e) {
        }
    }

    @Test
    public void printnames(){
        try {
            Stream<String> stream = Files.lines(Paths.get(fileName));
            List<String> line = stream.collect(Collectors.toList());
            String lineWithMethodCall = line.get(42);
            Assert.assertTrue("Для всех введенных корректных строк необходимо вывести на экран простые имена(movie.getClass().getSimpleName()) " +
                            "типов объектов возвращаемых методом MovieFactory.getMovie.",
                    lineWithMethodCall.contains(" System.out.println(movie.getClass().getSimpleName());"));
        } catch (IOException e) {
        }
    }

}