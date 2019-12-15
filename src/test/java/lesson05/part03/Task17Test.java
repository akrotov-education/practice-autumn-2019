package lesson05.part03;

import lesson05.part03.task17.Task17;
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

public class Task17Test {
    public static String fileName = "./src/main/java/lesson05/part03/task17/Task17.java";
    public static List<String> collect;
    public static List<String> mainFunc;
    public static List<String> todayClass;
    public static List<String> getWeatherTypeFunc;

    static {
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

            collect = stream.collect(Collectors.toList());
            int numberMainFunc = -1;
            int numberTodayClass = -1;
            int numbergetWeatherTypeFunc = -1;

            for (int i = 0; i < collect.size(); i++) {
                if (collect.get(i).contains("static class Today")) {
                    numbergetWeatherTypeFunc = i;
                }
            }

            for (int i = 0; i < collect.size(); i++) {
                if (collect.get(i).contains("static class Today")) {
                    numberTodayClass = i;
                }
            }

            for (int i = 0; i < collect.size(); i++) {
                if (collect.get(i).contains("public static void main(String[] args)")) {
                    numberMainFunc = i;
                }
            }

            mainFunc = ReadFuncBodyUtil.getFuncBody(collect, numberMainFunc);
            todayClass = ReadFuncBodyUtil.getFuncBody(collect, numberTodayClass);
            getWeatherTypeFunc = ReadFuncBodyUtil.getFuncBody(collect, numbergetWeatherTypeFunc);
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
    public void test17WeatherInsideTodayClass() {
        boolean isImplements = false;

        for (String list: collect) {
            if (list.contains("static class Today implements Weather")) {
                isImplements = true;
            }
        }

        Assert.assertTrue(
                "Интерфейс Weather должен быть реализован в классе Today.",
                isImplements
        );
    }

    @Test
    public void test17GetWeatherTypeRealization() {
        boolean isRealization = false;

        for (String list: todayClass) {
            if (list.contains("public String getWeatherType() {")) {
                isRealization = true;
            }
        }

        Assert.assertTrue(
                "В классе Today должен быть реализован метод getWeatherType объявленный в интерфейсе Weather.",
                isRealization
        );
    }

    @Test
    public void test17GetWeatherTypeReturnString() {
        boolean isString = false;

        for (String list: todayClass) {
            if (list.contains("String getWeatherType")) {
                isString = true;
            }
        }

        Assert.assertTrue(
                "Тип возвращаемого значения метода getWeatherType должен быть String.",
                isString
        );
    }

    @Test
    public void test16DeclareNAME() {
        boolean isReturnType = false;

        for (String list: getWeatherTypeFunc) {
            if (list.contains("return type;")) {
                isReturnType = true;
            }
        }

        Assert.assertTrue(
                "Метод getWeatherType должен возвращать значение переменной type.",
                isReturnType
        );
    }
}
