package lesson01.part2;

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

public class Task05Test {
    public static String fileName = "./src/main/java/lesson01/part2/Task05.java";

    @Before
    public void before() {
        SystemOutGatewayUtil.setCustomOut();
    }

    @Test
    public void test05NotOutputScreen() {
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

            List<String> collect = stream.collect(Collectors.toList());
            boolean var = true;

            for (int i = 0; i < collect.size(); i++)
                if (collect.get(i).contains("System.out.print")) {
                    var = false;
                    break;
                }
            Assert.assertTrue(
                    "РџСЂРѕРіСЂР°РјРјР° РЅРµ РґРѕР»Р¶РЅР° РІС‹РІРѕРґРёС‚СЊ С‚РµРєСЃС‚ РЅР° СЌРєСЂР°РЅ",
                    var
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test05TwoCats() {
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

            List<String> collect = stream.collect(Collectors.toList());
            int b = 0;
            int a = 0;
            int cats = 0;

            for (int i = 0; i < collect.size(); i++)
                if (collect.get(i).contains("public static void main(String[] args)")) {
                    b = i;
                    break;
                }
            for (int i = b; i < collect.size(); i++)
                if (collect.get(i).contains("}")) {
                    a = i;
                    break;
                }
            for (int i = b; i < a + 1; i++) {
                if (collect.get(i).contains("Cat "))
                    cats++;
            }
            Assert.assertTrue(
                    "Р’ РјРµС‚РѕРґРµ main РґРѕР»Р¶РЅРѕ Р±С‹С‚СЊ С‚РѕР»СЊРєРѕ РґРІРµ РїРµСЂРµРјРµРЅРЅС‹Рµ С‚РёРїР° Cat",
                    cats == 2
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test05VarInit() {
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

            List<String> collect = stream.collect(Collectors.toList());
            int b = 0;
            int a = 0;
            int cats = 0;

            for (int i = 0; i < collect.size(); i++)
                if (collect.get(i).contains("public static void main(String[] args)")) {
                    b = i;
                    break;
                }
            for (int i = b; i < collect.size(); i++)
                if (collect.get(i).contains("}")) {
                    a = i;
                    break;
                }
            for (int i = b; i < a + 1; i++) {
                if (collect.get(i).contains("Cat ") && collect.get(i).contains("new Cat();"))
                    cats++;
            }

            Assert.assertTrue("РџРµСЂРµРјРµРЅРЅС‹Рј СЃСЂР°Р·Сѓ РґРѕР»Р¶РЅС‹ Р±С‹С‚СЊ РїСЂРёСЃРІРѕРµРЅС‹ Р·РЅР°С‡РµРЅРёСЏ", cats == 2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test05ClassCatNotVar() {
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

            List<String> collect = stream.collect(Collectors.toList());
            int b = 0;
            int a = 0;
            boolean var = true;

            for (int i = 0; i < collect.size(); i++)
                if (collect.get(i).contains("public static class Cat")) {
                    b = i;
                    break;
                }
            for (int i = b; i < collect.size(); i++)
                if (collect.get(i).contains("}")) {
                    a = i;
                    break;
                }
            for (int i = b; i < a + 1; i++) {
                if (collect.get(i).contains(";"))
                    var = false;
            }

            Assert.assertTrue(
                    "Р’ РєР»Р°СЃСЃРµ Cat РЅРµ РґРѕР»Р¶РЅРѕ Р±С‹С‚СЊ РїРµСЂРµРјРµРЅРЅС‹С…",
                    var
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test05ClassCatNotMethod() {
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

            List<String> collect = stream.collect(Collectors.toList());
            int b = 0;
            int a = 0;
            boolean var = true;

            for (int i = 0; i < collect.size(); i++)
                if (collect.get(i).contains("public static class Cat")) {
                    b = i;
                    break;
                }
            for (int i = b; i < collect.size(); i++)
                if (collect.get(i).contains("}")) {
                    a = i;
                    break;
                }
            for (int i = b + 1; i < a + 1; i++) {
                if (collect.get(i).contains("{"))
                    var = false;
            }
            Assert.assertTrue(
                    "Р’ РєР»Р°СЃСЃРµ Cat РЅРµ РґРѕР»Р¶РЅРѕ Р±С‹С‚СЊ РјРµС‚РѕРґРѕРІ",
                    var
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}