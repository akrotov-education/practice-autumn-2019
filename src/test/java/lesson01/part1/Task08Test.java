package lesson01.part1;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import util.SystemOutGatewayUtil;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RunWith(JUnit4.class)

public class Task08Test {

    private static String fileName = "./src/main/java/lesson01/part1/Task08.java";

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
    public void testOutput() {
        Task08.main(null);
        String str, str1;
        ByteArrayOutputStream outputArray = SystemOutGatewayUtil.getOutputArray(); //SystemOutGatewayUtil.getOutputArray();
        str = outputArray.toString();
        Assert.assertTrue("Вывод не верен", outputArray.toString().contains("2"));
    }

    @Test
    public void testMetod() {
        int actual = Task08.getMetreFromCentimetre(243);
        Assert.assertEquals("В 243 сантиметрах должно быть 2 метра", 2, actual);
    }


}
