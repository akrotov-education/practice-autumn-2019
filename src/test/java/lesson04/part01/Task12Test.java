package lesson04.part01;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import util.SystemInGatewayUtil;
import util.SystemOutGatewayUtil;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RunWith(JUnit4.class)
public class Task12Test {
    private static List<String> collect;

    static {
        String fileName = "./src/main/java/lesson04/part01/Task12.java";
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
    public void task12ifKeyboardInput() {
        boolean isInputExist = false;
        for (String s : collect) {
            if (s.contains("nextInt()") || s.contains("nextLine()") || s.contains("readLine()")) {
                isInputExist = true;
                break;
            }
        }
        Assert.assertFalse("Программа не должна получать числа с клавиатуры",isInputExist);
    }

    @Test
    public void task12ifListCreated() {
        boolean isListCreated = false;
        for (String s : collect) {
            if (s.contains("ArrayList<String>") && s.contains("= new ArrayList"))
                isListCreated = true;
        }
        Assert.assertTrue("объяви переменную типа список строк и сразу проинициализируй",
                isListCreated);
    }

    @Test
    public void task12ifListWasAddedAndEditedAndPrinted() {
        Task12.main(null);
        ByteArrayOutputStream stream = SystemOutGatewayUtil.getOutputArray();
        String result = stream.toString();
        Assert.assertEquals("в списке должны быть слова мама, мыла и раму",
                "мама\r\nименно\r\nмыла\r\nименно\r\nраму\r\nименно\r\n",result);
        stream.reset();
    }
}