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
public class Task04Test {
    @Test
    public void checkCatFields() {
        Field[] fields = Task04.Cat.class.getDeclaredFields();
        Assert.assertTrue("Класс Cat должен содержать только одну переменную catsCount",
                fields.length == 1 && fields[0].getName().contentEquals("catsCount"));
    }

    @Test
    public void checkCatsCountField() {
        try {
            Field field = Task04.Cat.class.getDeclaredField("catsCount");
            String modifier = Modifier.toString(field.getModifiers());
            String type = field.getType().toString();

            Assert.assertEquals("Переменная catsCount должна быть статической, иметь модификатор доступа private",
                    "private static", modifier);
            Assert.assertEquals("Переменная catsCount должна иметь тип int",
                    "int", type);
            field.setAccessible(true);
            int val = (int)field.get(null);
            Assert.assertEquals("Переменная catsCount должна быть проинициализирована нулем",
                    0, val);
        } catch (NoSuchFieldException e) {
        } catch (IllegalAccessException e) {
        }
    }

    @Test
    public void checkClassMethods() {
        Method[] methods = Task04.Cat.class.getDeclaredMethods();
        Assert.assertTrue("Класс Cat должен содержать два метода addNewCat и main",
                methods.length == 1 && methods[0].getName().contentEquals("addNewCat"));
    }

    @Test
    public void checkAddNewCatWork() {
        Task04.Cat.addNewCat();
        try {
            Field field = Task04.Cat.class.getDeclaredField("catsCount");
            field.setAccessible(true);
            int val = (int) field.get(null);

            Assert.assertEquals("Метод addNewCat класса Cat должен увеличивать количество котов на 1",
                    1, val);
        } catch (NoSuchFieldException e) {
        } catch (IllegalAccessException e) {
        }
    }
}