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
public class Task38Test {

    @Test
    public void test38() throws Exception {
        SystemOutGatewayUtil.setCustomOut();
        ByteArrayOutputStream out = SystemOutGatewayUtil.getOutputArray();
        out.reset();

        Task38.main(null);
        String[] output = out.toString().trim().split("\n");
        Assert.assertEquals(11, output.length);

        Assert.assertEquals("8888888888", output[0].trim());

        for(int j = 1; j < output.length; j++)
        {
            Assert.assertEquals("8", output[j ].trim());
        }
    }
}