package test.java.lesson02.part02;

import main.java.lesson02.part02.Task17;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import test.java.util.SystemInGatewayUtil;
import test.java.util.SystemOutGatewayUtil;

import java.io.ByteArrayOutputStream;

import static org.junit.Assert.*;


@RunWith(JUnit4.class)
public class Task17Test {

    @Test
    public void test17() throws Exception {
        SystemOutGatewayUtil.setCustomOut();
        ByteArrayOutputStream out = SystemOutGatewayUtil.getOutputArray();
        out.reset();

        SystemInGatewayUtil.setCustomIn("2\n2\n1");
        Task17.main(null);
        String[] output = out.toString().trim().split("\n");
        Assert.assertEquals("2 2", output[output.length - 1].trim());
        out.reset();

        SystemInGatewayUtil.setCustomIn("3\n2\n3");
        Task17.main(null);
        output = out.toString().trim().split("\n");
        Assert.assertEquals("3 3", output[output.length - 1].trim());
        out.reset();

        SystemInGatewayUtil.setCustomIn("1\n3\n3");
        Task17.main(null);
        output = out.toString().trim().split("\n");
        Assert.assertEquals("3 3", output[output.length - 1].trim());
        out.reset();

        SystemInGatewayUtil.setCustomIn("2\n2\n2");
        Task17.main(null);
        output = out.toString().trim().split("\n");
        Assert.assertEquals("2 2 2", output[output.length - 1].trim());
        out.reset();
    }
}