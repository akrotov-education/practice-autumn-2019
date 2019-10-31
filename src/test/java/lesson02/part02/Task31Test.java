package lesson02.part02;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.modules.junit4.PowerMockRunner;
import util.SystemOutGatewayUtil;

import java.io.ByteArrayOutputStream;

import static org.junit.Assert.*;

@RunWith(PowerMockRunner.class)
public class Task31Test {

    @Test
    public void test31() throws Exception {
        SystemOutGatewayUtil.setCustomOut();
        ByteArrayOutputStream out = SystemOutGatewayUtil.getOutputArray();
        out.reset();

        Task31.main(null);
        String[] output = out.toString().trim().split("\n");

        for (int i = 0; i < 10; i++) {
            try {
                Assert.assertEquals(Math.abs(i - 10), Integer.parseInt(output[i].trim()));
            } catch (Exception e) {
                Assert.fail("wrong out" + e);
            }
        }
    }

}