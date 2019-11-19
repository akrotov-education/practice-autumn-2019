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
public class Task04Test {
    @Before
    public void before()
    {
        SystemOutGatewayUtil.setCustomOut();
    }

    @After
    public void after()
    {
        SystemOutGatewayUtil.setOriginalOut();
        SystemOutGatewayUtil.clearOutput();
    }

    @Test
    public void testOutput26(){
        Task04.main(null);
        String str,str1;
        ByteArrayOutputStream outputArray = SystemOutGatewayUtil.getOutputArray(); //SystemOutGatewayUtil.getOutputArray();
        str=outputArray.toString();
        Assert.assertTrue("Error 26",outputArray.toString().contains("26"));
    }
    @Test
    public void testOutput25(){
        Task04.main(null);
        String str,str1;
        ByteArrayOutputStream outputArray = SystemOutGatewayUtil.getOutputArray(); //SystemOutGatewayUtil.getOutputArray();
        str=outputArray.toString();
        Assert.assertTrue("Error 25",outputArray.toString().contains("25"));
    }

}
