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
public class Task05Test {
    @Test
    public void test05()
    {
        Task05.main(null);
        //TODO: check var count
        try {
            Task05.Cat c = new Task05.Cat();
            Field f = Task05.Cat.class.getDeclaredField("catsCount");
            f.setAccessible(true);
            Assert.assertEquals(10, f.get(null));

        }
        catch (Exception e)
        {
            Assert.fail("name declaration is wrong");
        }


    }
}