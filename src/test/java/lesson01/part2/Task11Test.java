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
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.*;

public class Task11Test {
    public static String s;
    public static List<String> collect;

    @Before
    public void before(){
        SystemOutGatewayUtil.setCustomOut();
        Task11.main(null);
        SystemOutGatewayUtil.setOriginalOut();
        ByteArrayOutputStream ouputArr=SystemOutGatewayUtil.getOutputArray() ;
        s = ouputArr.toString();


        String fileName=".\\src\\main\\java\\lesson01\\part2\\Task11.java";
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            collect = stream.collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test11_1() {

        Assert.assertTrue("Не пройдено 1е условие!", collect.get(27).contains("System.out.print"));
    }

    @Test
    public void test11_2() {

        Assert.assertFalse("Не пройдено 2е условие!", collect.get(20).contains("System.out.print") &&
                                                                        collect.get(21).contains("System.out.print") &&
                                                                            collect.get(22).contains("System.out.print"));
    }

    @Test
    public void test11_3() {

        Assert.assertTrue("Не пройдено 3е условие!", collect.get(25).contains("min(") &&
                                                                        collect.get(26).contains("min(") &&
                                                                        collect.get(27).contains("min(") &&
                                                                        collect.get(28).contains("min("));
    }

    @Test
    public void test11_4() {

        Assert.assertTrue("Не пройдено 3е условие!", collect.get(25).contains("System.out.println(min") &&
                collect.get(26).contains("System.out.println(min") &&
                collect.get(27).contains("System.out.println(min") &&
                collect.get(28).contains("System.out.println(min"));
    }

    @Test
    public void test11_5() {
        Task11 a=new Task11();

        Assert.assertTrue("Не пройдено 3е условие!", a.min(-100,2,332)==-100);
    }


}