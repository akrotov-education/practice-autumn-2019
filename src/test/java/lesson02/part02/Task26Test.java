package test.java.lesson02.part02;

import main.java.lesson02.part02.Task26;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import test.java.util.SystemInGatewayUtil;
import test.java.util.SystemOutGatewayUtil;

import java.io.ByteArrayOutputStream;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class Task26Test {

    @Test
    public void test26() throws Exception {
        //TODO: check no out on full diff
        SystemOutGatewayUtil.setCustomOut();
        ByteArrayOutputStream out = SystemOutGatewayUtil.getOutputArray();
        out.reset();

        SystemInGatewayUtil.setCustomIn("-2");
        Task26.main(null);
        String[] output = out.toString().trim().split("\n");
        Assert.assertEquals("отрицательное четное число", output[output.length - 1].trim());
        out.reset();

        SystemInGatewayUtil.setCustomIn("-3");
        Task26.main(null);
        output = out.toString().trim().split("\n");
        Assert.assertEquals("отрицательное нечетное число", output[output.length - 1].trim());
        out.reset();

        SystemInGatewayUtil.setCustomIn("0");
        Task26.main(null);
        output = out.toString().trim().split("\n");
        Assert.assertEquals("ноль", output[output.length - 1].trim());
        out.reset();

        SystemInGatewayUtil.setCustomIn("4");
        Task26.main(null);
        output = out.toString().trim().split("\n");
        Assert.assertEquals("положительное четное число", output[output.length - 1].trim());
        out.reset();

        SystemInGatewayUtil.setCustomIn("3");
        Task26.main(null);
        output = out.toString().trim().split("\n");
        Assert.assertEquals("положительное нечетное число", output[output.length - 1].trim());
        out.reset();
    }
}