package lesson01.part2;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import util.SystemOutGatewayUtil;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

@RunWith(JUnit4.class)
public class Task11Test {

    @Test
    public void test11() throws Exception
    {
        //TODO: parse out min2 and min4
        SystemOutGatewayUtil.setCustomOut();
        ByteArrayOutputStream out = SystemOutGatewayUtil.getOutputArray();
        out.reset();

        Task12.main(null);
        Assert.assertEquals(5, out.toString().trim().split("\n").length);

        Assert.assertEquals(1, Task12.min(2, 1, 3, 4));
        Assert.assertEquals(1, Task12.min(1, 2, 3, 4));
        Assert.assertEquals(1, Task12.min(2, 2, 1, 4));
        Assert.assertEquals(1, Task12.min(2, 2, 4, 1));
        Assert.assertEquals(1, Task12.min(2, 1));
        Assert.assertEquals(1, Task12.min(1, 2));
    }
}