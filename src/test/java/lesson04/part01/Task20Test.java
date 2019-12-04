package lesson04.part01;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import util.SystemInGatewayUtil;
import util.SystemOutGatewayUtil;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RunWith(JUnit4.class)
public class Task20Test {
    private static int mainBeginIndex = 0;
    private static int mainEndIndex = 0;
    private static List<String> collect;

    static {
        String fileName = "./src/main/java/lesson04/part01/Task20.java";
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            collect = stream.collect(Collectors.toList());
            for (String s : collect) {
                if (s.contains("public static void main")) {
                    mainBeginIndex = collect.indexOf(s);
                }
            }
            for (int i = mainBeginIndex; i < collect.size(); i++) {
                if (collect.get(i).contains("public static void sort"))
                    mainEndIndex = i;
            }
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
    public void task20isMethodExists() {
        String methods = Arrays.toString(Task20.class.getMethods());
        boolean isMethodExists = methods.contains("public static void lesson04.part01.Task20.sort(int[])");
        Assert.assertTrue("в классе должен быть метод сортировки", isMethodExists);
    }

    @Test
    public void task20MainCalledSort() {
        boolean isSortCalled = false;
        for (int i = Task20Test.mainBeginIndex; i < Task20Test.mainEndIndex; i++) {
            if (collect.get(i).contains("sort(array)"))
                isSortCalled = true;
        }
        Assert.assertTrue("метод main должен вызывать сортировку", isSortCalled);
    }

    @Test
    public void task20SortWorksCorrectly() {
        int[] test = {1,2,3};
        String testStr = "";
        int[] expected = {3,2,1};
        String expectedStr = "";
        Task20.sort(test);
        testStr = Arrays.toString(test);
        expectedStr = Arrays.toString(expected);
        Assert.assertEquals("метод sort должен сортировать массив по убыванию",expectedStr,testStr);
    }

    @Test
    public void task20InputContains20Integers() throws Exception {
        String input = "0\n1\n2\n3\n4\n5\n6\n7\n8\n9\n0\n1\n2\n3\n4\n5\n6\n7\n8\n9\n";
        SystemInGatewayUtil.provideInput(input);
        Task20.main(null);
        ByteArrayOutputStream stream = SystemOutGatewayUtil.getOutputArray();
        String result = stream.toString();
        String[] results = result.split("\r\n");
        Assert.assertEquals("программа должна выводить 20 чисел",20,results.length);
        stream.reset();
    }
}