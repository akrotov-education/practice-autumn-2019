package lesson02.part01;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import util.SystemOutGatewayUtil;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
@RunWith(JUnit4.class)
public class Task13Test {
    @Test
    public void test13()
    {
        SystemOutGatewayUtil.setCustomOut();
        ByteArrayOutputStream out = SystemOutGatewayUtil.getOutputArray();
        out.reset();

        Task13.main(null);
        String[] output = out.toString().trim().split("\n");

        Assert.assertEquals(10, output.length);

        int line = 1;
        for (String outLine : output) {
            int pos = 1;
            for (String number : outLine.trim().split(" ")) {
                Assert.assertEquals(Integer.toString(line * pos), number.trim());
                pos++;
            }

            line++;
        }
    }
}