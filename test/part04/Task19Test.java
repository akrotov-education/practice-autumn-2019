package part04;

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


public class Task19Test {
    public static String fileName = "./src/main/java/lesson05/part04/Task19.java";

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
    public void ReadKeyboard() throws Exception {
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            List<String> collect = stream.collect(Collectors.toList());
            int number = 0;
            for (int i = 0; i < collect.size(); i++) {
                if (collect.get(i).contains("readLine"))
                    number++;
            }
            Assert.assertTrue("Программа должна считывать с клавиатуры 2 строки.", number == 2);
        } catch (IOException e) {
        }
    }

    @Test
    public void wrongInput() throws Exception {
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            boolean is = false;
            List<String> collect = stream.collect(Collectors.toList());
            int number = 0;
            for (int i = 0; i < collect.size(); i++) {
                if ((collect.get(i).contains("if (a <= 0) throw new Exception();")) &
                        (collect.get(i).contains(" if (b <= 0) throw new Exception();"))){
                        is = true;
                }
            }
            Assert.assertTrue("Программа должна считывать с клавиатуры 2 строки.", is);
        } catch (IOException e) {
        }
    }

    @Test
    public void IsTextOut() throws Exception {
        lesson05.part04.Task19.main(null);
        ByteArrayOutputStream stream = SystemOutGatewayUtil.getOutputArray();
        String result = stream.toString();
        Assert.assertNotNull("Программа должна выводить данные на экран", result);
        stream.reset();
    }

}