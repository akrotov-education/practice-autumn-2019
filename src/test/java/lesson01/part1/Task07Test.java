package lesson01.part1;

import lesson02.cw.loop.Do;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import util.SystemOutGatewayUtil;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class Task07Test {

    /* Требования:
            * 1. Метод convertCelsiusToFahrenheit(int) должен быть публичным и статическим.
            * 2. Метод convertCelsiusToFahrenheit должен возвращать значение типа double.
            * 3. Метод convertCelsiusToFahrenheit не должен ничего выводить на экран.
            * 4. Метод convertCelsiusToFahrenheit должен правильно переводить градусы Цельсия в градусы Фаренгейта и возвращать это число.
            */
    @Test
    public void main() {
        SystemOutGatewayUtil.setCustomOut();
        ByteArrayOutputStream out = SystemOutGatewayUtil.getOutputArray();

        try{
            Method m = Task07.class.getDeclaredMethod("convertCelsiusToFahrenheit", int.class);
            Assert.assertTrue(m.toString().contains("public static "));

            Assert.assertEquals(Double.TYPE, m.getReturnType());

            Assert.assertEquals((9d / 5d) * 5 + 32d, m.invoke(null,5));
            Assert.assertTrue(out.toString().isEmpty());

            Task07.main(null);
            Assert.assertFalse(out.toString().isEmpty());
        }
        catch (Exception e)
        {
            System.out.println(e.toString());
        }

        out.reset();
    }
}