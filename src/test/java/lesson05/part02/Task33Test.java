package lesson05.part02;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class Task33Test {
    @Test
    public void checkPairExists() {
        Class[] interfaces = Task33.class.getDeclaredClasses();
        boolean isContains = false;
        for (Class anInterface : interfaces) {
            if (anInterface.getSimpleName().equals("Pair")) {
                isContains = true;

                break;
            }
        }

        Assert.assertTrue("Class must contains Pair class",
                isContains);
    }

    @Test
    public void checkHave2Methods() {
        Assert.assertEquals("Class must contains 2 methods",
                2, Task33.class.getDeclaredMethods().length);
    }

    @Test
    public void checkGetMinimumAndIndexExists() {
        try {
            Task33.class.getDeclaredMethod("getMinimumAndIndex", int[].class);
        } catch (NoSuchMethodException e) {
            Assert.fail("Class must contains getMinimumAndIndex() method");
        }
    }

    @Test
    public void checkGetMinimumAndIndex() {
        int[] data = new int[]{1, 2, 3, 5, -2, -8, 0, 77, 5, 5};

        Task33.Pair<Integer, Integer> result = Task33.getMinimumAndIndex(data);
        Assert.assertTrue("Method getMinimumAndIndex must returns minimum value and its index",
                result.x == -8 && result.y == 5);
    }
}