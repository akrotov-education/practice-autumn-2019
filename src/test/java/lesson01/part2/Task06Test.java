package test.java.lesson01.part2;

import main.java.lesson01.part2.Task06;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import test.java.util.SystemOutGatewayUtil;

import java.io.ByteArrayOutputStream;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class Task06Test {
    @Test
    public void test06()
    {
        SystemOutGatewayUtil.setCustomOut();
        ByteArrayOutputStream out = SystemOutGatewayUtil.getOutputArray();
        out.reset();
        Task06.main(null);

        Assert.assertEquals("Будешь плохо кодить, придет Java и съест твою память", out.toString().trim());
    }
}