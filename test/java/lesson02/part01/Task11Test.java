package lesson02.part01;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import util.SystemOutGatewayUtil;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RunWith(JUnit4.class)
public class Task11Test {

    public static String fileName = "./src/main/java/lesson02/part1/Task11.java";

    @Before
    public void setUp() {
        SystemOutGatewayUtil.setCustomOut();
    }

    @After
    public void tearDown() {
        SystemOutGatewayUtil.clearOutput();
        SystemOutGatewayUtil.setOriginalOut();
        SystemOutGatewayUtil.clearOutput();
    }

    @Test
    public void checkConvertToSec() {
        try {
            Method method = Task11.class.getMethod("convertToSeconds", int.class);
            String modifiers = Modifier.toString(method.getModifiers());
            String type = method.getReturnType().toString();
            Assert.assertEquals("Метод 'convertToSeconds' должен быть public stati","public static", modifiers);
            Assert.assertEquals("Метод 'convertToSeconds' должен возвращать int","int", type);
        } catch (NoSuchMethodException e) {
            Assert.fail("Метод 'convertToSeconds' должен принимать int");
        }
    }

    @Test
    public void mainCallsConvertToSec() {
       try {
           Stream<String> stream = Files.lines(Paths.get(fileName));
           List<String> lines = stream.collect(Collectors.toList());
           int startLine = 0;
           for (int i = 0; i < lines.size(); i++) {
               if (lines.get(i).contains("public static void main")) {
                   startLine = i;
                   break;
               }
           }
           int callsCount = 0;
           for (int i = startLine; i < lines.size(); i++) {
               String line = lines.get(i);
               if (line.contains("}")) {break;}
               if (line.contains("convertToSeconds")) {callsCount++;}
           }
           Assert.assertEquals("Метод main должен дважды вызывать метод convertToSeconds",2,callsCount);
       } catch (IOException e) {
        }
    }

    @Test
    public void checkMainOutput() {
        Task11.main(null);
        ByteArrayOutputStream output = SystemOutGatewayUtil.getOutputArray();
        String[] outLines = output.toString().split("\n");
        Assert.assertTrue("Метод main должен выводить результаты вызова на экран, каждый раз с новой строки",outLines.length == 2);
    }

    @Test
    public void checkConvertToSecOutput() {
        Task11.convertToSeconds(1);
        ByteArrayOutputStream output = SystemOutGatewayUtil.getOutputArray();
        Assert.assertTrue("Метод convertToSeconds не должен ничего выводить на экран",output.toString().length() == 0);
    }
}