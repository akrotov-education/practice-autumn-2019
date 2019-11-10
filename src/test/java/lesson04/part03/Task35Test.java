package lesson04.part03;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import util.SystemInGatewayUtil;
import util.SystemOutGatewayUtil;
import util.ReadFuncBodyUtil;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.*;

public class Task35Test {
    private static String fileName = "./src/main/java/lesson04/part03/Task35.java";
    private static String returnString="return stackTraceElements;";
    int startLineMain;
    int startLineMethod1;
    int startLineMethod2;
    int startLineMethod3;
    int startLineMethod4;
    int startLineMethod5;
    List<String> listMain;
    List<String> listMethod1;
    List<String> listMethod2;
    List<String> listMethod3;
    List<String> listMethod4;
    List<String> listMethod5;

    public static List<String> collect;
    @Before
    public void before() throws Exception {
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            collect = stream.collect(Collectors.toList());
            for (int i=0;i<collect.size();i++
            ) {
                if(collect.get(i).contains("static void main(String[] args)")) startLineMain=i;
                if(collect.get(i).contains("static StackTraceElement[] method1()")) startLineMethod1=i;
                if(collect.get(i).contains("static StackTraceElement[] method2()")) startLineMethod2=i;
                if(collect.get(i).contains("static StackTraceElement[] method3()")) startLineMethod3=i;
                if(collect.get(i).contains("static StackTraceElement[] method4()")) startLineMethod4=i;
                if(collect.get(i).contains("static StackTraceElement[] method5()")) startLineMethod5=i;

            }
            listMain= ReadFuncBodyUtil.getFuncBody(collect,startLineMain);/*main*/
            listMethod1=ReadFuncBodyUtil.getFuncBody(collect,startLineMethod1);/*method1*/
            listMethod2=ReadFuncBodyUtil.getFuncBody(collect,startLineMethod2);/*method2*/
            listMethod3=ReadFuncBodyUtil.getFuncBody(collect,startLineMethod3);/*method3*/
            listMethod4=ReadFuncBodyUtil.getFuncBody(collect,startLineMethod4);/*method4*/
            listMethod5=ReadFuncBodyUtil.getFuncBody(collect,startLineMethod5);/*method5*/
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @After
    public void after() throws Exception {

    }

    @Test
    public void Check5metods(){
        Method a[]=Task35.class.getMethods();
        int m=0;
        for (Method s:a
        ) {
            if(s.toString().contains("lesson04.part03.Task35"))m++;
        }
        Assert.assertTrue("ClassNotHave5metids",m==6);
    }

    @Test
    public void CheckCallMethod(){

        int m=0;
        for (String a:listMain) {
            if (a.contains("method1")) m++;
        }
        for (String a:listMethod2) {
            if (a.contains("method3")) m++;
        }
        for (String a:listMethod1) {
            if (a.contains("method2")) m++;
        }
        for (String a:listMethod3) {
            if (a.contains("method4")) m++;
        }
        for (String a:listMethod4) {
            if (a.contains("method5")) m++;
        }

        Assert.assertTrue(
                "method call error",m==5);
    }

    @Test
    public void CheckReturnStack(){/*впишите свои числа */
        int m = 0;
        for (String a:listMethod2) {
            if (a.contains(returnString)) m++;
        }
        for (String a:listMethod1) {
            if (a.contains(returnString)) m++;
        }
        for (String a:listMethod3) {
            if (a.contains(returnString)) m++;
        }
        for (String a:listMethod4) {
            if (a.contains(returnString)) m++;
        }
        for (String a:listMethod5) {
            if (a.contains(returnString)) m++;
        }
        Assert.assertTrue( "return value error",m == 5);
    }
}