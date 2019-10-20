package lesson02.part02;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import util.SystemOutGatewayUtil;

import java.io.ByteArrayOutputStream;

import static org.junit.Assert.*;
@RunWith(PowerMockRunner.class)
public class Task08Test {
    static int catsCount;
    @Test
    @PrepareForTest(Task08.class)
    public void test07() {
        //TODO: count print calls;
        SystemOutGatewayUtil.setCustomOut();
        ByteArrayOutputStream out = SystemOutGatewayUtil.getOutputArray();
        out.reset();

        Task08.main(null);
        Assert.assertFalse(out.toString().isEmpty());

        out.reset();
        Task08.compare(5);
        Assert.assertEquals("Число равно 5", out.toString().trim());

        out.reset();
        Task08.compare(3);
        Assert.assertEquals("Число меньше 5", out.toString().trim());

        out.reset();
        Task08.compare(6);
        Assert.assertEquals("Число больше 5", out.toString().trim());
    }

}