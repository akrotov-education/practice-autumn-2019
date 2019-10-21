package lesson01.part2;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import util.SystemOutGatewayUtil;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

@RunWith(JUnit4.class)
public class Task03Test {

    @Test
    public void test03()
    {
        //TODO: check println callings
        SystemOutGatewayUtil.setCustomOut();
        ByteArrayOutputStream out = SystemOutGatewayUtil.getOutputArray();
        out.reset();
        Task03.hackSalary(700);

        Assert.assertEquals("Твоя зарплата составляет: 800 долларов в месяц", out.toString().trim());

        out.reset();

        Task03.main(null);
        Assert.assertFalse(out.toString().isEmpty());
    }
}