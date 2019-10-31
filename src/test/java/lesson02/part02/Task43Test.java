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
public class Task43Test {

    @Test
    public void test43() throws Exception {
        SystemOutGatewayUtil.setCustomOut();
        ByteArrayOutputStream out = SystemOutGatewayUtil.getOutputArray();
        out.reset();

        SystemInGatewayUtil.setCustomIn("test\n1998\n7\n31");
        Task43.main(null);
        String[] output = out.toString().trim().split("\n");
        Assert.assertTrue(output.length >= 2);
        Assert.assertEquals("Меня зовут test.", output[output.length - 2].trim());
        Assert.assertEquals( "Я родился 31.7.1998", output[output.length - 1].trim());
    }
}