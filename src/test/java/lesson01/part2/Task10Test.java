package lesson01.part2;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import util.SystemOutGatewayUtil;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.*;

public class Task10Test {
    public static String s;
    public static List<String> collect;
    public  static ArrayList<String> methodName;
    public  static ArrayList<Integer> methodS;
    public  static ArrayList<Integer> methodF;

    @Before
    public void before(){
        SystemOutGatewayUtil.setCustomOut();
        Task10.main(null);
        SystemOutGatewayUtil.setOriginalOut();
        ByteArrayOutputStream ouputArr=SystemOutGatewayUtil.getOutputArray() ;
        s = ouputArr.toString();


        String fileName="./src/main/java/lesson01/part2/Task10.java";
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
    public void test11_1() {

        Assert.assertTrue("Не пройдено 1е условие!", collect.get(24).contains("System.out.print"));
    }

    @Test
    public void test11_2() {

        Assert.assertFalse("Не пройдено 2е условие!", collect.get(20).contains("System.out.print") &&
                collect.get(21).contains("System.out.print") &&
                collect.get(19).contains("System.out.print"));
    }

    @Test
    public void test11_3() {

        Assert.assertTrue("Не пройдено 3е условие!", collect.get(24).contains("min(") &&
                collect.get(25).contains("min(") &&
                collect.get(26).contains("min("));
    }

    @Test
    public void test11_4() {

        Assert.assertTrue("Не пройдено 4е условие!", collect.get(24).contains("System.out.println(min") &&
                collect.get(25).contains("System.out.println(min") &&
                collect.get(26).contains("System.out.println(min"));
    }

    @Test
    public void test11_5() {
        Task10 a=new Task10();

        Assert.assertTrue("Не пройдено 5е условие!", a.min(-100,332)==-100);
    }

}