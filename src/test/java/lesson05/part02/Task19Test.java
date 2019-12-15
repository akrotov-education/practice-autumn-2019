package lesson05.part02;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class Task19Test {
    @Test
    public void checkCanFlyInterface() {
        Class[] interfaces = Task19.class.getDeclaredClasses();
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
    public void checkCanRunInterface() {
        Class[] interfaces = Task19.class.getDeclaredClasses();
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
        Class[] interfaces = Task19.class.getDeclaredClasses();
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
    public void checkHuman() {
        Class[] humanInterfaces = Task19.Human.class.getInterfaces();
        if (humanInterfaces.length > 2) {
            Assert.fail("Human have to be able to run and swim");
        }

        int count = 0;
        for (Class humanInterface : humanInterfaces) {
            if (humanInterface.getSimpleName().equals("CanRun") ||
                humanInterface.getSimpleName().equals("CanSwim")) {
                count++;
            }
        }

        Assert.assertEquals("Human have to be able to run and swim",
                2, count);
    }

    @Test
    public void checkDuck() {
        Class[] duckInterfaces = Task19.Duck.class.getInterfaces();
        if (duckInterfaces.length > 3) {
            Assert.fail("Duck have to be able to run, fly and swim");
        }

        int count = 0;
        for (Class duckInterface : duckInterfaces) {
            if (duckInterface.getSimpleName().equals("CanRun") ||
                duckInterface.getSimpleName().equals("CanSwim") ||
                duckInterface.getSimpleName().equals("CanFly")) {
                count++;
            }
        }

        Assert.assertEquals("Duck have to be able to run, fly and swim",
                3, count);
    }

    @Test
    public void checkPenguin() {
        Class[] penguinInterfaces = Task19.Penguin.class.getInterfaces();
        if (penguinInterfaces.length > 2) {
            Assert.fail("Penguin have to be able to run and swim");
        }

        int count = 0;
        for (Class penguinInterface : penguinInterfaces) {
            if (penguinInterface.getSimpleName().equals("CanRun") ||
                penguinInterface.getSimpleName().equals("CanSwim")) {
                count++;
            }
        }

        Assert.assertEquals("Penguin have to be able to run and swim",
                2, count);
    }

    @Test
    public void checkAiplane() {
        Class[] airplaneInterfaces = Task19.Airplane.class.getInterfaces();
        if (airplaneInterfaces.length > 2) {
            Assert.fail("Airplane have to be able to run and fly");
        }

        int count = 0;
        for (Class airplaneInterface : airplaneInterfaces) {
            if (airplaneInterface.getSimpleName().equals("CanRun") ||
                airplaneInterface.getSimpleName().equals("CanFly")) {
                count++;
            }
        }

        Assert.assertEquals("Airplane have to be able to run and fly",
                2, count);
    }
}