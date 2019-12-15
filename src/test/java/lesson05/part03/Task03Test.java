package lesson05.part03;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.lang.reflect.Method;

@RunWith(JUnit4.class)
public class Task03Test {
    @Test
    public void checkBeerImplements() {
        Assert.assertEquals("Beer must implements Drink interface",
                "Drink", Task03.Beer.class.getInterfaces()[0].getSimpleName());
    }

    @Test
    public void checkColaImplements() {
        Assert.assertEquals("Cola must implements Drink interface",
                "Drink", Task03.Cola.class.getInterfaces()[0].getSimpleName());
    }

    @Test
    public void beerContainsDrinkMethods() {
        int count = 0;
        for (Method declaredMethod : Task03.Beer.class.getDeclaredMethods()) {
            if (declaredMethod.getName().equals("isAlcoholic")) {
                count++;
            }
        }

        Assert.assertEquals("Class Beer must contains methods from Drink interface",
                1, count);
    }

    @Test
    public void colaContainsDrinkMethods() {
        int count = 0;
        for (Method declaredMethod : Task03.Cola.class.getDeclaredMethods()) {
            if (declaredMethod.getName().equals("isAlcoholic")) {
                count++;
            }
        }

        Assert.assertEquals("Class Cola must contains methods from Drink interface",
                1, count);
    }
}