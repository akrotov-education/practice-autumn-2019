package lesson01.part2;

import lesson01.part1.Task01;
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
    public void Output(){
        Task03.main(null);
        ByteArrayOutputStream s = SystemOutGatewayUtil.getOutputArray();
        String s2 = s.toString();
        Assert.assertEquals("Твоя зарплата составляет: 800 долларов в месяц.\n", s2);
    }
    @Test
    public void checkParameter() {
        List<String> lines = ReadFileUtil.readFileInList("./src/main/java/lesson01/part2/Task03.java");
        String lineWithMethodCall = lines.get(21);


        Assert.assertTrue("Method main must call method hackSalary with parameter 700",
                lineWithMethodCall.contains("hackSalary(700);"));
    }
}