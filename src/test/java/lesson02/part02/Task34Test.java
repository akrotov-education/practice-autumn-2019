package lesson02.part02;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import util.SystemInGatewayUtil;
import util.SystemOutGatewayUtil;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;

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