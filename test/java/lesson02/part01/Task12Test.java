package lesson02.part01;

import lesson01.part2.Task03;
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
        }
    }

    @After
    public void after() {
        SystemInGatewayUtil.setOriginalIn();
        SystemOutGatewayUtil.clearOutput();
    }

    @Test
    public void IsTextOut(){
        Task12.main(null);
        ByteArrayOutputStream stream = SystemOutGatewayUtil.getOutputArray();
        String result = stream.toString();
        Assert.assertNotNull("Программа должна выводить текст", result);
        stream.reset();
    }

    @Test
    public void Is6Lines(){
        Assert.assertTrue("Выведенный текст должен содержать 6 строк", s.split("\n").length==6);
    }

    @Test
    public void UnicText(){
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
        Assert.assertFalse("Текст в каждой строке должен быть уникален",val );
    }

    @Test
    public void AllKombos(){
        Assert.assertTrue("Должны быть выведены все возможные комбинации", s.split("\n").length==6);
    }
}