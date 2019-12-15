package lesson05.part03;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import util.SystemOutGatewayUtil;

import java.lang.reflect.Method;

@RunWith(JUnit4.class)
public class Task02Test {
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
    public void checkAlcoholicBeerImplements() {
        Assert.assertEquals("AlcoholicBeer must implements Drink interface",
                "Drink", Task02.AlcoholicBeer.class.getInterfaces()[0].getSimpleName());
    }

    @Test
    public void alcoholicBeerContainsDrinkMethods() {
        int count = 0;
        for (Method declaredMethod : Task02.AlcoholicBeer.class.getDeclaredMethods()) {
            if (declaredMethod.getName().equals("isAlcoholic")) {
                count++;
            }
        }

        Assert.assertEquals("Class AlcoholicBeer must contains methods from Drink interface",
                1, count);
    }

    @Test
    public void alcoholicBeerContains2Methods() {
        Assert.assertEquals("Class AlcoholicBeer must contains 2 methods",
                2, Task02.AlcoholicBeer.class.getDeclaredMethods().length);
    }

    @Test
    public void checkOutput() throws Exception {
        Task02.main(null);
        String output = SystemOutGatewayUtil.getOutputArray().toString();
        Assert.assertTrue("Program must output 'Напиток алкогольный'",
                output.contains("Напиток алкогольный"));
    }
}