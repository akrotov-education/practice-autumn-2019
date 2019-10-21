package lesson02.part02;

import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;
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
public class Task09Test {
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
        Task09.main(null);

        ByteArrayOutputStream output = SystemOutGatewayUtil.getOutputArray();
        Assert.assertTrue("The program must output numbers", output.toString().length() > 0);
        String[] outLines = output.toString().split("\n");

        try {
            for (String line : outLines) {
                Integer.parseInt(line);
            }
        } catch (NumberFormatException e) {
            Assert.fail("The program must output numbers");
        }
    }

    @Test
    public void mainDoesntCallPrint() {
        List<String> lines = ReadFileUtil.readFileInList("./src/main/java/lesson02/part02/Task09.java");

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
    public void mainCallsDisplayClosestToTen() {
        List<String> lines = ReadFileUtil.readFileInList("./src/main/java/lesson02/part02/Task09.java");

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

            if (line.contains("displayClosestToTen")) {
                isCallingCompare = true;
                break;
            }
        }

        Assert.assertTrue("Main have to call displayClosestToTen", isCallingCompare);
    }

    @Test
    public void displayClosestToTenCallsAbs() {
        List<String> lines = ReadFileUtil.readFileInList("./src/main/java/lesson02/part02/Task09.java");

        int startLine = 0;
        for (int i = 0; i < lines.size(); i++) {
            if (lines.get(i).contains("public static void displayClosestToTen")) {
                startLine = i;
                break;
            }
        }

        Boolean isCallingAbs = false;
        for (int i = startLine; i < lines.size(); i++) {
            String line = lines.get(i);

            if (line.contains("}")) {
                break;
            }

            if (line.contains("abs")) {
                isCallingAbs = true;
                break;
            }
        }

        Assert.assertTrue("displayClosestToTen have to call abs", isCallingAbs);
    }

    @Test
    public void checkDisplayClosestToTen() {
        Task09.displayClosestToTen(8, 11);
        Task09.displayClosestToTen(7, 14);

        ByteArrayOutputStream output = SystemOutGatewayUtil.getOutputArray();
        String[] outLines = output.toString().split("\n");

        Assert.assertEquals("Method displayClosestToTen works incorrect",
                "11",
                outLines[0]
        );
        Assert.assertEquals("Method displayClosestToTen works incorrect",
                "7",
                outLines[1]
        );
    }
}