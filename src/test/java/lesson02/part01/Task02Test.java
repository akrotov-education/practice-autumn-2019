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
@RunWith(JUnit4.class)

public class Task02Test {
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
        Task02.main(null);
        ByteArrayOutputStream s = SystemOutGatewayUtil.getOutputArray();
        String s2 = s.toString();
        Assert.assertEquals("Hello, Amigo!\n", s2);
    }
    @Test
    public void checkPrintStringCreate() {
        List<String> lines = ReadFileUtil.readFileInList("/Users/Xesavov/Documents/practice-autumn-2019/src/main/java/lesson02/part01/Task02.java");
        String lineWithMethodCall = lines.get(18);

        Assert.assertTrue("line must contain public static void printString(String s)", lineWithMethodCall.contains("public static void printString(String s)"));
    }
}