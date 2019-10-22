package lesson01.part1;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import util.ReadFileUtil;
import util.SystemOutGatewayUtil;

import java.io.ByteArrayOutputStream;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(JUnit4.class)
public class Task07Test {

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
        Task07.main(null);
        ByteArrayOutputStream s = SystemOutGatewayUtil.getOutputArray();
        String s2 = s.toString();
        Assert.assertEquals("105.8\n", s2);
    }
    @Test
    public void checkParameter() {
        List<String> lines = ReadFileUtil.readFileInList("./src/main/java/lesson01/part1/Task07.java");
        String lineWithMethodCall = lines.get(24);

        Assert.assertTrue("Method main must call System.out.println(convertCelsiusToFahrenheit(41));",
                lineWithMethodCall.contains("System.out.println(convertCelsiusToFahrenheit(41));"));
    }
}