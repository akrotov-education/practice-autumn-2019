package lesson05.part03;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.lang.reflect.Method;

@RunWith(JUnit4.class)
public class Task01Test {
    @Test
    public void checkBeerLoverImplements() {
        Assert.assertEquals("BeerLover must implements Alcoholic interface",
                "Alcoholic", Task01.BeerLover.class.getInterfaces()[0].getSimpleName());
    }

    @Test
    public void beerLoverNotImplementDrinker() {
        for (Class<?> anInterface : Task01.BeerLover.class.getInterfaces()) {
            if (anInterface.getSimpleName().equals("Drinker")) {
                Assert.fail("BeerLover hasn't to implement Drinker interface");
            }
        }
    }

    @Test
    public void beerLoverContainsAlcoholicMethods() {
        int count = 0;
        for (Method declaredMethod : Task01.BeerLover.class.getDeclaredMethods()) {
            if (declaredMethod.getName().equals("sleepOnTheFloor")) {
                count++;
            }
        }

        Assert.assertEquals("Class BeerLover must contains methods from Alcoholic interface",
                1, count);
    }

    @Test
    public void beerLoverContainsDrinkerMethods() {
        int count = 0;
        for (Method declaredMethod : Task01.BeerLover.class.getDeclaredMethods()) {
            if (declaredMethod.getName().equals("askForMore") ||
                declaredMethod.getName().equals("sayThankYou") ||
                declaredMethod.getName().equals("isReadyToGoHome")) {
                count++;
            }
        }

        Assert.assertEquals("Class BeerLover must contains methods from Drinker interface",
                3, count);
    }
}