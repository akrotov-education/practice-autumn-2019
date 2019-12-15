package lesson05.part02;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import util.SystemOutGatewayUtil;

import java.io.ByteArrayOutputStream;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.*;

public class Task12Test {
    private static String fileName = "./src/main/java/lesson05/part02/Task12.java";
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
            Task12.main(null);
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
    public void t2(){/*впишите свои числа */
        Method[] a=Task12.Pet.class.getMethods();
        int r=0;
        for (Method c:a
        ) {if(c.toString().contains("Task12")) r++;

        }
        Assert.assertTrue(   "Не пройдено 2 условие",r==2);
    }

    @Test
    public void t3() throws NoSuchMethodException {/*впишите свои числа */
        String a=Task12.Pet.class.getMethod("getChild",null).toString();
        Assert.assertTrue(   "Не пройдено 3 условие",a.contains("abstract"));
    }

    @Test
    public void t14(){/*впишите свои числа */

        Assert.assertTrue(   "Не пройдено 1 или 4 условие",Modifier.toString(Task12.Pet.class.getModifiers()).contains("abstract static"));
    }

}