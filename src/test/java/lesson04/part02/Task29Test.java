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

public class Task29Test {

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
        Task29.main(null);

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
    public void checkMethodCall() {
        List<String> fileLines = ReadFileUtil.readFileInList("./src/main/java/lesson04/part02/Task29.java");

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
            if (line.contains("getInsertTimeInMs")) {
                callCount++;
            }
        }
        Assert.assertEquals("Program must calls getInsertTimeInMs only 2 times",
                2,
                callCount
        );
    }

    @Test
    public void checkInsert10000() {
        ArrayList arrayList = new ArrayList();
        Task29.insert10000(arrayList);

        Assert.assertEquals("Method insert10000 must insert 10000 elements in List",
                10000,
                arrayList.size()
        );
    }

    @Test
    public void checkInsert10kCall() {
        List<String> fileLines = ReadFileUtil.readFileInList("./src/main/java/lesson04/part02/Task29.java");

        int methodLine = -1;
        for (int i = 0; i < fileLines.size(); i++) {
            String line = fileLines.get(i);
            if (line.matches(".*public static.*getInsertTimeInMs.*")) {
                methodLine = i;
            }
        }

        List<String> methodBody = ReadFuncBodyUtil.getFuncBody(fileLines, methodLine);
        int callCount = 0;
        for (String line : methodBody) {
            if (line.contains("insert10000")) {
                callCount++;
            }
        }
        Assert.assertEquals("Method getInsertTimeInMs must calls insert10000 only 1 time",
                1,
                callCount
        );
    }
}