package lesson04.part03;

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

public class Task38Test {
    private static String fileName = "./src/main/java/lesson04/part03/Task38.java";
    int startLineMain;
    int startLineLog;
    List<String> listMain;
    List<String> listLog;
    String s[];
    String r;

    public static List<String> collect;

    @Before
    public void before() throws Exception {
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            collect = stream.collect(Collectors.toList());
            for (int i=0;i<collect.size();i++
            ) {
                if(collect.get(i).contains("static void main(String[] args)")) startLineMain=i;
                if(collect.get(i).contains("static void log(String s)")) startLineLog=i;


            }
            listMain= ReadFuncBodyUtil.getFuncBody(collect,startLineMain);/*main*/
            listLog=ReadFuncBodyUtil.getFuncBody(collect,startLineLog);/*method1*/

            SystemOutGatewayUtil.setCustomOut();
            Task38.log("helllp!!");
            SystemOutGatewayUtil.setOriginalOut();
            ByteArrayOutputStream ouputArr=SystemOutGatewayUtil.getOutputArray() ;
            r=ouputArr.toString();
            s = ouputArr.toString().split(":");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @After
    public void after() throws Exception {
        SystemOutGatewayUtil.clearOutput();
    }

    @Test
    public void soutLog(){/*впишите свои числа */
        boolean t=false;
        for (String s: listLog
             ) {
            if(s.contains("out.print")) t=true;
        }

        Assert.assertTrue(   "log does not display",t);
    }

    @Test
    public void CheckOutStringClass(){/*впишите свои числа */

        Assert.assertTrue("error out class",s[0].contains("lesson04.part03.Task38Test"));
    }

    @Test
    public void CheckOutStringMethod(){/*впишите свои числа */

        Assert.assertTrue("error out method",s[1].contains("before"));
    }

    @Test
    public void CheckOutStringValue(){/*впишите свои числа */

        Assert.assertTrue("error out value",s[2].contains("helllp!!"));
    }

    @Test
    public void CheckOutString(){/*впишите свои числа */

        Assert.assertTrue("error out string",r.contains("lesson04.part03.Task38Test: before: helllp!!"));
    }

}