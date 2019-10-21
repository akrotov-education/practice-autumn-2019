package lesson01.part1;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import util.SystemOutGatewayUtil;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

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