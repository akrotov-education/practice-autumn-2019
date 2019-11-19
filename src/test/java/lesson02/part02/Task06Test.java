package lesson02.part02;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.modules.junit4.PowerMockRunner;

import java.lang.reflect.Field;

import static org.junit.Assert.*;

@RunWith(PowerMockRunner.class)
public class Task06Test {
    @Test
    public void test04()
    {
        //TODO: check var count
        try {
            Task06.Cat c = new Task06.Cat();
            Field f = Task06.Cat.class.getDeclaredField("fullName");
            f.setAccessible(true);
            c.setName("Test", "Cat");
            Assert.assertTrue( f.get(c).equals("Test Cat") || f.get(c).equals("TestCat"));


        }
        catch (Exception e)
        {
            Assert.fail("name declaration is wrong");
        }

        Task06.main(null);
    }
}