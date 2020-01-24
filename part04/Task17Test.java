package part04;

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

public class Task17Test {
    public static String fileName = "./src/main/java/lesson05/part04/Task17.java";

    @Before
    public void setUp() throws Exception {
        SystemOutGatewayUtil.setCustomOut();
    }

    @After
    public void tearDown() throws Exception {
        SystemOutGatewayUtil.setOriginalOut();
        SystemOutGatewayUtil.clearOutput();
    }

    @Test
    public void MethodsUsed() {
        boolean is = false;
        boolean is1 = false;
        boolean is2 = false;
        boolean is3 = false;
        try {
            Stream<String> stream = Files.lines(Paths.get(fileName));
            List<String> collect = stream.collect(Collectors.toList());
            for (int i = 26; i < 31; i++) {
                if (collect.get(i).contains("initList(list);")) {
                    is1 = true;
                }
                if (collect.get(i).contains("printListValues(list);")) {
                    is2 = true;
                }
                if (collect.get(i).contains("processCastedObjects(list);")) {
                    is3 = true;
                }
            }
            if (is1 & is2 & is3) {
                is=true;
            }
            Assert.assertTrue("В классе Solution должны быть реализованы статические методы initList(List<Number> list), " +
                    "printListValues(List<Number> list), processCastedObjects(List<Number> list).", is);
        } catch (IOException e) { }
    }

    @Test
    public void listadd(){
        try {
            Stream<String> stream = Files.lines(Paths.get(fileName));
            List<String> line = stream.collect(Collectors.toList());
            String lineWithMethodCall = line.get(36);
            Assert.assertTrue("Метод initList должен заполнять полученный список произвольными значениями.",
                    lineWithMethodCall.contains("list.add"));
        } catch (IOException e) { }
    }

    @Test
    public void printlist(){
        try {
            Stream<String> stream = Files.lines(Paths.get(fileName));
            List<String> line = stream.collect(Collectors.toList());
            String lineWithMethodCall = line.get(44);
            Assert.assertTrue("Метод printListValues должен выводить содержимое полученного списка на экран.",
                    lineWithMethodCall.contains("System.out.println(list.get(i));"));
        } catch (IOException e) { }
    }

    @Test
    public void process(){
        try {
            Stream<String> stream = Files.lines(Paths.get(fileName));
            List<String> line = stream.collect(Collectors.toList());
            String lineWithMethodCall = line.get(44);
            Assert.assertTrue("Метод processCastedObjects должен анализировать элементы списка и для " +
                            "объектов типа Float или Double выводить на экран текст согласно условию задачи.",
                    lineWithMethodCall.contains("if (object instanceof Float) {"));
            String lineWithMethodCall2 = line.get(44);
            Assert.assertTrue("Метод processCastedObjects должен анализировать элементы списка и для " +
                            "объектов типа Float или Double выводить на экран текст согласно условию задачи",
                    lineWithMethodCall2.contains("if (object instanceof Double) {"));
        } catch (IOException e) { }
    }
}