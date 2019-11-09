package lesson04.part03;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import util.ReadFuncBodyUtil;
import util.SystemOutGatewayUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task48Test {
    public static String fileName = "./src/main/java/lesson04/part03/Task48.java";
    public static List<String> collect;
    public static List<String> classTask;
    public static List<String> mainFunc;

    static {
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

            collect = stream.collect(Collectors.toList());
            int numberMainFunc = 0;
            int numberClass = 0;

            for (int i = 0; i < collect.size(); i++) {
                if (collect.get(i).contains("public static void main(String[] args)")) {
                    numberMainFunc = i;
                }
            }

            for (int i = 0; i < collect.size(); i++) {
                if (collect.get(i).contains("public class Task48")) {
                    numberClass = i;
                }
            }

            classTask = ReadFuncBodyUtil.getFuncBody(collect, numberClass);
            mainFunc = ReadFuncBodyUtil.getFuncBody(collect, numberMainFunc);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Before
    public void before() {
        SystemOutGatewayUtil.setCustomOut();
    }

    @Test
    public void test48CheckClasses() {
        int countClasses = 0;

        for (String s : classTask) {
            if (s.contains("MyException ")) {
                countClasses++;
            }
            if (s.contains("MyException2 ")) {
                countClasses++;
            }
            if (s.contains("MyException3 ")) {
                countClasses++;
            }
            if (s.contains("MyException4 ")) {
                countClasses++;
            }
        }
        Assert.assertTrue(
            "В классе Solution должно быть 4 вложенных класса: MyException, MyException2, MyException3 и MyException4",
            countClasses == 4
        );
    }

    @Test
    public void test48ExtendsExceptions() {
        Class str = Task48.MyException.class.getSuperclass();
        boolean a = Exception.class.isAssignableFrom(str);
        str = Task48.MyException2.class.getSuperclass();
        boolean b = Exception.class.isAssignableFrom(str);
        str = Task48.MyException3.class.getSuperclass();
        boolean c = Exception.class.isAssignableFrom(str);
        str = Task48.MyException4.class.getSuperclass();
        boolean d = Exception.class.isAssignableFrom(str);

        Assert.assertTrue(
                "Все вложенные классы должны быть унаследованы от классов исключений",
                a && b && c && d
        );
    }

    @Test
    public void test48CheckedExceptions() {
        int countCheckedExceptions = 0;

        Class str = Task48.MyException.class.getSuperclass();
        if (!RuntimeException.class.isAssignableFrom(str)) {
            countCheckedExceptions++;
        }

        str = Task48.MyException2.class.getSuperclass();
        if (!RuntimeException.class.isAssignableFrom(str)) {
            countCheckedExceptions++;
        }

        str = Task48.MyException3.class.getSuperclass();
        if (!RuntimeException.class.isAssignableFrom(str)) {
            countCheckedExceptions++;
        }

        str = Task48.MyException4.class.getSuperclass();
        if (!RuntimeException.class.isAssignableFrom(str)) {
            countCheckedExceptions++;
        }

        Assert.assertTrue(
            "Два класса из четырех должны быть checked исключениями",
            countCheckedExceptions == 2
        );
    }

    @Test
    public void test48UncheckedExceptions() {
        int countUncheckedExceptions = 0;

        Class str = Task48.MyException.class.getSuperclass();
        if (RuntimeException.class.isAssignableFrom(str)) {
            countUncheckedExceptions++;
        }

        str = Task48.MyException2.class.getSuperclass();
        if (RuntimeException.class.isAssignableFrom(str)) {
            countUncheckedExceptions++;
        }

        str = Task48.MyException3.class.getSuperclass();
        if (RuntimeException.class.isAssignableFrom(str)) {
            countUncheckedExceptions++;
        }

        str = Task48.MyException4.class.getSuperclass();
        if (RuntimeException.class.isAssignableFrom(str)) {
            countUncheckedExceptions++;
        }

        Assert.assertTrue(
            "Два класса из четырех должны быть unchecked исключениями",
                countUncheckedExceptions == 2
        );
    }
}
