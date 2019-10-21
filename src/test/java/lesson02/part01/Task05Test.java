package test.java.lesson02.part01;

import main.java.lesson02.part01.Task05;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import test.java.util.SystemOutGatewayUtil;

import java.io.ByteArrayOutputStream;
import java.time.LocalDate;
import java.time.Month;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class Task05Test {

    @Test
    public void test05()
    {
        SystemOutGatewayUtil.setCustomOut();
        ByteArrayOutputStream out = SystemOutGatewayUtil.getOutputArray();
        out.reset();

        Task05.main(null);
        String[] dates = out.toString().trim().split(" ");
        Assert.assertEquals(3, dates.length);

        try {
            Month.valueOf(dates[0]);
        }catch (IllegalArgumentException e)
        {
            Assert.fail("что с месяцем?");
        }

        try{
           int day = Integer.parseInt(dates[1]);
           if(day < 1 || day > 31)
               throw new Exception();
        }catch(Exception e)
        {
            Assert.fail("что с датой?");
        }

        try{
            int year = Integer.parseInt(dates[1]);
            if (year < 1900 || year > LocalDate.now().getYear());
        }catch (Exception e)
        {
            Assert.fail("что с годом?");
        }
    }
}