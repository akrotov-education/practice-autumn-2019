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

public class Task21Test {
    private static String fileName = "/Users/Xesavov/Documents/practice-autumn-2019/src/main/java/lesson02/part02/Task21.java";

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
    public void task21ifTwoLinesAreRead() {
        int readerCount = 0;
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            List<String> collect = stream.collect(Collectors.toList());
            for (String s : collect) {
                if (s.contains("readLine()") || s.contains("nextLine()"))
                    readerCount++;
            }
            Assert.assertEquals("Программа должна считывать две строки с клавиатуры.",
                    2,readerCount);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void task21ifPrintWasUsed() {
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
    public void task21sameLengthNamesOutputCheck() throws Exception {
        SystemInGatewayUtil.provideInput("Eugene\nAlexei");
        Task21.main(null);
        ByteArrayOutputStream stream = SystemOutGatewayUtil.getOutputArray();
        String result = stream.toString();
        Assert.assertEquals("Если имена разные, но длины равны, нужно вывести \"Длины имен равны\"",
                "Длины имен равны\n",result);
        stream.reset();
    }

    @Test
    public void task21assertNamesAreSame() throws Exception {
        SystemInGatewayUtil.provideInput("Eugene\nEugene");
        Task21.main(null);
        ByteArrayOutputStream stream = SystemOutGatewayUtil.getOutputArray();
        String result = stream.toString();
        Assert.assertEquals("Если имена одинаковые, нужно вывести сообщение \"Имена идентичны\"",
                "Имена идентичны\n",result);
        stream.reset();
    }

    @Test
    public void task21isOutputEmpty() throws Exception {
        SystemInGatewayUtil.provideInput("Eugene\nAlex");
        Task21.main(null);
        ByteArrayOutputStream stream = SystemOutGatewayUtil.getOutputArray();
        String result = stream.toString();
        Assert.assertEquals("Если имена и длины разные - ничего не выводить","",result);
        stream.reset();
    }
}