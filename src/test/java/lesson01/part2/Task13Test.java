package lesson01.part2;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import util.SystemOutGatewayUtil;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.*;

public class Task13Test {
    public static String s;
    public static List<String> collect;

    @Before
    public void before(){
        SystemOutGatewayUtil.setCustomOut();
        Task13.main(null);
        SystemOutGatewayUtil.setOriginalOut();
        ByteArrayOutputStream ouputArr=SystemOutGatewayUtil.getOutputArray() ;
        s = ouputArr.toString();


        String fileName="./src/main/java/lesson01/part2/Task13.java";
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            collect = stream.collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @After
    public void after() {
        SystemOutGatewayUtil.setOriginalOut();
        SystemOutGatewayUtil.clearOutput();
    }

    @Test
    public void test13_1() {

        Assert.assertTrue("Не пройдено 1е условие!", s.contains(""));
    }

    @Test
    public void test13_2() {

        Assert.assertFalse("Не пройдено 2е условие!",
                collect.get(25).contains("System.out.print"));
    }

    @Test
    public void test14_3() {

        Assert.assertTrue("Не пройдено 3е условие!",
                collect.get(19).contains("System.out.print") );
    }

    @Test
    public void test14_4() {

        Assert.assertTrue("Не пройдено 4е условие!",
                             collect.get(24).contains("print3(") );
    }

    @Test
    public void test14_5() {

        Assert.assertTrue("Не пройдено 5е условие!",
                s.contains("I love you!\nI love you!\n"));
    }

}