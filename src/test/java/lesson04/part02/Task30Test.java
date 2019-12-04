package lesson04.part02;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import util.ReadFileUtil;
import util.ReadFuncBodyUtil;
import util.SystemOutGatewayUtil;

import java.util.ArrayList;
import java.util.List;

public class Task30Test {

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
    public void checkOutput() {
        Task30.main(null);

        String output = SystemOutGatewayUtil.getOutputArray().toString();
        Assert.assertTrue("The program must output numbers", output.length() > 0);
        String[] outLines = output.split("\n");

        try {
            for (String line : outLines) {
                int symInd = line.indexOf("\r");
                if (symInd != -1) {
                    line = line.substring(0, symInd) + line.substring(symInd + 1);
                }

                Integer.parseInt(line);
            }
        } catch (NumberFormatException e) {
            Assert.fail("The program must output numbers");
        }
    }

    @Test
    public void checkMethod1CallCount() {
        List<String> fileLines = ReadFileUtil.readFileInList("./src/main/java/lesson04/part02/Task30.java");

        int methodLine = -1;
        for (int i = 0; i < fileLines.size(); i++) {
            String line = fileLines.get(i);
            if (line.matches(".*public static.*main.*")) {
                methodLine = i;
            }
        }

        List<String> methodBody = ReadFuncBodyUtil.getFuncBody(fileLines, methodLine);
        int callCount = 0;
        for (String line : methodBody) {
            if (line.contains("getGetTimeInMs")) {
                callCount++;
            }
        }
        Assert.assertEquals("Program must calls getGetTimeInMs only 2 times",
                2,
                callCount
        );
    }

    @Test
    public void checkMethod2CallCount() {
        List<String> fileLines = ReadFileUtil.readFileInList("./src/main/java/lesson04/part02/Task30.java");

        int methodLine = -1;
        for (int i = 0; i < fileLines.size(); i++) {
            String line = fileLines.get(i);
            if (line.matches(".*public static.*main.*")) {
                methodLine = i;
            }
        }

        List<String> methodBody = ReadFuncBodyUtil.getFuncBody(fileLines, methodLine);
        int callCount = 0;
        for (String line : methodBody) {
            if (line.contains("fill")) {
                callCount++;
            }
        }
        Assert.assertEquals("Program must calls fill only 2 times",
                2,
                callCount
        );
    }

    @Test
    public void checkFill() {
        ArrayList arrayList = new ArrayList();
        Task30.fill(arrayList);

        Assert.assertEquals("Method fill must insert 10000 elements in List",
                10000,
                arrayList.size()
        );
    }

    @Test
    public void checkGet10000() {
        List<String> fileLines = ReadFileUtil.readFileInList("./src/main/java/lesson04/part02/Task30.java");

        int methodLine = -1;
        for (int i = 0; i < fileLines.size(); i++) {
            String line = fileLines.get(i);
            if (line.matches(".*public static.*get10000.*")) {
                methodLine = i;
            }
        }

        List<String> methodBody = ReadFuncBodyUtil.getFuncBody(fileLines, methodLine);
        int loopLine = -1;
        for (int i = 0; i < methodBody.size(); i++) {
            String line = methodBody.get(i);
            if (line.matches(".*for\\s*(.*10000.*).*")) {
                loopLine = i;
                break;
            }
        }

        List<String> loopBody = ReadFuncBodyUtil.getFuncBody(methodBody, loopLine);
        boolean isOk = false;
        for (String line : loopBody) {
            if (line.contains(".get")) {
                isOk = true;
                break;
            }
        }

        Assert.assertTrue("Method get10000 must calls get 10000 times",
                isOk
        );
    }

    @Test
    public void checkGet10kCall() {
        List<String> fileLines = ReadFileUtil.readFileInList("./src/main/java/lesson04/part02/Task30.java");

        int methodLine = -1;
        for (int i = 0; i < fileLines.size(); i++) {
            String line = fileLines.get(i);
            if (line.matches(".*public static.*getGetTimeInMs.*")) {
                methodLine = i;
            }
        }

        List<String> methodBody = ReadFuncBodyUtil.getFuncBody(fileLines, methodLine);
        int callCount = 0;
        for (String line : methodBody) {
            if (line.contains("get10000")) {
                callCount++;
            }
        }
        Assert.assertEquals("Method getGetTimeInMs must calls get10000 only 1 time",
                1,
                callCount
        );
    }
}