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
public class Task19Test {
    private static int cycleBeginIndex = 0;
    private static int cycleEndIndex = 0;
    private static List<String> collect;
    /*
    Получаем индексы начала и конца цикла, в котором идет сортировка чисел по спискам
     */
    static {
        String fileName = "./src/main/java/lesson04/part01/Task19.java";
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
    public void task19ifKeyboardInput() {
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
    public void task19NumbersWerePrinted() {
        boolean isNumbersPrinted = false;
        for (int i = Task19Test.cycleBeginIndex; i < Task19Test.cycleEndIndex; i++) {
            if (collect.get(i).contains("System.out.println(i)"))
                isNumbersPrinted = true;
        }
        Assert.assertTrue("должен быть обратный отсчёт от 30 до 0", isNumbersPrinted);
    }

    @Test
    public void task19BoomWasPrinted() throws InterruptedException {
        Task19.main(null);
        ByteArrayOutputStream stream = SystemOutGatewayUtil.getOutputArray();
        String result = stream.toString();
        String endofInput = result.substring(result.lastIndexOf("0") + 1);
        Assert.assertEquals("должно выводиться Бум! в конце отсчета", "Бум!", endofInput.trim());
        stream.reset();
    }

    @Test
    public void task19SleepWasCalled31Times() {
        int sleepMethodCallsCount = 0;
        for (String s : collect)
            if (s.equals("      Thread.sleep(100);"))
                sleepMethodCallsCount++;
        Assert.assertEquals("метод sleep должен быть использован 31 раз",
                1, sleepMethodCallsCount);
    }
}