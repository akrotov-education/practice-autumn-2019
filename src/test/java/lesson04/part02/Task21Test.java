package lesson04.part02;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import util.ReadFileUtil;
import util.SystemOutGatewayUtil;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@RunWith(JUnit4.class)
public class Task21Test {

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
        List<String> fileLines = ReadFileUtil.readFileInList("./src/main/java/lesson04/part02/Task21.java");
        boolean isOk = false;
        for (String line : fileLines) {
            if (!line.matches(".*Set\\s*<String>.*new.*")) {
                continue;
            }

            isOk = true;
            break;
        }

        Assert.assertTrue("You have to declare and initialize variable of type Set",
                isOk
        );
    }

    @Test
    public void checkCollectionAdd() {
        List<String> fileLines = ReadFileUtil.readFileInList("./src/main/java/lesson04/part02/Task21.java");

        List<String> words = new LinkedList<>(Arrays.asList(
                "арбуз",
                "банан",
                "вишня",
                "груша",
                "дыня",
                "ежевика",
                "женьшень",
                "земляника",
                "ирис",
                "картофель"
        ));

        for (String line : fileLines) {
            if (line.contains(".add")) {
                int firstInd = line.indexOf("\"");
                String word = line.substring(firstInd + 1, line.indexOf("\"", firstInd + 1)).trim();
                int ind = words.indexOf(word);
                if (ind == -1) {
                    break;
                }

                words.remove(ind);
            }
        }

        Assert.assertEquals("Program must adds 10 strings in collection",
                0,
                words.size()
        );
    }

    @Test
    public void checkOutput() {
        Task21.main(null);

        String output = SystemOutGatewayUtil.getOutputArray().toString();
        Assert.assertEquals("Program must display 10 strings each from new string",
                10,
                output.split("\n").length
        );
    }
}