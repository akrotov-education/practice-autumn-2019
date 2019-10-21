package lesson01.part2;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import util.SystemOutGatewayUtil;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.*;

public class Task12Test {
    public static String s;
    public static List<String> collect;

    @Before
    public void before() throws Exception {
        SystemOutGatewayUtil.setCustomOut();
        Task12.main(null);
        SystemOutGatewayUtil.setOriginalOut();
        ByteArrayOutputStream ouputArr=SystemOutGatewayUtil.getOutputArray() ;
        s = ouputArr.toString();


        String fileName=".\\src\\main\\java\\lesson01\\part2\\Task12.java";
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            collect = stream.collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void test12_1() {
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
            if (collect.get(i).contains("System.out.print") ){
                var = true;
                break For3;

            }

        }
        Assert.assertTrue("Не пройдено 1е условие!",var );
    }

    @Test
    public void test12_2() {

        int a=0,b=0;
        boolean var=false;
        for (int i = 0; i < collect.size(); i++)
            if (collect.get(i).contains("public static int min(int a, int b, int c, int d)")) {
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
            if (collect.get(i).contains("System.out.print") ){
                var = true;
                break For3;

            }


        }

        for (int i = 0; i < collect.size(); i++)
            if (collect.get(i).contains("public static int min(int a, int b)")) {
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
            if (collect.get(i).contains("System.out.print") ){
                var = true;
                break For3;

            }


        }

        Assert.assertFalse("Не пройдено 2е условие!",var );
    }

    @Test
    public void test12_3() {



        Assert.assertTrue("Не пройдено 3е условие!", collect.get(34).contains("min(-20, -10)") && collect.get(35).contains("min(-40, -10, -30, 40)"));
    }

    @Test
    public void test12_4() {



        Assert.assertTrue("Не пройдено 3е условие!", collect.get(4).contains("min("));
    }

    @Test
    public void test12_5() {
        int a=0,b=0;
        int var=0;
        for (int i = 0; i < collect.size(); i++)
            if (collect.get(i).contains("public static void main(String[] args) throws Exception {")) {
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
            if (collect.get(i).contains("min") ){
                var ++;

            }


        }

        Assert.assertTrue("Не пройдено 5е условие!", s.split("\n").length==var);
    }

    @Test
    public void test12_6() {
        int a=0,b=0;
        boolean var=false;
        for (int i = 0; i < collect.size(); i++)
            if (collect.get(i).contains("public static int min(int a, int b, int c, int d)")) {
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
            if (collect.get(i).contains("min(")) {
                var = true;
                break For3;

            }
        }

        Assert.assertTrue("Не пройдено 6е условие!", var);
    }

    @Test
    public void test12_7() {

        Assert.assertTrue("Не пройдено 7е условие!", Task12.min(1,2,3,4)==1);
    }
}