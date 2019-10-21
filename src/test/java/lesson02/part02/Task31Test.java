package lesson02.part02;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import util.SystemOutGatewayUtil;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RunWith(JUnit4.class)

public class Task31Test {
    private static String fileName = "./src/main/java/lesson02/part02/Task31.java";

    @Before
    public void setUp() throws Exception {
        SystemOutGatewayUtil.setCustomOut();
    }

    @After
    public void tearDown() throws Exception {
        SystemOutGatewayUtil.setOriginalOut();
    }

    @Test
    public void task31ifKeyboardInput() {
        boolean isInputExist = false;
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            List<String> collect = stream.collect(Collectors.toList());
            for (String s : collect) {
                if (s.contains("nextInt()") || s.contains("nextLine()") || s.contains("readLine()")) {
                    isInputExist = true;
                    break;
                }
            }
            Assert.assertFalse("Программа не должна получать числа с клавиатуры",isInputExist);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void task31ifPrintWasUsed() {
        boolean isPrintUsed = false;
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            List<String> collect = stream.collect(Collectors.toList());
            for (String s : collect) {
                if (s.contains("System.out.println") || s.contains("System.out.print")) {
                    isPrintUsed = true;
                    break;
                }
            }
            Assert.assertTrue("Программа должна содержать консольный вывод.",
                    isPrintUsed);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void task31ifEachValueFromNewLine() {
        boolean isFromNewLine = false;
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            List<String> collect = stream.collect(Collectors.toList());
            for (int i = 0; i < collect.size(); i++) {
                if (collect.get(i).contains("while") && collect.get(i+1).contains("println")) {
                    isFromNewLine = true;
                    break;
                }
            }
            Assert.assertTrue("Программа должна выводить каждое значение с новой строки.",
                    isFromNewLine);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void task31if0to10NumsWerePrinted() {
        Task31.main(null);
        ByteArrayOutputStream stream = SystemOutGatewayUtil.getOutputArray();
        String result = stream.toString();
        Assert.assertEquals("Программа должна выводить числа от 1 до 10.",
                "10\n9\n8\n7\n6\n5\n4\n3\n2\n1\n", result);
        stream.reset();
    }

    @Test
    public void task31ifWhileUsed() {
        boolean isWhileUsed = false;
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            List<String> collect = stream.collect(Collectors.toList());
            for (String s : collect) {
                if (s.contains("while (")) {
                    isWhileUsed = true;
                    break;
                }
            }
            Assert.assertTrue("Должен использоваться цикл while.",
                    isWhileUsed);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}