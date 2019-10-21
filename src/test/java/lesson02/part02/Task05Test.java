package test.java.lesson02.part02;

import main.java.lesson02.part02.Task05;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;


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