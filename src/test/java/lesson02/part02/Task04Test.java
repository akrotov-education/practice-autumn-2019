package lesson02.part02;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.modules.junit4.PowerMockRunner;

import java.lang.reflect.Field;

import static org.junit.Assert.*;

@RunWith(PowerMockRunner.class)
public class Task04Test {
    @Test
    public void test04()
    {
        //TODO: check var count
        try {
            Task04.Cat.addNewCat();
            Task04.Cat.addNewCat();
            Field f = Task04.Cat.class.getDeclaredField("catsCount");
            f.setAccessible(true);
            Assert.assertEquals(2, f.get(null));
        }
        catch (Exception e)
        {
            Assert.fail("name declaration is wrong");
        }

        Task04.main(null);
    }
}