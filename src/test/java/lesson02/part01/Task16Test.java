package lesson02.part01;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import util.SystemOutGatewayUtil;

import java.io.ByteArrayOutputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task16Test {
    public static String fileName = "./src/main/java/lesson02/part01/Task16.java";

    @Before
    public void before() {
        SystemOutGatewayUtil.setCustomOut();
    }

    @After
    public void after() {
        SystemOutGatewayUtil.clearOutput();
    }

    @Test
    public void test16OutputScreen() {
        Task16.main(null);
        SystemOutGatewayUtil.setOriginalOut();
        ByteArrayOutputStream outputArr = SystemOutGatewayUtil.getOutputArray();
        String s = outputArr.toString();

        Assert.assertTrue(
                "Программа должна выводить текст",
                !s.isEmpty()
        );
    }

    @Test
    public void test16FirstSymbol() {
        Task16.main(null);
        SystemOutGatewayUtil.setOriginalOut();
        ByteArrayOutputStream outputArr = SystemOutGatewayUtil.getOutputArray();
        String s = outputArr.toString();

        Pattern p = Pattern.compile("^[日]");
        Matcher m = p.matcher(s);

        Assert.assertTrue(
                "Текст должен начинаться с \"日\"",
                m.find()
        );
    }

    @Test
    public void test16LastSymbol() {
        Task16.main(null);
        SystemOutGatewayUtil.setOriginalOut();
        ByteArrayOutputStream outputArr = SystemOutGatewayUtil.getOutputArray();
        String s = outputArr.toString();

        Pattern p = Pattern.compile("[語]$");
        Matcher m = p.matcher(s);

        Assert.assertTrue(
                "Текст должен заканчиваться на \"語\"",
                m.find()
        );
    }

    @Test
    public void test16RightOutputString() {
        Task16.main(null);
        SystemOutGatewayUtil.setOriginalOut();
        ByteArrayOutputStream outputArr = SystemOutGatewayUtil.getOutputArray();
        String s = outputArr.toString();

        Assert.assertTrue(
                "Выведенный текст должен соответствовать заданию",
                s.split("\n")[0].equals("日本語")
        );
    }
}
