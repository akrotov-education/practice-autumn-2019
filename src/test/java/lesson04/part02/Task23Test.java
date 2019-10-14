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
import java.util.Map;

@RunWith(JUnit4.class)
public class Task23Test {

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
        List<String> fileLines = ReadFileUtil.readFileInList("./src/main/java/lesson04/part02/Task23.java");

        int methodLine = -1;
        for (int i = 0; i < fileLines.size(); i++) {
            String line = fileLines.get(i);
            if (line.matches(".*public static.*addCatsToMap.*")) {
                methodLine = i;
            }
        }

        List<String> methodBody = ReadFuncBodyUtil.getFuncBody(fileLines, methodLine);
        boolean isOk = false;
        for (String line : methodBody) {
            if (line.matches(".*Map\\s*<String,\\s*Cat>.*new.*")) {
                isOk = true;
                break;
            }
        }

        Assert.assertTrue("You must declare and initialize variable of type Map<String, Cat> in addCatsToMap method",
                isOk
        );
    }

    @Test
    public void checkAddCatsToMap() {
        Map<String, Task23.Cat> cats = Task23.addCatsToMap(new String[]{"васька", "мурка", "дымка"});
        Assert.assertTrue("Method addCatsToMap works incorrect",
                cats.get("васька") != null && cats.get("мурка") != null && cats.get("дымка") != null
        );
    }

    @Test
    public void checkOutput() throws Exception {
        Task23.main(null);
        String output = SystemOutGatewayUtil.getOutputArray().toString();
        String[] pairs = output.split("\n");

        Assert.assertEquals("Program must display 10 strings each from new line",
                10,
                pairs.length
        );

        for (String pair : pairs) {
            if (!pair.contains("-")) {
                Assert.fail("Program must display pairs with hyphen");
            }
        }
    }
}