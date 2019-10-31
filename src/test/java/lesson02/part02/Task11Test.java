package lesson02.part02;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.modules.junit4.PowerMockRunner;
import util.SystemOutGatewayUtil;

import java.io.ByteArrayOutputStream;

import static org.junit.Assert.*;


@RunWith(PowerMockRunner.class)
public class Task11Test {
    @Test
    public void test11() {
        SystemOutGatewayUtil.setCustomOut();
        ByteArrayOutputStream out = SystemOutGatewayUtil.getOutputArray();
        out.reset();

        Task11.checkSeason(1);
        Assert.assertEquals("зима", out.toString().trim());
        out.reset();
        Task11.checkSeason(2);
        Assert.assertEquals("зима", out.toString().trim());
        out.reset();
        Task11.checkSeason(3);
        Assert.assertEquals("весна", out.toString().trim());
        out.reset();
        Task11.checkSeason(4);
        Assert.assertEquals("весна", out.toString().trim());
        out.reset();
        Task11.checkSeason(5);
        Assert.assertEquals("весна", out.toString().trim());
        out.reset();
        Task11.checkSeason(6);
        Assert.assertEquals("лето", out.toString().trim());
        out.reset();
        Task11.checkSeason(7);
        Assert.assertEquals("лето", out.toString().trim());
        out.reset();
        Task11.checkSeason(8);
        Assert.assertEquals("лето", out.toString().trim());
        out.reset();
        Task11.checkSeason(9);
        Assert.assertEquals("осень", out.toString().trim());
        out.reset();
        Task11.checkSeason(10);
        Assert.assertEquals("осень", out.toString().trim());
        out.reset();
        Task11.checkSeason(11);
        Assert.assertEquals("осень", out.toString().trim());
        out.reset();
        Task11.checkSeason(12);
        Assert.assertEquals("зима", out.toString().trim());
        out.reset();

        Task11.main(null);
        Assert.assertFalse(out.toString().isEmpty());
    }
}