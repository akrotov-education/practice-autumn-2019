package lesson02.part01;

import lesson01.part2.Task06;
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

public class Task09Test {
    public static String fileName = "./src/main/java/lesson02/part1/Task09.java";

    @Before
    public void before(){
        SystemOutGatewayUtil.setCustomOut();
    }

    @After
    public void after() {
        SystemInGatewayUtil.setOriginalIn();
        SystemOutGatewayUtil.clearOutput();
    }

    @Test
    public void IsTextOut(){
        Task09.main(null);
        ByteArrayOutputStream stream = SystemOutGatewayUtil.getOutputArray();
        String result = stream.toString();
        Assert.assertNotNull("Программа должна выводить текст", result);
        stream.reset();
    }

    @Test
    public void Is5Lines(){
        Task09.main(null);
        ByteArrayOutputStream stream = SystemOutGatewayUtil.getOutputArray();
        String result = stream.toString();
        int kol = (result.split("\n").length);
        Assert.assertEquals("Выведенный текст должен содержать 5 строк", 5, kol);
    }

    @Test
    public void IsNumsBigger() {
        int is = 0;
        try {
            Stream<String> stream = Files.lines(Paths.get(fileName));
            List<String> collect = stream.collect(Collectors.toList());
            int ind = collect.indexOf("        for (int i=2; i<6; i++){");
            int ind2 = collect.indexOf("        }");
            for (int i = ind; i < ind2; i++) {
                if (collect.get(i).contains("sum += i")) {
                    is ++;
                    break;
                }
            }
            Assert.assertEquals("Число в каждой новой строке должно быть больше предыдущего", 1, is);
        } catch (IOException e) {
        }
    }
}