package lesson01.part2;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import util.SystemOutGatewayUtil;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.*;

public class Task09Test {
    public static String s;
    public static List<String> collect;

    @Before
    public void before(){
        SystemOutGatewayUtil.setCustomOut();


        String fileName="./src/main/java/lesson01/part2/Task09.java";
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            collect = stream.collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @After
    public void after() {
        SystemOutGatewayUtil.setOriginalOut();
        SystemOutGatewayUtil.clearOutput();
    }

    @Test
    public void test09NotWriteInConsole() {
        for (int i = 0; i < collect.size(); i++)
            Assert.assertFalse("Не пройдено 1е условие!", collect.get(i).contains("System.out.print"));
    }

    @Test
    public void test09varWoman() {
        Field[] method=Task09.Woman.class.getFields();
        Assert.assertTrue("Не пройдено 5е условие!", method.length==0);
    }

    @Test
    public void test09varCatDogFish() {
        Field[] method1=Task09.Cat.class.getFields();
        Field[] method2=Task09.Fish.class.getFields();
        Field[] method3=Task09.Dog.class.getFields();



        Assert.assertTrue("Не пройдено 4е условие!", method1.length==1 &&
                method2.length==1 &&
                method3.length==1);
    }

    @Test
    public void test09CheckMain() {


        Assert.assertTrue("Не пройдено 5е условие!",collect.get(21).contains("= new Woman();") &&
                collect.get(18).contains("= new Cat();") &&
                collect.get(23).contains(".owner =") &&
                collect.get(20).contains("new Fish();") &&
                collect.get(23).contains(".owner =") &&
                collect.get(19).contains("new Dog();") &&
                collect.get(23).contains(".owner =") );
    }

}