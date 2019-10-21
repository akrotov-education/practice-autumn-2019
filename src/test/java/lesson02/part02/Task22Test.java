package test.java.lesson02.part02;

import main.java.lesson02.part02.Task22;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import test.java.util.SystemInGatewayUtil;
import test.java.util.SystemOutGatewayUtil;

import java.io.ByteArrayOutputStream;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class Task22Test {

    @Test
    public void test22() throws Exception {
        //TODO: check no out on full diff
        SystemOutGatewayUtil.setCustomOut();
        ByteArrayOutputStream out = SystemOutGatewayUtil.getOutputArray();
        out.reset();

        SystemInGatewayUtil.setCustomIn("abc\n17");
        Task22.main(null);
        String[] output = out.toString().trim().split("\n");
        Assert.assertEquals("Подрасти еще", output[output.length - 1].trim());
        out.reset();
    }
}