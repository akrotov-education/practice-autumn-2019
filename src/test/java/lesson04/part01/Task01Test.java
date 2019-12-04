package lesson04.part01;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import util.SystemInGatewayUtil;
import util.SystemOutGatewayUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task01Test {
    private static List<String> collect;

    static {
        String fileName = "./src/main/java/lesson04/part01/Task01.java";
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
    public void task01ifListIntCreated() {
        boolean isListCreated = false;
        for (String s : collect) {
            if (s.contains("int[] ") && s.contains("=new int[20]"))
                isListCreated = true;
        }
        Assert.assertTrue("Метод initializeArray должен создавать массив из 20 целых чисел.",
                isListCreated);
    }
    @Test
    public void task01KeyboardInputToList() {
        boolean isInputExist = false;
        for (String s : collect) {
            if (s.contains("[i]=Integer.parseInt")) {
                isInputExist = true;
                break;
            }
        }
        Assert.assertTrue("Метод initializeArray должен считать 20 чисел и вернуть их в виде массива.",isInputExist);
    }
    @Test
    public void task01MaxElement() {
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};

        int maxNumber = Task01.max(arr);

        Assert.assertTrue("Метод max должен возвращать максимальный элемент из переданного массива.", maxNumber == 20);
    }

    public boolean checkCode(String funcName) {
        boolean test = false;
        int a = 0;

        for (int i = 0; i < collect.size(); i++)
            if (collect.get(i).contains(" void " + funcName)) {
                a = i;
                break;
            }

        test = collect.get(a).equals("  public static void main(String[] args) throws Exception {") &&
                collect.get(a + 1).equals("    int[] array = initializeArray();") &&
                collect.get(a + 2).equals("    int max = max(array);") &&
                collect.get(a + 3).equals("    System.out.println(max);") &&
                collect.get(a + 4).equals("  }");

        return test;
    }

    @Test
    public void task01MainHaveNoChanges() {
        Assert.assertTrue("Метод main изменять нельзя.", checkCode("main"));
    }
}
