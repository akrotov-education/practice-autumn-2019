package lesson01.part2;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import util.SystemOutGatewayUtil;

import java.io.ByteArrayOutputStream;

import static org.junit.Assert.*;
@RunWith(JUnit4.class)
public class Task12Test {

    @Test
    public void test12()
    {
        SystemOutGatewayUtil.setCustomOut();
        ByteArrayOutputStream out = SystemOutGatewayUtil.getOutputArray();
        out.reset();

        Task11.main(null);
        Assert.assertEquals(4, out.toString().trim().split("\n").length);

        Assert.assertEquals(1, Task11.min(2, 1, 3));
        Assert.assertEquals(1, Task11.min(1, 2, 3));
        Assert.assertEquals(1, Task11.min(2, 2, 1));
    }

}