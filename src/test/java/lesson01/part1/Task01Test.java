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
public class Task01Test {

    @Before
    public void before()
    {
        SystemOutGatewayUtil.setCustomOut();
    }

    @After
    public void after()
    {
        SystemOutGatewayUtil.setOriginalOut();
    }

    @Test
    public void testOutput0(){
        Task01.main(null);
        ByteArrayOutputStream outputArray = SystemOutGatewayUtil.getOutputArray(); //SystemOutGatewayUtil.getOutputArray();
        Assert.assertTrue("Error Output",outputArray.toString().contentEquals("Hellooooooo!"));
    }
    @Test
    public void testOutput1(){
        Task01.main(null);
        ByteArrayOutputStream outputArray = SystemOutGatewayUtil.getOutputArray(); //SystemOutGatewayUtil.getOutputArray();
        Assert.assertTrue("Error Output Hello",outputArray.toString().contains("Hello"));
    }
    @Test
    public void testOutput2(){
        Task01.main(null);
        ByteArrayOutputStream outputArray = SystemOutGatewayUtil.getOutputArray(); //SystemOutGatewayUtil.getOutputArray();
        Assert.assertTrue("Error Output !",outputArray.toString().contains("!"));

    }
    @Test
    public void testOutput12cimv(){
        Task01.main(null);
        Boolean f=false;
        ByteArrayOutputStream outS = SystemOutGatewayUtil.getOutputArray();
        String st = outS.toString();
        if (st.length()==12)
            f=true;

        Assert.assertTrue("Error не 12 символов!",f);

    }

}

/*    @Test
    public void testGetMetreFromCentimetre() {
        int actual = Task08.getMetreFromCentimetre(243);
        Assert.assertEquals("В 243 сантиметрах должно быть 2 метра", 2, actual);
    }
    */
