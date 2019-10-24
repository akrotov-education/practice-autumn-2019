package lesson01.part1;
//@FoLoKe
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

        Task10.main(null);
        mainOutput = out.toString().trim();
        mainOutputStrings = mainOutput.split("\n");
    }

    @Test
    public void test11main() {
        Assert.assertEquals("1250000", mainOutput);
    }

    @Test
    public void test1101() throws Exception
    {
        //TODO: can't check not static methods of private inner class without default constructor
        try {
            Class<?> innerClass = Task11.class.getDeclaredClasses()[0];
            //innerClass.ge
            Constructor<?>[] c;// = innerClass.getConstructors();
            //c[0].setAccessible(true);
            //c.setAccessible(true);
            Object obj = innerClass.newInstance();

            Method m = innerClass.getDeclaredMethod("getVolume", int.class, int.class, int.class);
            m.setAccessible(true);
            long result = (long)m.invoke(innerClass.newInstance() ,1, 1, 1);
            //Assert.assertEquals(1250000, result);
        } catch(NoSuchMethodException e) {
            fail("метод плох");
        } catch (IllegalAccessException e){
            fail("метод плох 2");
        } catch (InvocationTargetException e){
            fail("метод плох 3");
        }
    }
}