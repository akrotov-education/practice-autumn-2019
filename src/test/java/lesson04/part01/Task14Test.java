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
public class Task14Test {
    private static List<String> collect;

    static {
        String fileName = "./src/main/java/lesson04/part01/Task14.java";
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
    public void task14ifKeyboardInput() {
        boolean isInputExist = false;
        for (String s : collect) {
            if (s.contains("nextInt()") || s.contains("nextLine()") || s.contains("readLine()")) {
                isInputExist = true;
                break;
            }
        }
        Assert.assertTrue("Программа не должна получать числа с клавиатуры",isInputExist);
    }

    @Test
    public void task14ifListCreated() {
        boolean isListCreated = false;
        for (String s : collect) {
            if (s.contains("ArrayList<String>") && s.contains("= new ArrayList"))
                isListCreated = true;
        }
        Assert.assertTrue("объяви переменную типа список строк и сразу проинициализируй",
                isListCreated);
    }

    @Test
    public void task14doubleValuesWorks() {
        ArrayList<String> test = new ArrayList<>(Arrays.asList("тест","уйди"));
        test = Task14.doubleValues(test);
        Assert.assertTrue("метод должен выводить строку дважды",
                test.get(0) == test.get(1) && test.get(2) == test.get(3));
    }

    @Test
    public void task14isOutputCorrect() throws Exception {
        String input = "a\na\na\na\na\na\na\na\na\na\n";
        String expected = input + input;
        SystemInGatewayUtil.provideInput(input);
        Task14.main(null);
        ByteArrayOutputStream stream = SystemOutGatewayUtil.getOutputArray();
        String result = stream.toString();
        Assert.assertEquals("выведи получившийся список на экран, каждый элемент с новой строки",
                expected,result);
        stream.reset();
    }
}