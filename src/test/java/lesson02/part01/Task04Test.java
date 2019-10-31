package lesson02.part01;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import util.SystemOutGatewayUtil;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class Task04Test {

    @Test
    public void test04()
    {
        SystemOutGatewayUtil.setCustomOut();
        ByteArrayOutputStream out = SystemOutGatewayUtil.getOutputArray();
        out.reset();

        Assert.assertEquals(55, Task04.addTenPercent(50), 0);
        Assert.assertTrue(out.toString().isEmpty());

        Task04.main(null);
        Assert.assertTrue(out.toString().trim().matches("\\d+\\.\\d+"));
    }
}