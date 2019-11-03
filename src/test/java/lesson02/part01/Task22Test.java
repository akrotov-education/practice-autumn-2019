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
public class Task22Test {
    @Test
    public void test22() throws Exception
    {
        SystemOutGatewayUtil.setCustomOut();
        ByteArrayOutputStream out = SystemOutGatewayUtil.getOutputArray();
        out.reset();

        int value = 44;

        SystemInGatewayUtil.setCustomIn(Integer.toString(value));

        Task22.main(null);
        String[] output = out.toString().trim().split("\n");
        boolean found = false;

        for (String outString : output) {
            if (outString.trim().equals("Я буду зарабатывать $" + value + " в час")) {
                found = true;
            }
        }

        Assert.assertTrue("что с выводом?", found);
    }
}