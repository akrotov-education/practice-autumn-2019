package lesson01.part2;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import util.SystemOutGatewayUtil;

import java.io.ByteArrayOutputStream;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class Task14Test {

    @Test
    public void test14()
    {
        //TODO: parse out print3 calling form main
        SystemOutGatewayUtil.setCustomOut();
        ByteArrayOutputStream out = SystemOutGatewayUtil.getOutputArray();
        out.reset();

        String testString = "test";
        Task14.print3(testString);

        String[] output = out.toString().trim().split(" ");
        Assert.assertEquals(3, output.length);

        for (String outString : output) {
            Assert.assertEquals(testString, outString.trim());
        }

        out.reset();
        Task14.main(null);

        Assert.assertEquals(6, out.toString().trim().split(" ").length);


    }
}