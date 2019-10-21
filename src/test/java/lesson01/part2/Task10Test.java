package test.java.lesson01.part2;

import main.java.lesson01.part2.Task10;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import test.java.util.SystemOutGatewayUtil;

import java.io.ByteArrayOutputStream;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class Task10Test {

    @Test
    public void test10()
    {
        SystemOutGatewayUtil.setCustomOut();
        ByteArrayOutputStream out = SystemOutGatewayUtil.getOutputArray();
        out.reset();

        Task10.main(null);
        Assert.assertEquals(3, out.toString().trim().split("\n").length);

        Assert.assertEquals(1, Task10.min(2, 1));
        Assert.assertEquals(1, Task10.min(1, 2));

    }

}