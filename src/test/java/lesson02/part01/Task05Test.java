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
/*
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
    }*/



}