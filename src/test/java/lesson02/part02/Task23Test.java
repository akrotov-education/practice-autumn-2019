package test.java.lesson02.part02;

import main.java.lesson02.part02.Task23;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import test.java.util.SystemInGatewayUtil;
import test.java.util.SystemOutGatewayUtil;

import java.io.ByteArrayOutputStream;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class Task23Test {

    @Test
    public void test23() throws Exception {
        //TODO: check no out on full diff
        SystemOutGatewayUtil.setCustomOut();
        ByteArrayOutputStream out = SystemOutGatewayUtil.getOutputArray();
        out.reset();

        SystemInGatewayUtil.setCustomIn("abc\n21");
        Task23.main(null);
        String[] output = out.toString().trim().split("\n");
        Assert.assertEquals("И 18-ти достаточно", output[output.length - 1].trim());
        out.reset();
    }
}