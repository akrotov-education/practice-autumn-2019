package lesson02.part01;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import util.SystemInGatewayUtil;
import util.SystemOutGatewayUtil;

import java.io.ByteArrayOutputStream;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class Task18Test {
    @Test
    public void test18() throws Exception
    {
        SystemOutGatewayUtil.setCustomOut();
        ByteArrayOutputStream out = SystemOutGatewayUtil.getOutputArray();
        out.reset();

        String name = "test";
        int value = 500;
        int years = 10;

        SystemInGatewayUtil.setCustomIn(name + "\n" + value + "\n" + years);

        Task18.main(null);
        String[] output = out.toString().trim().split("\n");
        boolean found = false;

        for (String outString : output) {
            if(outString.trim().equals(name + " получает " + value + " через " + years + " лет.")) {
                found = true;
            }
        }

        Assert.assertTrue("что с выводом?", found);
    }
}