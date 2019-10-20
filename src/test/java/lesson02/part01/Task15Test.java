package lesson02.part01;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import util.SystemOutGatewayUtil;

import java.io.ByteArrayOutputStream;

import static org.junit.Assert.*;
@RunWith(JUnit4.class)
public class Task15Test {
    @Test
    public void test15()
    {
        SystemOutGatewayUtil.setCustomOut();
        ByteArrayOutputStream out = SystemOutGatewayUtil.getOutputArray();
        out.reset();

        Task15.main(null);
        String[] output = out.toString().trim().split("\n");

        Assert.assertEquals(2, output.length);
        Assert.assertEquals("It's Windows path: \"C:\\Program Files\\Java\\jdk1.7.0\\bin\"", output[0].trim());
        Assert.assertEquals("It's Java string: \"C:\\\\Program Files\\\\Java\\\\jdk1.7.0\\\\bin\\\"", output[1].trim());
    }
}