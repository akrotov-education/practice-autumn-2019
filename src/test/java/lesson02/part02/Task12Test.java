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
public class Task12Test {

        @Test
        public void test12() throws Exception {
            SystemOutGatewayUtil.setCustomOut();
            ByteArrayOutputStream out = SystemOutGatewayUtil.getOutputArray();
            out.reset();

            SystemInGatewayUtil.setCustomIn("5");
            Task12.main(null);
            String[] output = out.toString().trim().split("\n");
            Assert.assertEquals("10", output[output.length-1].trim());

            out.reset();
            SystemInGatewayUtil.setCustomIn("-5");
            Task12.main(null);
            output = out.toString().trim().split("\n");
            Assert.assertEquals("-4", output[output.length-1].trim());
        }
}