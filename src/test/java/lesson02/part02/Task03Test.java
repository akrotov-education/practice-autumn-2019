package lesson02.part02;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class Task03Test {
    @Test
    public void checkClassFields() {
        Task03.Cat cat = new Task03.Cat();
        Field[] fields = cat.getClass().getDeclaredFields();

        Assert.assertTrue("Class Cat must contain only one field 'name'",
                fields.length == 1 && fields[0].toString().contains("name")
        );
    }

    @Test
    public void checkFieldName() {
        Task03.Cat cat = new Task03.Cat();
        try {
            Field field = cat.getClass().getDeclaredField("name");
            Assert.assertTrue("Field 'name' must be private and have String type",
                    field.toString().contains("private") && field.toString().contains("String")
            );
        } catch (NoSuchFieldException e) {
            Assert.fail("Class Cat doesn't have field name");
        }
    }

    @Test
    public void checkClassMethods() {
        Method[] methods = Task03.Cat.class.getDeclaredMethods();

        Assert.assertTrue("Class Cat must contain only one method setName",
                methods.length == 2 && methods[1].getName().contentEquals("setName")
        );
    }

    @Test
    public void checkSetNameWork() {
        Task03.Cat cat = new Task03.Cat();
        cat.setName("Kek");

        try {
            Field f = cat.getClass().getDeclaredField("name"); //NoSuchFieldException
            f.setAccessible(true);

            String val = (String)f.get(cat);
            Assert.assertEquals("Method setName should set name from transmitted parameter",
                    "Kek",
                    val
            );
        } catch (NoSuchFieldException e) {
            Assert.fail("Class doesn't contain field name");
        } catch (IllegalAccessException e) {
            Assert.fail("Can't get access to private field");
        }
    }
}