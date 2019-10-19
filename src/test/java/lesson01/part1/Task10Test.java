package lesson01.part1;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import util.SystemOutGatewayUtil;

@RunWith(JUnit4.class)
public class Task10Test {
    String output;

    @Before
    public void setUp() throws Exception {
        SystemOutGatewayUtil.clearOutput();
        SystemOutGatewayUtil.setCustomOut();

        Task10.main(null);
        output = SystemOutGatewayUtil.getOutputArray().toString();
    }

    @After
    public void tearDown() throws Exception {
        SystemOutGatewayUtil.setOriginalOut();
    }

    @Test
    public void checkOutputType() {
        Assert.assertTrue("Solution must print int value",
                !output.contains("."));
    }

    @Test
    public void checkMultiplicity() {
        int num = Integer.parseInt(output.substring(0, output.length()-1));
        Assert.assertTrue("Solution must print output a multiple of 60",
                num % 60 == 0);
    }
}