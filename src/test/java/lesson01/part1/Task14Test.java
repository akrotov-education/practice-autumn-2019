package test.java.lesson01.part1;

import main.java.lesson01.part1.Task14;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import test.java.util.SystemOutGatewayUtil;

import java.io.ByteArrayOutputStream;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class Task14Test {

    @Test
    public void main() {
        SystemOutGatewayUtil.setCustomOut();
        ByteArrayOutputStream out = SystemOutGatewayUtil.getOutputArray();

        Task14.main(null);

        Assert.assertEquals("20", out.toString().trim());

        out.reset();
    }
}