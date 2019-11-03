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

import static org.junit.Assert.*;
@RunWith(JUnit4.class)
public class Task14Test {

    @Test
    public void test14() throws Exception {
        SystemOutGatewayUtil.setCustomOut();
        ByteArrayOutputStream out = SystemOutGatewayUtil.getOutputArray();
        out.reset();

        SystemInGatewayUtil.setCustomIn("1700");
        Task14.main(null);
        String[] output = out.toString().trim().split("\n");
        Assert.assertEquals("количество дней в году: 365", output[output.length - 1].trim());
        out.reset();

        SystemInGatewayUtil.setCustomIn("1600");
        Task14.main(null);
        output = out.toString().trim().split("\n");
        Assert.assertEquals("количество дней в году: 366", output[output.length - 1].trim());
        out.reset();

        SystemInGatewayUtil.setCustomIn("2100");
        Task14.main(null);
        output = out.toString().trim().split("\n");
        Assert.assertEquals("количество дней в году: 365", output[output.length - 1].trim());
        out.reset();

        SystemInGatewayUtil.setCustomIn("2004");
        Task14.main(null);
        output = out.toString().trim().split("\n");
        Assert.assertEquals("количество дней в году: 366", output[output.length - 1].trim());
        out.reset();

        SystemInGatewayUtil.setCustomIn("2007");
        Task14.main(null);
        output = out.toString().trim().split("\n");
        Assert.assertEquals("количество дней в году: 365", output[output.length - 1].trim());
        out.reset();
    }
}