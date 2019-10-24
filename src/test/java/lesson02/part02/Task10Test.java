package lesson02.part02;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import util.ReadFileUtil;
import util.SystemOutGatewayUtil;

import java.io.ByteArrayOutputStream;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.List;

@RunWith(JUnit4.class)
public class Task10Test {
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
        Assert.assertTrue("The program must output text", output.toString().length() > 0);
    }

    @Test
    public void mainDoesntCallPrint() {
        List<String> lines = ReadFileUtil.readFileInList("./src/main/java/lesson02/part02/Task10.java");

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
                Assert.fail("Main haven't to call System.out.print and System.out.println");
            }
        }
    }

    @Test
    public void mainCallsCheckInterval() {
        List<String> lines = ReadFileUtil.readFileInList("./src/main/java/lesson02/part02/Task10.java");

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

        Assert.assertTrue("Main have to call checkInterval", isCallingCheckInterval);
    }

    @Test
    public void checkFuncCheckInt() {
        try {
            Method method = Task10.class.getDeclaredMethod("checkInterval", int.class);
            String modifier = Modifier.toString(method.getModifiers());
            String type = method.getReturnType().toString();

            Assert.assertTrue("Method checkInterval must be static",
                    modifier.contains("static")
            );
            Assert.assertEquals("Method checkInterval must have void return type",
                    "void",
                    type
            );
        } catch (NoSuchMethodException e) {
            Assert.fail("Class doesn't contain checkInterval method");
        }
    }

    @Test
    public void checkFuncCheckIntWork() {
        Task10.checkInterval(60);
        Task10.checkInterval(112);

        ByteArrayOutputStream output = SystemOutGatewayUtil.getOutputArray();
        String[] outLines = output.toString().split("\n");
        Assert.assertEquals("Method checkInterval works incorrect",
                "Число 60 содержится в интервале.",
                outLines[0]
        );
        Assert.assertEquals("Method checkInterval works incorrect",
                "Число 112 не содержится в интервале.",
                outLines[1]
        );
    }
}