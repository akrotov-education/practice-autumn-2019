package lesson01.part2;

import lesson02.part01.Task07;
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
import util.ClassReader;

import java.lang.reflect.Field;
import static org.mockito.Mockito.*;
import java.util.concurrent.ExecutionException;

import static org.junit.Assert.*;
@RunWith(PowerMockRunner.class)
public class Task01Test {

    static boolean crated = false;
    @Test
    @PrepareForTest(Task01.class)
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

        ClassReader cl = ClassReader.openClass(Task01.class);

        try
        {
            PowerMockito.mockStatic(Task01.Person.class);
            PowerMockito.whenNew(Task01.Person.class).withNoArguments().thenAnswer(new Answer<Object>() {
                @Override
                public Object answer(InvocationOnMock invocationOnMock) throws Throwable {
                    crated = true;
                    return new Task01.Person();
                }
            });

            Task01.main(null);

            Assert.assertTrue(crated);
        }
        catch (Exception e)
        {
            Assert.fail("неправильное создание объекта");
        }


    }
}