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

public class Task09Test {
    private static List<String> collect;

    static {
        String fileName = "./src/main/java/lesson04/part01/Task09.java";
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
    public void task09ifListCreated() {
        boolean isListCreated = false;
        for (String s : collect) {
            if (s.contains("ArrayList<String>") && s.contains("= new ArrayList"))
                isListCreated = true;
        }
        Assert.assertTrue("Объяви переменную типа список строк и сразу проинициализируй ee.",
                isListCreated);
    }
    @Test
    public void task09KeyboardInputToList() {
        boolean isInputExist = true;
        for (String s : collect) {
            if (s.contains("(int i = 0; i < 5; i++)") || s.contains(".add(reader.readLine())")) {
                isInputExist = true;
                break;
            }
        }
        Assert.assertTrue("Программа должна считывать 5 строк с клавиатуры и добавлять их в список",isInputExist);
    }
    @Test
    public void task09Require3AndOut() {
        boolean isInputExist = false;
        for (String s : collect) {
            if (s.contains("int n = 0; n < 13; n++") || s.contains("strings.get(4);")
            && s.contains(".remove(4);") && s.contains(".add(0,")
                    && s.contains("System.out.println") && s.contains(".get(i)")) {
                isInputExist = true;
                break;
            }
        }
        Assert.assertTrue("Удали последнюю строку и вставь её в начало. Повторить 13 раз.\n" +
                "Программа должна выводить список на экран, каждое значение с новой строки.",isInputExist);
    }
}