package lesson01.part2;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import util.SystemOutGatewayUtil;

import java.io.ByteArrayOutputStream;
@RunWith(JUnit4.class)
public class Task04Test {
    @Test
    public void checkValueA(){
        Task04.main(null);
        Task04 obj = Task04.obj;
        int a = obj.a;
        Assert.assertEquals("задано значение а = 10", 10 ,a);
    }
    @Test
    public void checkValueB(){
        Task04.main(null);
        Task04 obj = Task04.obj;
        int b = obj.b;
        Assert.assertEquals("задано значение b = 20", 20 ,b);
    }
    @Before
    public void setUp() throws Exception {
        SystemOutGatewayUtil.setCustomOut();

    }

    @After
    public void tearDown() throws Exception {
        SystemOutGatewayUtil.setOriginalOut();
    }
    @Test
    public void CheckOutput(){
        Task04.main(null);
        ByteArrayOutputStream s = SystemOutGatewayUtil.getOutputArray();
        String s2 = s.toString();
        Assert.assertEquals("30\n200\n", s2);
    }
}