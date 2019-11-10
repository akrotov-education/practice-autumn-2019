package lesson02.part01;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import util.SystemOutGatewayUtil;

import java.io.ByteArrayOutputStream;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class Task05Test {
    public static String fileName = "./src/main/java/lesson02/part01/Task05.java";

    @Before
    public void before() {
        SystemOutGatewayUtil.setCustomOut();
    }

    @After
    public void after() {
        SystemOutGatewayUtil.setOriginalOut();
        SystemOutGatewayUtil.clearOutput();
    }

    @Test
    public void test05RightDate() throws ParseException {
        Task05.main(null);
        SystemOutGatewayUtil.setOriginalOut();
        ByteArrayOutputStream outputArr = SystemOutGatewayUtil.getOutputArray();
        String s = outputArr.toString();

        Assert.assertTrue(
                "Выводимый текст должен содержать месяц, день и год, разделенные пробелом",
                s.split(" ").length == 3
        );
    }

    @Test
    public void test05RightMonth() {
        Task05.main(null);
        SystemOutGatewayUtil.setOriginalOut();
        ByteArrayOutputStream outputArr = SystemOutGatewayUtil.getOutputArray();
        String s = outputArr.toString();
        boolean enMonth = s.split(" ")[0].matches("\\w+");
        boolean upperCase = s.split(" ")[0].toUpperCase().equals(s.split(" ")[0]);
        Assert.assertTrue(
                "Название месяца должно выводиться на английском языке и заглавными буквами",
                enMonth && upperCase
        );
    }

    @Test
    public void test05CheckYear() {
        Task05.main(null);
        SystemOutGatewayUtil.setOriginalOut();
        ByteArrayOutputStream outputArr = SystemOutGatewayUtil.getOutputArray();
        String s = outputArr.toString();
        boolean year = Integer.parseInt(s.split(" ")[2].split("\n")[0]) > 1900;
        Assert.assertTrue(
                "Год должен состоять из четырех цифр и быть не меньше 1900",
                year
        );
    }

    @Test
    public void test05RightBirthday() throws ParseException {
        Task05.main(null);
        SystemOutGatewayUtil.setOriginalOut();
        ByteArrayOutputStream outputArr = SystemOutGatewayUtil.getOutputArray();
        String s = outputArr.toString();

        Date today = new Date();
        LocalDate localDate = today.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        int year  = localDate.getYear();
        int month = localDate.getMonthValue();
        int day   = localDate.getDayOfMonth();
        boolean var = false;

        String[] months = {"JANUARY", "FEBRUARY", "MARCH", "APRIL", "MAY", "JUNE", "JULY", "AUGUST", "SEPTEMBER", "OCTOBER", "NOVEMBER", "DECEMBER"};
        int dayB = Integer.parseInt(s.split(" ")[1]);
        int yearB = Integer.parseInt(s.split(" ")[2].split("\n")[0]);
        int monthB = 0;
        for (int i = 0; i < 0; i++)
            if (s.contains(months[i]))
                monthB = (i + 1);

        if (yearB < year)
            var = true;
        else if (yearB == year && monthB < month)
            var = true;
        else if (yearB == year && monthB == month && dayB <= day)
            var = true;


        Assert.assertTrue(
                "Дата рождения должна предшествовать текущей",
                var
        );
    }
}