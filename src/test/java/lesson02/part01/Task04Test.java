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
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.*;
@RunWith(JUnit4.class)

public class Task04Test {
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
        Assert.assertEquals("9.9\n", s2);
    }
    @Test
    public void checkParameter() {
        List<String> lines = ReadFileUtil.readFileInList("/Users/Xesavov/Documents/practice-autumn-2019/src/main/java/lesson02/part01/Task04.java");
        String lineWithMethodCall = lines.get(21);


        Assert.assertTrue("Method main must call method addTenPercent with parameter 9",
                lineWithMethodCall.contains("System.out.println(addTenPercent(9));"));
    }
}