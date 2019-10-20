package test.java.lesson01.part2;

import main.java.lesson01.part2.Task07;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import test.java.util.SystemOutGatewayUtil;


import java.io.ByteArrayOutputStream;

import static org.junit.Assert.*;
@RunWith(JUnit4.class)
public class Task07Test {

    @Test
    public void test07()
    {
        //TODO: parsing
        SystemOutGatewayUtil.setCustomOut();
        ByteArrayOutputStream out = SystemOutGatewayUtil.getOutputArray();
        out.reset();
        Task07.main(null);

        Assert.assertEquals("19", out.toString().trim());
    }

}