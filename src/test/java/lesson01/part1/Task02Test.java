package lesson01.part1;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import util.SystemOutGatewayUtil;

import java.io.ByteArrayOutputStream;
import java.io.IOException;


@RunWith(JUnit4.class)
public class Task02Test {

    @Test
    public void main() {

        SystemOutGatewayUtil.setCustomOut();
        ByteArrayOutputStream out = SystemOutGatewayUtil.getOutputArray();
        try {
            out.flush();
        }catch (IOException e)
        {
            System.out.println(e.toString());
        }
        Task02.main(null);


        //Условия
        Assert.assertFalse("Пусто", out.toString().isEmpty());
        String[] hells = out.toString().split("\n");

        Assert.assertTrue("не начинается с Hello", out.toString().startsWith("Hello"));
        Assert.assertTrue("не заканчивается на !", out.toString().endsWith("!"));

        Assert.assertEquals("Не 3 строки", 3, hells.length);
        for (String hell: hells) {
            Assert.assertEquals("Hello World!", hell);
        }

        //ПРОВЕРКА ЕЩЕ ОДНОЙ ПУСТОЙ СТРОКИ ИЗ-ЗА println()
        Assert.assertFalse("Не одна строка (println в конце)" , out.toString().endsWith("\n"));

        out.reset();
    }
}