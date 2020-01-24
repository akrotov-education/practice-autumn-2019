package lesson01.part1;

import lesson02.part02.Task21;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
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

@RunWith(JUnit4.class)
public class Task01Test {

    @Before
    public void setUp() throws Exception {
        SystemOutGatewayUtil.setCustomOut();
    }

    @After
    public void tearDown() throws Exception {
        SystemOutGatewayUtil.setOriginalOut();
        SystemOutGatewayUtil.clearOutput();
    }

    @Test
    public void IsTextOut(){
        Task01.main(null);
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
        Assert.assertTrue("Текст должен начинаться с \"Hello\"", result.startsWith("Hello"));
        stream.reset();
    }

    @Test
    public void OutputEnd(){
        Task01.main(null);
        ByteArrayOutputStream stream = SystemOutGatewayUtil.getOutputArray();
        String result = stream.toString();
        char ch = result.charAt(result.length()-1);
        Assert.assertEquals("Текст должен заканчиваться на \"!\"", '!', ch);
        stream.reset();
    }

    @Test
    public void TextLength(){
        Task01.main(null);
        ByteArrayOutputStream stream = SystemOutGatewayUtil.getOutputArray();
        String result = stream.toString();
        Assert.assertEquals("Текст должен состоять из 12 символов, включая пробелы и знаки препинания",
                12, result.length());
        stream.reset();
    }

    @Test
    public void IsOutputOneLine(){
        Task01.main(null);
        ByteArrayOutputStream stream = SystemOutGatewayUtil.getOutputArray();
        String result = stream.toString();
        Assert.assertFalse("Текст должен состоять из одной строки", result.contains("\n"));
        stream.reset();
    }
}