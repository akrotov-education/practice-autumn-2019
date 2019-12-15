package lesson05.part02;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import util.SystemOutGatewayUtil;

import java.lang.reflect.Method;

public class Task23Test {
    @Before
    public void setUp() {
        SystemOutGatewayUtil.setCustomOut();
    }

    @After
    public void tearDown() {
        SystemOutGatewayUtil.setOriginalOut();
        SystemOutGatewayUtil.clearOutput();
    }

    @Test
    public void checkPetClass() {
        Class[] interfaces = Task23.class.getDeclaredClasses();
        boolean isContains = false;
        for (Class anInterface : interfaces) {
            if (anInterface.getSimpleName().equals("Pet")) {
                isContains = true;

                break;
            }
        }

        Assert.assertTrue("Class must contains Pet class",
                isContains);
    }

    @Test
    public void checkCatClass() {
        Class[] interfaces = Task23.class.getDeclaredClasses();
        boolean isContains = false;
        for (Class anInterface : interfaces) {
            if (anInterface.getSimpleName().equals("Cat")) {
                isContains = true;

                break;
            }
        }

        Assert.assertTrue("Class must contains Cat class",
                isContains);
    }

    @Test
    public void checkCatExtends() {
        Class parent = Task23.Cat.class.getSuperclass();
        Assert.assertEquals("Class Cat must extends from Pet",
                "Pet", parent.getSimpleName());
    }

    @Test
    public void checkPetMethods() {
        Method[] methods = Task23.Pet.class.getDeclaredMethods();
        if (methods.length != 2) {
            Assert.fail("Class Pet must contains getName() and setName() methods");
        }

        int count = 0;
        for (Method method : methods) {
            if (method.getName().equals("getName") ||
                    method.getName().equals("setName")) {
                count++;
            }
        }

        Assert.assertEquals("Class Pet must contains getName() and setName() methods",
                2, count);
    }

    @Test
    public void checkCatMethods() {
        Method[] methods = Task23.Cat.class.getDeclaredMethods();

        Assert.assertEquals("Class Cat should contains method",
                1, methods.length);
    }

    @Test
    public void checkOutput() {
        Task23.main(null);
        String output = SystemOutGatewayUtil.getOutputArray().toString();
        if (output.contains("\r\n")) {
            output = output.substring(0, output.length() - 2);
        } else if (output.contains("\n")) {
            output = output.substring(0, output.length() - 1);
        }

        Assert.assertEquals("Program must displays result of calling getName() of object pet",
                "", output);
    }
}