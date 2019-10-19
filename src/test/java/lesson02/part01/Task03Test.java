package lesson02.part01;

import org.junit.Assert;
import org.junit.Test;
import util.SystemOutGatewayUtil;

import java.io.ByteArrayOutputStream;

import static org.junit.Assert.*;

public class Task03Test {
    @Test
    public void test1 () {
        double res = Task03.convertEurToUsd(3, 1.1);
        Assert.assertTrue("Message", Math.abs(res - 3.3) < 0.0001);
    }
    @Test
    public void test2 () {
        double res = Task03.convertEurToUsd(12, 1.1);
        Assert.assertTrue("Message", Math.abs(res - 13.2) < 0.0001);
    }
}