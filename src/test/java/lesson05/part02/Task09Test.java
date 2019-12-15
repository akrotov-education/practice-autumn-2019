package lesson05.part02;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import util.SystemOutGatewayUtil;

import java.io.ByteArrayOutputStream;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.*;

public class Task09Test {
    private static String fileName = "./src/main/java/lesson05/part02/Task09.java";
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

                if(collect.get(i).contains("void print(")) l1++;


            }

            SystemOutGatewayUtil.setCustomOut();
            Task09.main(null);
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
    public void t2(){/*впишите свои числа */
        Method[] a=Task09.class.getMethods();
        int r=0;
        for (Method c:a
        ) {if(c.toString().contains("Task09")) r++;

        }
        Assert.assertTrue(   "Не пройдено 2 условие",r==4);
    }

    @Test
    public void t3() throws NoSuchMethodException {/*впишите свои числа */
        Method a=Task09.class.getMethod("min",int.class,int.class);
        Assert.assertTrue(   "Не пройдено 3 условие",a.toString().contains("static int"));
    }
    @Test
    public void t4() throws NoSuchMethodException {/*впишите свои числа */

        Assert.assertTrue(   "Не пройдено 4 условие",Task09.min(1,8)==1);
    }
    @Test
    public void t5() throws NoSuchMethodException {/*впишите свои числа */
        Method a=Task09.class.getMethod("min",long.class,long.class);
        Assert.assertTrue(   "Не пройдено 5 условие",a.toString().contains("static long"));
    }
    @Test
    public void t6() throws NoSuchMethodException {/*впишите свои числа */

        Assert.assertTrue(   "Не пройдено 6 условие",Task09.min(1L,8L)==1L);
    }
    @Test
    public void t7() throws NoSuchMethodException {/*впишите свои числа */
        Method a=Task09.class.getMethod("min",double.class,double.class);
        Assert.assertTrue(   "Не пройдено 7 условие",a.toString().contains("static double"));
    }
    @Test
    public void t8() throws NoSuchMethodException {/*впишите свои числа */

        Assert.assertTrue(   "Не пройдено 8 условие",Task09.min(1D,8D)==1D);
    }

}