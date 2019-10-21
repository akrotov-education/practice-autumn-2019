package test.java.lesson02.part02;

import main.java.lesson02.part02.Task37;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import test.java.util.SystemInGatewayUtil;
import test.java.util.SystemOutGatewayUtil;

import java.io.ByteArrayOutputStream;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class Task37Test {

    @Test
    public void test37() throws Exception {
        SystemOutGatewayUtil.setCustomOut();
        ByteArrayOutputStream out = SystemOutGatewayUtil.getOutputArray();
        out.reset();


        Task37.main(null);
        String[] output = out.toString().trim().split("\n");

        int index = 0;
        for (int i = 0; i < output.length; i++) {
            if(output[i].trim().equals("8"))
            {
                break;
            }
            index++;
        }

        assertEquals(10, output.length - index);

        for(int j = index; j < output.length; j++){
            String s = "";
            for(int k = 0; k < j - index + 1; k++)
                s += "8";
            Assert.assertEquals(s, output[j].trim());
        }
    }
}