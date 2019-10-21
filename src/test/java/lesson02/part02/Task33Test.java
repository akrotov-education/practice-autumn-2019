package test.java.lesson02.part02;

import main.java.lesson02.part02.Task33;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import test.java.util.SystemInGatewayUtil;
import test.java.util.SystemOutGatewayUtil;

import java.io.ByteArrayOutputStream;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class Task33Test {

    @Test
    public void test33() throws Exception {
        SystemOutGatewayUtil.setCustomOut();
        ByteArrayOutputStream out = SystemOutGatewayUtil.getOutputArray();
        out.reset();

        Task33.main(null);
        String[] output = out.toString().trim().split("\n");

        Assert.assertEquals(10, output.length);
        for (String string : output) {
            Assert.assertEquals(string.trim(), "SSSSSSSSSS");
        }

    }
}