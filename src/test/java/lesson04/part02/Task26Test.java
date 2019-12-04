package lesson04.part02;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import util.ReadFileUtil;
import util.ReadFuncBodyUtil;
import util.SystemOutGatewayUtil;

import java.util.List;

@RunWith(JUnit4.class)
public class Task26Test {

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
    public void checkInitialize() {
        List<String> fileLines = ReadFileUtil.readFileInList("./src/main/java/lesson04/part02/Task26.java");

        int methodLine = -1;
        for (int i = 0; i < fileLines.size(); i++) {
            String line = fileLines.get(i);
            if (line.matches(".*public static.*main.*")) {
                methodLine = i;
            }
        }

        List<String> methodBody = ReadFuncBodyUtil.getFuncBody(fileLines, methodLine);
        boolean isOk = false;
        for (String line : methodBody) {
            if (line.matches(".*Map\\s*<String,\\s*Object>.*new.*")) {
                isOk = true;
                break;
            }
        }

        Assert.assertTrue("You must declare and initialize variable of type Map<String, Object>",
                isOk
        );
    }

    @Test
    public void checkMapAdd() {
        List<String> fileLines = ReadFileUtil.readFileInList("./src/main/java/lesson04/part02/Task26.java");

        int methodLine = -1;
        for (int i = 0; i < fileLines.size(); i++) {
            String line = fileLines.get(i);
            if (line.matches(".*public static.*main.*")) {
                methodLine = i;
            }
        }

        List<String> methodBody = ReadFuncBodyUtil.getFuncBody(fileLines, methodLine);
        int putCount = 0;
        for (String line : methodBody) {
            if (line.contains(".put")) {
                putCount++;
            }
        }
        Assert.assertEquals("Program must adds 10 elements to collection",
                10,
                putCount
        );
    }

    @Test
    public void checkOutput() {
        Task26.main(null);

        String output = SystemOutGatewayUtil.getOutputArray().toString();
        Assert.assertEquals("Program must display each element from new line",
                10,
                output.split("\n").length
        );
    }
}