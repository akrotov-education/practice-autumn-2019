package lesson01.part1;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import util.SystemOutGatewayUtil;

import java.io.ByteArrayOutputStream;
import java.lang.reflect.Method;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class Task11Test {

    //TODO: privateClass
    @Test
    public void main() {
        SystemOutGatewayUtil.setCustomOut();
        ByteArrayOutputStream out = SystemOutGatewayUtil.getOutputArray();

        Task11.main(null);

        Assert.assertEquals("1250000", out.toString().trim());

        Class[] a = Task11.class.getDeclaredClasses();
        try {
            Method m = a[0].getDeclaredMethod("getVolume", int.class, int.class, int.class);
            long result = (long)m.invoke(a[0].newInstance(),1,1,1);
            Assert.assertEquals(1250000, result);
        }
        catch(Exception e)
        {
            System.out.println(e.toString());
        }
        //Assert.assertEquals();

        out.reset();
    }
}