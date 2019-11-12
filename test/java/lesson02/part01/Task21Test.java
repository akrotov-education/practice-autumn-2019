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
    public void IsInput(){
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
        Assert.assertFalse("Программа не должна считывать данные с клавиатуры",var);
    }
    @Test
    public void IsOutput(){
        Assert.assertFalse("Программа должна выводить текст",s.isEmpty());
    }
    @Test
    public void TextBegin(){
        Assert.assertTrue("Текст должен начинаться с \"Я хочу\"", Pattern.compile("^Я хочу").matcher(s).find());
    }
    @Test
    public void TextEnd(){
        Assert.assertTrue("Текст должен заканчиваться на \"изучаю Java\"", Pattern.compile("изучаю Java\r\n").matcher(s).find());
    }

    @Test
    public void Is10Lines(){
        Assert.assertTrue("Текст должен состоять из 10 строк", s.split("\n").length==10);
    }

    @Test
    public void EqualsRightResult(){
        Assert.assertEquals("Выводимый текст должен соответствовать заданию", ("Я хочу большую зарплату, и для этого изучаю Java\r\n" +
                "Я хочу большую зарплату, и для этого изучаю Java\r\n" +
                "Я хочу большую зарплату, и для этого изучаю Java\r\n" +
                "Я хочу большую зарплату, и для этого изучаю Java\r\n" +
                "Я хочу большую зарплату, и для этого изучаю Java\r\n" +
                "Я хочу большую зарплату, и для этого изучаю Java\r\n" +
                "Я хочу большую зарплату, и для этого изучаю Java\r\n" +
                "Я хочу большую зарплату, и для этого изучаю Java\r\n" +
                "Я хочу большую зарплату, и для этого изучаю Java\r\n" +
                "Я хочу большую зарплату, и для этого изучаю Java\r\n"), s);
    }

}