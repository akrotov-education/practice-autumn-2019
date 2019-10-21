package test.java.lesson01.part2;

import main.java.lesson01.part2.Task15;
import org.junit.Assert;
import org.junit.Test;

public class Task15Test {

	@Test
	public void test() {
        Task15.main(null);

        try{
           Assert.assertEquals(3, Task15.Man.class.getDeclaredFields().length);
           Assert.assertEquals(3, Task15.Woman.class.getDeclaredFields().length);
        }catch (Exception e)
        {
            Assert.fail("В классе Man должно быть 3 поля.\n" +
                    "В классе Woman должно быть 3 поля.");
        }
	}

}
