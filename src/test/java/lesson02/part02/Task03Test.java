package lesson02.part02;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import util.SystemInGatewayUtil;
import util.SystemOutGatewayUtil;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class Task03Test {
    @Test
    public void test03()
    {
        SystemOutGatewayUtil.setCustomOut();
        ByteArrayOutputStream out = SystemOutGatewayUtil.getOutputArray();
        out.reset();

        try {


            Task03.Cat c = new Task03.Cat();
            c.setName("s");
            Field f = Task03.Cat.class.getDeclaredField("name");
            f.setAccessible(true);
            Assert.assertEquals("s", f.get(c));
        }
        catch (Exception e)
        {
            Assert.fail("name declaration is wrong");
        }

        Task03.main(null);
        Assert.assertEquals("Жужик", out.toString().trim());
    }
}