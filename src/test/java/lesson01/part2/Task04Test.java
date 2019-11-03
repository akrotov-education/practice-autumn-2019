package lesson01.part2;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import util.ClassReader;
import util.SystemOutGatewayUtil;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

@RunWith(JUnit4.class)
public class Task04Test {

    @Test
    public void test04()
    {
        SystemOutGatewayUtil.setCustomOut();
        ByteArrayOutputStream out = SystemOutGatewayUtil.getOutputArray();
        out.reset();

        int a = 1;
        int b = 2;


        boolean foundA = false;
        boolean foundB = false;
        String clString = "";
        ClassReader reader = ClassReader.openClass(Task04.class);



        Task04.main(null);
        String[] output = out.toString().trim().split("\n");

        Assert.assertEquals(2, output.length);
        Assert.assertEquals(a + b, Integer.parseInt(output[0].trim()));
        Assert.assertEquals(a * b, Integer.parseInt(output[1].trim()));


    }
}
