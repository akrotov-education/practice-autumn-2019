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

public class Task10Test {
    public static String fileName = "./src/main/java/lesson05/part03/Task10.java";
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
    public void test10CleverManExtendBoss() {
        boolean isExtendInterface = false;
        Class[] intfs = Task10.CleverMan.class.getInterfaces();
        for (int i = 0; i < intfs.length; i++) {
            if (intfs[i].toString().contains("Boss")) {
                isExtendInterface = true;
            }
        }

        Assert.assertTrue(
                "Класс CleverMan должен реализовывать подходящий ему интерфейс(Secretary или Boss).",
                isExtendInterface
        );
    }

    @Test
    public void test10SmartGirlExtendSecretary() {
        boolean isExtendInterface = false;
        Class[] intfs = Task10.SmartGirl.class.getInterfaces();
        for (int i = 0; i < intfs.length; i++) {
            if (intfs[i].toString().contains("Secretary")) {
                isExtendInterface = true;
            }
        }

        Assert.assertTrue(
                "Класс SmartGirl должен реализовывать подходящий ему интерфейс(Secretary или Boss).",
                isExtendInterface
        );
    }

    @Test
    public void test10SecretaryExtendPerson() {
        boolean isExtendInterface = false;
        Class[] intfs = Task10.Secretary.class.getInterfaces();
        for (int i = 0; i < intfs.length; i++) {
            if (intfs[i].toString().contains("Person")) {
                isExtendInterface = true;
            }
        }

        Assert.assertTrue(
                "Секретарь(Secretary) является человеком(Person).",
                isExtendInterface
        );
    }

    @Test
    public void test10BossExtendPersonAndWorkable() {
        boolean isExtendInterface = false;
        Class[] intfs = Task10.Boss.class.getInterfaces();
        for (int i = 0; i < intfs.length; i++) {
            if (intfs[i].toString().contains("Person") || intfs[i].toString().contains("Workable")) {
                isExtendInterface = true;
            }
        }

        Assert.assertTrue(
                "Начальник(Boss) является человеком(Person), а также любит много работать(Workable).",
                isExtendInterface
        );
    }
}
