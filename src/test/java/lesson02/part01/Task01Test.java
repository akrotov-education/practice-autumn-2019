package lesson02.part01;

import lesson01.part1.Task07;
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

import static org.junit.Assert.*;
@RunWith(JUnit4.class)

public class Task01Test {
    @Before
    public void setUp() throws Exception {
        SystemOutGatewayUtil.setCustomOut();

    }
    @After
    public void tearDown() throws Exception {
        SystemOutGatewayUtil.setOriginalOut();
        SystemOutGatewayUtil.clearOutput();
    }
    @Test
    public void CheckOutput(){
        Task01.main(null);
        ByteArrayOutputStream s = SystemOutGatewayUtil.getOutputArray();
        String s2 = s.toString();
        Assert.assertEquals("2\n1\n0\n", s2);
    }
    @Test
    public void test03CallDiv() {
        try (Stream<String> stream = Files.lines(Paths.get("./src/main/java/lesson02/part01/Task01.java"))) {

            List<String> collect = stream.collect(Collectors.toList());
            boolean div = false;
            for (int i = 19; i <= 21; i++)
                div = collect.get(i).contains("div(");

            Assert.assertTrue("Функция main должна вызывать функцию div 3 раза", div);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}