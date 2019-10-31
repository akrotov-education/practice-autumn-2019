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
public class Task01Test {

    /* 1. Программа должна выводить текст.
     * 2. Текст должен начинаться с "Hello".
     * 3. Текст должен заканчиваться на "!".
     * 4. Текст должен состоять из 12 символов, включая пробелы и знаки препинания.
     * 5. Текст должен состоять из одной строки.
     *
     */
    private static ByteArrayOutputStream out;
    private static String output;

    @Before
    public void init()
    {
        SystemOutGatewayUtil.setCustomOut();
        out = SystemOutGatewayUtil.getOutputArray();
        out.reset();

        Task01.main(null);
        output = out.toString().trim();
    }

    @Test
    public void test01main() {
        Assert.assertEquals("Hello World!", output);
    }

    @Test
    public void test0101()
    {
        Assert.assertFalse("пусто", output.isEmpty());
    }

    @Test
    public void test0102()
    {
        Assert.assertTrue("не начинается Hello", output.startsWith("Hello"));
    }

    @Test
    public void test0103()
    {
        Assert.assertTrue("Не заканчивается на !", output.endsWith("!"));
    }

    @Test
    public void test0104()
    {
        Assert.assertEquals("Не 12 символов",12, output.length());
    }

    @Test
    public void test0105()
    {
        Assert.assertEquals("Не одна строка" ,1, output.split("\n").length);
    }
}