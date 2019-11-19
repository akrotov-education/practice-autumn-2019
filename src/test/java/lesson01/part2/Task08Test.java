package lesson01.part2;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import util.SystemOutGatewayUtil;

import java.io.ByteArrayOutputStream;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class Task08Test {

    @Test
    public void test()
    {
        //TODO: main fields parsing
        SystemOutGatewayUtil.setCustomOut();
        ByteArrayOutputStream out = SystemOutGatewayUtil.getOutputArray();
        out.reset();
        Task08.main(null);

        Assert.assertTrue(out.toString().isEmpty());

        try{
           Assert.assertEquals(0, Task08.Cat.class.getDeclaredMethods().length);
           Assert.assertEquals(0, Task08.Cat.class.getDeclaredFields().length);
        }catch (Exception e)
        {
            Assert.fail("В классе Cat не должно быть переменных.\n" +
                    "В классе Cat не должно быть методов.");
        }

    }
}