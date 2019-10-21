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
public class Task41Test {

    @Test
    public void test41() throws Exception {
        SystemOutGatewayUtil.setCustomOut();
        ByteArrayOutputStream out = SystemOutGatewayUtil.getOutputArray();
        out.reset();

        SystemInGatewayUtil.setCustomIn("3\n4\n2");
        Task41.main(null);
        String[] output = out.toString().trim().split("\n");
        Assert.assertEquals("3", output[output.length - 1].trim());
        out.reset();

        SystemInGatewayUtil.setCustomIn("1\n4\n2");
        Task41.main(null);
        output = out.toString().trim().split("\n");
        Assert.assertEquals("2", output[output.length - 1].trim());
        out.reset();

        SystemInGatewayUtil.setCustomIn("3\n4\n5");
        Task41.main(null);
        output = out.toString().trim().split("\n");
        Assert.assertEquals("4", output[output.length - 1].trim());
        out.reset();

        SystemInGatewayUtil.setCustomIn("3\n3\n3");
        Task41.main(null);
        output = out.toString().trim().split("\n");
        Assert.assertEquals("3", output[output.length - 1].trim());
        out.reset();

    }
}