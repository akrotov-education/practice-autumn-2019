package lesson01.part2;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import util.SystemOutGatewayUtil;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
@RunWith(JUnit4.class)
public class Task01Test {

    static boolean crated = false;
    @Test
    public void test01()
    {
        try {
            Field name = Task01.Person.class.getDeclaredField("name");
            Assert.assertEquals(String.class, name.getType());

            Field age = Task01.Person.class.getDeclaredField("age");
            Assert.assertEquals(Integer.TYPE, age.getType());

            Field weight = Task01.Person.class.getDeclaredField("money");
            Assert.assertEquals(Integer.TYPE, weight.getType());

        }
        catch (Exception e)
        {
            System.out.println(e);
            Assert.fail("no variable");
        }



    }
}