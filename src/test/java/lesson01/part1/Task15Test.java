package lesson01.part1;
//@FoLoKe
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import util.SystemOutGatewayUtil;

import java.io.ByteArrayOutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class Task15Test {

    /* 1. У переменной number можно менять только значение.
     * 2. Программа должна выводить текст.
     * 3. Выводимый текст должен быть числом.
     * 4. Выводимый текст должен быть квадратом переменной number.
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

        Task15.main(null);
        mainOutput = out.toString().trim();
        mainOutputStrings = mainOutput.split("\n");
    }

    @Test
    public void test15main() {
        try {
            Assert.assertFalse(out.toString().isEmpty());
        }
        catch(Exception e)
        {
            System.out.println(e.toString());
        }
    }

    @Test
    public void task1502()
    {
        Assert.assertTrue(mainOutput.matches("\\d*.\\d*"));
    }

    @Test
    public void task1501()
    {
        try {
            Field f = Task15.class.getDeclaredField("number");
            Assert.assertEquals(Integer.TYPE, f.getType());
            Assert.assertTrue(Modifier.isPublic(f.getModifiers()));
            Assert.assertTrue(Modifier.isStatic(f.getModifiers()));
        }catch (Exception e)
        {
            Assert.fail("переменная плоха");
        }

    }

    @Test
    public void task1503()
    {
        try {
            Field f = Task15.class.getDeclaredField("number");
            int number = (int) f.get(null);
            double real = Math.pow(number, 2);
            Assert.assertEquals(real, Double.parseDouble(out.toString().trim()), 0);
        } catch (Exception e)
        {
            Assert.fail("вывод плох");
        }
    }

}