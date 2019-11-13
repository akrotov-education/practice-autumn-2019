package lesson04.part02;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import util.ReadFuncBodyUtil;
import util.SystemOutGatewayUtil;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task33Test {
    public static String fileName = "./src/main/java/lesson04/part02/Task33.java";
    public static List<String> collect;
    public static List<String> mainFunc;

    static {
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

            collect = stream.collect(Collectors.toList());
            int numberMainFunc = 0;

            for (int i = 0; i < collect.size(); i++) {
                if (collect.get(i).contains("public static void main(String[] args)")) {
                    numberMainFunc = i;
                }
            }

            mainFunc = ReadFuncBodyUtil.getFuncBody(collect, numberMainFunc);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Before
    public void before() {
        SystemOutGatewayUtil.setCustomOut();
    }

    @After
    public void after() {
        SystemOutGatewayUtil.setOriginalOut();
        SystemOutGatewayUtil.clearOutput();
    }

    @Test
    public void test33Sout() {
        Task33.main(null);
        SystemOutGatewayUtil.setOriginalOut();
        ByteArrayOutputStream outputArr = SystemOutGatewayUtil.getOutputArray();
        String s = outputArr.toString();

        Assert.assertFalse(
                "Программа должна выводить текст на экран",
                s.isEmpty() || s.equals(null)
        );
    }

    @Test
    public void test33CheckClassCat() {
        int numberClassCat = 0;
        boolean checkClassCat = false;

        for (int i = 0; i < collect.size(); i++) {
            if (collect.get(i).contains("public static class Cat")) {
                numberClassCat = i;
                checkClassCat = true;

            }
        }

        List<String> classCat = ReadFuncBodyUtil.getFuncBody(collect, numberClassCat);

        Assert.assertTrue(
            "Внутри класса должен быть public static класс Cat с конструктором по умолчанию",
            checkClassCat && (classCat.size() == 0)
        );
    }

    @Test
    public void test33CreateCats() {
        Set<Task33.Cat> cats = Task33.createCats();
        int countCats = 0;

        for (Task33.Cat cat: cats) {
            if (cat instanceof Task33.Cat) {
                countCats++;
            }
        }

        Assert.assertTrue(
                "Метод createCats() должен возвращать множество (Set), содержащее 3 кота",
                countCats == 3
        );
    }

    @Test
    public void test33PrintCats() {
        Set<Task33.Cat> cats = Task33.createCats();
        Task33.printCats(cats);
        ByteArrayOutputStream outputArr = SystemOutGatewayUtil.getOutputArray() ;
        String s = outputArr.toString();

        Assert.assertTrue(
                "Метод printCats() должен вывести на экран всех котов из множества. Каждый кот с новой строки",
                s.split("\n").length == 3
        );
    }

    @Test
    public void test33CallCreateCats() {
        int countCallCreateCatsFunc = 0;

        for (String s: mainFunc) {
            if (s.contains("createCats();")) {
                countCallCreateCatsFunc++;
            }
        }

        Assert.assertTrue(
                "Метод main() должен один раз вызывать метод createCats()",
                countCallCreateCatsFunc == 1
        );
    }

    @Test
    public void test33CallPrintCats() {
        boolean isCallPrintCats = false;

        for (String s: mainFunc) {
            if (s.contains("printCats();")) {
                isCallPrintCats = true;
            }
        }

        Assert.assertFalse(
            "Метод main() должен вызывать метод printCats()",
            isCallPrintCats
        );
    }

    @Test
    public void test33RemoveCat() {
        int countCats = 0;

        Task33.main(null);

        ByteArrayOutputStream outputArr = SystemOutGatewayUtil.getOutputArray();
        String s = outputArr.toString();

        String[] arr = s.split("\n");

        for (String str: arr) {
            if (str.contains("lesson04.part02.Task33$")) {
                countCats++;
            }
        }

        Assert.assertTrue(
                "Метод main() должен удалять одного кота из множества котов",
                countCats == 2
        );
    }
}
