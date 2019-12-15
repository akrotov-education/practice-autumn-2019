package lesson05.part02;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class Task31Test {
    @Test
    public void checkPegasusImplements() {
        Assert.assertEquals("Class Pegasus must implements CanFly interface",
                "CanFly", Task31.Pegasus.class.getInterfaces()[0].getSimpleName());
    }

    @Test
    public void checkPegasusExtends() {
        Assert.assertEquals("Class Pegasus must extends from Horse class",
                "Horse", Task31.Pegasus.class.getSuperclass().getSimpleName());
    }

    @Test
    public void checkSwimmengPegasusExtends() {
        Assert.assertEquals("Class SwimmingPegasus must extends from Pegasus class",
                "Pegasus", Task31.SwimmingPegasus.class.getSuperclass().getSimpleName());
    }
}