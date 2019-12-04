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
    public void checkOutput() {
        Task11.main(null);

        ByteArrayOutputStream output = SystemOutGatewayUtil.getOutputArray();
        Assert.assertTrue("The program must output text", output.toString().length() > 0);
    }

    @Test
    public void mainDoesntCallPrint() {
        List<String> lines = ReadFileUtil.readFileInList("./src/main/java/lesson02/part02/Task11.java");

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
    public void mainCallsCheckSeason() {
        List<String> lines = ReadFileUtil.readFileInList("./src/main/java/lesson02/part02/Task11.java");

        int startLine = 0;
        for (int i = 0; i < lines.size(); i++) {
            if (lines.get(i).contains("public static void main")) {
                startLine = i;
                break;
            }
        }

        Boolean isCallingCheckSeason = false;
        for (int i = startLine; i < lines.size(); i++) {
            String line = lines.get(i);

            if (line.contains("}")) {
                break;
            }

            if (line.contains("checkSeason")) {
                isCallingCheckSeason = true;
                break;
            }
        }

        Assert.assertTrue("Main have to call checkSeason", isCallingCheckSeason);
    }

    @Test
    public void checkFuncCheckSeason() {
        try {
            Method method = Task11.class.getDeclaredMethod("checkSeason", int.class);
            String modifier = Modifier.toString(method.getModifiers());
            String type = method.getReturnType().toString();

            Assert.assertTrue("Method checkSeason must be static",
                    modifier.contains("static")
            );
            Assert.assertEquals("Method checkSeason must have void return type",
                    "void",
                    type
            );
        } catch (NoSuchMethodException e) {
            Assert.fail("Method checkSeason must have only one parameter int");
        }
    }

    @Test
    public void checkFuncCheckSeasonWork() {
        Task11.checkSeason(12);
        Task11.checkSeason(4);
        Task11.checkSeason(7);
        Task11.checkSeason(10);

        ByteArrayOutputStream output = SystemOutGatewayUtil.getOutputArray();
        String[] outLines = output.toString().split("\n");

        Assert.assertEquals("Method checkSeason works incorrect",
                "зима",
                outLines[0]
        );
        Assert.assertEquals("Method checkSeason works incorrect",
                "весна",
                outLines[1]
        );
        Assert.assertEquals("Method checkSeason works incorrect",
                "лето",
                outLines[2]
        );
        Assert.assertEquals("Method checkSeason works incorrect",
                "осень",
                outLines[3]
        );
    }
}