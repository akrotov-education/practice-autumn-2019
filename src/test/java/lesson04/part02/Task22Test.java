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
public class Task22Test {

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
        List<String> fileLines = ReadFileUtil.readFileInList("./src/main/java/lesson04/part02/Task22.java");
        boolean isOk = false;
        for (String line : fileLines) {
            if (!line.matches(".*Map\\s*<String, String>.*new.*")) {
                continue;
            }

            isOk = true;
            break;
        }

        Assert.assertTrue("You have to declare and initialize variable of type Map",
                isOk
        );
    }

    @Test
    public void checkCollectionAdd() {
        List<String> fileLines = ReadFileUtil.readFileInList("./src/main/java/lesson04/part02/Task22.java");

        List<String> words = new LinkedList<>(Arrays.asList(
                "арбуз-ягода",
                "банан-трава",
                "вишня-ягода",
                "груша-фрукт",
                "дыня-овощ",
                "ежевика-куст",
                "жень-шень-корень",
                "земляника-ягода",
                "ирис-цветок",
                "картофель-клубень"
        ));

        for (String line : fileLines) {
            if (line.contains(".put")) {
                int firstInd = line.indexOf("\"") + 1;
                int secondInd = line.indexOf("\"", firstInd);
                int thirdInd = line.indexOf("\"", secondInd + 1) + 1;
                int fourthInd = line.indexOf("\"", thirdInd);
                String firstWord = line.substring(firstInd, secondInd).trim();
                String secondWord = line.substring(thirdInd, fourthInd).trim();
                int ind = words.indexOf(firstWord + "-" + secondWord);
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
        Task22.main(null);

        String output = SystemOutGatewayUtil.getOutputArray().toString();
        Assert.assertEquals("Program must display 10 strings each from new string",
                10,
                output.split("\n").length
        );
    }
}