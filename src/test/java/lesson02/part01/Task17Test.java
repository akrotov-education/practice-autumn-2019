package lesson02.part01;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import foloke.utils.SystemInGatewayUtil;
import util.SystemOutGatewayUtil;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class Task17Test {
    @Test
    public void test17() throws Exception
    {
        SystemOutGatewayUtil.setCustomOut();
        ByteArrayOutputStream out = SystemOutGatewayUtil.getOutputArray();
        out.reset();

        SystemInGatewayUtil.setCustomIn("Вася\n8");

        Task17.main(null);
        String[] output = out.toString().trim().split("\n");
        boolean found = false;

        for (String outString : output)
        {
           if(outString.trim().equals("Вася захватит мир через 8 лет. Му-ха-ха!"))
           {
               found = true;
           }
        }

        Assert.assertTrue("что с выводом", found);
    }
}