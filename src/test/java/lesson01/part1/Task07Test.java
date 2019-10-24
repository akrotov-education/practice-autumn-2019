package lesson01.part1;
//@FoLoKe
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import util.SystemOutGatewayUtil;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

@RunWith(JUnit4.class)
public class Task07Test {

    /* 1. Метод convertCelsiusToFahrenheit(int) должен быть публичным и статическим.
     * 2. Метод convertCelsiusToFahrenheit должен возвращать значение типа double.
     * 3. Метод convertCelsiusToFahrenheit не должен ничего выводить на экран.
     * 4. Метод convertCelsiusToFahrenheit должен правильно переводить градусы Цельсия в градусы Фаренгейта и возвращать это число.
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

        Task07.main(null);
        mainOutput = out.toString().trim();
        mainOutputStrings = mainOutput.split("\n");
    }

    @Test
    public void test07main() {
        Assert.assertFalse(out.toString().isEmpty());
    }

    @Test
    public void test0701() throws NoSuchMethodException
    {
        Method m = Task07.class.getDeclaredMethod("convertCelsiusToFahrenheit", int.class);
        Assert.assertTrue(Modifier.isPublic(m.getModifiers()));
        Assert.assertTrue(Modifier.isStatic(m.getModifiers()));
    }

    @Test
    public void test0702() throws NoSuchMethodException
    {
        Method m = Task07.class.getDeclaredMethod("convertCelsiusToFahrenheit", int.class);
        Assert.assertEquals(Double.TYPE, m.getReturnType());
    }

    @Test
    public void test0703()
    {
        Assert.assertEquals((9d / 5d) * 5 + 32d, Task07.convertCelsiusToFahrenheit(5), 0);
    }

    @Test
    public void test0704()
    {
        out.reset();
        Task07.convertCelsiusToFahrenheit(1);
        Assert.assertTrue(out.toString().isEmpty());
    }
}