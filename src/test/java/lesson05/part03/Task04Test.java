package lesson05.part03;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.lang.reflect.Method;

@RunWith(JUnit4.class)
public class Task04Test {
    @Test
    public void checkScreenImplementsSelectable() {
        boolean contains = false;
        for (Class<?> anInterface : Task04.Screen.class.getInterfaces()) {
            if (anInterface.getSimpleName().equals("Selectable")) {
                contains = true;
            }
        }
        Assert.assertTrue("Screen must implements Selectable interface",
                contains);
    }

    @Test
    public void checkScreenImplementsUpdatable() {
        boolean contains = false;
        for (Class<?> anInterface : Task04.Screen.class.getInterfaces()) {
            if (anInterface.getSimpleName().equals("Updatable")) {
                contains = true;
            }
        }
        Assert.assertTrue("Screen must implements Updatable interface",
                contains);
    }

    @Test
    public void screenContainsSelectableMethods() {
        int count = 0;
        for (Method declaredMethod : Task04.Screen.class.getDeclaredMethods()) {
            if (declaredMethod.getName().equals("onSelect")) {
                count++;
            }
        }

        Assert.assertEquals("Class Screen must contains methods from Selectable interface",
                1, count);
    }

    @Test
    public void screenContainsUpdatableMethods() {
        int count = 0;
        for (Method declaredMethod : Task04.Screen.class.getDeclaredMethods()) {
            if (declaredMethod.getName().equals("refresh")) {
                count++;
            }
        }

        Assert.assertEquals("Class Screen must contains methods from Updatable interface",
                1, count);
    }
}