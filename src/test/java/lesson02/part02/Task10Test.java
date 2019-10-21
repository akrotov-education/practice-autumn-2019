package test.java.lesson02.part02;

import main.java.lesson02.part02.Task10;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.junit.runners.JUnit4;
import test.java.util.SystemOutGatewayUtil;

import java.io.ByteArrayOutputStream;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class Task10Test {
    @Test
    public void test10()
    {
        SystemOutGatewayUtil.setCustomOut();
        ByteArrayOutputStream out = SystemOutGatewayUtil.getOutputArray();
        out.reset();

        int a = 51;
        int b = -5;
        int c = 1230;

        Task10.checkInterval(a);
        Assert.assertEquals("Число " + a + " содержится в интервале", out.toString().trim());
        out.reset();

        Task10.checkInterval(b);
        Assert.assertEquals("Число " + b + " не содержится в интервале", out.toString().trim());
        out.reset();

        Task10.checkInterval(c);
        Assert.assertEquals("Число " + c + " не содержится в интервале", out.toString().trim());
        out.reset();

        Task10.main(null);
        Assert.assertFalse(out.toString().isEmpty());

    }
}