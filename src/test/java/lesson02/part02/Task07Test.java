package test.java.lesson02.part02;

import main.java.lesson02.part02.Task07;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;


import java.lang.reflect.Field;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class Task07Test {
    static int catsCount;
    @Test
    public void test07()
    {


            Task07.main(null);
            Assert.assertEquals(2, Task07.Cat.count);



    }
}