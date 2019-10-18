package lesson01.part1;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import util.SystemInGatewayUtil;
import util.SystemOutGatewayUtil;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Scanner;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class Task08Test {

    /* 1. Программа не должна считывать данные с клавиатуры.
     * 2. Метод getMetreFromCentimetre(int) должен быть публичным и статическим.
     * 3. Метод getMetreFromCentimetre должен возвращать значение типа int.
     * 4. Метод getMetreFromCentimetre не должен ничего выводить на экран.
     * 5. Метод getMetreFromCentimetre должен правильно возвращать количество полных метров в centimetre.
     */

    @Test
    public void main() {

        //TODO: input check
        SystemOutGatewayUtil.setCustomOut();
        ByteArrayOutputStream out = SystemOutGatewayUtil.getOutputArray();

        try {
            Method m = Task08.class.getDeclaredMethod("getMetreFromCentimetre", int.class);
            Assert.assertTrue(m.toString().contains("public static "));
            Assert.assertEquals(Integer.TYPE,m.getReturnType());
            Assert.assertEquals((256 / 100),m.invoke(null, 256));
            Assert.assertTrue(out.toString().isEmpty());

            Task08.main(null);

           // Assert.assertTrue(System.in.toString().isEmpty());
        }catch(Exception e)
        {
            System.out.println(e);
        }

        out.reset();
    }
}