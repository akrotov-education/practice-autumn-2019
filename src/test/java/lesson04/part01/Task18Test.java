package lesson04.part01;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import util.SystemInGatewayUtil;
import util.SystemOutGatewayUtil;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RunWith(JUnit4.class)
public class Task18Test {
    private static List<String> collect;

    static {
        String fileName = "./src/main/java/lesson04/part01/Task18.java";
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
    public void task18ifListCreated() {
        boolean isListCreated = false;
        for (String s : collect) {
            if (s.contains("ArrayList<String>") && s.contains("= new ArrayList"))
                isListCreated = true;
        }
        Assert.assertTrue("объяви переменную типа список Integer и сразу проинициализируй",
                isListCreated);
    }

    @Test
    public void task18ifInputCorrect() throws IOException {
        String input = "a\r\nb\r\nc\r\nend\r\n";
        String expected = "a\r\nb\r\nc\r\n";
        SystemInGatewayUtil.provideInput(input);
        Task18.main(null);
        ByteArrayOutputStream stream = SystemOutGatewayUtil.getOutputArray();
        String result = stream.toString();
        Assert.assertEquals("программа должна добавить введенные строки в список и вывести с новой строки каждую",
                expected,result);
        stream.reset();
    }

    @Test
    public void task18isEndCounted() throws IOException {
        String input = "a\nb\nc\nend\n";
        SystemInGatewayUtil.provideInput(input);
        Task18.main(null);
        ByteArrayOutputStream stream = SystemOutGatewayUtil.getOutputArray();
        String result = stream.toString();
        Assert.assertFalse("строка end не должна быть в списке",
                result.contains("end"));
    }

    @Test
    public void task18ifForUsed() {
        boolean isForUsed = false;
        for (String s : collect) {
            if (s.contains("for (")) {
                isForUsed = true;
                break;
            }
        }
        Assert.assertTrue("Должен использоваться цикл for.", isForUsed);
    }
}