package test.java.lesson02.part02;

import main.java.lesson02.part02.Task04;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;


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