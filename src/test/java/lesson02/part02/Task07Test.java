package lesson02.part02;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.lang.reflect.Field;

import static org.junit.Assert.*;

@RunWith(PowerMockRunner.class)
public class Task07Test {
    static int catsCount;
    @Test
    @PrepareForTest(Task07.class)
    public void test07()
    {
        //TODO: check var count
        try {
            PowerMockito.mockStatic(Task07.Cat.class);
            PowerMockito.whenNew(Task07.Cat.class).withAnyArguments().thenAnswer(new Answer<Object>() {
                @Override
                public Void answer(InvocationOnMock invocationOnMock) throws Throwable {
                    catsCount++;
                    return null;
                }
            });

            Task07.main(null);
            Assert.assertEquals(catsCount, Task07.Cat.count);
        }
        catch (Exception e)
        {
            Assert.fail("something wrong...");
        }

    }
}