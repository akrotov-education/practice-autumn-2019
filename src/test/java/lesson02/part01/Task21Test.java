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
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.*;

public class Task21Test {
    public static String s;
    public static List<String> collect;

    @Before
    public void before() throws Exception {
        SystemInGatewayUtil.provideInput("");

        SystemOutGatewayUtil.setCustomOut();
        Task21.main(null);
        SystemOutGatewayUtil.setOriginalOut();
        ByteArrayOutputStream ouputArr = SystemOutGatewayUtil.getOutputArray();
        s = ouputArr.toString();




        String fileName="./src/main/java/lesson02/part01/Task21.java";
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            collect = stream.collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @After
    public void after() {
        SystemInGatewayUtil.setOriginalIn();
        SystemOutGatewayUtil.clearOutput();
    }

    @Test
    public void test21_1(){
        int a=0,b=0;
        boolean var=false;
        for (int i = 0; i < collect.size(); i++)
            if (collect.get(i).contains("public static void main(String[] args) throws Exception")) {
                a = i + 1;
                break;
            }
        for (int i = a; i < collect.size(); i++)
            if (collect.get(i).contains("}")) {
                b = i;
                break;
            }
        For3:
        for (int i = a; i < b; i++) {
            if (collect.get(i).contains("Input") ){
                var = true;
                break For3;

            }

        }
        Assert.assertFalse("Не пройдено 1е условие!",var);
    }
    @Test
    public void test21_2(){
        Assert.assertFalse("Не пройдено 2е условие!",s.isEmpty());
    }
    @Test
    public void test21_3(){
        Assert.assertTrue("Не пройдено 3е условие!", Pattern.compile("^Я хочу").matcher(s).find());
    }
    @Test
    public void test21_4(){
        Assert.assertTrue("Не пройдено 4е условие!", Pattern.compile("изучаю Java\n").matcher(s).find());
    }

    @Test
    public void test21_5(){
        Assert.assertTrue("Не пройдено 5е условие!", s.split("\n").length==10);
    }

    @Test
    public void test21_6(){
        Assert.assertTrue("Не пройдено 5е условие!", s.equals("Я хочу большую зарплату, и для этого изучаю Java\n" +
                "Я хочу большую зарплату, и для этого изучаю Java\n" +
                "Я хочу большую зарплату, и для этого изучаю Java\n" +
                "Я хочу большую зарплату, и для этого изучаю Java\n" +
                "Я хочу большую зарплату, и для этого изучаю Java\n" +
                "Я хочу большую зарплату, и для этого изучаю Java\n" +
                "Я хочу большую зарплату, и для этого изучаю Java\n" +
                "Я хочу большую зарплату, и для этого изучаю Java\n" +
                "Я хочу большую зарплату, и для этого изучаю Java\n" +
                "Я хочу большую зарплату, и для этого изучаю Java\n"));
    }

}