package lesson01.part2;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import util.SystemOutGatewayUtil;

import java.io.ByteArrayOutputStream;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class Task05Test {

    @Test
    public void test05()
    {
        //TODO: main fields parsing
        SystemOutGatewayUtil.setCustomOut();
        ByteArrayOutputStream out = SystemOutGatewayUtil.getOutputArray();
        out.reset();

        Task05.main(null);
        Assert.assertTrue(out.toString().isEmpty());

        try {
            Assert.assertEquals(0, Task05.Cat.class.getDeclaredFields().length);
            Assert.assertEquals(0, Task05.Cat.class.getDeclaredMethods().length);
        }catch (Exception e)
        {
            Assert.fail("В классе Cat не должно быть переменных.\n" +
                    "В классе Cat не должно быть методов.");
        }
    }
}