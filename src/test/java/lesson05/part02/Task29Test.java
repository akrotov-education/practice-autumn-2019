package lesson05.part02;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.lang.reflect.Modifier;

@RunWith(JUnit4.class)
public class Task29Test {
    @Test
    public void checkBusinessmanInterface() {
        Class[] interfaces = Task29.class.getDeclaredClasses();
        boolean isContains = false;
        for (Class anInterface : interfaces) {
            if (anInterface.getSimpleName().equals("Businessman")) {
                try {
                    anInterface.getDeclaredMethod("workHard");
                    isContains = true;
                } catch (NoSuchMethodException e) {
                    isContains = false;
                }

                break;
            }
        }

        Assert.assertTrue("Class must contains Businessman interface with method workHard()",
                isContains);
    }

    @Test
    public void checkCTOAbstract() {
        int modifiers = Task29.CTO.class.getModifiers();
        Assert.assertTrue("Class must contain non-abstract class CTO",
                !Modifier.toString(modifiers).contains("abstract"));
    }

    @Test
    public void checkCTOImplements() {
        Class[] interfaces = Task29.CTO.class.getInterfaces();
        Assert.assertEquals("Class must implements Businessman interface",
                "Businessman", interfaces[0].getSimpleName());
    }

    @Test
    public void ctoHaveNoMethods() {
        Assert.assertEquals("CTO class hasn't to have methods",
                0, Task29.CTO.class.getDeclaredMethods().length);
    }

    @Test
    public void checkExtraClassExists() {
        Assert.assertEquals("Class must contains extra class",
                3, Task29.class.getDeclaredClasses().length);
    }

    @Test
    public void checkExtendsOfExtraClass() {
        Assert.assertTrue("Class CTO must extends of extra class",
                !Task29.CTO.class.getSuperclass().getSimpleName().equals("Object"));
    }

    @Test
    public void checkExtraClass() {
        for (Class<?> aClass : Task29.class.getDeclaredClasses()) {
            if (aClass.getSimpleName().equals("Businessman") ||
                aClass.getSimpleName().equals("CTO")) {
                continue;
            }

            Assert.assertEquals("Extra class must contains only one method",
                    1, aClass.getDeclaredMethods().length);
        }
    }
}