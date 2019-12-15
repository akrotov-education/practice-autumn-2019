package lesson05.part02;

import lesson05.part01.Task22;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import util.ReadFuncBodyUtil;
import util.SystemOutGatewayUtil;

import java.io.ByteArrayOutputStream;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.*;

public class Task03Test {
    private static String fileName = "./src/main/java/lesson05/part02/Task03.java";
    String s[];
    String r;
    int startLineMain;
    List<String> listMain;
    public static List<String> collect;

    @Before
    public void before() throws Exception {
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

            collect = stream.collect(Collectors.toList());
            for (int i=0;i<collect.size();i++
            ) {
                if(collect.get(i).contains("static void main(String[] args)")) startLineMain=i;            }
            listMain= ReadFuncBodyUtil.getFuncBody(collect,startLineMain);/*main*/

            SystemOutGatewayUtil.setCustomOut();
            Task03.main(null);
            SystemOutGatewayUtil.setOriginalOut();
            ByteArrayOutputStream ouputArr=SystemOutGatewayUtil.getOutputArray() ;
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
        Assert.assertTrue(   "Не пройдено 2 условие",Task03.Pet.class.isAssignableFrom(Task03.Cat.class));
    }

    @Test
    public void t2(){/*впишите свои числа */
        Assert.assertTrue(   "Не пройдено 2 условие",Task03.Pet.class.isAssignableFrom(Task03.Dog.class));
            }
    @Test
    public void t3(){/*впишите свои числа */
        Method[] a=Task03.Cat.class.getDeclaredMethods();
        boolean w=false;
        for (Method c:a
        ) {if(c.toString().contains("getChild()")) w=true;

        }
        Assert.assertTrue(   "Не пройдено 3 условие", w);
    }

    @Test
    public void t4(){/*впишите свои числа */
        Method[] a=Task03.Cat.class.getDeclaredMethods();
        boolean w=false;
        for (Method c:a
        ) {if(c.toString().contains("getChild()")) w=true;

        }
        Assert.assertTrue(   "Не пройдено 4 условие", w);
    }

    @Test
    public void t56(){/*впишите свои числа *//**/
        int i=0;
        for (String a:listMain
             ) { if(a.contains(".getChild();")) i++;

        }
        Assert.assertTrue(   "Не пройдено 56 test",i==2);
    }
}