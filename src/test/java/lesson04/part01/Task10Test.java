package lesson04.part01;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import util.SystemInGatewayUtil;
import util.SystemOutGatewayUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.*;

public class Task10Test {
    private static List<String> collect;

    static {
        String fileName = "./src/main/java/lesson04/part01/Task10.java";
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            collect = stream.collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Before
    public void setUp() throws Exception {
        SystemOutGatewayUtil.setCustomOut();
    }

    @After
    public void tearDown() throws Exception {
        SystemOutGatewayUtil.setOriginalOut();
        SystemInGatewayUtil.setOriginalIn();
        SystemOutGatewayUtil.clearOutput();
    }
    @Test
    public void task10ifListCreated() {
        boolean isListCreated = false;
        for (String s : collect) {
            if (s.contains("ArrayList<String>") && s.contains("= new ArrayList"))
                isListCreated = true;
        }
        Assert.assertTrue("Объяви переменную типа ArrayList<String> (список строк) и сразу проинициализируй ee",
                isListCreated);
    }
    @Test
    public void task10KeyboardInputToList() {
        boolean isInputExist = false;
        for (String s : collect) {
            if (s.contains("(int i = 0; i < 5; i++)") && s.contains(".add(reader.readLine())")) {
                isInputExist = true;
                break;
            }
        }
        Assert.assertFalse("Программа должна считывать 5 строк с клавиатуры и добавлять их в список",isInputExist);
    }
    @Test
    public void task10ifThirdElementDeleted() {
        boolean isInputExist = false;
        for (String s : collect) {
            if (s.contains("list.remove(2);")) {
                isInputExist = true;
                break;
            }
        }
        Assert.assertTrue("Удали третий элемент списка.",isInputExist);
    }
    @Test
    public void task10OutChecker() {
        boolean isInputExist = true;
        for (String s : collect) {
            if (s.contains("int i = list.size() - 1; i >= 0; i--") && s.contains("System.out.println(list.get(i))")) {
                isInputExist = false;
                break;
            }
        }
        Assert.assertTrue("Выведи элементы на экран, каждый с новой строки.\n" +
                "Порядок вывода должен быть обратный.",isInputExist);
    }
}