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

public class Task37Test {
    private static String fileName = "./src/main/java/lesson02/part02/Task37.java";

    @Before
    public void setUp() throws Exception {
        SystemOutGatewayUtil.setCustomOut();
    }

    @After
    public void tearDown() throws Exception {
        SystemOutGatewayUtil.setOriginalOut();
    }

    @Test
    public void task37ifKeyboardInput() {
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
    public void task37ifPrintWasUsed() {
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
    public void task37isResultGood() {
        Task37.main(null);
        ByteArrayOutputStream stream = SystemOutGatewayUtil.getOutputArray();
        String result = stream.toString();
        Assert.assertEquals("Неправильный вывод",
                "8\n" +
                        "88\n" +
                        "888\n" +
                        "8888\n" +
                        "88888\n" +
                        "888888\n" +
                        "8888888\n" +
                        "88888888\n" +
                        "888888888\n" +
                        "8888888888\n",result);
        stream.reset();
    }

    @Test
    public void task37ifForUsed() {
        boolean isForUsed = false;
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            List<String> collect = stream.collect(Collectors.toList());
            for (String s : collect) {
                if (s.contains("for (")) {
                    isForUsed = true;
                    break;
                }
            }
            Assert.assertTrue("Должен использоваться цикл for.",
                    isForUsed);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}