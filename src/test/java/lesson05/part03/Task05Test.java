package lesson05.part03;

import lesson04.part03.Task50;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import util.ReadFuncBodyUtil;
import util.SystemInGatewayUtil;
import util.SystemOutGatewayUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task05Test {
    public static String fileName = "./src/main/java/lesson05/part03/Task05.java";
    public static List<String> collect;
    public static List<String> dreamInterface;

    static {
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

            collect = stream.collect(Collectors.toList());
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
        SystemInGatewayUtil.setOriginalIn();
        SystemOutGatewayUtil.clearOutput();
    }

    @Test
    public void test05ReadKeyboardPublicVariables() {
        boolean isPublic = true;

        int numberDream = 0;

        for (int i = 0; i < collect.size(); i++) {
            if (collect.get(i).contains("interface Dream")) {
                numberDream = i;
            }
        }

        dreamInterface = ReadFuncBodyUtil.getFuncBody(collect, numberDream);

        for (String list: dreamInterface) {
            if (!list.contains("public")) { isPublic = false; }
        }

        Assert.assertTrue(
                "Переменные объявленные в интерфейсе могут иметь только самый широкий уровень доступа(public).",
                isPublic
        );
    }

    @Test
    public void test05IsStaticClass() {
        boolean isStatic = false;

        for (int i = 0; i < collect.size(); i++) {
            if (collect.get(i).contains("class Hobby") && collect.get(i).contains("static")) {
                isStatic = true;
            }
        }

        Assert.assertTrue(
                "Класс Hobby должен быть объявлен с модификатором доступа static.",
                isStatic
        );
    }

    public boolean checkCodeDesire() {
        boolean test = false;

        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

            List<String> collect = stream.collect(Collectors.toList());
            int a = 0;

            for (int i = 0; i < collect.size(); i++)
                if (collect.get(i).contains("interface Desire")) {
                    a = i;
                    break;
                }
            test = collect.get(a).equals("    interface Desire {") &&
                    collect.get(a + 1).equals("    }");

        } catch (Exception e) {
            e.printStackTrace();
        }

        return test;
    }

    public boolean checkCodeDream() {
        boolean test = false;

        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

            List<String> collect = stream.collect(Collectors.toList());
            int a = 0;

            for (int i = 0; i < collect.size(); i++)
                if (collect.get(i).contains("interface Dream")) {
                    a = i;
                    break;
                }
            test = collect.get(a).equals("    interface Dream {") &&
                    collect.get(a + 1).equals("        public static Hobby HOBBY = new Hobby();") &&
                    collect.get(a + 2).equals("    }");

        } catch (Exception e) {
            e.printStackTrace();
        }

        return test;
    }

    @Test
    public void test05NoChangeInterface() {
        Assert.assertTrue(
                "Объявления интерфейсов не изменять.",
                checkCodeDesire() && checkCodeDream()
        );
    }
}
