package lesson05.part03;

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

public class Task08Test {
    public static String fileName = "./src/main/java/lesson05/part03/Task08.java";
    public static List<String> collect;

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
    public void test08CheckInterfacePerson() {
        int numberInterfacePerson = -1;

        for (int i = 0; i < collect.size(); i++) {
            if (collect.get(i).contains("interface Person")) {
                numberInterfacePerson = i;
            }
        }

        Assert.assertTrue(
                "В классе Task08 должен быть объявлен интерфейс Person.",
                numberInterfacePerson > -1
        );
    }

    @Test
    public void test08CheckInterfacePresentable() {
        int numberInterfacePresentable = -1;

        for (int i = 0; i < collect.size(); i++) {
            if (collect.get(i).contains("interface Presentable")) {
                numberInterfacePresentable = i;
            }
        }

        Assert.assertTrue(
                "В классе Task08 должен быть объявлен интерфейс Presentable.",
                numberInterfacePresentable > -1
        );
    }

    @Test
    public void test08PresentableExtendPerson() {
        boolean isExtendInterface = false;
        Class[] intfs = Task08.Presentable.class.getInterfaces();
        for (int i = 0; i < intfs.length; i++) {
            if (intfs[i].toString().contains("Person")) {
                isExtendInterface = true;
            }
        }

        Assert.assertTrue(
                "Интерфейс Presentable должен наследоваться от интерфейса Person.",
                isExtendInterface
        );
    }

    @Test
    public void test08IsAliveReturnBool() throws NoSuchMethodException {
        boolean isIsAlive = false;

        try {
            if (Task08.Person.class.getMethod("isAlive").toString().contains("boolean")) {
                isIsAlive = true;
            }
        } catch (Exception e) {

        }

        Assert.assertTrue(
                "Тип возвращаемого значения метода isAlive может иметь только два значения.",
                isIsAlive
        );
    }
}
