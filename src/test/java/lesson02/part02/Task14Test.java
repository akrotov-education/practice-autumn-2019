package test.java.lesson02.part02;

import main.java.lesson02.part02.Task14;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import test.java.util.SystemInGatewayUtil;
import test.java.util.SystemOutGatewayUtil;

import java.io.ByteArrayOutputStream;

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