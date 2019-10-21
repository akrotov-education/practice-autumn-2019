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

public class Task34Test {
    private static String fileName = "./src/main/java/lesson02/part02/Task34.java";

    @Before
    public void setUp() throws Exception {
        SystemOutGatewayUtil.setCustomOut();
    }

    @After
    public void tearDown() throws Exception {
        SystemOutGatewayUtil.setOriginalOut();
    }

    @Test
    public void task34ifKeyboardInput() {
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
    public void task34ifPrintWasUsed() {
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
    public void task34ifResultIsGood() {
        Task34.main(null);
        ByteArrayOutputStream stream = SystemOutGatewayUtil.getOutputArray();
        String result = stream.toString();
        Assert.assertEquals("Программа должна вывести таблицу умножения 10 на 10",
                "1 2 3 4 5 6 7 8 9 10 \n" +
                        "2 4 6 8 10 12 14 16 18 20 \n" +
                        "3 6 9 12 15 18 21 24 27 30 \n" +
                        "4 8 12 16 20 24 28 32 36 40 \n" +
                        "5 10 15 20 25 30 35 40 45 50 \n" +
                        "6 12 18 24 30 36 42 48 54 60 \n" +
                        "7 14 21 28 35 42 49 56 63 70 \n" +
                        "8 16 24 32 40 48 56 64 72 80 \n" +
                        "9 18 27 36 45 54 63 72 81 90 \n" +
                        "10 20 30 40 50 60 70 80 90 100 \n", result);
        stream.reset();
    }

    @Test
    public void task34ifWhileUsed() {
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