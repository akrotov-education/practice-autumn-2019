package lesson01.part1;
//@FoLoKe
import com.sun.org.apache.xpath.internal.operations.Mod;
import foloke.utils.SystemInGatewayUtil;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import util.SystemOutGatewayUtil;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class Task11Test {
    /* 1. Метод getVolume(int, int, int) должен быть публичным и статическим.
     * 2. Метод getVolume(int, int, int) должен возвращать значение типа long.
     * 3. Метод getVolume(int, int, int) не должен ничего выводить на экран.
     * 4. Метод getVolume(int, int, int) должен правильно возвращать количество воды, которое необходимо для наполнения бассейна в литрах.
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

        Task11.main(null);
        mainOutput = out.toString().trim();
        mainOutputStrings = mainOutput.split("\n");
    }

    @Test
    public void test11main() {
        Assert.assertEquals("250000", mainOutput);
    }

    @Test
    public void test1101()
    {
        try {
            Class<?> innerClass = Task11.class.getDeclaredClasses()[0];

            Method m = innerClass.getDeclaredMethod("getVolume", int.class, int.class, int.class);
            Assert.assertTrue(Modifier.isStatic(m.getModifiers()));
            Assert.assertTrue(Modifier.isPublic(m.getModifiers()));
        } catch (Exception e) {
            Assert.fail("метод плох");
        }
    }

    @Test
    public void test1102()
    {
        try {
            Class<?> innerClass = Task11.class.getDeclaredClasses()[0];

            Method m = innerClass.getDeclaredMethod("getVolume", int.class, int.class, int.class);
            Assert.assertEquals(Long.TYPE, m.getReturnType());
        } catch (Exception e) {
            Assert.fail("метод плох");
        }
    }

    @Test
    public void test1103()
    {
        try {
            out.reset();
            Class<?> innerClass = Task11.class.getDeclaredClasses()[0];

            Method m = innerClass.getDeclaredMethod("getVolume", int.class, int.class, int.class);
            m.setAccessible(true);
            m.invoke(null ,1, 1, 1);

            Assert.assertTrue(out.toString().isEmpty());
        } catch(Exception e) {
            fail("метод плох");
        }
    }

    public void test1104()
    {
        try {
            out.reset();
            Class<?> innerClass = Task11.class.getDeclaredClasses()[0];

            Method m = innerClass.getDeclaredMethod("getVolume", int.class, int.class, int.class);
            m.setAccessible(true);

            Assert.assertEquals(2L, m.invoke(null ,1, 2, 1));
        } catch(Exception e) {
            fail("метод плох");
        }
    }
}