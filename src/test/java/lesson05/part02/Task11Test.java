package lesson05.part02;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import util.SystemOutGatewayUtil;

import java.io.ByteArrayOutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.*;

public class Task11Test {
    private static String fileName = "./src/main/java/lesson05/part02/Task11.java";
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
            Task11.main(null);
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
        Assert.assertTrue(   "Не пройдено 1 условие",r.length()==0);
    }


    @Test
    public void t23(){/*впишите свои числа */

        Assert.assertTrue(   "Не пройдено 2 или 3 условие",l1>0);
    }

    @Test
    public void t4(){/*впишите свои числа */
        Method[] a=Task11.Pet.class.getMethods();
        int q=0;
        for (Method s:a
             ) {if(s.toString().contains("getName()"))q++;

        }
                Assert.assertTrue(   "Не пройдено 4 условие",q==1);
    }

}