package lesson01.part1;
//@FoLoKe
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import foloke.utils.SystemInGatewayUtil;
import util.SystemOutGatewayUtil;
import java.io.*;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

@RunWith(JUnit4.class)
public class Task08Test {

    /* 1. Программа не должна считывать данные с клавиатуры.
     * 2. Метод getMetreFromCentimetre(int) должен быть публичным и статическим.
     * 3. Метод getMetreFromCentimetre должен возвращать значение типа int.
     * 4. Метод getMetreFromCentimetre не должен ничего выводить на экран.
     * 5. Метод getMetreFromCentimetre должен правильно возвращать количество полных метров в centimetre.
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
    }

    @Test
    public void test0801() {
        try {
            SystemInGatewayUtil.setCustomIn("");
            Task08.main(null);
        } catch (Exception e) {
            Assert.fail("скажем нет входным данным товаргхищи!");
        }
    }


    @Test
    public void test08main() {
        Task08.main(null);
        Assert.assertFalse(out.toString().isEmpty());
    }


    @Test
    public void test0802() throws NoSuchMethodException
    {
        Method m = Task08.class.getDeclaredMethod("getMetreFromCentimetre", int.class);
        Assert.assertTrue(Modifier.isStatic(m.getModifiers()));
        Assert.assertTrue(Modifier.isPublic(m.getModifiers()));
    }

    @Test
    public void test0803() throws NoSuchMethodException
    {
        Method m = Task08.class.getDeclaredMethod("getMetreFromCentimetre", int.class);
        Assert.assertEquals(Integer.TYPE, m.getReturnType());
    }

    @Test
    public void test0804()
    {
        Assert.assertEquals((256 / 100), Task08.getMetreFromCentimetre(256));
    }

    @Test
    public void test0805()
    {
        out.reset();
        Assert.assertTrue(out.toString().isEmpty());
    }

}