package lesson01.part1;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import util.SystemOutGatewayUtil;
import java.io.ByteArrayOutputStream;
import java.lang.*;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class Task02Test {

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
    public void IsTextOut(){
        Task02.main(null);
        ByteArrayOutputStream stream = SystemOutGatewayUtil.getOutputArray();
        String result = stream.toString();
        Assert.assertNotNull("Программа должна выводить текст", result);
        stream.reset();
    }

    @Test
    public void OutputBegin(){
        Task02.main(null);
        ByteArrayOutputStream stream = SystemOutGatewayUtil.getOutputArray();
        String result = stream.toString();
        Assert.assertTrue("Текст должен начинаться с \"Hello\"", result.startsWith("Hello"));
    }

    @Test
    public void OutputEnd(){
        Task02.main(null);
        ByteArrayOutputStream stream = SystemOutGatewayUtil.getOutputArray();
        String result = stream.toString();
        char ch = result.charAt(result.length()-1);
        Assert.assertEquals("Текст должен заканчиваться на \"!\"", '!', ch);
    }

    @Test
    public void ThreeLines(){
        Task02.main(null);
        ByteArrayOutputStream stream = SystemOutGatewayUtil.getOutputArray();
        String result = stream.toString();
        //String[] strArr = result.toString().split("\n");
        //Assert.assertEquals("Текст должен состоять из 3 строк", 3, strArr.length);
        //for (String str : strArr) {
        //    Assert.assertEquals(str, "Hello World!");
        //}
        Assert.assertEquals("Текст должен состоять из 3 строк", "Hello World!\nHello World!\nHello World!", result);
    }
}