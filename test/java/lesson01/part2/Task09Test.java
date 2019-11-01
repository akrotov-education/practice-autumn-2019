package lesson01.part2;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import util.SystemOutGatewayUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.*;

public class Task09Test {
    public static String fileName = "./src/main/java/lesson01/part2/Task09.java";

    @Before
    public void before(){
        SystemOutGatewayUtil.setCustomOut();
    }

    @After
    public void after(){
        SystemOutGatewayUtil.setOriginalOut();
    }

    @Test
    public void IsOutput() {
        boolean is = false;
        try {
            Stream<String> stream = Files.lines(Paths.get(fileName));
            List<String> collect = stream.collect(Collectors.toList());
            for (int i = 0; i < collect.size(); i++) {
                if (collect.get(i).contains("System.out.print")) {
                    is = true;
                    break;
                }
            }
            Assert.assertEquals("Программа не должна выводить текст на экран", false, is);
        } catch (IOException e) {
        }
    }

    @Test
    public void CallOneTime() {
        int cat =0, dog =0, fish = 0, woman = 0;
        try {
            Stream<String> stream = Files.lines(Paths.get(fileName));
            List<String> collect = stream.collect(Collectors.toList());
            int index = collect.indexOf("    public static void main(String[] args) {");
            int index2 = collect.indexOf("    }");
            for (int i = index; i < index2; i++) {
                if (collect.get(i).contains("Cat")&collect.get(i).contains("= new Cat")) {
                    cat ++;
                }
                if (collect.get(i).contains("Dog")&collect.get(i).contains("= new Dog")) {
                    dog ++;
                }
                if (collect.get(i).contains("Fish")&collect.get(i).contains("= new Fish")) {
                    fish ++;
                }
                if (collect.get(i).contains("Woman")&collect.get(i).contains("= new Woman")) {
                    woman ++;
                }
            }
            Assert.assertEquals("В методе main надо создать объект типа Cat и занести ссылку в переменную", 1, cat);
            Assert.assertEquals("В методе main надо создать объект типа Dog и занести ссылку в переменную",1, dog);
            Assert.assertEquals("В методе main надо создать объект типа Fish и занести ссылку в переменную",1, fish);
            Assert.assertEquals("В методе main надо создать объект типа Woman и занести ссылку в переменную",1, woman);
        } catch (IOException e) {
        }
    }

    @Test
    public void IsOwner() {
        int cat = 0, fish =0, dog =0;
        try {
            Stream<String> stream = Files.lines(Paths.get(fileName));
            List<String> collect = stream.collect(Collectors.toList());
            for (int i = 17; i < 25; i++) {
                if (collect.get(i).contains("cat1.owner = woman1;")) {
                    cat ++;
                }
                if (collect.get(i).contains("dog1.owner = woman1;")) {
                    dog ++;
                }
                if (collect.get(i).contains("fish1.owner = woman1;")) {
                    fish ++;
                }
            }
            Assert.assertEquals("В методе main присвойте каждому животному владельца Woman (cat)", 1, cat);
            Assert.assertEquals("В методе main присвойте каждому животному владельца Woman (dog)",1, dog);
            Assert.assertEquals("В методе main присвойте каждому животному владельца Woman (fish)",1, fish);
        } catch (IOException e) {
        }
    }

    @Test
    public void WomanNull() {
        try {
            Stream<String> stream = Files.lines(Paths.get(fileName));
            List<String> collect = stream.collect(Collectors.toList());
            int ind = collect.indexOf("    public static class Woman {");
            int ind2 = collect.indexOf("    }");
            for (int i = ind; i < ind2; i++) {
                Assert.assertNull("В классе Woman не должно быть переменных или методов", collect.get(i));
            }
        } catch (IOException e) {
        }
    }

    @Test
    public void ClassOneVar() {
        boolean is = true;
        try {
            Stream<String> stream = Files.lines(Paths.get(fileName));
            List<String> collect = stream.collect(Collectors.toList());
            int ind = collect.indexOf("    public static class Cat {");
            if ((collect.get(ind+1).contains("Woman owner"))&(collect.get(ind+2).contains("    }"))) {
                is = false;
            }
            Assert.assertEquals("Класс Cat должен содержать только одну переменную Woman owner", false, is);

            is = true;
            int ind2 = collect.indexOf("    public static class Dog {");
            if ((collect.get(ind2+1).contains("Woman owner"))&(collect.get(ind2+2).contains("    }"))) {
                is = false;
            }
            Assert.assertEquals("Класс Dog должен содержать только одну переменную Woman owner", false, is);

            is = true;
            int ind3 = collect.indexOf("    public static class Fish {");
            if ((collect.get(ind3+1).contains("Woman owner"))&(collect.get(ind3+2).contains("    }"))) {
                is = false;
            }
            Assert.assertEquals("Класс Fish должен содержать только одну переменную Woman owner", false, is);
        } catch (IOException e) {
        }
    }
}