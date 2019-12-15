package lesson05.part02;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class Task32Test {
    @Test
    public void checkCanFlyInterface() {
        Class[] interfaces = Task32.class.getDeclaredClasses();
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
    public void checkBusinessmanInterface() {
        Class[] interfaces = Task32.class.getDeclaredClasses();
        boolean isContains = false;
        for (Class anInterface : interfaces) {
            if (anInterface.getSimpleName().equals("Horse")) {
                try {
                    anInterface.getDeclaredMethod("run");
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
    public void checkPegasusExists() {
        Class[] interfaces = Task32.class.getDeclaredClasses();
        boolean isContains = false;
        for (Class anInterface : interfaces) {
            if (anInterface.getSimpleName().equals("Pegasus")) {
                isContains = true;

                break;
            }
        }

        Assert.assertTrue("Class must contains Pegasus class",
                isContains);
    }

    @Test
    public void checkPegasusExtends() {
        Assert.assertEquals("Class Pegasus must extends from Horse class",
                "Horse", Task32.Pegasus.class.getSuperclass().getSimpleName());
    }

    @Test
    public void checkPegasusImplements() {
        Assert.assertEquals("Class Pegasus must implements CanFly interface",
                "CanFly", Task32.Pegasus.class.getInterfaces()[0].getSimpleName());
    }
}