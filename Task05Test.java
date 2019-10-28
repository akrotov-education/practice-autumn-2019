package lesson02.part02;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class Task05Test {
    @Test
    public void checkCatFields() {
        Field[] fields = Task05.Cat.class.getDeclaredFields();

        Assert.assertTrue("Class Cat must contain only one field 'catsCount'",
                fields.length == 1 && fields[0].getName().contentEquals("catsCount")
        );
    }

    @Test
    public void checkCatsCountField() {
        try {
            Field field = Task05.Cat.class.getDeclaredField("catsCount");
            String modifier = Modifier.toString(field.getModifiers());
            String type = field.getType().toString();

            Assert.assertEquals("Field catsCount must be private and static",
                    "private static",
                    modifier
            );
            Assert.assertEquals("Field catsCount must have int type",
                    "int",
                    type
            );

            field.setAccessible(true);
            int val = (int)field.get(null);
            Assert.assertEquals("Field catsCount must be initialized with value 0",
                    0,
                    val
            );
        } catch (NoSuchFieldException e) {
            Assert.fail("Class Cat doesn't contain catsCount field");
        } catch (IllegalAccessException e) {
            Assert.fail("Can't get access to field");
        }
    }

    @Test
    public void checkClassMethods() {
        Method[] methods = Task05.Cat.class.getDeclaredMethods();

        Assert.assertTrue("Class Cat must contain only one method setCatsCount",
                methods.length == 1 && methods[0].getName().contentEquals("setCatsCount")
        );
    }

    @Test
    public void checkSetCatsCountWork() {
        Task05.Cat.setCatsCount(10);
        try {
            Field field = Task05.Cat.class.getDeclaredField("catsCount");
            field.setAccessible(true);
            int val = (int) field.get(null);

            Assert.assertEquals("Method setCatsCount should set value of field catsCount equals transmitted parameter",
                    10,
                    val
            );
        } catch (NoSuchFieldException e) {
            Assert.fail("Class Cat doesn't contain catsCount field");
        } catch (IllegalAccessException e) {
            Assert.fail("Can't get access to field");
        }
    }
}