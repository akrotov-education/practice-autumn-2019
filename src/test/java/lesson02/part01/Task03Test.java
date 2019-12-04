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

public class Task03Test {
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
        Task03.main(null);
        ByteArrayOutputStream s = SystemOutGatewayUtil.getOutputArray();
        String s2 = s.toString();
        Assert.assertEquals("200.0\n1200.0\n", s2);
    }
    @Test
    public void checkConvertNoPrint() {
        List<String> lines = ReadFileUtil.readFileInList("/Users/Xesavov/Documents/practice-autumn-2019/src/main/java/lesson02/part01/Task03.java");
        String lineWithMethodCall = lines.get(24);


        Assert.assertTrue("Method convertEurToUsd musn`t call Print",
                lineWithMethodCall.contains("return"));
    }
    @Test
    public void checkConvertUses2Times() {
        List<String> lines = ReadFileUtil.readFileInList("/Users/Xesavov/Documents/practice-autumn-2019/src/main/java/lesson02/part01/Task03.java");
        String lineWithMethodCall = lines.get(19);

        Assert.assertTrue("Method main must call convertEurToUsd",
                lineWithMethodCall.contains("convertEurToUsd"));

        lineWithMethodCall = lines.get(20);

        Assert.assertTrue("Method main must call convertEurToUsd",
                lineWithMethodCall.contains("convertEurToUsd"));
    }
}