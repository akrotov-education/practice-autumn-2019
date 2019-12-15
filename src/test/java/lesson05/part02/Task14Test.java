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

public class Task14Test {
    private static String fileName = "./src/main/java/lesson05/part02/Task14.java";
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
            Task14.main(null);
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
    public void t5(){/*впишите свои числа */
        Task14.Cow f=new Task14.Cow();
        Assert.assertTrue(   "Не пройдено 5 условие",f.getName().length()>0);
    }

    @Test
    public void t3() throws NoSuchMethodException {/*впишите свои числа */
        Assert.assertTrue(   "Не пройдено 3 условие",Task14.Animal.class.isAssignableFrom(Task14.Cow.class));
    }

    @Test
    public void t1(){/*впишите свои числа */

        Assert.assertTrue(   "Не пройдено 1 условие", Modifier.toString(Task14.Animal.class.getModifiers()).contains("abstract"));
    }
    @Test
    public void t2(){/*впишите свои числа */

        Assert.assertFalse(   "Не пройдено 2 условие", Modifier.toString(Task14.Cow.class.getModifiers()).contains("abstract"));
    }

    @Test
    public void t4() throws NoSuchMethodException {/*впишите свои числа */
        Method[] a=Task14.Cow.class.getMethods();
        boolean s=false;
        for (Method d:a
             ) {if (d.toString().contains("getName")) s=true;

        }
        Assert.assertTrue(   "Не пройдено 4 условие", s);
    }


}