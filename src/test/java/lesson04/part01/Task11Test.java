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
public class Task11Test {
    private static int cycleBeginIndex = 0;
    private static int cycleEndIndex = 0;
    private static List<String> collect;
    /*
    Получаем индексы начала и конца цикла, в котором идет сортировка чисел по спискам
    */
    static {
        String fileName = "./src/main/java/lesson04/part01/Task11.java";
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            collect = stream.collect(Collectors.toList());
            for (String s : collect) {
                if (s.contains("for (int i = 0")) {
                    cycleBeginIndex = collect.indexOf(s);
                }
            }
            for (int i = cycleBeginIndex; i < collect.size(); i++) {
                if (collect.get(i).contains("}"))
                    cycleEndIndex = i;
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
    public void task11If4ListsCreated() {
        int listCount = 0;
        for (String s : collect) {
            if (s.contains("ArrayList<Integer>") && s.contains("new ArrayList"))
                listCount++;
        }
        Assert.assertEquals("Объяви и сразу проинициализируй 4 переменных типа ArrayList<Integer>",
                4,listCount);

    }

    @Test
    public void task11If20IntegersRead() {
        boolean is20TimesCycleUsed = false;
        boolean isLoop = false;

        for (int i = 0; i < collect.size(); i++) {
            if (collect.get(i).contains("for (int i = 0; i < 20; i++)")) {
                isLoop = true;
            }

            if (isLoop && collect.get(i).contains("listMain.add(Integer.parseInt(reader.readLine()));")) {
                is20TimesCycleUsed = true;
            }
        }

        Assert.assertTrue("нужно добавить 20 чисел в лист", is20TimesCycleUsed);

    }

    @Test
    public void task11IfDiv3IntegersAdded() {
        boolean isDiv3IntegersAdded = false;
        for (int i = 0; i < collect.size(); i++) {
            if (collect.get(i).contains("% 3 == 0") && (collect.get(i).contains(".add") || collect.get(i + 1).contains(".add")))
                isDiv3IntegersAdded = true;
        }
        Assert.assertTrue("нужно добавить делящиеся на 3 числа в список",isDiv3IntegersAdded);
    }

    @Test
    public void task11IfDiv2IntegersAdded() {
        boolean isDiv2IntegersAdded = false;
        for (int i = 0; i < collect.size(); i++) {
            if (collect.get(i).contains("% 2 == 0") && (collect.get(i).contains("add") || collect.get(i+1).contains("add")))
                isDiv2IntegersAdded = true;
        }
        Assert.assertTrue("нужно добавить делящиеся на 2 числа в список",isDiv2IntegersAdded);
    }

    @Test
    public void task11IfOtherIntegersAdded() {
        boolean isOtherIntegersAdded = false;
        for (int i = 0; i < collect.size(); i++) {
            if ((collect.get(i).contains("% 2 != 0") && collect.get(i).contains("% 3 != 0"))
                    && (collect.get(i).contains("add") || collect.get(i+1).contains("add")))
                isOtherIntegersAdded = true;
        }
        Assert.assertTrue("нужно добавить оставшиеся числа в список",isOtherIntegersAdded);
    }

    @Test
    public void task11ifPrintListCalled3Times() {
        int printListCalls = 0;
        for (String s : collect)
            if (s.contains("printList(") && !s.contains("tic void printLis"))
                printListCalls++;
        Assert.assertEquals("метод вывода списков должен быть вызван трижды",3,printListCalls);
    }

    @Test
    public void task11ifPrintListPrintsCorrectly() {
        ArrayList<Integer> test = new ArrayList<>(Arrays.asList(4,5,6));
        Task11.printList(test);
        ByteArrayOutputStream stream = SystemOutGatewayUtil.getOutputArray();
        String result = stream.toString();
        Assert.assertEquals("метод printList должен выводить числа каждое с новой строки",
                "4\n5\n6\n",result);
        stream.reset();
    }
}