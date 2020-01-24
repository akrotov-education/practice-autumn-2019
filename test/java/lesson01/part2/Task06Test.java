package lesson01.part2;

import lesson01.part1.Task01;
import lesson01.part1.Task03;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import util.SystemOutGatewayUtil;

import java.io.ByteArrayOutputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//import static jdk.vm.ci.meta.JavaKind.Char;
//import static org.junit.Assert.*;

public class Task06Test {
    public static String fileName = "./src/main/java/lesson01/part2/Task06.java";

    @Before
    public void before(){
        SystemOutGatewayUtil.setCustomOut();
    }

    @After
    public void after(){
        SystemOutGatewayUtil.setOriginalOut();
    }

    @Test
    public void IsTextOut(){
        Task06.main(null);
        ByteArrayOutputStream stream = SystemOutGatewayUtil.getOutputArray();
        String result = stream.toString();
        Assert.assertNotNull("Программа должна выводить текст", result);
        stream.reset();
    }

    @Test
    public void OutputBegin(){
        Task01.main(null);
        ByteArrayOutputStream stream = SystemOutGatewayUtil.getOutputArray();
        String result = stream.toString();
        Assert.assertTrue("Текст должен начинаться с \"Hello\"", result.startsWith("Будешь"));
        stream.reset();
    }

    @Test
    public void OutputEnd(){
        Task06.main(null);
        ByteArrayOutputStream stream = SystemOutGatewayUtil.getOutputArray();
        String s = stream.toString();
        Pattern p = Pattern.compile("[память]$");
        Matcher m = p.matcher(s);
        Assert.assertTrue("Текст должен заканчиваться на \"память\"", m.find());
    }

    @Test
    public void TextLength(){
        Task06.main(null);
        ByteArrayOutputStream stream = SystemOutGatewayUtil.getOutputArray();
        String result = stream.toString();
        Assert.assertEquals("Текст должен состоять из 52 символов, включая пробелы и знаки препинания",
                52, result.length());
        stream.reset();
    }

    @Test
    public void EqualsRightResult(){
        Task06.main(null);
        ByteArrayOutputStream stream = SystemOutGatewayUtil.getOutputArray();
        String result = stream.toString();
        Assert.assertEquals("Программа должна выводить \"Будешь плохо кодить, придет Java и съест твою память\"",
                result, "Будешь плохо кодить, придет Java и съест твою память");
        stream.reset();
    }


}