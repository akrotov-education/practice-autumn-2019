package lesson02.part02;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.modules.junit4.PowerMockRunner;
import foloke.utils.SystemInGatewayUtil;
import util.SystemOutGatewayUtil;

import java.io.ByteArrayOutputStream;

import static org.junit.Assert.*;

@RunWith(PowerMockRunner.class)
public class Task13Test {

    @Test
    public void test13() throws Exception {
        SystemOutGatewayUtil.setCustomOut();
        ByteArrayOutputStream out = SystemOutGatewayUtil.getOutputArray();
        out.reset();

        SystemInGatewayUtil.setCustomIn("1");
        Task13.main(null);
        String[] output = out.toString().trim().split("\n");
        Assert.assertEquals("понедельник", output[output.length - 1].trim());
        out.reset();

        SystemInGatewayUtil.setCustomIn("2");
        Task13.main(null);
        output = out.toString().trim().split("\n");
        Assert.assertEquals("вторник", output[output.length - 1].trim());
        out.reset();

        SystemInGatewayUtil.setCustomIn("3");
        Task13.main(null);
        output = out.toString().trim().split("\n");
        Assert.assertEquals("среда", output[output.length - 1].trim());
        out.reset();

        SystemInGatewayUtil.setCustomIn("4");
        Task13.main(null);
        output = out.toString().trim().split("\n");
        Assert.assertEquals("четверг", output[output.length - 1].trim());
        out.reset();

        SystemInGatewayUtil.setCustomIn("5");
        Task13.main(null);
        output = out.toString().trim().split("\n");
        Assert.assertEquals("пятница", output[output.length - 1].trim());
        out.reset();

        SystemInGatewayUtil.setCustomIn("6");
        Task13.main(null);
        output = out.toString().trim().split("\n");
        Assert.assertEquals("суббота", output[output.length - 1].trim());
        out.reset();

        SystemInGatewayUtil.setCustomIn("7");
        Task13.main(null);
        output = out.toString().trim().split("\n");
        Assert.assertEquals("воскресенье", output[output.length - 1].trim());

        out.reset();
        SystemInGatewayUtil.setCustomIn("8");
        Task13.main(null);
        output = out.toString().trim().split("\n");
        Assert.assertEquals("такого дня недели не существует", output[output.length - 1].trim());

        out.reset();
        SystemInGatewayUtil.setCustomIn("0");
        Task13.main(null);
        output = out.toString().trim().split("\n");
        Assert.assertEquals("такого дня недели не существует", output[output.length - 1].trim());

    }
}