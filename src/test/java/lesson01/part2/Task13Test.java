package lesson01.part2;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import util.SystemOutGatewayUtil;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

@RunWith(JUnit4.class)
public class Task13Test {

    @Test
    public void test13()
    {
        //TODO: parse out calling print3 form main
        SystemOutGatewayUtil.setCustomOut();
        ByteArrayOutputStream out = SystemOutGatewayUtil.getOutputArray();
        out.reset();

        String testString = "test";

        Task13.print3(testString);

        String[] output = out.toString().trim().split("\n");

        Assert.assertEquals(3, output.length);

        for (String outString: output) {
            Assert.assertEquals(testString, outString.trim());
        }

        out.reset();
        Task13.main(null);

        Assert.assertEquals(3, out.toString().trim().split("\n").length);


    }


}