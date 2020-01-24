package lesson01.part1;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import util.SystemOutGatewayUtil;

import java.io.ByteArrayOutputStream;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class Task03Test {

    @Before
    public void before(){
        SystemOutGatewayUtil.setCustomOut();
    }

    @After
    public void after(){
        SystemOutGatewayUtil.setOriginalOut();
        SystemOutGatewayUtil.clearOutput();
    }

    @Test
    public void TextLength(){
        Task03.main(null);
        ByteArrayOutputStream stream = SystemOutGatewayUtil.getOutputArray();
        String result = stream.toString();
        Assert.assertEquals("Текст должен состоять из 4 цифр", 4, result.length());
        stream.reset();
    }

    @Test
    public void IsTextOut(){
        Task03.main(null);
        ByteArrayOutputStream stream = SystemOutGatewayUtil.getOutputArray();
        String result = stream.toString();
        Assert.assertNotNull("Программа должна выводить текст", result);
        stream.reset();
    }

    @Test
    public void OutputBegin(){
        Task03.main(null);
        ByteArrayOutputStream stream = SystemOutGatewayUtil.getOutputArray();
        String result = stream.toString();
        Assert.assertTrue("Текст должен начинаться с \"19\"", result.startsWith("19"));
        stream.reset();
    }

    @Test
    public void EqualsRightResult(){
        Task03.main(null);
        ByteArrayOutputStream stream = SystemOutGatewayUtil.getOutputArray();
        String result = stream.toString();
        Assert.assertTrue("Программа должна выводить \"1921\"",
                1921 == Integer.parseInt(result));
        stream.reset();
    }
}