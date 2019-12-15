package lesson05.part02;

import org.junit.Assert;
import org.junit.Test;

public class Task28Test {
    @Test
    public void checkWorkerInterface() {
        Class[] interfaces = Task28.class.getDeclaredClasses();
        boolean isContains = false;
        for (Class anInterface : interfaces) {
            if (anInterface.getSimpleName().equals("Worker")) {
                try {
                    anInterface.getDeclaredMethod("workLazy");
                    isContains = true;
                } catch (NoSuchMethodException e) {
                    isContains = false;
                }

                break;
            }
        }

        Assert.assertTrue("Class must contains Worker interface with method workLazy()",
                isContains);
    }

    @Test
    public void checkBusinessmanInterface() {
        Class[] interfaces = Task28.class.getDeclaredClasses();
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
    public void checkSecretaryInterface() {
        Class[] interfaces = Task28.class.getDeclaredClasses();
        boolean isContains = false;
        for (Class anInterface : interfaces) {
            if (anInterface.getSimpleName().equals("Secretary")) {
                try {
                    anInterface.getDeclaredMethod("workLazy");
                    isContains = true;
                } catch (NoSuchMethodException e) {
                    isContains = false;
                }

                break;
            }
        }

        Assert.assertTrue("Class must contains Secretary interface with method workLazy()",
                isContains);
    }

    @Test
    public void checkMinerInterface() {
        Class[] interfaces = Task28.class.getDeclaredClasses();
        boolean isContains = false;
        for (Class anInterface : interfaces) {
            if (anInterface.getSimpleName().equals("Miner")) {
                try {
                    anInterface.getDeclaredMethod("workVeryHard");
                    isContains = true;
                } catch (NoSuchMethodException e) {
                    isContains = false;
                }

                break;
            }
        }

        Assert.assertTrue("Class must contains Miner interface with method workVeryHard()",
                isContains);
    }

    @Test
    public void checkHumanClass() {
        Class[] interfaces = Task28.class.getDeclaredClasses();
        boolean isContains = false;
        for (Class anInterface : interfaces) {
            if (anInterface.getSimpleName().equals("Human")) {
                try {
                    anInterface.getDeclaredMethod("workLazy");
                    anInterface.getDeclaredMethod("workHard");
                    isContains = true;
                } catch (NoSuchMethodException e) {
                    isContains = false;
                }

                break;
            }
        }

        Assert.assertTrue("Class must contains Human interface with method workLazy() and workHard()",
                isContains);
    }

    @Test
    public void checkHuman() {
        Class[] humanInterfaces = Task28.Human.class.getInterfaces();

        Assert.assertEquals("Penguin should implements CanRun and CanSwim interfaces",
                3, humanInterfaces.length);
    }
}