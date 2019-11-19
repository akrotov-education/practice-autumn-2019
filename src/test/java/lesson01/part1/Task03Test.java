package lesson01.part1;
//@FoLoKe
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import util.SystemOutGatewayUtil;
import java.io.ByteArrayOutputStream;
import java.time.LocalDate;

@RunWith(JUnit4.class)
public class Task03Test {
    /* Требования:
     * 1. Программа должна выводить текст.
     * 2. Выведенный год должен состоять из 4 цифр.
     * 3. Выведенный год должен начинаться с "19".
     * 4. Выведенный год должен соответствовать заданию.
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

        Task03.main(null);
        output = out.toString().trim();
        outputStrings = output.split("\n");
    }

    @Test
    public void test03main() {
        LocalDate localDate = LocalDate.now();
        Assert.assertEquals(Integer.toString(localDate.minusYears(98).getYear()), output);
    }

    @Test
    public void test0301()
    {
        Assert.assertFalse("пусто", output.isEmpty());
    }

    @Test
    public void test0302()
    {
        Assert.assertTrue("не число 4х значное число", output.matches("\\d+"));
    }

    @Test
    public void test0303()
    {
        Assert.assertTrue("не начинается с 19", output.startsWith("19"));
    }
}