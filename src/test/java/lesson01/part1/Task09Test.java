package lesson01.part1;
//@FоLoKe
import foloke.utils.SystemInGatewayUtil;
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
public class Task09Test {
    /* 1. Программа не должна считывать данные с клавиатуры.
     * 2. Метод sumDigitsInNumber(int) должен быть публичным и статическим.
     * 3. Метод sumDigitsInNumber должен возвращать значение типа int.
     * 4. Метод sumDigitsInNumber не должен ничего выводить на экран.
     * 5. Метод sumDigitsInNumber должен правильно возвращать сумму всех цифр в числе number.
     */
    private static ByteArrayOutputStream out;

    @Before
    public void init() {
        SystemOutGatewayUtil.setCustomOut();
        out = SystemOutGatewayUtil.getOutputArray();
        out.reset();
    }

    @Test
    public void test0901()
    {
        try {
            SystemInGatewayUtil.setCustomIn("");
            Task08.main(null);
        } catch (Exception e) {
            Assert.fail("скажем нет входным данным товаргхищи!");
        }
    }

    @Test
    public void test09main() {
        out.reset();
        Task09.main(null);
        Assert.assertFalse(out.toString().isEmpty());
    }

    @Test
    public void test0902() throws NoSuchMethodException
    {
        Method m = Task09.class.getDeclaredMethod("sumDigitsInNumber", int.class);
        Assert.assertTrue(Modifier.isPublic(m.getModifiers()));
        Assert.assertTrue(Modifier.isStatic(m.getModifiers()));
    }

    @Test
    public void test0903() throws NoSuchMethodException
    {
        Method m = Task09.class.getDeclaredMethod("sumDigitsInNumber", int.class);
        Assert.assertEquals(Integer.TYPE, m.getReturnType());
    }

    @Test
    public void test0904()
    {
        out.reset();
        Task09.sumDigitsInNumber(0);
        Assert.assertTrue(out.toString().isEmpty());
    }

    @Test
    public void  test0905()
    {
        Assert.assertEquals(11,Task09.sumDigitsInNumber(542));
    }
}