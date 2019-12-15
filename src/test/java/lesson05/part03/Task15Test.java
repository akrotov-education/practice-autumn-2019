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

public class Task15Test {
    public static String fileName = "./src/main/java/lesson05/part03/Task15.java";
    public static List<String> collect;
    public static List<String> mainFunc;

    static {
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

            collect = stream.collect(Collectors.toList());
            int numberMainFunc = -1;

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
        SystemInGatewayUtil.setOriginalIn();
        SystemOutGatewayUtil.clearOutput();
    }

    @Test
    public void test15CatInsideTask15Class() {
        boolean isInside = false;
        Class[] intfs = Task15.class.getClasses();
        for (int i = 0; i < intfs.length; i++) {
            if (intfs[i].toString().contains("Cat")) {
                isInside = true;
            }
        }

        Assert.assertTrue(
                "Класс Cat должен быть объявлен внутри класса Task15.",
                isInside
        );
    }

    @Test
    public void test15DogInsideTask15Class() {
        boolean isInside = false;
        Class[] intfs = Task15.class.getClasses();
        for (int i = 0; i < intfs.length; i++) {
            if (intfs[i].toString().contains("Dog")) {
                isInside = true;
            }
        }

        Assert.assertTrue(
                "Класс Dog должен быть объявлен внутри класса Task15.",
                isInside
        );
    }

    @Test
    public void test15MouseInsideTask15Class() {
        boolean isInside = false;
        Class[] intfs = Task15.class.getClasses();
        for (int i = 0; i < intfs.length; i++) {
            if (intfs[i].toString().contains("Mouse")) {
                isInside = true;
            }
        }

        Assert.assertTrue(
                "Класс Mouse должен быть объявлен внутри класса Task15.",
                isInside
        );
    }

    @Test
    public void test15WhatCatCanDo() {
        boolean isImplements = false;

        for (String list: collect) {
            if (list.contains("class Cat implements Movable, Eat, Edible")) {
                isImplements = true;
            }
        }

        Assert.assertTrue(
                "Кот(Cat) может передвигаться, может кого-то съесть и может быть сам съеден.",
                isImplements
        );
    }

    @Test
    public void test15WhatMouseCanDo() {
        boolean isImplements = false;

        for (String list: collect) {
            if (list.contains("class Mouse implements Movable, Edible")) {
                isImplements = true;
            }
        }

        Assert.assertTrue(
                "Мышь(Mouse) может передвигаться и может быть съедена.",
                isImplements
        );
    }

    @Test
    public void test15WhatDogCanDo() {
        boolean isImplements = false;

        for (String list: collect) {
            if (list.contains("class Dog implements Movable, Eat")) {
                isImplements = true;
            }
        }

        Assert.assertTrue(
                "Собака(Dog) может передвигаться и съесть кого-то.",
                isImplements
        );
    }
}
