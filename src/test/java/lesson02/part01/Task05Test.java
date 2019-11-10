package lesson02.part01;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import util.SystemOutGatewayUtil;


import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.io.ByteArrayOutputStream;
import java.util.TimeZone;

import static org.junit.Assert.*;

public class Task05Test {
    @Test
    public void test1 () {
        Task05.main(null);
        ByteArrayOutputStream outputArray = SystemOutGatewayUtil.getOutputArray();
        String s = outputArray.toString();
        String[] month = {"JANUARY", "FEBRUARY", "MARCH","APRIL", "MAY", "JULY",
            "JUNE", "AUGUST", "SEPTEMBER", "OCTOBER", "NOVEMBER"};
        String[] date = s.split("\\s");
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault(), Locale.getDefault());
        calendar.setTime(new Date());
        int year = calendar.get(Calendar.YEAR);
        boolean boo = false;
        for (String el: month) {
            if(el.equals(date[0]))
                boo = true;
        }

        Assert.assertTrue("Message", boo);
        Assert.assertTrue("Message", (Integer.parseInt(date[1]) <= 31) && (Integer.parseInt(date[1]) > 0));
        Assert.assertTrue("Message", (Integer.parseInt(date[2]) > 1900) && (Integer.parseInt(date[2]) < year));
    }
    @Before
    public void before() {
        SystemOutGatewayUtil.setCustomOut();
    }

    @After
    public void after() {
        SystemOutGatewayUtil.getOutputArray();
    }
}