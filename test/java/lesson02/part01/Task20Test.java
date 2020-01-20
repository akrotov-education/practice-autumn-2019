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

public class Task20Test {
    String fileName ="./src/main/java/lesson02/part01/Task20.java";
    public static String s;
    public static List<String> collect;
    public static String n1="aaa";
    public static String n2="bbb";
    public static String n3="ccc";

    @Before
    public void before() throws Exception {
        SystemInGatewayUtil.provideInput(""+n1+"\n"+n2+"\n"+n3);

        SystemOutGatewayUtil.setCustomOut();
        Task20.main(null);
        SystemOutGatewayUtil.setOriginalOut();
        ByteArrayOutputStream ouputArr = SystemOutGatewayUtil.getOutputArray();
        s = ouputArr.toString();


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
    public void IsTextOut(){
        Assert.assertNotNull("Программа должна выводить текст", s);
    }

    @Test
    public void IsInput(){
        int a=0,b=0;
        boolean var=false;
        for (int i = 0; i < collect.size(); i++)
            if (collect.get(i).contains("public static void main(String[] args)")) {
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
            if (collect.get(i).contains("print") ){
                var = true;
                break For3;
            }
        }
        Assert.assertTrue("Выведенный текст должен содержать введенное имя name1", var);
    }

    @Test
    public void ReadKeyboard() throws Exception {
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            List<String> collect = stream.collect(Collectors.toList());
            boolean number = false;
            for (int i = 0; i < collect.size(); i++) {
                if (collect.get(i).contains("Scanner"))
                    number = true;
            }
            Assert.assertTrue("Программа должна считывать данные с клавиатуры", number == true);
        } catch (IOException e) {
        }
    }

    @Test
    public void IsName1(){
        Assert.assertTrue("Выведенный текст должен содержать введенное имя name1", Pattern.compile(n1).matcher(s).find());
    }

    @Test
    public void IsName2(){
        Assert.assertTrue("Выведенный текст должен содержать введенное имя name2", Pattern.compile(n2).matcher(s).find());
    }

    @Test
    public void IsName3(){
        Assert.assertTrue("Выведенный текст должен содержать введенное имя name3", Pattern.compile(n3).matcher(s).find());
    }

    @Test
    public void EqualsRightResula(){
        Assert.assertEquals("Выведенный тест должен полностью соответствовать заданию",
                (n1+" + "+n2+" + "+n3+" = Чистая любовь, да-да!"), s);
    }

}