package lesson02.part01;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import util.SystemInGatewayUtil;
import util.SystemOutGatewayUtil;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


import static org.junit.Assert.*;

public class Task08Test {
    public static String s;
    public static List<String> collect;

    @Before
    public void before() throws Exception {
        SystemInGatewayUtil.provideInput("");

        SystemOutGatewayUtil.setCustomOut();
        Task08.main(null);
        SystemOutGatewayUtil.setOriginalOut();
        ByteArrayOutputStream ouputArr;
        ouputArr = SystemOutGatewayUtil.getOutputArray();
        s = ouputArr.toString();

        String fileName="./src/main/java/lesson02/part01/Task08.java";
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            collect = stream.collect(Collectors.toList());
        } catch (IOException e) {
        }
    }

    @After
    public void after() {
        SystemInGatewayUtil.setOriginalIn();
        SystemOutGatewayUtil.clearOutput();
    }

    @Test
    public void CheckOutput(){
        Assert.assertEquals("Выведенное число должно соответствовать заданию","3628800\r\n", s);
    }

    @Test
    public void checkMainContainPrint() {
        Assert.assertTrue("Method main must contain println", collect.get(16).contains("System.out.println"));
    }

    @Test
    public void NumBigger(){
        int num = Integer.parseInt(s.substring(0,7));
        Assert.assertEquals("Выведенное число должно быть больше трех миллионов",true, num>3000000);
    }

    @Test
    public void IsNumInt(){
        int num = Integer.parseInt(s.substring(0,7));
        Assert.assertEquals("Программа должна выводить целое число на экран",true, num%1==0);
    }
}