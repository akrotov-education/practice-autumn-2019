package lesson05.part02;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import util.ReadFuncBodyUtil;
import util.SystemOutGatewayUtil;

import java.io.ByteArrayOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.*;

public class Task04Test {
    private static String fileName = "./src/main/java/lesson05/part02/Task04.java";
    String s[];
    String r;
    int startLineMain,cat,dog,bird,lamp;
    List<String> listMain;
    List<String> listcat;
    List<String> listdog;
    List<String> listbird;
    List<String>listlamp;
    public static List<String> collect;
    ByteArrayOutputStream ouputArr;

    @Before
    public void before() throws Exception {
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

            collect = stream.collect(Collectors.toList());
            for (int i=0;i<collect.size();i++
            ) {
                if(collect.get(i).contains("static void main(String[] args)")) startLineMain=i;
                if(collect.get(i).contains("class Cat ")) cat=i;
                if(collect.get(i).contains("class Dog")) dog=i;
                if(collect.get(i).contains("class Bird")) bird=i;
                if(collect.get(i).contains("class Lamp")) lamp=i;
            }
            listcat= ReadFuncBodyUtil.getFuncBody(collect,cat);
            listdog= ReadFuncBodyUtil.getFuncBody(collect,dog);
            listbird= ReadFuncBodyUtil.getFuncBody(collect,bird);
            listlamp= ReadFuncBodyUtil.getFuncBody(collect,lamp);
            listMain= ReadFuncBodyUtil.getFuncBody(collect,startLineMain);

            SystemOutGatewayUtil.setCustomOut();
            Task04.printObjectType(new Task04.Cat());
            Task04.printObjectType(new Task04.Dog());
            Task04.printObjectType(new Task04.Bird());
            Task04.printObjectType(new Task04.Lamp());
            SystemOutGatewayUtil.setOriginalOut();
            ouputArr=SystemOutGatewayUtil.getOutputArray() ;
            r=ouputArr.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @After
    public void after() throws Exception {
        SystemOutGatewayUtil.clearOutput();
    }

    @Test
    public void t1(){/*впишите свои числа */
        Assert.assertTrue(   "Не пройдено 1 условие",r.length()>0);
    }
    @Test
    public void t2(){/*впишите свои числа */
        Assert.assertTrue(   "Не пройдено 2 условие",listcat.size()==0);
    }
    @Test
    public void t3(){/*впишите свои числа */
        Assert.assertTrue(   "Не пройдено 3 условие",listdog.size()==0);
    }
    @Test
    public void t4(){/*впишите свои числа */
        Assert.assertTrue(   "Не пройдено 4 условие",listbird.size()==0);
    }
    @Test
    public void t5(){/*впишите свои числа */
        Assert.assertTrue(   "Не пройдено 5 условие",listlamp.size()==0);
    }
    @Test
    public void t6(){/*впишите свои числа */
        Assert.assertTrue(   "Не пройдено 6 условие",r.contains("Кошка\r\nСобака\r\nПтица\r\nЛампа\r\n"));
    }
}