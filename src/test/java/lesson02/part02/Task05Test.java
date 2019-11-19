package lesson02.part02;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.modules.junit4.PowerMockRunner;

import java.lang.reflect.Field;

import static org.junit.Assert.*;

@RunWith(PowerMockRunner.class)
public class Task05Test {
    @Test
    public void test05()
    {
        //TODO: check var count
        try {
            Task05.Cat c = new Task05.Cat();
            Field f = Task05.Cat.class.getDeclaredField("catsCount");
            f.setAccessible(true);
            Task05.Cat.setCatsCount(3);
            Assert.assertEquals(3, f.get(null));
            Task05.Cat.setCatsCount(1);
            Assert.assertEquals(1, f.get(null));

        }
        catch (Exception e)
        {
            Assert.fail("name declaration is wrong");
        }

        Task05.main(null);
    }
}