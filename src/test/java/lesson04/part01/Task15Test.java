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
public class Task15Test {
    private static List<String> collect;

    static {
        String fileName = "./src/main/java/lesson04/part01/Task15.java";
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
    public void task15ifListCreated() {
        boolean isListCreated = false;
        for (String s : collect) {
            if (s.contains("ArrayList<Integer>") && s.contains("= new ArrayList"))
                isListCreated = true;
        }
        Assert.assertTrue("объяви переменную типа список Integer и сразу проинициализируй",
                isListCreated);
    }

    @Test
    public void task15ifForUsed() {
        boolean isForUsed = false;
        for (String s : collect) {
            if (s.contains("for (")) {
                isForUsed = true;
                break;
            }
        }
        Assert.assertTrue("Должен использоваться цикл for.", isForUsed);
    }

    @Test
    public void task15CorrectOutputTest() throws IOException {
        String input = "0\n1\n2\n3\n4\n5\n6\n7\n8\n9\n";
        String expected = "9\n8\n7\n6\n5\n4\n3\n2\n1\n0\n";
        SystemInGatewayUtil.provideInput(input);
        Task15.main(null);
        ByteArrayOutputStream stream = SystemOutGatewayUtil.getOutputArray();
        String result = stream.toString();
        Assert.assertEquals("выведи числа в обратном порядке",
                expected.trim(),result.trim());
        stream.reset();
    }
}