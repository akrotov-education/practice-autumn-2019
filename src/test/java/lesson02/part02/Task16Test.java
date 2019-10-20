package lesson02.part02;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.modules.junit4.PowerMockRunner;
import util.SystemInGatewayUtil;
import util.SystemOutGatewayUtil;

import java.io.ByteArrayOutputStream;

import static org.junit.Assert.*;


@RunWith(PowerMockRunner.class)
public class Task16Test {

    @Test
    public void test16() throws Exception {
        SystemOutGatewayUtil.setCustomOut();
        ByteArrayOutputStream out = SystemOutGatewayUtil.getOutputArray();
        out.reset();

        SystemInGatewayUtil.setCustomIn("2,5");
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