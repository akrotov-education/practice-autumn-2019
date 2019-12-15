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

public class Task06Test {
    public static String fileName = "./src/main/java/lesson05/part03/Task06.java";
    public static List<String> collect;
    public static List<String> DBObjectInterface;
    public static List<String> userClass;

    static {
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

            collect = stream.collect(Collectors.toList());
            int numberDBObject = 0;
            int numberUserClass = 0;

            for (int i = 0; i < collect.size(); i++) {
                if (collect.get(i).contains("public interface DBObject")) {
                    numberDBObject = i;
                }
            }

            for (int i = 0; i < collect.size(); i++) {
                if (collect.get(i).contains("public static class User")) {
                    numberUserClass = i;
                }
            }

            DBObjectInterface = ReadFuncBodyUtil.getFuncBody(collect, numberDBObject);
            userClass = ReadFuncBodyUtil.getFuncBody(collect, numberUserClass);
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
    public void test06DBObjectInterface() {
        Assert.assertTrue(
                "Интерфейс DBObject должен содержать только объявление метода initializeIdAndName без реализации.",
                DBObjectInterface.get(0).contains(";") && !DBObjectInterface.get(0).contains("{")
        );
    }

    @Test
    public void test06InitializeIdAndName() {
        boolean isRealization = false;

        for (String list: userClass) {
            if (list.contains("public User initializeIdAndName") && list.contains("{")) {
                isRealization = true;
            }
        }

        Assert.assertTrue(
                "Реализуй метод initializeIdAndName в классе User.",
                isRealization
        );
    }

    @Test
    public void test06InitializeIdAndNameReturnUser() {
        Assert.assertTrue(
                "Метод initializeIdAndName в классе User должен иметь тип возвращаемого значения User.",
                (new Task06.User().initializeIdAndName(10, "Sergey")) instanceof Task06.User
        );
    }

    @Test
    public void test06Variables() {
        int id = 10;
        String name = "Sergey";
        Task06.User user =  new Task06.User().initializeIdAndName(id, name);
        Assert.assertTrue(
                "Метод initializeIdAndName должен присваивать значения полям id и name объекта типа User в соответствии с переданными ему параметрами и возвращать этот объект.",
                user.id == id && user.name == name
        );
    }
}
