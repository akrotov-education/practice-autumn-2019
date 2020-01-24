package part04.task10;

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

public class Task10Test {
    public static String fileName = "./src/main/java/lesson05/part04/task10/Task10.java";

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
                if (s.contains("readLine")) {
                    isInputExist = true;
                    break;
                }
            }
            Assert.assertFalse("Программа не должна считывать данные с клавиатуры",isInputExist);
        } catch (IOException e) {
        }
    }

    @Test
    public void CorrectInput() {
        try {
            Stream<String> stream = Files.lines(Paths.get(fileName));
            List<String> line = stream.collect(Collectors.toList());
            String lineWithMethodCall = line.get(49);
            Assert.assertTrue("Метод main должен прекращать считывать строки с клавиатуры, " +
                            "как только введенная строка не совпадает с одной из ожидаемых(user, loser, coder, proger).",
                    (lineWithMethodCall.contains("if (!strings.contains(key))")));
        } catch (IOException e) {
        }
    }

    @Test
    public void CorrectInputdowork() {
        try {
            Stream<String> stream = Files.lines(Paths.get(fileName));
            List<String> line = stream.collect(Collectors.toList());
            String lineWithMethodCall = line.get(58);
            Assert.assertTrue("Для каждой корректной(user, loser, coder, proger) введенной строки должен " +
                            "быть вызван метод doWork с соответствующим объектом класса Person в качестве параметра." +
                            "В классе Solution должен быть реализован метод doWork с одним параметром типа Person.",
                    (lineWithMethodCall.contains("doWork(person);")));
        } catch (IOException e) {
        }
    }

    @Test
    public void dowork() {
        try {
            Stream<String> stream = Files.lines(Paths.get(fileName));
            List<String> line = stream.collect(Collectors.toList());
            int i = 63;
            Assert.assertTrue("Метод doWork должен вызывать метод live() у переданного объекта, если этот объект имеет тип User.",
                    (line.get(i).contains("if (person instanceof Person.User)"))&
                            (line.get(i+1).contains("((Person.User) person).live();")));
            i = 65;
            Assert.assertTrue("Метод doWork должен вызывать метод doNothing() у переданного объекта, если этот объект имеет тип Loser.",
                    (line.get(i).contains("if (person instanceof Person.Loser)"))&
                            (line.get(i+1).contains(" ((Person.Loser) person).doNothing();")));
            i = 67;
            Assert.assertTrue("Метод doWork должен вызывать метод enjoy() у переданного объекта, если этот объект имеет тип Proger.",
                    (line.get(i).contains("if (person instanceof Person.Proger)"))&
                            (line.get(i+1).contains(" ((Person.Proger) person).enjoy();")));
            i = 69;
            Assert.assertTrue("Метод doWork должен вызывать метод writeCode() у переданного объекта, если этот объект имеет тип Coder.",
                    (line.get(i).contains("if (person instanceof Person.Coder)"))&
                            (line.get(i+1).contains(" ((Person.Coder) person).writeCode();")));
        } catch (IOException e) {
        }
    }

}