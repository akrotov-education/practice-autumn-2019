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
public class Task25Test {

    @Test
    public void test25() throws Exception {
        //TODO: check no out on full diff
        SystemOutGatewayUtil.setCustomOut();
        ByteArrayOutputStream out = SystemOutGatewayUtil.getOutputArray();
        out.reset();

        SystemInGatewayUtil.setCustomIn("4\n4");
        Task25.main(null);
        String[] output = out.toString().trim().split("\n");
        Assert.assertEquals("1", output[output.length - 1].trim());
        out.reset();

        SystemInGatewayUtil.setCustomIn("-4\n4");
        Task25.main(null);
        output = out.toString().trim().split("\n");
        Assert.assertEquals("2", output[output.length - 1].trim());
        out.reset();

        SystemInGatewayUtil.setCustomIn("-4\n-4");
        Task25.main(null);
        output = out.toString().trim().split("\n");
        Assert.assertEquals("3", output[output.length - 1].trim());
        out.reset();

        SystemInGatewayUtil.setCustomIn("4\n-4");
        Task25.main(null);
        output = out.toString().trim().split("\n");
        Assert.assertEquals("4", output[output.length - 1].trim());
        out.reset();
    }
}