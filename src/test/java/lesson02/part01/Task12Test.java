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

public class Task12Test {
    public static String s;
    public static List<String> collect;

    @Before
    public void before() throws Exception {
        SystemInGatewayUtil.provideInput("");

        SystemOutGatewayUtil.setCustomOut();
        Task12.main(null);
        SystemOutGatewayUtil.setOriginalOut();
        ByteArrayOutputStream ouputArr = SystemOutGatewayUtil.getOutputArray();
        s = ouputArr.toString();




        String fileName="./src/main/java/lesson02/part01/Task12.java";
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
    public void test12_1(){
        int a=0,b=0;
        boolean var=false;
        for (int i = 0; i < collect.size(); i++)
            if (collect.get(i).contains("public static void main(String[] args)")) {
                a = i + 1;
                break;
            }
        for (int i = a; i < collect.size(); i++)
            if (collect.get(i).contains("}") && i != 21) {
                b = i;
                break;
            }
        For3:
        for (int i = a; i < b; i++) {
            if (collect.get(i).contains("print") ){
                var = true;
                break For3;

            }

        }
        Assert.assertTrue("Не пройдено 1е условие!", var);
    }

    @Test
    public void test12_2(){

        Assert.assertTrue("Не пройдено 2е условие!", s.split("\n").length==6);
    }

    @Test
    public void test12_3(){
        boolean val=false;
        String[] a=s.split("\n");
        for1:
        for (int i=0;i<a.length;i++) {
            for (int j = 0; j < a.length; j++) {
                if (i != j && a[j] == a[j])
                    val = true;
                break for1;
            }
        }
        Assert.assertFalse("Не пройдено 3е условие!",val );
    }

    @Test
    public void test12_4(){

        Assert.assertTrue("Не пройдено 4е условие!", s.split("\n").length==6);
    }
}