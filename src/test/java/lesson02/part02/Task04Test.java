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
public class Task04Test {
    @Test
    public void test04()
    {
        //TODO: check var count
        Task04.main(null);
        try {
            Field f = Task04.Cat.class.getDeclaredField("catsCount");
            f.setAccessible(true);
            Assert.assertEquals(2, f.get(null));
        }
        catch (Exception e)
        {
            Assert.fail("name declaration is wrong");
        }


    }
}