package test.java.lesson02.part02;

import main.java.lesson02.part02.Task34;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import test.java.util.SystemInGatewayUtil;
import test.java.util.SystemOutGatewayUtil;

import java.io.ByteArrayOutputStream;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class Task34Test {

    @Test
    public void test34() throws Exception {
        SystemOutGatewayUtil.setCustomOut();
        ByteArrayOutputStream out = SystemOutGatewayUtil.getOutputArray();
        out.reset();

        Task34.main(null);
        String[] output = out.toString().trim().split("\n");

        Assert.assertEquals(10, output.length);
        for (int line = 0; line < 10; line ++) {
            for(int pos = 0; pos < 10; pos++)
                Assert.assertTrue(output[line].trim().contains(Integer.toString((line + 1)*(pos + 1))));

        }
    }
}