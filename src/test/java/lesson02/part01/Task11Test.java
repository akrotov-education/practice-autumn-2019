package lesson02.part01;

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
public class Task11Test {
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
    public void checkConvertToSec() {
        try {
            Method method = Task11.class.getMethod("convertToSeconds", int.class);
            String modifiers = Modifier.toString(method.getModifiers());
            String type = method.getReturnType().toString();

            Assert.assertEquals("Method 'convertToSeconds' must be public and static",
                    "public static",
                    modifiers
            );

            Assert.assertEquals("Method 'convertToSeconds' must return int",
                    "int",
                    type
            );
        } catch (NoSuchMethodException e) {
            Assert.fail("Task11 have to have method convertToSeconds and get int parameter");
        }
    }

    @Test
    public void mainCallsConvertToSec() {
        List<String> lines = ReadFileUtil.readFileInList("./src/main/java/lesson02/part01/Task11.java");

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

            if (line.contains("}")) {
                break;
            }

            if (line.contains("convertToSeconds")) {
                callsCount++;
            }
        }

        Assert.assertEquals("Main have to call convertToSeconds twice",
                2,
                callsCount
        );
    }

    @Test
    public void checkMainOutput() {
        Task11.main(null);

        ByteArrayOutputStream output = SystemOutGatewayUtil.getOutputArray();
        String[] outLines = output.toString().split("\n");

        Assert.assertTrue("Main should display 2 lines",
                outLines.length == 2
        );
    }

    @Test
    public void checkConvertToSecOutput() {
        Task11.convertToSeconds(1);

        ByteArrayOutputStream output = SystemOutGatewayUtil.getOutputArray();

        Assert.assertTrue("Method convertToSeconds shouldn't display anything",
                output.toString().length() == 0
        );
    }
}