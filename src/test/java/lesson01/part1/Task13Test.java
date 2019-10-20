package test.java.lesson01.part1;

import main.java.lesson01.part1.Task13;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import test.java.util.SystemInGatewayUtil;
import test.java.util.SystemOutGatewayUtil;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class Task13Test {

    @Test
    public void main() {
        SystemOutGatewayUtil.getOutputArray();
        ByteArrayOutputStream out = SystemOutGatewayUtil.getOutputArray();
        Task13.main(null);
        Assert.assertFalse(out.toString().matches("\\d+"));
        Assert.assertTrue((88 * 0.17d) == Task13.getWeight(88));

        out.reset();
    }
}