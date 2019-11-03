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