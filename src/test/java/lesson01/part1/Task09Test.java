package lesson01.part1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import util.ReadFileUtil;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class Task09Test {
    private List<String> source;

    @Before
    public void setUp() throws Exception {
        source = ReadFileUtil.readFileInList("./src/main/java/lesson01/part1/Task09.java");
    }

    @Test
    public void checkFuncDef() {
        String lineWithFuncDef = source.get(27);

        Assert.assertTrue("Method sumDigitsInNumber must be public, static and returns int",
                lineWithFuncDef.contains("public static int")
        );
    }

    @Test
    public void methodDoesntCallPrint() {
        for (int i = 28; i < source.size(); i++) {
            String line = source.get(i);
            if (line.contains("print")) {
                Assert.fail("Method sumDigitsInNumber mustn't call output method");
            }
        }
    }

    @Test
    public void methodReturnsCorrectValue() {
        int result = Task09.sumDigitsInNumber(356);
        Assert.assertEquals("Function sumDigitsInNumber must returns 14 for argument 356",
                "14",
                Integer.toString(result)
        );
    }
}