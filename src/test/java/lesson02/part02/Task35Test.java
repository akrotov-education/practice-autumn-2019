package lesson02.part02;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.modules.junit4.PowerMockRunner;
import util.SystemOutGatewayUtil;

import java.io.ByteArrayOutputStream;

import static org.junit.Assert.*;

@RunWith(PowerMockRunner.class)
public class Task35Test {

    @Test
    public void test35() throws Exception {
        SystemOutGatewayUtil.setCustomOut();
        ByteArrayOutputStream out = SystemOutGatewayUtil.getOutputArray();
        out.reset();

        Task35.main(null);
        String[] output = out.toString().trim().split("\n");

        Assert.assertEquals(50, output.length);
        for(int i = 2; i <= 100; i += 2)
        {
            Assert.assertEquals(Integer.toString(i), output[i / 2 - 1].trim());

        }
    }

}