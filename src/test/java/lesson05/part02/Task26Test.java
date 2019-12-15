package lesson05.part02;

import org.junit.Assert;
import org.junit.Test;

public class Task26Test {
    @Test
    public void checkCanRunInterface() {
        Class[] interfaces = Task26.class.getDeclaredClasses();
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
    public void checkCanClimbInterface() {
        Class[] interfaces = Task26.class.getDeclaredClasses();
        boolean isContains = false;
        for (Class anInterface : interfaces) {
            if (anInterface.getSimpleName().equals("CanClimb")) {
                try {
                    anInterface.getDeclaredMethod("climb");
                    isContains = true;
                } catch (NoSuchMethodException e) {
                    isContains = false;
                }

                break;
            }
        }

        Assert.assertTrue("Class must contains CanClimb interface with method climb()",
                isContains);
    }

    @Test
    public void checkCanFlyInterface() {
        Class[] interfaces = Task26.class.getDeclaredClasses();
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
    public void checkCat() {
        Class[] catInterfaces = Task26.Cat.class.getInterfaces();
        if (catInterfaces.length > 2) {
            Assert.fail("Cat should implements CanRun and CanClimb interfaces");
        }

        int count = 0;
        for (Class catInterface : catInterfaces) {
            if (catInterface.getSimpleName().equals("CanRun") ||
                    catInterface.getSimpleName().equals("CanClimb")) {
                count++;
            }
        }

        Assert.assertEquals("Cat should implements CanRun and CanClimb interfaces",
                2, count);
    }

    @Test
    public void checkDog() {
        Class[] dogInterfaces = Task26.Dog.class.getInterfaces();
        if (dogInterfaces.length > 1) {
            Assert.fail("Dog should implements CanRun interface");
        }

        int count = 0;
        for (Class dogInterface : dogInterfaces) {
            if (dogInterface.getSimpleName().equals("CanRun")) {
                count++;
            }
        }

        Assert.assertEquals("Dog should implements CanRun interface",
                1, count);
    }

    @Test
    public void checkDuck() {
        Class[] duckInterfaces = Task26.Duck.class.getInterfaces();
        if (duckInterfaces.length > 2) {
            Assert.fail("Duck should implements CanRun, CanFly interfaces");
        }

        int count = 0;
        for (Class duckInterface : duckInterfaces) {
            if (duckInterface.getSimpleName().equals("CanRun") ||
                duckInterface.getSimpleName().equals("CanFly")) {
                count++;
            }
        }

        Assert.assertEquals("Duck should implements CanRun, CanFly interfaces",
                2, count);
    }

    @Test
    public void checkTigerExtendsCat() {
        String parent = Task26.Tiger.class.getSuperclass().getSimpleName();
        Assert.assertEquals("Tiger must extends of Cat class",
                "Cat", parent);
    }
}