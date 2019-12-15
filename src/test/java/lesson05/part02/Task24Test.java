package lesson05.part02;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class Task24Test {
    @Test
    public void checkClasses() {
        Class[] interfaces = Task24.class.getDeclaredClasses();
        int count = 0;
        for (Class anInterface : interfaces) {
            if (anInterface.getSimpleName().equals("Cat") ||
                anInterface.getSimpleName().equals("Tiger") ||
                anInterface.getSimpleName().equals("Lion") ||
                anInterface.getSimpleName().equals("Bull") ||
                anInterface.getSimpleName().equals("Pig")) {
                count++;
            }
        }

        Assert.assertEquals("Class must contains Cat, Tiger, Lion, Bull and Pig classes",
                5, count);
    }

    @Test
    public void checkMethodExist() {
        try {
            Task24.class.getDeclaredMethod("getObjectType", Object.class);
        } catch (NoSuchMethodException e) {
            Assert.fail("Class must contains method getObjectType(Object)");
        }
    }

    @Test
    public void checkOutputCat() {
        String out = Task24.getObjectType(new Task24.Cat());
        Assert.assertEquals("getObjectType must return 'Кот'",
                "Кот", out);
    }

    @Test
    public void checkOutputTiger() {
        String out = Task24.getObjectType(new Task24.Tiger());
        Assert.assertEquals("getObjectType must return 'Тигр'",
                "Тигр", out);
    }

    @Test
    public void checkOutputLion() {
        String out = Task24.getObjectType(new Task24.Lion());
        Assert.assertEquals("getObjectType must return 'Лев'",
                "Лев", out);
    }

    @Test
    public void checkOutputBull() {
        String out = Task24.getObjectType(new Task24.Bull());
        Assert.assertEquals("getObjectType must return 'Бык'",
                "Бык", out);
    }

    @Test
    public void checkOutputPig() {
        String out = Task24.getObjectType(new Task24.Pig());
        Assert.assertEquals("getObjectType must return 'Животное'",
                "Животное", out);
    }
}