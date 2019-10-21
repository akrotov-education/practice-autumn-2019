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

public class Task25Test {
    private static String fileName = "./src/main/java/lesson02/part02/Task25.java";

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
    public void task25ifPrintWasUsed() {
        boolean isPrintUsed = false;
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            List<String> collect = stream.collect(Collectors.toList());
            for (String s : collect) {
                if (s.contains("System.out.println()") || s.contains("System.out.print()")) {
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
    public void task25ifKeyboardInput() {
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
    public void task25correct1stQuarter() throws Exception {
        SystemInGatewayUtil.provideInput("1\n1\n");
        Task25.main(null);
        ByteArrayOutputStream stream = SystemOutGatewayUtil.getOutputArray();
        String result = stream.toString();
        Assert.assertEquals("Если точка находится в первой координатной четверти, вывести \"1\".",
                "1\n",result);
        stream.reset();
    }

    @Test
    public void task25correct2ndQuarter() throws Exception {
        SystemInGatewayUtil.provideInput("-1\n1\n");
        Task25.main(null);
        ByteArrayOutputStream stream = SystemOutGatewayUtil.getOutputArray();
        String result = stream.toString();
        Assert.assertEquals("Если точка находится во второй координатной четверти, вывести \"2\".",
                "2\n",result);
        stream.reset();
    }

    @Test
    public void task25correct3rdQuarter() throws Exception {
        SystemInGatewayUtil.provideInput("-1\n-1\n");
        Task25.main(null);
        ByteArrayOutputStream stream = SystemOutGatewayUtil.getOutputArray();
        String result = stream.toString();
        Assert.assertEquals("Если точка находится в третьей координатной четверти, вывести \"3\".",
                "3\n",result);
        stream.reset();
    }

    @Test
    public void task25correct4thQuarter() throws Exception {
        SystemInGatewayUtil.provideInput("1\n-1\n");
        Task25.main(null);
        ByteArrayOutputStream stream = SystemOutGatewayUtil.getOutputArray();
        String result = stream.toString();
        Assert.assertEquals("Если точка находится в четвертой координатной четверти, вывести \"4\".",
                "4\n",result);
        stream.reset();
    }
}