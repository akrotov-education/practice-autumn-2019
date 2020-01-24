package part04;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import util.SystemOutGatewayUtil;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task18Test {
    public static String fileName = "./src/main/java/lesson05/part04/Task18.java";

    @Before
    public void setUp() throws Exception {
        SystemOutGatewayUtil.setCustomOut();
    }

    @After
    public void tearDown() throws Exception {
        SystemOutGatewayUtil.setOriginalOut();
        SystemOutGatewayUtil.clearOutput();
    }

    @Test
    public void ListofExeptions(){
        try {
            Stream<String> stream = Files.lines(Paths.get(fileName));
            List<String> line = stream.collect(Collectors.toList());
            String lineWithMethodCall = line.get(20);
            Assert.assertTrue("Все элементы списка exceptions должны быть исключениями(потомками класса Throwable).",
                    lineWithMethodCall.contains("List<Exception> exceptions = new ArrayList<Exception>()"));
        } catch (IOException e) { }
    }

    @Test
    public void DifferentVals() {
        lesson05.part04.Task18.main(null);
        ByteArrayOutputStream stream = SystemOutGatewayUtil.getOutputArray();
        String result = stream.toString();
        String[] subStr = result.split("\r\n");

        Assert.assertEquals("Список exceptions должен содержать 10 элементов", 10, subStr.length);

        ArrayList<String> res = new ArrayList<>();
        for (String str : subStr) {
            if (!res.contains(str)) {
                res.add(str);
            }
        }
        Assert.assertEquals("Все элементы списка exceptions должны быть уникальны",  10, res.size());
        subStr = null;
        stream.reset();
    }

    @Test
    public void staticmethod(){
        try {
            Stream<String> stream = Files.lines(Paths.get(fileName));
            List<String> line = stream.collect(Collectors.toList());
            String lineWithMethodCall = line.get(29);
            Assert.assertTrue("Метод initExceptions должен быть статическим",
                    lineWithMethodCall.contains("static void initExceptions()"));
        } catch (IOException e) { }
    }

}