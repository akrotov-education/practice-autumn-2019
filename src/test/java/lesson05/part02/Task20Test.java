package lesson05.part02;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.lang.reflect.Modifier;

@RunWith(JUnit4.class)
public class Task20Test {
    @Test
    public void checkCanRunInterface() {
        Class[] interfaces = Task20.class.getDeclaredClasses();
        boolean isContains = false;
        for (Class anInterface : interfaces) {
            if (anInterface.getSimpleName().equals("CanRun")) {
                try {
                    anInterface.getDeclaredMethod("run");
                    isContains = true;
                } catch (NoSuchMethodException e) {
                    isContains = false;
                }

                break;
            }
        }

        Assert.assertTrue("Class must contains CanRun interface with method run()",
                isContains);
    }

    @Test
    public void checkCanSwimInterface() {
        Class[] interfaces = Task20.class.getDeclaredClasses();
        boolean isContains = false;
        for (Class anInterface : interfaces) {
            if (anInterface.getSimpleName().equals("CanSwim")) {
                try {
                    anInterface.getDeclaredMethod("swim");
                    isContains = true;
                } catch (NoSuchMethodException e) {
                    isContains = false;
                }

                break;
            }
        }

        Assert.assertTrue("Class must contains CanSwim interface with method swim()",
                isContains);
    }

    @Test
    public void checkHumanClass() {
        Class[] interfaces = Task20.class.getDeclaredClasses();
        boolean isContains = false;
        for (Class anInterface : interfaces) {
            if (anInterface.getSimpleName().equals("Human")) {
                isContains = true;

                break;
            }
        }

        Assert.assertTrue("Class must contains Human class",
                isContains);
    }

    @Test
    public void checkHuman() {
        Class[] humanInterfaces = Task20.Human.class.getInterfaces();
        if (humanInterfaces.length > 2) {
            Assert.fail("Human should implements CanRun and CanSwim interfaces");
        }

        int count = 0;
        for (Class humanInterface : humanInterfaces) {
            if (humanInterface.getSimpleName().equals("CanRun") ||
                    humanInterface.getSimpleName().equals("CanSwim")) {
                count++;
            }
        }

        Assert.assertEquals("Human should implements CanRun and CanSwim interfaces",
                2, count);
    }

    @Test
    public void checkHumanAbstract() {
        int modifiers = Task20.Human.class.getModifiers();
        Assert.assertTrue("Class Human must be abstract",
                Modifier.toString(modifiers).contains("abstract"));
    }

    @Test
    public void checkHumanHaveNoMethods() {
        Assert.assertEquals("Class Human must have not contains methods",
                0, Task20.Human.class.getDeclaredMethods().length);
    }
}