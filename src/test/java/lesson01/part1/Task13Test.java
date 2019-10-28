package lesson01.part1;
//@FolоКе
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
public class Task13Test {
    /* 1. Метод getWeight(int) должен быть публичным и статическим.
     * 2. Метод getWeight должен возвращать значение типа double.
     * 3. Метод getWeight не должен ничего выводить на экран.
     * 4. Метод getWeight должен правильно переводить вес тела в Ньютонах на Земле в вес этого же тела на Луне, и возвращать это значение.
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

        Task13.main(null);
        mainOutput = out.toString().trim();
        mainOutputStrings = mainOutput.split("\n");
    }

    @Test
    public void test13main() {
        Assert.assertFalse(mainOutput.isEmpty());
    }

    @Test
    public void test1301() throws Exception
    {
        Method m = Task13.class.getDeclaredMethod("getWeight", int.class);
        Assert.assertTrue(Modifier.isPublic(m.getModifiers()));
        Assert.assertTrue(Modifier.isStatic(m.getModifiers()));
    }

    @Test
    public void test1302() throws Exception
    {
        Method m = Task13.class.getDeclaredMethod("getWeight", int.class);
        Assert.assertEquals(Double.TYPE, m.getReturnType());
    }

    @Test
    public void test1303()
    {
        out.reset();
        Task13.getWeight(1);
        Assert.assertTrue(out.toString().isEmpty());
    }

    @Test
    public void test1304()
    {
        int earthWeight = 4;
        Assert.assertEquals(earthWeight * 0.17d, Task13.getWeight(earthWeight), 0);
    }
}