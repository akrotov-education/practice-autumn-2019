package test.java.lesson01.part1;

import main.java.lesson01.part1.Task01;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import test.java.util.SystemOutGatewayUtil;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

@RunWith(JUnit4.class)
public class Task01Test {

    @Test
    public void test01() {
        ////Task01.main
        SystemOutGatewayUtil.setCustomOut();
        Task01.main(null);
        ByteArrayOutputStream out = SystemOutGatewayUtil.getOutputArray();
        String output = out.toString();


        //Проверка по условиям
        Assert.assertFalse("пусто", output.isEmpty());
        Assert.assertTrue("не начинается Hello", output.startsWith("Hello"));
        Assert.assertTrue("Не заканчивается на !", output.endsWith("!"));
        Assert.assertEquals("Не 12 символов",12, output.length());
        Assert.assertEquals("Не одна строка (в строке)" ,1, output.split("\n").length);

        //ПРОВЕРКА ЕЩЕ ОДНОЙ ПУСТОЙ СТРОКИ ИЗ-ЗА println()
        Assert.assertFalse("Не одна строка (println в конце)" , output.endsWith("\n"));

        //Итог
        Assert.assertEquals("Hello World!", output);

        out.reset();
    }
}