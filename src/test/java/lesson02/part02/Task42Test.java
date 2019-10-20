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
public class Task42Test {

    @Test
    public void test42() throws Exception {
        SystemOutGatewayUtil.setCustomOut();
        ByteArrayOutputStream out = SystemOutGatewayUtil.getOutputArray();
        out.reset();

        SystemInGatewayUtil.setCustomIn("3\n4\n2\n2\n-1");
        Task42.main(null);
        String[] output = out.toString().trim().split("\n");
        Assert.assertEquals("11", output[output.length - 1].trim());
        out.reset();

        SystemInGatewayUtil.setCustomIn("-1");
        Task42.main(null);
        output = out.toString().trim().split("\n");
        Assert.assertEquals("0", output[output.length - 1].trim());
        out.reset();
    }
}