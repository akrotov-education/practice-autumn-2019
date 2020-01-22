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

public class Task04Test {
    public static String fileName = "./src/main/java/lesson05/part04/Task04.java";

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
    public void MethodImplements(){
        try {
            Stream<String> stream = Files.lines(Paths.get(fileName));
            List<String> line = stream.collect(Collectors.toList());
            String lineWithMethodCall = line.get(41);
            Assert.assertTrue("Интерфейс Selectable должен быть реализован в классе Food",
                    lineWithMethodCall.contains("class Food implements Selectable"));
        } catch (IOException e) { }
    }

    @Test
    public void MethodPrints(){
        try {
            Stream<String> stream = Files.lines(Paths.get(fileName));
            List<String> line = stream.collect(Collectors.toList());
            String lineWithMethodCall = line.get(48);
            Assert.assertTrue("Метод onSelect() в классе Food должен выводить на экран фразу \"The food was selected\".",
                    lineWithMethodCall.contains(" System.out.println(\"The food was selected\");"));
        } catch (IOException e) { }
    }

    @Test
    public void Foodobj() {
        boolean isMethodPrints = false;
        try {
            Stream<String> stream = Files.lines(Paths.get(fileName));
            List<String> collect = stream.collect(Collectors.toList());
            for (int i = 28; i < 31; i++) {
                if (collect.get(i).contains("food.onSelect();") &
                        collect.get(i).contains("food.onSelectEat();")) {
                    isMethodPrints = true;
                    break;
                }
            }
            Assert.assertFalse("В методе foodMethods должны вызываться методы объекта типа Food.", isMethodPrints);
        } catch (IOException e) { }
    }

    @Test
    public void selectableobj() {
        boolean isMethodPrints = false;
        try {
            Stream<String> stream = Files.lines(Paths.get(fileName));
            List<String> collect = stream.collect(Collectors.toList());
            for (int i = 33; i < 36; i++) {
                if (collect.get(i).contains("selectable.onSelect()")) {
                    isMethodPrints = true;
                    break;
                }
            }
            Assert.assertFalse("В методе selectableMethods должны вызываться методы доступные" +
                    " у любого объекта реализующего интерфейс Selectable.", isMethodPrints);
        } catch (IOException e) { }
    }
}