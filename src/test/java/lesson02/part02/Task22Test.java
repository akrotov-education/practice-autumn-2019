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

public class Task22Test {
    private static String fileName = "/Users/Xesavov/Documents/practice-autumn-2019/src/main/java/lesson02/part02/Task22.java";

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
    public void task22ifTwoLinesAreRead() {
        int readerCount = 0;
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            List<String> collect = stream.collect(Collectors.toList());
            for (String s : collect) {
                if (s.contains("readLine()") || s.contains("nextLine()"))
                    readerCount++;
            }
            Assert.assertEquals("Программа должна считывать две строки с клавиатуры.",
                    1,readerCount);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void task22ifPrintWasUsed() {
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
    public void task22isOutputCorrectUnder18() throws Exception {
        SystemInGatewayUtil.provideInput("Jane\n17");
        Task22.main(null);
        ByteArrayOutputStream stream = SystemOutGatewayUtil.getOutputArray();
        String result = stream.toString();
        Assert.assertEquals("Если возраст меньше 18, вывести сообщение \"Подрасти ещё\"",
                "Подрасти еще\n",result);
        stream.reset();
    }

    @Test
    public void task22isOutputCorrectAbove18() throws Exception {
        SystemInGatewayUtil.provideInput("Jane\n18");
        Task22.main(null);
        ByteArrayOutputStream stream = SystemOutGatewayUtil.getOutputArray();
        String result = stream.toString();
        Assert.assertEquals("Если возраст больше 18, ничего не выводить!",
                "",result);
        stream.reset();
    }
}