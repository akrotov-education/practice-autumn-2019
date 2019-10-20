package lesson01.part2;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mockito;
import org.powermock.modules.junit4.PowerMockRunner;
import util.ClassReader;

import java.lang.reflect.Field;
import static org.mockito.Mockito.*;
import java.util.concurrent.ExecutionException;

import static org.junit.Assert.*;
@RunWith(JUnit4.class)
public class Task01Test {

    @Test
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
            boolean found = false;
            String clLine;
            while((clLine = cl.readLine()) !=null) {
                if (clLine.contains("Person person = new Person"))
                    found = true;
            }

            if(!found)
                throw new Exception();

        }
        catch (Exception e)
        {
            Assert.fail("неправильное создание объекта");
        }
    }
}