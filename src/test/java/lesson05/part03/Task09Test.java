package lesson05.part03;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import util.ReadFuncBodyUtil;
import util.SystemInGatewayUtil;
import util.SystemOutGatewayUtil;

import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task09Test {
    public static String fileName = "./src/main/java/lesson05/part03/Task09.java";
    public static List<String> collect;
    public static List<String> canMoveInterface;

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
    public void test09CheckInterfaceCanMove() {
        int numberInterfaceCanMove = -1;

        for (int i = 0; i < collect.size(); i++) {
            if (collect.get(i).contains("interface CanMove")) {
                numberInterfaceCanMove = i;
            }
        }

        Assert.assertTrue(
                "В классе Task09 должен быть объявлен интерфейс CanMove.",
                numberInterfaceCanMove > -1
        );
    }

    @Test
    public void test09CheckInterfaceCanFly() {
        int numberInterfaceCanFly = -1;

        for (int i = 0; i < collect.size(); i++) {
            if (collect.get(i).contains("interface CanFly")) {
                numberInterfaceCanFly = i;
            }
        }

        Assert.assertTrue(
                "В классе Task09 должен быть объявлен интерфейс CanFly.",
                numberInterfaceCanFly > -1
        );
    }

    @Test
    public void test09PresentableExtendPerson() {
        boolean isExtendInterface = false;
        Class[] intfs = Task09.CanFly.class.getInterfaces();
        for (int i = 0; i < intfs.length; i++) {
            if (intfs[i].toString().contains("CanMove")) {
                isExtendInterface = true;
            }
        }

        Assert.assertTrue(
                "Интерфейс CanFly должен наследоваться от интерфейса CanMove.",
                isExtendInterface
        );
    }

    @Test
    public void test09SpeedReturnDouble() {
        boolean isSpeedNoParameters = false;
        boolean isSpeedReturnDouble = false;
        int numberInterfaceCanMove = 0;

        for (int i = 0; i < collect.size(); i++) {
            if (collect.get(i).contains("interface CanMove")) {
                numberInterfaceCanMove = i;
            }
        }

        canMoveInterface = ReadFuncBodyUtil.getFuncBody(collect, numberInterfaceCanMove);

        for (String list: canMoveInterface) {
            if (list.contains("speed();")) {
                isSpeedNoParameters = true;
            }
        }

        try {
            if (Task09.CanMove.class.getMethod("speed").toString().contains("Double")) {
                isSpeedReturnDouble = true;
            }
        } catch (Exception e) {

        }

        Assert.assertTrue(
                "В интерфейсе CanMove должен быть объявлен метод speed без параметров и с типом возвращаемого значения Double.",
                isSpeedReturnDouble && isSpeedNoParameters
        );
    }

    @Test
    public void test09CanFlyMethodSpeed() throws NoSuchMethodException {
        boolean isSpeedCanFlyParameter = false;
        boolean isSpeedReturnDouble = false;

        Method[] methods = Task09.CanFly.class.getMethods();
        for (Method list: methods) {
            if (list.toString().contains("CanFly.speed") && list.getParameterCount() == 1) {
                isSpeedCanFlyParameter = true;
            }
        }
        System.out.println(Task09.CanFly.class.getMethods());

        try {
            if (Task09.CanFly.class.getMethod("speed").toString().contains("Double")) {
                isSpeedReturnDouble = true;
            }
        } catch (Exception e) {

        }

        Assert.assertTrue(
                "В интерфейсе CanFly должен быть объявлен метод speed c одним аргументом типа CanFly и с типом возвращаемого значения Double.",
                isSpeedReturnDouble && isSpeedCanFlyParameter
        );
    }
}
