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
public class Task16Test {
    private static List<String> collect;

    static {
        String fileName = "./src/main/java/lesson04/part01/Task16.java";
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
    public void task16ifListCreated() {
        boolean isListCreated = false;
        for (String s : collect) {
            if (s.contains("ArrayList<String>") && s.contains("= new ArrayList"))
                isListCreated = true;
        }
        Assert.assertTrue("объяви переменную типа список Integer и сразу проинициализируй",
                isListCreated);
    }

    @Test
    public void task16ifMNWasRead() throws IOException {
        String input = "2\r\n1\r\nодин\r\nдва\r\n";
        String expected = "два\r\nодин\r\n";
        SystemInGatewayUtil.provideInput(input);
        Task16.main(null);
        ByteArrayOutputStream stream = SystemOutGatewayUtil.getOutputArray();
        String result = stream.toString();
        Assert.assertEquals("программа должна считать N и M, затем считать N строк",
                expected.trim(),result.trim());
        stream.reset();
    }

    @Test
    public void task16ifListMadeCorrectly() throws IOException {
        String input = "2\r\n1\r\nодин\r\nдва\r\n";
        String expected = "два\r\nодин\r\n";
        SystemInGatewayUtil.provideInput(input);
        Task16.main(null);
        ByteArrayOutputStream stream = SystemOutGatewayUtil.getOutputArray();
        String result = stream.toString();
        Assert.assertEquals("программа должна переставить M первых строк в конец списка",
                expected.trim(),result.trim());
        stream.reset();
    }

    @Test
    public void task16ifOutputIsCorrect() throws IOException {
        String input = "2\r\n1\r\nодин\r\nдва\r\n";
        String expected = "два\r\nодин\r\n";
        SystemInGatewayUtil.provideInput(input);
        Task16.main(null);
        ByteArrayOutputStream stream = SystemOutGatewayUtil.getOutputArray();
        String result = stream.toString();
        Assert.assertEquals("выведи список на экран, каждое значение с новой строки",
                expected,result);
        stream.reset();
    }
}