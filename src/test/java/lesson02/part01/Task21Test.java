package lesson02.part01;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import util.SystemInGatewayUtil;
import util.SystemOutGatewayUtil;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class Task21Test {
    @Test
    public void test21()
    {
        SystemOutGatewayUtil.setCustomOut();
        ByteArrayOutputStream out = SystemOutGatewayUtil.getOutputArray();
        out.reset();

        String name = "test";

        Task21.main(null);
        String[] output = out.toString().trim().split("\n");
        Assert.assertEquals(10, output.length);

        for (String outString : output) {
            Assert.assertEquals("Я хочу большую зарплату, и для этого изучаю Java", outString.trim());
        }


    }
}