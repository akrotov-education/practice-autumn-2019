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

public class Task07Test {
    private static List<String> collect;

    static {
        String fileName = "./src/main/java/lesson04/part01/Task07.java";
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
    public void task07ifListCreated() {
        boolean isListCreated = false;
        for (String s : collect) {
            if (s.contains("strings = new ArrayList<>()"))
                isListCreated = true;
        }
        Assert.assertTrue("В методе main инициализируй существующее поле strings новым ArrayList<>",
                isListCreated);
    }
    @Test
    public void task07KeyboardInputToList() {
        boolean isInputExist = false;
        for (String s : collect) {
            if ((s.contains("(int i = 0; i < 5; i++)"))
                    || (s.contains("strings.add(reader.readLine())"))) {
                isInputExist = true;
                break;
            }
        }
        Assert.assertTrue("Программа должна считывать 5 строк с клавиатуры и записывать их в поле strings.",isInputExist);
    }
    @Test
    public void task07OutLongestString() {
        boolean isInputExist = false;
        for (String s : collect) {
            if ((s.contains("if (str.length() != maxLen)")) || (s.contains("System.out.println(str)"))) {
                isInputExist = true;
                break;
            }
        }
        Assert.assertTrue("Программа должна выводить самую длинную строку на экран.\n" +
                "Если есть несколько строк с длиной равной максимальной, то нужно вывести каждую из них с новой строки.",isInputExist);
    }
}