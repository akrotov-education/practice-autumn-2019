package test.java.lesson01.part2;

import main.java.lesson01.part2.Task01;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import test.java.util.ClassReader;

import java.lang.reflect.Field;
import java.util.concurrent.ExecutionException;

import static org.junit.Assert.*;
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