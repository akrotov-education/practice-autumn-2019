package lesson01.part1;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import util.ReadFileUtil;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class Task07Test {
    private List<String> source;

    @Before
    public void setUp() throws Exception {
        source = ReadFileUtil.readFileInList("./src/main/java/lesson01/part1/Task07.java");
    }

    @Test
    public void checkFunctionDef() {
        String lineWithFuncDef = source.get(27);

        Assert.assertTrue("Method convertCelsiusToFahrenheit must be public, static and returns double",
                lineWithFuncDef.contains("public static double")
        );
    }

    @Test
    public void methodDoesntCallPrint() {
        for (int i = 28; i < source.size(); i++) {
            String line = source.get(i);
            if (line.contains("print")) {
                Assert.fail("Method convertCelsiusToFahrenheit mustn't call output method");
            }
        }
    }

    @Test
    public void methodReturnsCorrectValue() {
        double result = Task07.convertCelsiusToFahrenheit(45);
        Assert.assertEquals("Function convertCelsiusToFahrenheit must return 113.0 for argument 45",
                "113.0",
                Double.toString(result)
        );
    }
}