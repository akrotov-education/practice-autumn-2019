package lesson01.part1;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import util.SystemOutGatewayUtil;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

@RunWith(JUnit4.class)
public class Task12Test {

    @Test
    public void main() {
        SystemOutGatewayUtil.setCustomOut();
        ByteArrayOutputStream out = SystemOutGatewayUtil.getOutputArray();
        Task12.main(null);
        String s = out.toString();
        Assert.assertEquals("Яблоко\nПерсик\n", s);

        out.reset();
    }
}