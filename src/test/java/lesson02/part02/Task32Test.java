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
public class Task32Test {

    @Test
    public void test32() throws Exception {
        SystemOutGatewayUtil.setCustomOut();
        ByteArrayOutputStream out = SystemOutGatewayUtil.getOutputArray();
        out.reset();

        SystemInGatewayUtil.setCustomIn("test\n4");
        Task32.main(null);
        String[] output = out.toString().trim().split("\n");

        int count = 0;
        for (int i = 0; i < output.length; i++) {
            if(output[i].trim().equals("test"))
            {
                count++;
            }
        }

        assertEquals(4, count); ////strings count
    }

}