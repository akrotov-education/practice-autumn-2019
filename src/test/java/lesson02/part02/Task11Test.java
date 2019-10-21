package lesson02.part02;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import util.SystemInGatewayUtil;
import util.SystemOutGatewayUtil;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;

import static org.junit.Assert.*;


@RunWith(JUnit4.class)
public class Task11Test {
    @Test
    public void test11() {
        SystemOutGatewayUtil.setCustomOut();
        ByteArrayOutputStream out = SystemOutGatewayUtil.getOutputArray();
        out.reset();

        Task11.checkSeason(1);
        Assert.assertEquals("Зима", out.toString().trim());
        out.reset();
        Task11.checkSeason(2);
        Assert.assertEquals("Зима", out.toString().trim());
        out.reset();
        Task11.checkSeason(3);
        Assert.assertEquals("Весна", out.toString().trim());
        out.reset();
        Task11.checkSeason(4);
        Assert.assertEquals("Весна", out.toString().trim());
        out.reset();
        Task11.checkSeason(5);
        Assert.assertEquals("Весна", out.toString().trim());
        out.reset();
        Task11.checkSeason(6);
        Assert.assertEquals("Лето", out.toString().trim());
        out.reset();
        Task11.checkSeason(7);
        Assert.assertEquals("Лето", out.toString().trim());
        out.reset();
        Task11.checkSeason(8);
        Assert.assertEquals("Лето", out.toString().trim());
        out.reset();
        Task11.checkSeason(9);
        Assert.assertEquals("Осень", out.toString().trim());
        out.reset();
        Task11.checkSeason(10);
        Assert.assertEquals("Осень", out.toString().trim());
        out.reset();
        Task11.checkSeason(11);
        Assert.assertEquals("Осень", out.toString().trim());
        out.reset();
        Task11.checkSeason(12);
        Assert.assertEquals("Зима", out.toString().trim());
        out.reset();

        Task11.main(null);
        Assert.assertFalse(out.toString().isEmpty());
    }
}