package lesson02.part01;

import lesson01.part2.Task13;
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

public class Task22Test {
    public static String s;
    public static List<String> collect;

    @Before
    public void before() throws Exception {
        int n = 12;
        SystemInGatewayUtil.provideInput(""+n);

        SystemOutGatewayUtil.setCustomOut();
        Task22.main(null);
        SystemOutGatewayUtil.setOriginalOut();
        ByteArrayOutputStream ouputArr = SystemOutGatewayUtil.getOutputArray();
        s = ouputArr.toString();




        String fileName="./src/main/java/lesson02/part01/Task22.java";
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            collect = stream.collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @After
    public void after() {
        SystemInGatewayUtil.setOriginalIn();
    }

    @Test
    public void test22_1() {
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


        Assert.assertTrue("Не пройдено 1е условие!",var);
    }

    @Test
    public void test22_234(){
        Assert.assertTrue("Не пройдено 1е условие!",s.contains("Я буду зарабатывать $12 в час\n"));
    }

}