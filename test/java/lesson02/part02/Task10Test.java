package lesson02.part02;

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
public class Task10Test {

    public static String fileName = "./src/main/java/lesson02/part02/Task10.java";
    @Before
    public void setUp() {
        SystemOutGatewayUtil.setCustomOut();
    }

    @After
    public void tearDown() {
        SystemOutGatewayUtil.clearOutput();
        SystemOutGatewayUtil.setOriginalOut();
    }

    @Test
    public void checkOutput() {
        Task10.main(null);

        ByteArrayOutputStream output = SystemOutGatewayUtil.getOutputArray();
        Assert.assertTrue("Программа должна выводить текст на экран", output.toString().length() > 0);
    }

    @Test
    public void mainDoesntCallPrint() {
        try{
            Stream<String> stream = Files.lines(Paths.get(fileName));
            List<String> lines = stream.collect(Collectors.toList());
        int startLine = 0;
        for (int i = 0; i < lines.size(); i++) {
            if (lines.get(i).contains("public static void main")) {
                startLine = i;
                break;
            }
        }

        for (int i = startLine; i < lines.size(); i++) {
            String line = lines.get(i);

            if (line.contains("}")) {
                break;
            }

            if (line.contains("System.out.print")) {
                Assert.fail("Метод main не должен вызывать System.out.println() или System.out.print()");
            }
        }
        } catch (IOException e) {
        }
    }

    @Test
    public void mainCallsCheckInterval() {
        try{
            Stream<String> stream = Files.lines(Paths.get(fileName));
            List<String> lines = stream.collect(Collectors.toList());
        int startLine = 0;
        for (int i = 0; i < lines.size(); i++) {
            if (lines.get(i).contains("public static void main")) {
                startLine = i;
                break;
            }
        }

        Boolean isCallingCheckInterval = false;
        for (int i = startLine; i < lines.size(); i++) {
            String line = lines.get(i);

            if (line.contains("}")) {
                break;
            }

            if (line.contains("checkInterval")) {
                isCallingCheckInterval = true;
                break;
            }
        }

        Assert.assertTrue("Метод main должен вызывать метод checkInterval", isCallingCheckInterval);
    } catch (IOException e) {
    }
    }

    @Test
    public void checkFuncCheckInt() {
        try {
            Method method = Task10.class.getDeclaredMethod("checkInterval", int.class);
            String modifier = Modifier.toString(method.getModifiers());
            String type = method.getReturnType().toString();

            Assert.assertTrue("Метод checkInterval должен быть static",
                    modifier.contains("static")
            );
            Assert.assertEquals("Метод checkInterval должен быть void",
                    "void",
                    type
            );
        } catch (NoSuchMethodException e) {
        }
    }

    @Test
    public void checkFuncCheckIntWork() {
        Task10.checkInterval(60);
        Task10.checkInterval(112);

        ByteArrayOutputStream output = SystemOutGatewayUtil.getOutputArray();
        String[] outLines = output.toString().split("\r\n");
        Assert.assertEquals("Метод checkInterval должен выводить текст на экран согласно заданию",
                "Число 60 содержится в интервале", outLines[0]);
        Assert.assertEquals("Метод checkInterval должен выводить текст на экран согласно заданию",
                "Число 112 не содержится в интервале", outLines[1]);
    }
}