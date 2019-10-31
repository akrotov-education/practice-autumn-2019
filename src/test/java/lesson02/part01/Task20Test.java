package lesson02.part01;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import foloke.utils.SystemInGatewayUtil;
import util.SystemOutGatewayUtil;

import java.io.ByteArrayOutputStream;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class Task20Test {
    @Test
    public void test20() throws Exception
    {
        SystemOutGatewayUtil.setCustomOut();
        ByteArrayOutputStream out = SystemOutGatewayUtil.getOutputArray();
        out.reset();

        String name1 = "test1";
        String name2 = "test2";
        String name3 = "test3";

        SystemInGatewayUtil.setCustomIn(name1 + "\n" + name2 + "\n" + name3);

        Task20.main(null);
        String[] output = out.toString().trim().split("\n");
        boolean found = false;

        for (String outString : output) {
            if(outString.trim().equals(name1 + " + " + name2 + " + " + name3 + " = " + "Чистая любовь, да-да!")) {
                found = true;
            }
        }

        Assert.assertTrue("что с выводом?", found);
    }
}