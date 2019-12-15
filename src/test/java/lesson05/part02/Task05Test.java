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

public class Task05Test {
    private static String fileName = "./src/main/java/lesson05/part02/Task05.java";
    String s[];
    String r;
    int l1=0,l2=0,l3=0,l4=0;
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

                if(collect.get(i).contains("static class Cow")) l1++;
                if(collect.get(i).contains("static class Dog")) l2++;
                if(collect.get(i).contains("static class Whale")) l3++;
                if(collect.get(i).contains("static class Pig")) l4++;
            }
            SystemOutGatewayUtil.setCustomOut();
            Task05.main(null);
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
        Assert.assertTrue(   "Не пройдено 1 условие",l1==1);
        }
    @Test
    public void t3(){/*впишите свои числа */
        Assert.assertTrue(   "Не пройдено 1 условие",l2==1);
        }
    @Test
    public void t4(){/*впишите свои числа */
        Assert.assertTrue(   "Не пройдено 1 условие",l3==1);
        }
    @Test
    public void t5(){/*впишите свои числа */
        Assert.assertTrue(   "Не пройдено 1 условие",l4==1);
        }
    @Test
    public void t6(){/*впишите свои числа */
        Assert.assertTrue(   "Не пройдено 6 условие","Неизвестное животное".contains(Task05.getObjectType(new Task04.Lamp())));
        Assert.assertTrue(   "Не пройдено 6 условие","Собака".contains(Task05.getObjectType(new Task05.Dog())));
        Assert.assertTrue(   "Не пройдено 6 условие","Собака".contains(Task05.getObjectType(new Task05.Dog())));
        Assert.assertTrue(   "Не пройдено 6 условие","Кит".contains(Task05.getObjectType(new Task05.Whale())));

    }

}