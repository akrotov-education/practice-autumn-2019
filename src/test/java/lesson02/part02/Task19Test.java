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
public class Task19Test {

    @Test
    public void test19() throws Exception {
        SystemOutGatewayUtil.setCustomOut();
        ByteArrayOutputStream out = SystemOutGatewayUtil.getOutputArray();
        out.reset();

        SystemInGatewayUtil.setCustomIn("2\n1\n3\n4");
        Task19.main(null);
        String[] output = out.toString().trim().split("\n");
        Assert.assertEquals("4", output[output.length - 1].trim());
        out.reset();

        SystemInGatewayUtil.setCustomIn("1\n3\n1\n2");
        Task19.main(null);
        output = out.toString().trim().split("\n");
        Assert.assertEquals("3", output[output.length - 1].trim());
        out.reset();

        SystemInGatewayUtil.setCustomIn("3\n2\n1\n2");
        Task19.main(null);
        output = out.toString().trim().split("\n");
        Assert.assertEquals("3", output[output.length - 1].trim());
        out.reset();

        SystemInGatewayUtil.setCustomIn("3\n2\n4\n2");
        Task19.main(null);
        output = out.toString().trim().split("\n");
        Assert.assertEquals("4", output[output.length - 1].trim());
        out.reset();

        SystemInGatewayUtil.setCustomIn("1\n1\n1\n1");
        Task19.main(null);
        output = out.toString().trim().split("\n");
        Assert.assertEquals("1", output[output.length - 1].trim());
        out.reset();
    }
}