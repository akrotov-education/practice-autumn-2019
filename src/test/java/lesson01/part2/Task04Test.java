package test.java.lesson01.part2;

import main.java.lesson01.part2.Task04;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import test.java.util.ClassReader;
import test.java.util.SystemOutGatewayUtil;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.Field;

import static org.junit.Assert.*;

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
