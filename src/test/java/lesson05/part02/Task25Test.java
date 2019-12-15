package lesson05.part02;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class Task25Test {
    @Test
    public void checkClasses() {
        Class[] interfaces = Task25.class.getDeclaredClasses();
        int count = 0;
        for (Class anInterface : interfaces) {
            if (anInterface.getSimpleName().equals("Cat") ||
                anInterface.getSimpleName().equals("Tiger") ||
                anInterface.getSimpleName().equals("Lion") ||
                anInterface.getSimpleName().equals("Bull") ||
                anInterface.getSimpleName().equals("Cow") ||
                anInterface.getSimpleName().equals("Animal")) {
                count++;
            }
        }

        Assert.assertEquals("Class must contains Cat, Tiger, Lion, Bull, Cow, Animal classes",
                6, count);
    }

    @Test
    public void checkMethodExist() {
        try {
            Task25.class.getDeclaredMethod("getObjectType", Object.class);
        } catch (NoSuchMethodException e) {
            Assert.fail("Class must contains method getObjectType(Object)");
        }
    }

    @Test
    public void checkOutputCat() {
        String out = Task25.getObjectType(new Task25.Cat());
        Assert.assertEquals("getObjectType must return 'Кот'",
                "Кот", out);
    }

    @Test
    public void checkOutputTiger() {
        String out = Task25.getObjectType(new Task25.Tiger());
        Assert.assertEquals("getObjectType must return 'Тигр'",
                "Тигр", out);
    }

    @Test
    public void checkOutputLion() {
        String out = Task25.getObjectType(new Task25.Lion());
        Assert.assertEquals("getObjectType must return 'Лев'",
                "Лев", out);
    }

    @Test
    public void checkOutputBull() {
        String out = Task25.getObjectType(new Task25.Bull());
        Assert.assertEquals("getObjectType must return 'Бык'",
                "Бык", out);
    }

    @Test
    public void checkOutputCow() {
        String out = Task25.getObjectType(new Task25.Cow());
        Assert.assertEquals("getObjectType must return 'Корова'",
                "Корова", out);
    }

    @Test
    public void checkOutputAnimal() {
        String out = Task25.getObjectType(new Task25.Animal());
        Assert.assertEquals("getObjectType must return 'Животное'",
                "Животное", out);
    }
}