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

public class Task14Test {
    public static String fileName = "./src/main/java/lesson05/part04/Task14.java";

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
    public void MethodObjParam(){
        try {
            Stream<String> stream = Files.lines(Paths.get(fileName));
            List<String> line = stream.collect(Collectors.toList());
            String lineWithMethodCall = line.get(35);
            Assert.assertTrue("Метод cleanAllApartments должен принимать список аппартаметов в качестве параметра.",
                    lineWithMethodCall.contains("void cleanAllApartments(List<Task14.Apartment> apartments) {"));
        } catch (IOException e) { }
    }

    @Test
    public void Neededobj() {
        boolean is1 = false;
        boolean is2 = false;
        boolean is3 = false;
        try {
            Stream<String> stream = Files.lines(Paths.get(fileName));
            List<String> collect = stream.collect(Collectors.toList());
            for (int i = 35; i < 45; i++) {
                if (collect.get(i).contains(" if (ap instanceof OneRoomApt) {") &
                        collect.get(i+1).contains(" ((OneRoomApt) ap).clean1Room();")) {
                    is1 = true;
                    break;
                }
                if (collect.get(i).contains("if (ap instanceof TwoRoomApt) {") &
                        collect.get(i+1).contains(" ((TwoRoomApt) ap).clean2Rooms();")) {
                    is1 = true;
                    break;
                }
                if (collect.get(i).contains(" if (ap instanceof ThreeRoomApt) {") &
                        collect.get(i+1).contains(" ((ThreeRoomApt) ap).clean3Rooms();")) {
                    is1 = true;
                    break;
                }
            }
            Assert.assertTrue("В методе cleanAllApartments для всех однокомнатных аппартаментов(OneRoomApt)" +
                    " содержащихся в списке необходимо вызвать метод clean1Room.", is1);
            Assert.assertTrue("В методе cleanAllApartments для всех двухкомнатных аппартаментов(TwoRoomApt)" +
                    " содержащихся в списке необходимо вызвать метод clean2Rooms.", is2);
            Assert.assertTrue("В методе cleanAllApartments для всех трехкомнатных аппартаментов(ThreeRoomApt) " +
                    "содержащихся в списке необходимо вызвать метод clean3Rooms.", is3);
        } catch (IOException e) { }
    }

    @Test
    public void isImplements() {
        boolean is = false;
        boolean is1 = false;
        boolean is2 = false;
        boolean is3 = false;
        try {
            Stream<String> stream = Files.lines(Paths.get(fileName));
            List<String> collect = stream.collect(Collectors.toList());
            for (int i = 50; i < 68; i++) {
                if (collect.get(i).contains("class OneRoomApt implements Apartment")) {
                    is1 = true;
                }
                if (collect.get(i).contains("class TwoRoomApt implements Apartment")) {
                    is2 = true;
                }
                if (collect.get(i).contains("class ThreeRoomApt implements Apartment")) {
                    is3 = true;
                }
            }
            if (is1 & is2 & is3) {
                is=true;
            }
            Assert.assertTrue("Классы OneRoomApt, TwoRoomApt, ThreeRoomApt " +
                    "должны поддерживать(реализовывать) интерфейс Apartment.", is);
        } catch (IOException e) { }
    }
}