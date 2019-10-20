package test.java.lesson01.part2;

import main.java.lesson01.part2.Task09;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import test.java.util.SystemOutGatewayUtil;

import java.io.ByteArrayOutputStream;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class Task09Test {

    @Test
    public void test09()
    {
        //TODO: main fields parsing
        SystemOutGatewayUtil.setCustomOut();
        ByteArrayOutputStream out = SystemOutGatewayUtil.getOutputArray();
        out.reset();

        Task09.main(null);

        Assert.assertTrue(out.toString().isEmpty());


    }
}