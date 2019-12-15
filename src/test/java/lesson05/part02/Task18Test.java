package lesson05.part02;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class Task18Test {
    @Test
    public void checkCanFlyInterface() {
        Class[] interfaces = Task18.class.getDeclaredClasses();
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
    public void checkCanMoveInterface() {
        Class[] interfaces = Task18.class.getDeclaredClasses();
        boolean isContains = false;
        for (Class anInterface : interfaces) {
            if (anInterface.getSimpleName().equals("CanMove")) {
                try {
                    anInterface.getDeclaredMethod("move");
                    isContains = true;
                } catch (NoSuchMethodException e) {
                    isContains = false;
                }

                break;
            }
        }

        Assert.assertTrue("Class must contains CanMove interface with method move()",
                isContains);
    }

    @Test
    public void checkCanEatInterface() {
        Class[] interfaces = Task18.class.getDeclaredClasses();
        boolean isContains = false;
        for (Class anInterface : interfaces) {
            if (anInterface.getSimpleName().equals("CanEat")) {
                try {
                    anInterface.getDeclaredMethod("eat");
                    isContains = true;
                } catch (NoSuchMethodException e) {
                    isContains = false;
                }

                break;
            }
        }

        Assert.assertTrue("Class must contains CanEat interface with method eat()",
                isContains);
    }

    @Test
    public void checkDog() {
        Class[] dogInterfaces = Task18.Dog.class.getInterfaces();
        if (dogInterfaces.length > 2) {
            Assert.fail("Dog have to be able to move and eat");
        }

        int count = 0;
        for (Class dogInterface : dogInterfaces) {
            if (dogInterface.getSimpleName().equals("CanMove") ||
                dogInterface.getSimpleName().equals("CanEat")) {
                count++;
            }
        }

        Assert.assertEquals("Dog have to be able to move and eat",
                2, count);
    }

    @Test
    public void checkCar() {
        Class[] carInterfaces = Task18.Car.class.getInterfaces();
        if (carInterfaces.length > 1) {
            Assert.fail("Car have to be able to move");
        }

        int count = 0;
        for (Class carInterface : carInterfaces) {
            if (carInterface.getSimpleName().equals("CanMove")) {
                count++;
            }
        }

        Assert.assertEquals("Car have to be able to move",
                1, count);
    }

    @Test
    public void checkAirplane() {
        Class[] airplaneInterfaces = Task18.Airplane.class.getInterfaces();
        if (airplaneInterfaces.length > 2) {
            Assert.fail("Airplane have to be able to move and fly");
        }

        int count = 0;
        for (Class airplaneInterface : airplaneInterfaces) {
            if (airplaneInterface.getSimpleName().equals("CanMove") ||
                airplaneInterface.getSimpleName().equals("CanFly")) {
                count++;
            }
        }

        Assert.assertEquals("Airplane have to be able to move and fly",
                2, count);
    }

    @Test
    public void checkDuck() {
        Class[] duckInterfaces = Task18.Duck.class.getInterfaces();
        if (duckInterfaces.length > 3) {
            Assert.fail("Duck have to be able to move, eat and fly");
        }

        int count = 0;
        for (Class duckInterface : duckInterfaces) {
            if (duckInterface.getSimpleName().equals("CanMove") ||
                duckInterface.getSimpleName().equals("CanFly") ||
                duckInterface.getSimpleName().equals("CanEat")) {
                count++;
            }
        }

        Assert.assertEquals("Duck  have to be able to move, eat and fly",
                3, count);
    }
}