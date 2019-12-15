package lesson05.part02;

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
public class Task30Test {
    @Before
    public void setUp() {
        SystemOutGatewayUtil.setCustomOut();
    }

    @After
    public void tearDown() {
        SystemOutGatewayUtil.setOriginalOut();
        SystemOutGatewayUtil.clearOutput();
    }

    @Test
    public void checkContains3Methods() {
        Assert.assertEquals("Class must contains only 3 methods",
                3, Task30.class.getDeclaredMethods().length);
    }

    @Test
    public void checkTransformValue() {
        Assert.assertEquals("Method transformValue must double transferred value",
                4, Task30.transformValue(2));
    }

    @Test
    public void checkCallOnce() {
        List<String> fileLines = ReadFileUtil.readFileInList("./src/main/java/lesson05/part02/Task30.java");
        for (int i = 0; i < fileLines.size(); i++) {
            String line = fileLines.get(i);
            if (!line.contains("void main(String[] args)")) {
                continue;
            }

            List<String> body = ReadFuncBodyUtil.getFuncBody(fileLines, i);
            int count = 0;
            for (String s : body) {
                if (s.contains("transformValue(")) {
                    count++;
                }
            }

            Assert.assertEquals("TransformValue must calls only one time",
                    1, count);
        }
    }

    @Test
    public void checkOutput() {
        Task30.main(null);
        String output = SystemOutGatewayUtil.getOutputArray().toString();
        Assert.assertTrue("Program must display 10",
                output.contains("10"));
    }
}