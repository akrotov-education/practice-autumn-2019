package test.java.lesson02.part01;

import main.java.lesson02.part01.Task19;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import test.java.util.SystemInGatewayUtil;
import test.java.util.SystemOutGatewayUtil;

import java.io.ByteArrayOutputStream;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class Task19Test {
    @Test
    public void test19() throws Exception
    {
        SystemOutGatewayUtil.setCustomOut();
        ByteArrayOutputStream out = SystemOutGatewayUtil.getOutputArray();
        out.reset();

        String name = "test";

        SystemInGatewayUtil.setCustomIn(name );

        Task19.main(null);
        String[] output = out.toString().trim().split("\n");
        boolean found = false;

        for (String outString : output) {
            if(outString.trim().equals(name + " зарабатывает $5,000. Ха-ха-ха!")) {
                found = true;
            }
        }

        Assert.assertTrue("что с выводом?", found);
    }
}