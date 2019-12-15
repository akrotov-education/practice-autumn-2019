package lesson05.part02;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import util.SystemOutGatewayUtil;

import java.io.ByteArrayOutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.*;

public class Task15Test {
    private static String fileName = "./src/main/java/lesson05/part02/Task15.java";
    String s[];
    String r;
    int l1=0;
    public static List<String> collect;
    ByteArrayOutputStream ouputArr;

    @Before
    public void before() throws Exception {
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

            collect = stream.collect(Collectors.toList());

            for (int i=0;i<collect.size();i++
            ) {

                if(collect.get(i).contains("abstract static class Pet")) l1++;


            }

            SystemOutGatewayUtil.setCustomOut();
            Task15.main(null);
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

        Assert.assertTrue(   "Не пройдено 1 условие", Modifier.toString(Task15.Pet.class.getModifiers()).contains("abstract"));
    }
    @Test
    public void t2(){/*впишите свои числа */

        Assert.assertFalse(   "Не пройдено 2 условие", Modifier.toString(Task15.Cat.class.getModifiers()).contains("abstract"));
    }

    @Test
    public void t3(){/*впишите свои числа */

        Assert.assertFalse(   "Не пройдено 3 условие", Modifier.toString(Task15.Dog.class.getModifiers()).contains("abstract"));
    }

    @Test
    public void t4() throws NoSuchMethodException {/*впишите свои числа */
        Method[] a=Task15.Dog.class.getMethods();
        boolean s=false,r=false;
        for (Method d:a
        ) { if (d.toString().contains("getName")) s=true;
            if (d.toString().contains("getName")) r=true;

        }
        Assert.assertTrue(   "Не пройдено 4 условие", s&&r);
    }
    @Test
    public void t5() throws NoSuchMethodException {/*впишите свои числа */
        Method[] a=Task15.Cat.class.getMethods();
        boolean s=false,r=false;
        for (Method d:a
        ) { if (d.toString().contains("getName")) s=true;
            if (d.toString().contains("getName")) r=true;

        }
        Assert.assertTrue(   "Не пройдено 5 условие", s&&r);
    }

}