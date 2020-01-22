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


public class Task06Test {
    public static String fileName = "./src/main/java/lesson05/part04/Task06.java";

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
            String lineWithMethodCall = line.get(47);
            Assert.assertTrue("Класс Player должен реализовывать интерфейс Person.",
                    lineWithMethodCall.contains("class Player implements Person"));
        } catch (IOException e) { }
    }

    @Test
    public void MethodImplements2(){
        try {
            Stream<String> stream = Files.lines(Paths.get(fileName));
            List<String> line = stream.collect(Collectors.toList());
            String lineWithMethodCall = line.get(53);
            Assert.assertTrue("Класс Dancer должен реализовывать интерфейс Person.",
                    lineWithMethodCall.contains("class Dancer implements Person"));
        } catch (IOException e) { }
    }

    @Test
    public void Neededobj() {
        boolean isdancer = false;
        boolean isplayer = false;
        try {
            Stream<String> stream = Files.lines(Paths.get(fileName));
            List<String> collect = stream.collect(Collectors.toList());
            for (int i = 28; i < 35; i++) {
                if (collect.get(i).contains("if (\"player\".equals(key)) {") &
                        collect.get(i+1).contains("person = new Player();")) {
                    isplayer = true;
                    break;
                }
                if (collect.get(i).contains("if (\"dancer\".equals(key))") &
                        collect.get(i+1).contains("person = new Dancer();")) {
                    isdancer = true;
                    break;
                }
            }
            Assert.assertTrue("Метод haveFun должен вызывать метод play, если переданный ему объект является игроком(Player).", isplayer);
            Assert.assertTrue("Метод haveFun должен вызывать метод dance, если переданный ему объект является танцором(Dancer).", isdancer);
        } catch (IOException e) { }
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
            Assert.assertFalse("Программа не должна считывать данные с клавиатуры",isInputExist);
        } catch (IOException e) {
        }
    }

    @Test
    public void stopinput() {
        boolean is = false;
        try {
            Stream<String> stream = Files.lines(Paths.get(fileName));
            List<String> collect = stream.collect(Collectors.toList());
            for (int i = 25; i < 35; i++) {
                if (collect.get(i).contains("while (!(key = reader.readLine()).equals(\"exit\")) {")) {
                    is = true;
                    break;
                }
            }
            Assert.assertFalse("Метод main должен прекращать считывать данные с клавиатуры, если введенная строка равна \"exit\".", is);
        } catch (IOException e) {
        }
    }
}