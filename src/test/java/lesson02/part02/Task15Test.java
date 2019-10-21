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
public class Task15Test {

    @Test
    public void test15() throws Exception {
        SystemOutGatewayUtil.setCustomOut();
        ByteArrayOutputStream out = SystemOutGatewayUtil.getOutputArray();
        out.reset();

        SystemInGatewayUtil.setCustomIn("1700\n1\n1");
        Task15.main(null);
        String[] output = out.toString().trim().split("\n");
        Assert.assertEquals("Треугольник не существует.", output[output.length - 1].trim());
        out.reset();

        SystemInGatewayUtil.setCustomIn("5\n2\n4");
        Task15.main(null);
        output = out.toString().trim().split("\n");
        Assert.assertEquals("Треугольник существует.", output[output.length - 1].trim());
        out.reset();
    }
}