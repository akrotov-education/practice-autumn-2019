package lesson02.part01;

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
public class Task10Test {
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
        Task10.main(null);
        ByteArrayOutputStream s = SystemOutGatewayUtil.getOutputArray();
        String s2 = s.toString();
        Assert.assertEquals("printing: Hello world!\n", s2);
    }
    @Test
    public void containWriteToConsole() {
        List<String> lines = ReadFileUtil.readFileInList("/Users/Xesavov/Documents/practice-autumn-2019/src/main/java/lesson02/part01/Task10.java");
        String lineWithMethodCall = lines.get(23);


        Assert.assertTrue("Method main must contain public static void writeToConsole",
                lineWithMethodCall.contains("public static void writeToConsole(String s)"));
    }
}