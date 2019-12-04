package lesson04.part01;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import util.SystemInGatewayUtil;
import util.SystemOutGatewayUtil;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task06Test {

    private static List<String> collect;

    static {
        String fileName = "./src/main/java/lesson04/part01/Task06.java";
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            collect = stream.collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Before
    public void setUp() throws Exception {
        SystemOutGatewayUtil.setCustomOut();
    }

    @After
    public void tearDown() throws Exception {
        SystemOutGatewayUtil.setOriginalOut();
        SystemInGatewayUtil.setOriginalIn();
        SystemOutGatewayUtil.clearOutput();
    }
    @Test
    public void task06ifKeyboardInput() {
        boolean isInputExist = false;
        for (String s : collect) {
            if (s.contains("nextInt()") || s.contains("nextLine()") || s.contains("readLine()")) {
                isInputExist = true;
                break;
            }
        }
        Assert.assertFalse("Программа не должна ничего считывать с клавиатуры",isInputExist);
    }
    @Test
    public void task06ifListCreated() {
        boolean isListCreated = false;
        for (String s : collect) {
            if (s.contains("ArrayList<String>") && s.contains("= new ArrayList"))
                isListCreated = true;
        }
        Assert.assertTrue("Объяви переменную типа ArrayList<String> (список строк) и сразу проинициализируй",
                isListCreated);
    }
//    @Test
//    public void task06OutListSize() throws IOException {
//        Task06.main(null);
//        ByteArrayOutputStream stream = SystemOutGatewayUtil.getOutputArray();
//        String result = stream.toString();
//        Assert.assertEquals("Программа должна вывести размер списка на экран",
//                "5\n", result);
//        stream.reset();
//    }

}