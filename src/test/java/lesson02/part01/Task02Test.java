package lesson02.part01;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import util.SystemOutGatewayUtil;

import java.io.ByteArrayOutputStream;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class Task02Test
{
    @Test
    public void test02()
    {
        //TODO: parse out printString calling from main
        SystemOutGatewayUtil.setCustomOut();
        ByteArrayOutputStream out = SystemOutGatewayUtil.getOutputArray();
        out.reset();

        Task02.main(null);
        Assert.assertEquals("Hello, Amigo!", out.toString().trim());

        try{
            Method m = Task02.class.getDeclaredMethod("printString", String.class);
            Assert.assertTrue(Modifier.isPublic(m.getModifiers()));
            Assert.assertTrue(Modifier.isStatic(m.getModifiers()));
            Assert.assertEquals(void.class, m.getReturnType());
        }catch (Exception e)
        {
            Assert.fail("что с методом?");
        }
    }
}