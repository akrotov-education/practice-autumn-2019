package lesson05.part02;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import util.SystemOutGatewayUtil;

import java.lang.reflect.Method;

@RunWith(JUnit4.class)
public class Task21Test {
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
        Class[] interfaces = Task21.class.getDeclaredClasses();
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
        Class[] interfaces = Task21.class.getDeclaredClasses();
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
        Class parent = Task21.Cat.class.getSuperclass();
        Assert.assertEquals("Class Cat must extends from Pet",
                "Pet", parent.getSimpleName());
    }

    @Test
    public void checkCatMethods() {
        Method[] methods = Task21.Cat.class.getDeclaredMethods();
        if (methods.length != 1) {
            Assert.fail("Class Cat must contains one method getName()");
        }

        Assert.assertEquals("Class Cat must contains one method getName()",
                "getName", methods[0].getName());
    }

    @Test
    public void checkPetMethods() {
        Method[] methods = Task21.Pet.class.getDeclaredMethods();
        if (methods.length != 1) {
            Assert.fail("Class Pet must contains one method getName()");
        }

        Assert.assertEquals("Class Pet must contains one method getName()",
                "getName", methods[0].getName());
    }

    @Test
    public void checkOutput() {
        Task21.main(null);
        String output = SystemOutGatewayUtil.getOutputArray().toString();
        Assert.assertTrue("Program must displays result of calling getName() of object pet",
                output.contains("Я - кот"));
    }
}