package lesson02.part02;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.*;

@RunWith(PowerMockRunner.class)
public class Task01Test {

    static int callCount;
    @Test
    @PrepareForTest(Task01.class)
    public void test01()
    {
        //TODO:
        Task01.Person person = new Task01.Person();
        person.adjustAge(20);
        Assert.assertEquals(40, person.age);


        try {
            //PowerMockito.mockStatic(Task01.Person.class);
            person = Mockito.mock(Task01.Person.class);
            PowerMockito.whenNew(Task01.Person.class).withNoArguments().thenReturn(person);
            PowerMockito.doAnswer(new Answer<Object>() {
                @Override
                public Void answer(InvocationOnMock invocationOnMock) throws Throwable {
                    callCount++;
                    return null;
                }
            }).when(person).adjustAge(Mockito.anyInt());


            Task01.main(null);
            Assert.assertEquals(1, callCount);
        }
        catch (Exception e)
        {
            Assert.fail("main is bad");
        }
    }
}