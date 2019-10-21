package test.java.lesson02.part01;

import main.java.lesson02.part01.Task09;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import test.java.util.SystemOutGatewayUtil;

import java.io.ByteArrayOutputStream;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class Task09Test {
    @Test
    public void test09()
    {
        SystemOutGatewayUtil.setCustomOut();
        ByteArrayOutputStream out = SystemOutGatewayUtil.getOutputArray();
        out.reset();

        Task09.main(null);
        String[] testStrings = new String[5];

        int s = 0;
        for(int i = 1; i <= 5; i++)
        {
            s += i;
            testStrings[i - 1] = Integer.toString(s);
        }

        String[] outStrings = out.toString().trim().replace("\r", "").split("\n");

        Assert.assertArrayEquals(testStrings, outStrings);
    }
}