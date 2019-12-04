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
public class Task05Test {


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
        Task05.main(null);
        ByteArrayOutputStream s = SystemOutGatewayUtil.getOutputArray();
        String s2 = s.toString();
        Assert.assertEquals("9 умножить на 3 равно 27", s2);
    }
    @Test
    public void CheckLineComment() {
        List<String> lines = ReadFileUtil.readFileInList("./src/main/java/lesson01/part1/Task05.java");
        String lineWithMethodCall = lines.get(18);

        Assert.assertTrue("line must contain //", lineWithMethodCall.contains("//"));

        lineWithMethodCall = lines.get(23);

        Assert.assertTrue("line must contain //", lineWithMethodCall.contains("//"));

        lineWithMethodCall = lines.get(24);

        Assert.assertTrue("line must contain //", lineWithMethodCall.contains("//"));

        lineWithMethodCall = lines.get(25);

        Assert.assertTrue("line must contain //", lineWithMethodCall.contains("//"));

        lineWithMethodCall = lines.get(27);

        Assert.assertTrue("line must contain //", lineWithMethodCall.contains("//"));

        lineWithMethodCall = lines.get(28);

        Assert.assertTrue("line must contain //", lineWithMethodCall.contains("//"));
    }
}