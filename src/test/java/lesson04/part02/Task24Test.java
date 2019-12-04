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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(JUnit4.class)
public class Task24Test {

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
        List<String> fileLines = ReadFileUtil.readFileInList("./src/main/java/lesson04/part02/Task24.java");

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
            if (line.matches(".*Map\\s*<String,\\s*String>.*new.*")) {
                isOk = true;
                break;
            }
        }

        Assert.assertTrue("You must declare and initialize variable of type Map<String, String>",
                isOk
        );
    }

    @Test
    public void checkMapAdd() {
        List<String> fileLines = ReadFileUtil.readFileInList("./src/main/java/lesson04/part02/Task24.java");

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
    public void checkPrintKeys() {
        Map<String, String> map = new HashMap<>();
        map.put("Sim", "Sifwm");
        map.put("Tom", "Tomewv");
        map.put("Arbus", "Arcwevbus");

        Task24.printKeys(map);
        String output = SystemOutGatewayUtil.getOutputArray().toString();
        String[] lines = output.split("\n");
        for (String line : lines) {
            line = line.replace("\r", "");
            if (map.get(line) == null) {
                Assert.fail("Method printKeys works incorrect");
            }
        }
    }
}