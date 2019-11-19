package lesson02.part02;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.modules.junit4.PowerMockRunner;
import foloke.utils.SystemInGatewayUtil;
import util.SystemOutGatewayUtil;

import java.io.ByteArrayOutputStream;

import static org.junit.Assert.*;

@RunWith(PowerMockRunner.class)
public class Task21Test {

    @Test
    public void test21() throws Exception {
        //TODO: check no out on full diff
        SystemOutGatewayUtil.setCustomOut();
        ByteArrayOutputStream out = SystemOutGatewayUtil.getOutputArray();
        out.reset();

        SystemInGatewayUtil.setCustomIn("abc\nabc");
        Task21.main(null);
        String[] output = out.toString().trim().split("\n");
        Assert.assertEquals("Имена идентичны", output[output.length - 1].trim());
        out.reset();

        SystemInGatewayUtil.setCustomIn("abc\nabd");
        Task21.main(null);
        output = out.toString().trim().split("\n");
        Assert.assertEquals("Длины имен равны", output[output.length - 1].trim());
        out.reset();
    }
}