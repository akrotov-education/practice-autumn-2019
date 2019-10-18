package lesson01.part1;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import util.SystemOutGatewayUtil;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.time.LocalDate;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class Task03Test {

    @Test
    public void main() {
        SystemOutGatewayUtil.setCustomOut();
        Task03.main(null);

        ByteArrayOutputStream out = SystemOutGatewayUtil.getOutputArray();

        String output = out.toString().split("\n")[0];
        output = output.trim();
        //Проверка по условиям
        Assert.assertFalse("пусто", output.isEmpty());
        Assert.assertTrue("не число 4х значное число", output.matches("\\d+"));
        Assert.assertTrue("не начинается с 19", output.startsWith("19"));

        LocalDate localDate = LocalDate.now();
        Assert.assertEquals(Integer.toString(localDate.minusYears(98).getYear()), output);
        try{
            out.flush();
        }catch(IOException e)
        {
            System.out.println(e.toString());
        }
    }
}