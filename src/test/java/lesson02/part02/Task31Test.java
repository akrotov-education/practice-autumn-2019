package test.java.lesson02.part02;

import main.java.lesson02.part02.Task31;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import test.java.util.SystemOutGatewayUtil;

import java.io.ByteArrayOutputStream;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
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