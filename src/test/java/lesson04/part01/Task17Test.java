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
public class Task17Test {
    private static List<String> collect;

    static {
        String fileName = "./src/main/java/lesson04/part01/Task17.java";
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            collect = stream.collect(Collectors.toList());
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
    public void task17ifArrayCreated() {
        boolean isListCreated = false;
        for (String s : collect) {
            if (s.contains("int[]") && s.contains("= new int[20]"))
                isListCreated = true;
        }
        Assert.assertTrue("объяви переменную типа массив на 20 целых чисел",
                isListCreated);
    }

    @Test
    public void task17ifForUsed() {
        boolean isForUsed = false;
        for (String s : collect) {
            if (s.contains("for (")) {
                isForUsed = true;
                break;
            }
        }
        Assert.assertTrue("Должен использоваться цикл for.", isForUsed);
    }

    @Test
    public void task17IsResultCorrect() throws IOException {
        String input = "0\r\n1\n2\r\n3\r\n4\r\n5\r\n6\r\n7\r\n8\r\n9\r\n0\r\n1\r\n2\r\n3\r\n4\r\n5\r\n6\r\n7\r\n8\r\n9\r\n";
        String expected = "9 0\r\n";


        SystemInGatewayUtil.provideInput(input);
        Task17.main(null);
        ByteArrayOutputStream stream = SystemOutGatewayUtil.getOutputArray();
        String result = stream.toString();
        Assert.assertEquals("программа должна считать 20 чисел и вывести максимум и минимум через пробел",
                expected,result);
        stream.reset();
    }
}