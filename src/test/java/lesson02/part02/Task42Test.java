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

public class Task42Test {
    private static String fileName = "./src/main/java/lesson02/part02/Task42.java";

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
    public void task42ifKeyboardInput() {
        boolean isInputExist = false;
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            List<String> collect = stream.collect(Collectors.toList());
            for (String s : collect) {
                if (s.contains("nextInt()") || s.contains("nextLine()") || s.contains("readLine()")) {
                    isInputExist = true;
                    break;
                }
            }
            Assert.assertTrue("Программа должна получать числа с клавиатуры",isInputExist);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void task42isResultGood() throws Exception {
        SystemInGatewayUtil.provideInput("-1\n");
        Task42.main(null);
        ByteArrayOutputStream stream = SystemOutGatewayUtil.getOutputArray();
        String result = stream.toString();
        Assert.assertEquals("Неправильный вывод",
                "-1\n",result);
        stream.reset();
    }

    @Test
    public void task42isResultCorrect() throws Exception {
        SystemInGatewayUtil.provideInput("1\n2\n3\n4\n-1\n");
        Task42.main(null);
        ByteArrayOutputStream stream = SystemOutGatewayUtil.getOutputArray();
        String result = stream.toString();
        Assert.assertEquals("Неправильный вывод",
                "9\n",result);
        stream.reset();
    }

    @Test
    public void task42ifForOrWhileOrDoWhileUsed() {
        boolean isForUsed = false;
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            List<String> collect = stream.collect(Collectors.toList());
            for (String s : collect) {
                if (s.contains("for (") || s.contains("while (") || s.contains("do {")) {
                    isForUsed = true;
                    break;
                }
            }
            Assert.assertTrue("Должен использоваться цикл for или while.",
                    isForUsed);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}