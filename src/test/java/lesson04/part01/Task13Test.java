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
public class Task13Test {
    private static List<String> collect;

    static {
        String fileName = "./src/main/java/lesson04/part01/Task13.java";
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
    public void task13ifKeyboardInput() {
        boolean isInputExist = false;
        for (String s : collect) {
            if (s.contains("nextInt()") || s.contains("nextLine()") || s.contains("readLine()")) {
                isInputExist = true;
                break;
            }
        }
        Assert.assertFalse("Программа не должна получать числа с клавиатуры",isInputExist);
    }

    @Test
    public void task13FixRemoves() {
        ArrayList<String> test = new ArrayList<>(Arrays.asList("рама","рожа","ралли"));
        Task13.fix(test);
        Assert.assertEquals("fix должен удалять слова с р и не удалять слова с р и л",
                1,test.size());
    }

    @Test
    public void task13FixDoubles() {
        ArrayList<String> test = new ArrayList<>(Arrays.asList("лама","ралли"));
        Task13.fix(test);
        Assert.assertEquals("fix должен удваивать слова с л и не удваивать слова с р и л",
                3,test.size());
    }

    @Test
    public void task13FixDoNothing() {
        ArrayList<String> test = new ArrayList<>(Arrays.asList("роль","ралли"));
        Task13.fix(test);
        Assert.assertEquals("fix не должен что-то делать со словами с р и л",
                2,test.size());
    }

    @Test
    public void task13FixDoNothingWithOtherWords() {
        ArrayList<String> test = new ArrayList<>(Arrays.asList("тест","уйди"));
        Task13.fix(test);
        Assert.assertEquals("fix не должен делать что-то со словами без р и л",
                2,test.size());
    }
}