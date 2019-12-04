package lesson01.part2;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.lang.reflect.Field;

@RunWith(JUnit4.class)

public class Task01Test {

    @Test
    public void testCreateFields(){

        Class<Task01.Person> personClass = Task01.Person.class;

        Field[] declaredFields = personClass.getDeclaredFields();

        for (Field declaredField : declaredFields) {
            System.out.println(declaredField.getName());
        }
    }
}