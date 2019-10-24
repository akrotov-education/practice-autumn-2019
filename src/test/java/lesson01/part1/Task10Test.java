package lesson01.part1;
//@FoLоKe
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import util.SystemOutGatewayUtil;

import java.io.ByteArrayOutputStream;

import static org.junit.Assert.*;
@RunWith(JUnit4.class)
public class Task10Test {
    /* 1. Программа должна выводить текст.
     * 2. Выведенный текст должен быть целым положительным числом.
     * 3. Выведенное число должно быть кратно 60.
     * 4. Выводимое число должно соответствовать заданию.
     */
    private static ByteArrayOutputStream out;
    private static String mainOutput;
    private static String[] mainOutputStrings;

    @Before
    public void init()
    {
        SystemOutGatewayUtil.setCustomOut();
        out = SystemOutGatewayUtil.getOutputArray();
        out.reset();

        Task10.main(null);
        mainOutput = out.toString().trim();
        mainOutputStrings = mainOutput.split("\n");
    }

    @Test
    public void test10main() {
        Assert.assertEquals("1800", mainOutput);
    }

    @Test
    public void test1001()
    {
        Assert.assertFalse(mainOutput.isEmpty());
    }

    @Test
    public void test1002()
    {
        try {
            Assert.assertTrue(Integer.parseInt(mainOutput) > 0);
        }catch (Exception e) {
            Assert.fail("не целое");
        }
    }

    @Test
    public void test1003()
    {
        Assert.assertEquals(0, Integer.parseInt(mainOutput) % 60);
    }
}