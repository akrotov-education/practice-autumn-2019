package lesson01.part1;

import org.junit.After;
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

public class Task10Test {
    public static String fileName = "./src/main/java/lesson01/part1/Task10.java";

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
        Task10.main(null);
        ByteArrayOutputStream stream = SystemOutGatewayUtil.getOutputArray();
        String result = stream.toString();
        Assert.assertNotNull("Программа должна выводить текст", result);
        stream.reset();
    }

    @Test
    public void IsOutputIntPos(){
        Task10.main(null);
        ByteArrayOutputStream stream = SystemOutGatewayUtil.getOutputArray();
        String result = stream.toString();
        int value = 0;
        try {
            value = Integer.parseInt(result.substring(0, result.length()-1));
        } catch (Exception e) {
        }
        Assert.assertTrue("Выведенный текст должен быть целым числом", value > 0);
        Assert.assertFalse("Выведенный текст должен быть положительным числом",Integer.parseInt(result) <= 0);
    }

    @Test
    public void IsOutputDiv() {
        Task10.main(null);
        ByteArrayOutputStream outputArray = SystemOutGatewayUtil.getOutputArray();
        String result = outputArray.toString();
        Assert.assertFalse("Выведенное число должно быть кратно 60",Integer.parseInt(result)%60 != 0);
    }
}