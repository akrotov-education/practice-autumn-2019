package test.java.lesson02.part02;

import main.java.lesson02.part02.Task29;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import test.java.util.SystemInGatewayUtil;
import test.java.util.SystemOutGatewayUtil;

import java.io.ByteArrayOutputStream;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class Task29Test {

    @Test
    public void test29() throws Exception {
        //TODO: check no out on full diff
        SystemOutGatewayUtil.setCustomOut();
        ByteArrayOutputStream out = SystemOutGatewayUtil.getOutputArray();
        out.reset();

        SystemInGatewayUtil.setCustomIn("1\n3\n1");
        Task29.main(null);
        String[] output = out.toString().trim().split("\n");
        Assert.assertEquals("количество отрицательных чисел: 0", output[output.length - 2].trim());
        Assert.assertEquals("количество положительных чисел: 3", output[output.length - 1].trim());
        out.reset();

        SystemInGatewayUtil.setCustomIn("1\n-3\n1");
        Task29.main(null);
        output = out.toString().trim().split("\n");
        Assert.assertEquals("количество отрицательных чисел: 1", output[output.length - 2].trim());
        Assert.assertEquals("количество положительных чисел: 2", output[output.length - 1].trim());
        out.reset();

        SystemInGatewayUtil.setCustomIn("0\n0\n0");
        Task29.main(null);
        output = out.toString().trim().split("\n");
        Assert.assertEquals("количество отрицательных чисел: 0", output[output.length - 2].trim());
        Assert.assertEquals("количество положительных чисел: 0", output[output.length - 1].trim());
        out.reset();
    }
}