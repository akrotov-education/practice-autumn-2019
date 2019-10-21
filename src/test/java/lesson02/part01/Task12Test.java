package test.java.lesson02.part01;

import main.java.lesson02.part01.Task12;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import test.java.util.SystemOutGatewayUtil;

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

        String[] strings = new String[]{"Мама", "Мыла", "Раму"};
        String[] testStrings = new String[6];

        int pointer = 0;
        for (String s1: strings) {
            for (String s2: strings)
                if(!s2.equals(s1)) {
                    for (String s3 : strings)
                        if(!s3.equals(s1) && !s3.equals(s2)) {
                            testStrings[pointer] = s1+s2+s3;
                            pointer++;
                        }
                }
        }

        Task12.main(null);
        String[] output = out.toString().trim().split("\n");

        for (String testString : testStrings) {
            boolean found = false;
            for (String outString : output) {
                    if(outString.trim().equals(testString))
                        found = true;
            }

            if(!found)
                Assert.fail("не все строки");
        }
    }
}