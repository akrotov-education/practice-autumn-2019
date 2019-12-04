package lesson01.part2;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import util.SystemOutGatewayUtil;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
    public void test1(){
        Task02.main(null);
        ByteArrayOutputStream s = SystemOutGatewayUtil.getOutputArray();
        String s2 = s.toString();
        Assert.assertEquals("2\n1\n0\n", s2);
    }
    @Test
    public void test03CallDiv() {
        try (Stream<String> stream = Files.lines(Paths.get("/Users/Xesavov/Documents/practice-autumn-2019/src/main/java/lesson01/part2/Task02.java"))) {

            List<String> collect = stream.collect(Collectors.toList());
            boolean div = false;
            for (int i = 19; i < 21; i++)
                div = collect.get(i).contains("div(") ? true : false;

            Assert.assertTrue("Функция main должна вызывать функцию div 3 раза", div);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}