package lesson02.part02;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import util.SystemInGatewayUtil;
import util.SystemOutGatewayUtil;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RunWith(JUnit4.class)

public class Task39Test {
    private static String fileName = "./src/main/java/lesson02/part02/Task39.java";

    @Before
    public void setUp() throws Exception {
        SystemOutGatewayUtil.setCustomOut();
    }

    @After
    public void tearDown() throws Exception {
        SystemOutGatewayUtil.setOriginalOut();
        SystemInGatewayUtil.setOriginalIn();
    }

    @Test
    public void task39ifKeyboardInput() {
        boolean isInputExist = false;
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            List<String> collect = stream.collect(Collectors.toList());
            for (String s : collect) {
                if (s.contains("nextInt()") || s.contains("nextLine()") || s.contains("readLine()")) {
                    isInputExist = true;
                    break;
                }
            }
            Assert.assertTrue("Программа не должна получать числа с клавиатуры",isInputExist);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void task39ifPrintWasUsed() {
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
    public void task39isResultGood() throws Exception {
        SystemInGatewayUtil.provideInput("Java\n");
        Task39.main(null);
        ByteArrayOutputStream stream = SystemOutGatewayUtil.getOutputArray();
        String result = stream.toString();
        Assert.assertEquals("Неправильный вывод",
                "Java любит меня.\n" +
                        "Java любит меня.\n" +
                        "Java любит меня.\n" +
                        "Java любит меня.\n" +
                        "Java любит меня.\n" +
                        "Java любит меня.\n" +
                        "Java любит меня.\n" +
                        "Java любит меня.\n" +
                        "Java любит меня.\n" +
                        "Java любит меня.\n",result);
        stream.reset();
    }

    @Test
    public void task39ifForUsed() {
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