package lesson01.part1;
//@FoLoKe
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import util.SystemOutGatewayUtil;
import java.io.ByteArrayOutputStream;

@RunWith(JUnit4.class)
public class Task02Test {
    /* Требования:
     * 1. Программа должна выводить текст.
     * 2. Текст должен начинаться с "Hello".
     * 3. Текст должен заканчиваться на "!".
     * 4. Текст должен состоять из 3 строк.
     */

    private static ByteArrayOutputStream out;
    private static String output;
    private static String[] outputStrings;

    @Before
    public void init()
    {
        SystemOutGatewayUtil.setCustomOut();
        out = SystemOutGatewayUtil.getOutputArray();
        out.reset();

        Task02.main(null);
        output = out.toString().trim();
        outputStrings = output.split("\n");
    }

    @Test
    public void test02main() {
        for (String hell: outputStrings) {
            Assert.assertEquals("Hello World!", hell);
        }
    }

    @Test
    public void test0201()
    {
        Assert.assertFalse("Пусто", output.isEmpty());
    }

    @Test
    public void test0202()
    {
        Assert.assertTrue("не начинается с Hello", output.startsWith("Hello"));
    }

    @Test
    public void test0203()
    {
        Assert.assertTrue("не заканчивается на !", out.toString().endsWith("!"));
    }

    @Test
    public void test0204()
    {
        Assert.assertEquals("Не 3 строки", 3, outputStrings.length);
    }
}