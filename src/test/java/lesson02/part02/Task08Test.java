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
import java.util.List;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class Task08Test {
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
        Task08.main(null);

        ByteArrayOutputStream output = SystemOutGatewayUtil.getOutputArray();
        Assert.assertTrue("The program must output text", output.toString().length() > 0);
    }

    @Test
    public void mainDoesntCallPrint() {
        List<String> lines = ReadFileUtil.readFileInList("./src/main/java/lesson02/part02/Task08.java");

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
    public void mainCallsCompare() {
        List<String> lines = ReadFileUtil.readFileInList("./src/main/java/lesson02/part02/Task08.java");

        int startLine = 0;
        for (int i = 0; i < lines.size(); i++) {
            if (lines.get(i).contains("public static void main")) {
                startLine = i;
                break;
            }
        }

        Boolean isCallingCompare = false;
        for (int i = startLine; i < lines.size(); i++) {
            String line = lines.get(i);

            if (line.contains("}")) {
                break;
            }

            if (line.contains("compare")) {
                isCallingCompare = true;
                break;
            }
        }

        Assert.assertTrue("Main have to call compare", isCallingCompare);
    }

    @Test
    public void checkCompareType() {
        try {
            String type = Task08.class.getMethod("compare", int.class).getReturnType().toString();
            Assert.assertEquals("Method 'compare' must return void",
                    "void",
                    type
            );
        } catch (NoSuchMethodException e) {
            Assert.fail("Task08 doesn't have method compare");
        }
    }

    @Test
    public void checkCompareWork() {
        Task08.compare(4);
        Task08.compare(6);
        Task08.compare(5);

        ByteArrayOutputStream output = SystemOutGatewayUtil.getOutputArray();
        String[] outLines = output.toString().split("\n");

        Assert.assertEquals("Method works incorrect",
                "Число меньше 5",
                outLines[0]
        );
        Assert.assertEquals("Method works incorrect",
                "Число больше 5",
                outLines[1]
        );
        Assert.assertEquals("Method works incorrect",
                "Число равно 5",
                outLines[2]
        );
    }
}