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
public class Task08Test {
    private List<String> source;

    @Before
    public void setUp() throws Exception {
        source = ReadFileUtil.readFileInList("./src/main/java/lesson01/part1/Task08.java");
    }

    @Test
    public void checkFuncDef() {
        String lineWithFuncDef = source.get(28);

        Assert.assertTrue("Method getMetreFromCentimetre must be public, static and returns int",
                lineWithFuncDef.contains("public static int")
        );
    }

    @Test
    public void methodDoesntCallPrint() {
        for (int i = 29; i < source.size(); i++) {
            String line = source.get(i);
            if (line.contains("print")) {
                Assert.fail("Method getMetreFromCentimetre mustn't call output method");
            }
        }
    }

    @Test
    public void methodReturnsCorrectValue() {
        int result = Task08.getMetreFromCentimetre(356);
        Assert.assertEquals("Function convertCelsiusToFahrenheit must returns 3 for argument 356",
                "3",
                Integer.toString(result)
        );
    }
}