package lesson02.part02;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import util.SystemInGatewayUtil;
import util.SystemOutGatewayUtil;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class Task13Test {

    @Test
    public void test13() throws Exception {
        SystemOutGatewayUtil.setCustomOut();
        ByteArrayOutputStream out = SystemOutGatewayUtil.getOutputArray();
        out.reset();

        SystemInGatewayUtil.setCustomIn("1");
        Task13.main(null);
        String[] output = out.toString().trim().split("\n");
        Assert.assertEquals("Понедельник", output[output.length - 1].trim());
        out.reset();

        SystemInGatewayUtil.setCustomIn("2");
        Task13.main(null);
        output = out.toString().trim().split("\n");
        Assert.assertEquals("Вторник", output[output.length - 1].trim());
        out.reset();

        SystemInGatewayUtil.setCustomIn("3");
        Task13.main(null);
        output = out.toString().trim().split("\n");
        Assert.assertEquals("Среда", output[output.length - 1].trim());
        out.reset();

        SystemInGatewayUtil.setCustomIn("4");
        Task13.main(null);
        output = out.toString().trim().split("\n");
        Assert.assertEquals("Четверг", output[output.length - 1].trim());
        out.reset();

        SystemInGatewayUtil.setCustomIn("5");
        Task13.main(null);
        output = out.toString().trim().split("\n");
        Assert.assertEquals("Пятница", output[output.length - 1].trim());
        out.reset();

        SystemInGatewayUtil.setCustomIn("6");
        Task13.main(null);
        output = out.toString().trim().split("\n");
        Assert.assertEquals("Суббота", output[output.length - 1].trim());
        out.reset();

        SystemInGatewayUtil.setCustomIn("7");
        Task13.main(null);
        output = out.toString().trim().split("\n");
        Assert.assertEquals("Воскресенье", output[output.length - 1].trim());

        out.reset();
        SystemInGatewayUtil.setCustomIn("8");
        Task13.main(null);
        output = out.toString().trim().split("\n");
        Assert.assertEquals("Такого дня недели не существует", output[output.length - 1].trim());

        out.reset();
        SystemInGatewayUtil.setCustomIn("0");
        Task13.main(null);
        output = out.toString().trim().split("\n");
        Assert.assertEquals("Такого дня недели не существует", output[output.length - 1].trim());

    }
}