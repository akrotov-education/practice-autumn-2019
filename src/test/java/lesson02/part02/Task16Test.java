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
public class Task16Test {

    @Test
    public void test16() throws Exception {
        SystemOutGatewayUtil.setCustomOut();
        ByteArrayOutputStream out = SystemOutGatewayUtil.getOutputArray();
        out.reset();

        SystemInGatewayUtil.setCustomIn("2.5");
        Task16.main(null);
        String[] output = out.toString().trim().split("\n");
        Assert.assertEquals("зеленый", output[output.length - 1].trim());
        out.reset();

        SystemInGatewayUtil.setCustomIn("3");
        Task16.main(null);
        output = out.toString().trim().split("\n");
        Assert.assertEquals("желтый", output[output.length - 1].trim());
        out.reset();

        SystemInGatewayUtil.setCustomIn("4");
        Task16.main(null);
        output = out.toString().trim().split("\n");
        Assert.assertEquals("красный", output[output.length - 1].trim());
        out.reset();

        SystemInGatewayUtil.setCustomIn("7");
        Task16.main(null);
        output = out.toString().trim().split("\n");
        Assert.assertEquals("зеленый", output[output.length - 1].trim());
        out.reset();
    }
}