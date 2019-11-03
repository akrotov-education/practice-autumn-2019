package lesson01.part2;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;

import util.SystemOutGatewayUtil;

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
