package lesson01.part1;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import util.SystemOutGatewayUtil;

import java.io.ByteArrayOutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class Task15Test {

    @Test
    public void main() {
        try {
            Field f = Task15.class.getDeclaredField("number");

            Assert.assertTrue(f.getType() == Integer.TYPE);
            Assert.assertTrue(Modifier.isPublic(f.getModifiers()));
            Assert.assertTrue(Modifier.isStatic(f.getModifiers()));


            int number = (int)f.get(null);
            double real = Math.pow(number, 2);
            SystemOutGatewayUtil.setCustomOut();
            ByteArrayOutputStream out = SystemOutGatewayUtil.getOutputArray();

            Task15.main(null);
            Assert.assertEquals(Double.toString(real), out.toString().trim());

            out.reset();

        }
        catch(Exception e)
        {
            System.out.println(e.toString());
        }


    }
}