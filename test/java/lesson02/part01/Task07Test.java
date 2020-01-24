package lesson02.part01;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import util.SystemInGatewayUtil;
import util.SystemOutGatewayUtil;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.*;

public class Task07Test {

    public static String s;
    public static List<String> collect;

    @Before
    public void before() throws Exception {
        SystemInGatewayUtil.provideInput("");

        SystemOutGatewayUtil.setCustomOut();
        Task07.main(null);
        SystemOutGatewayUtil.setOriginalOut();
        ByteArrayOutputStream ouputArr;
        ouputArr = SystemOutGatewayUtil.getOutputArray();
        s = ouputArr.toString();

        String fileName="./src/main/java/lesson02/part01/Task07.java";
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            collect = stream.collect(Collectors.toList());
        } catch (IOException e) {
        }
    }

    @After
    public void after() {
        SystemInGatewayUtil.setOriginalIn();
        SystemOutGatewayUtil.clearOutput();
    }

    @Test
    public void ChangeClasses(){
        boolean z = false, t = false, p = false;
        try {
            for (int i = 0; i < collect.size(); i++) {
                if (collect.get(i).equals("    public static class Zerg {") &&
                        collect.get(i + 1).equals("        public String name;")&&
                        collect.get(i + 2).equals("    }")) {
                    z = true;
                }
                if (collect.get(i).equals("    public static class Terran {") &&
                        collect.get(i + 1).equals("        public String name;")&&
                        collect.get(i + 2).equals("    }")) {
                    t = true;
                }
                if (collect.get(i).equals("    public static class Protoss {") &&
                        collect.get(i + 1).equals("        public String name;")&&
                        collect.get(i + 2).equals("    }")) {
                    p = true;
                }
                if (z && t && p) {break;}
            }
        }
        catch (Exception ex){
        }
        Assert.assertTrue("Нельзя изменять классы Zerg, Protoss и Terran", z && t && p);
    }

    @Test
    public void RightObj(){
        int a=0,b=0,z=0,t=0,p=0,n=0;
        for (int i = 0; i < collect.size(); i++)
            if (collect.get(i).contains("public static void main(String[] args)")) {
                a = i + 1;
                break;
            }
        for (int i = a; i < collect.size(); i++)
            if (collect.get(i).contains("}")) {
                b = i;
                break;
            }
        For3:
        for (int i = a; i < b; i++) {
            if (collect.get(i).contains("new Zerg") ){z++;}
            if (collect.get(i).contains("new Protoss") ){p++;}
            if (collect.get(i).contains("new Terran") ){t++;}
            if (collect.get(i).contains(".name")){n++;}
        }
        Assert.assertTrue("Нужно создать 5 объектов типа Zerg, 3 объекта типа Protoss, 4 объекта типа Terran" +
                " и каждому из них дать свое имя", z == 5 && p == 3 && t == 4 && n == 12);
    }


}

