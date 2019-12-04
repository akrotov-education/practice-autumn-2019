package lesson04.part02;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import util.ReadFuncBodyUtil;
import util.SystemOutGatewayUtil;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task31Test {
    public static String fileName = "./src/main/java/lesson04/part02/Task31.java";
    public static List<String> collect;
    public static List<String> mainFunc;

    static {
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

            collect = stream.collect(Collectors.toList());
            int numberHMainFunc = 0;

            for (int i = 0; i < collect.size(); i++) {
                if (collect.get(i).contains("public static void main(String[] args)")) {
                    numberHMainFunc = i;
                }
            }

            mainFunc = ReadFuncBodyUtil.getFuncBody(collect, numberHMainFunc);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Before
    public void before() {
        SystemOutGatewayUtil.setCustomOut();
    }

    @Test
    public void test31FiveMethods() {
        Method a[] = Task31.class.getMethods();
        int number = 0;

        for (Method s: a) {
            if (s.toString().contains("lesson04.part02.Task31")) {
                number++;
            }
        }

        Assert.assertTrue(
                "Класс должен содержать только 5 методов",
                number == 5
        );
    }

    @Test
    public void test31NoSout() {
        Task31.main(null);

        ByteArrayOutputStream outputArr = SystemOutGatewayUtil.getOutputArray() ;
        String s = outputArr.toString();

        Assert.assertTrue(
                "Программа не должна выводить текст на экран",
                s.isEmpty() || s.equals(null)
        );
    }

    @Test
    public void test31ReturnArrayList() {
        boolean isArrayList = false;
        int numberGetListForGet = 0;
        int numberVar = 0;
        String variable = "";

        for (int i = 0; i < collect.size(); i++) {
            if (collect.get(i).contains("public static List getListForGet()")) {
                numberGetListForGet = i;
            }
        }

        List<String> getListForGetFunc = ReadFuncBodyUtil.getFuncBody(collect, numberGetListForGet);

        for (int i = 0; i < getListForGetFunc.size(); i++) {
            if (getListForGetFunc.get(i).contains("new ArrayList")) {
                numberVar = i;
            };
        }

        variable = getListForGetFunc.get(numberVar).split("=")[0].split(" ")[1].trim();

        for (String s: getListForGetFunc) {
            if (s.contains("return") && s.contains(variable)) {
                isArrayList = true;
            }
        }

        Assert.assertTrue(
                "Метод getListForGet должен возвращать список, который лучше всего подходит для операции взятия элемента",
                isArrayList
        );
    }

    @Test
    public void test31GetListForSet() {
        boolean isArrayList = false;
        int numberSetListForGet = 0;
        int numberVar = 0;
        String variable = "";

        for (int i = 0; i < collect.size(); i++) {
            if (collect.get(i).contains("public static List getListForSet()")) {
                numberSetListForGet = i;
            }
        }

        List<String> getListForGetFunc = ReadFuncBodyUtil.getFuncBody(collect, numberSetListForGet);

        for (int i = 0; i < getListForGetFunc.size(); i++) {
            if (getListForGetFunc.get(i).contains("new ArrayList")) {
                numberVar = i;
            };
        }

        variable = getListForGetFunc.get(numberVar).split("=")[0].split(" ")[1].trim();

        for (String s: getListForGetFunc) {
            if (s.contains("return") && s.contains(variable)) {
                isArrayList = true;
            }
        }

        Assert.assertTrue(
                "Метод getListForSet должен возвращать список, который лучше всего подходит для установки значения элемента",
                isArrayList
        );
    }

    @Test
    public void test31GetListForAddOrInsert() {
        boolean isLinkedList = false;
        int numberGetListForAddOrInsert = 0;
        int numberVar = 0;
        String variable = "";

        for (int i = 0; i < collect.size(); i++) {
            if (collect.get(i).contains("public static List getListForAddOrInsert()")) {
                numberGetListForAddOrInsert = i;
            }
        }

        List<String> getListForGetFunc = ReadFuncBodyUtil.getFuncBody(collect, numberGetListForAddOrInsert);

        for (int i = 0; i < getListForGetFunc.size(); i++) {
            if (getListForGetFunc.get(i).contains("new LinkedList")) {
                numberVar = i;
            };
        }

        variable = getListForGetFunc.get(numberVar).split("=")[0].split(" ")[1].trim();

        for (String s: getListForGetFunc) {
            if (s.contains("return") && s.contains(variable)) {
                isLinkedList = true;
            }
        }

        Assert.assertTrue(
                "Метод getListForAddOrInsert должен возвращать список, который лучше всего подходит для операций добавления или вставки элемента",
                isLinkedList
        );
    }

    @Test
    public void test31GetListForRemove() {
        boolean isLinkedList = false;
        int numberGetListForRemove = 0;
        int numberVar = 0;
        String variable = "";

        for (int i = 0; i < collect.size(); i++) {
            if (collect.get(i).contains("public static List getListForAddOrInsert()")) {
                numberGetListForRemove = i;
            }
        }

        List<String> getListForGetFunc = ReadFuncBodyUtil.getFuncBody(collect, numberGetListForRemove);

        for (int i = 0; i < getListForGetFunc.size(); i++) {
            if (getListForGetFunc.get(i).contains("new LinkedList")) {
                numberVar = i;
            };
        }

        variable = getListForGetFunc.get(numberVar).split("=")[0].split(" ")[1].trim();

        for (String s: getListForGetFunc) {
            if (s.contains("return") && s.contains(variable)) {
                isLinkedList = true;
            }
        }

        Assert.assertTrue(
                "Метод getListForRemove должен возвращать список, который лучше всего подходит для операции удаления элемента",
                isLinkedList
        );
    }
}
