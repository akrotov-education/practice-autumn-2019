package lesson02.part02;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import util.SystemOutGatewayUtil;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;

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