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
public class Task06Test {


    @Before
    public void setUp() throws Exception {
        SystemOutGatewayUtil.setCustomOut();

    }

    @After
    public void tearDown() throws Exception {
        SystemOutGatewayUtil.setOriginalOut();
    }
    @Test
    public void checkOutput(){
        Task06.main(null);
        ByteArrayOutputStream s = SystemOutGatewayUtil.getOutputArray();
        String s2 = s.toString();
        Assert.assertEquals("31.400000000000002\n", s2);
    }
    @Test
    public void checkParameter() {
        List<String> lines = ReadFileUtil.readFileInList("./src/main/java/lesson01/part1/Task06.java");
        String lineWithMethodCall = lines.get(18);


        Assert.assertTrue("Method main must call method printCircleLength with parameter 5",
                lineWithMethodCall.contains("printCircleLength(5);"));
    }
}