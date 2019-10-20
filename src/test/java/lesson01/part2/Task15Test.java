package lesson01.part2;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.*;

@RunWith(PowerMockRunner.class)
@PrepareForTest(Task15.class)
public class Task15Test {

    static Task15.Man man;
    static Task15.Woman woman;


    @Test
    public void test15()
    {
        try {
            PowerMockito.mockStatic(Task15.Man.class);
            PowerMockito.whenNew(Task15.Man.class).withNoArguments().thenAnswer(new Answer<Object>() {
                @Override
                public Object answer(InvocationOnMock invocationOnMock) throws Throwable {
                   return man = new Task15.Man();
                }
            });

            PowerMockito.mockStatic(Task15.Woman.class);
            PowerMockito.whenNew(Task15.Woman.class).withNoArguments().thenAnswer(new Answer<Object>() {
                @Override
                public Object answer(InvocationOnMock invocationOnMock) throws Throwable {
                    return woman = new Task15.Woman();
                }
            });

            Task15.main(null);
            Assert.assertNotNull(man);
            Assert.assertNotNull(woman);

            Assert.assertEquals(woman, man.wife);
            Assert.assertEquals(man, woman.husband);
        }catch (Exception e)
        {
            Assert.fail("что-то явно не так..." + e.toString());
        }

    }
}