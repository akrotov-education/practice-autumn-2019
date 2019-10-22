package lesson02.part02;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import util.SystemInGatewayUtil;
import util.SystemOutGatewayUtil;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RunWith(JUnit4.class)

public class Task24Test {
    private static String fileName = "./src/main/java/lesson02/part02/Task24.java";

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
    public void task24ifPrintWasUsed() {
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
    public void task24ifKeyboardInput() {
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
    public void task24ifCorrectIndex() throws Exception {
        SystemInGatewayUtil.provideInput("1\n2\n1\n");
        Task24.main(null);
        ByteArrayOutputStream stream = SystemOutGatewayUtil.getOutputArray();
        String result = stream.toString();
        Assert.assertEquals("Программа должна выводить на экран порядковый номер числа, отличного от остальных.",
                "2\n",result);
        stream.reset();
    }

    @Test
    public void task24ifOutputExistWithDiffValues() throws Exception {
        SystemInGatewayUtil.provideInput("1\n2\n3\n");
        Task24.main(null);
        ByteArrayOutputStream stream = SystemOutGatewayUtil.getOutputArray();
        String result = stream.toString();
        Assert.assertEquals("Программа ничего не должна выводить, если все числа разные.",
                "",result);
        stream.reset();
    }
}