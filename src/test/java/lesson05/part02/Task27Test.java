package lesson05.part02;

import org.junit.Assert;
import org.junit.Test;

public class Task27Test {
    @Test
    public void checkCanRunInterface() {
        Class[] interfaces = Task27.class.getDeclaredClasses();
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
        Class[] interfaces = Task27.class.getDeclaredClasses();
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
    public void checkCanFlyInterface() {
        Class[] interfaces = Task27.class.getDeclaredClasses();
        boolean isContains = false;
        for (Class anInterface : interfaces) {
            if (anInterface.getSimpleName().equals("CanFly")) {
                try {
                    anInterface.getDeclaredMethod("fly");
                    isContains = true;
                } catch (NoSuchMethodException e) {
                    isContains = false;
                }

                break;
            }
        }

        Assert.assertTrue("Class must contains CanFly interface with method fly()",
                isContains);
    }

    @Test
    public void checkClassesExist() {
        Class[] classes = Task27.class.getDeclaredClasses();
        int count = 0;
        for (Class aClass : classes) {
            if (aClass.getSimpleName().equals("Duck") ||
                aClass.getSimpleName().equals("Penguin") ||
                aClass.getSimpleName().equals("Toad")) {
                count++;
            }
        }

        Assert.assertEquals("Class must contains Duck, Penguin and Toad classes",
                3, count);
    }

    @Test
    public void checkPenguin() {
        Class[] penguinInterfaces = Task27.Penguin.class.getInterfaces();
        if (penguinInterfaces.length > 2) {
            Assert.fail("Penguin should implements CanRun and CanSwim interfaces");
        }

        int count = 0;
        for (Class penguinInterface : penguinInterfaces) {
            if (penguinInterface.getSimpleName().equals("CanRun") ||
                penguinInterface.getSimpleName().equals("CanSwim")) {
                count++;
            }
        }

        Assert.assertEquals("Penguin should implements CanRun and CanSwim interfaces",
                2, count);
    }

    @Test
    public void checkToad() {
        Class[] toadInterfaces = Task27.Toad.class.getInterfaces();
        if (toadInterfaces.length > 1) {
            Assert.fail("Toad should implements CanSwim interface");
        }

        int count = 0;
        for (Class toadInterface : toadInterfaces) {
            if (toadInterface.getSimpleName().equals("CanSwim")) {
                count++;
            }
        }

        Assert.assertEquals("Toad should implements CanSwim interface",
                1, count);
    }

    @Test
    public void checkDuck() {
        Class[] duckInterfaces = Task27.Duck.class.getInterfaces();
        if (duckInterfaces.length > 3) {
            Assert.fail("Duck should implements CanRun, CanFly, CanSwim interfaces");
        }

        int count = 0;
        for (Class duckInterface : duckInterfaces) {
            if (duckInterface.getSimpleName().equals("CanRun") ||
                duckInterface.getSimpleName().equals("CanFly") ||
                duckInterface.getSimpleName().equals("CanSwim")) {
                count++;
            }
        }

        Assert.assertEquals("Duck should implements CanRun, CanFly, CanSwim interfaces",
                3, count);
    }
}