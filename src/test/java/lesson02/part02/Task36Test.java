package test.java.lesson02.part02;

import main.java.lesson02.part02.Task36;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import test.java.util.SystemInGatewayUtil;
import test.java.util.SystemOutGatewayUtil;

import java.io.ByteArrayOutputStream;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class Task36Test {

    @Test
    public void test36() throws Exception {
        SystemOutGatewayUtil.setCustomOut();
        ByteArrayOutputStream out = SystemOutGatewayUtil.getOutputArray();
        out.reset();

        SystemInGatewayUtil.setCustomIn("4\n5");
        Task36.main(null);
        String[] output = out.toString().trim().split("\n");

        int index = 0;
        for (int i = 0; i < output.length; i++) {
            if(output[i].trim().equals("88888"))
            {
                break;
            }
            index++;
        }

        assertEquals(4, output.length - index);

        for(int j = index; j < output.length; j++)
            Assert.assertEquals("88888", output[j].trim());
    }
}