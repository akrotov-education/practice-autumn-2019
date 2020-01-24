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
        Assert.assertTrue("Класс Cat должен содержать только одну переменную name",
                fields.length == 1 && fields[0].toString().contains("name"));
    }

    @Test
    public void checkFieldName() {
        Task03.Cat cat = new Task03.Cat();
        try {
            Field field = cat.getClass().getDeclaredField("name");
            Assert.assertTrue("Переменная name должна иметь модификатор доступа private и тип String",
                    field.toString().contains("private") && field.toString().contains("String"));
        } catch (NoSuchFieldException e) {
        }
    }

    @Test
    public void checkClassMethods() {
        Method[] methods = Task03.Cat.class.getDeclaredMethods();
        Assert.assertTrue("Класс Cat должен содержать только два метода setName и main",
                methods.length == 2 && methods[1].getName().contentEquals("setName"));
    }

    @Test
    public void checkSetNameWork() {
        Task03.Cat cat = new Task03.Cat();
        cat.setName("meow");
        try {
            Field f = cat.getClass().getDeclaredField("name"); //NoSuchFieldException
            f.setAccessible(true);
            String val = (String)f.get(cat);
            Assert.assertEquals("Метод setName класса Cat должен устанавливать значение переменной private String name равным переданному параметру String name.",
                    "meow",
                    val
            );
        } catch (NoSuchFieldException e) {
            Assert.fail("Класс не содержит name");
        } catch (IllegalAccessException e) {
            Assert.fail("Can't get access to private field");
        }
    }
}