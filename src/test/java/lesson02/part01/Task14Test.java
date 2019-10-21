package lesson02.part01;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import util.SystemOutGatewayUtil;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
@RunWith(JUnit4.class)
public class Task14Test {
    @Test
    public void test14()
    {
        SystemOutGatewayUtil.setCustomOut();
        ByteArrayOutputStream out = SystemOutGatewayUtil.getOutputArray();
        out.reset();

        String[] testStrings = { "Red", "Orange", "Yellow", "Green", "Blue", "Indigo", "Violet"};

        Task14.main(null);
        String[] output = out.toString().trim().split("\n");

        Assert.assertEquals(7, output.length);

        for(int i = 0; i < 7; i++)
        {
            Assert.assertEquals(testStrings[i], output[i].trim());
        }
    }
}