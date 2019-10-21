package test.java.lesson02.part01;

import main.java.lesson02.part01.Task06;
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
        //TODO: parse out println and "(", ")"
        SystemOutGatewayUtil.setCustomOut();
        ByteArrayOutputStream out = SystemOutGatewayUtil.getOutputArray();
        out.reset();

        Task06.main(null);
        Assert.assertEquals("382", out.toString().trim());
    }
}