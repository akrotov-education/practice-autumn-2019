package test.java.lesson02.part01;

import main.java.lesson02.part01.Task11;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import test.java.util.SystemOutGatewayUtil;

import java.io.ByteArrayOutputStream;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class Task11Test {
    @Test
    public void test11()
    {
        SystemOutGatewayUtil.setCustomOut();
        ByteArrayOutputStream out = SystemOutGatewayUtil.getOutputArray();
        out.reset();

        try{
            Method m = Task11.class.getDeclaredMethod("convertToSeconds", int.class);
            Assert.assertTrue(Modifier.isPublic(m.getModifiers()));
            Assert.assertTrue(Modifier.isStatic(m.getModifiers()));
            Assert.assertEquals(Integer.TYPE, m.getReturnType());
            int result = (int)m.invoke(null, 2);
            Assert.assertEquals(60 * 60 * 2, result);
            Assert.assertTrue(out.toString().isEmpty());
        }catch (Exception e)
        {
            Assert.fail("что с методом?");
        }

        out.reset();
        Task11.main(null);
        String[] output = out.toString().trim().split("\n");
        Assert.assertEquals(2, output.length);
        Assert.assertTrue(output[0].trim().matches("\\d+"));
        Assert.assertTrue(output[1].trim().matches("\\d+"));
    }
}