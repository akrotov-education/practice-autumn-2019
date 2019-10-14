package lesson04.part03;

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

public class Task40Test {
    private static String fileName = "./src/main/java/lesson04/part03/Task40.java";
    int startLineMain;
    List<String> listMain;
    String r;
    public static List<String> collect;
    @Before
    public void before() throws Exception {

        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            collect = stream.collect(Collectors.toList());
            for (int i=0;i<collect.size();i++
            ) {
                if(collect.get(i).contains("static void main(String[] args)")) startLineMain=i;


            }
            listMain= ReadFuncBodyUtil.getFuncBody(collect,startLineMain);/*main*/
            SystemOutGatewayUtil.setCustomOut();
            Task40.main(null);
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
    public void soutCheck(){
        boolean a=false;
        for (String s:listMain
        ) {
            if(s.contains("print")) a=true;
        }
        Assert.assertTrue("err Sout Check",a);
    }

    @Test
    public void tryCatchCheck(){
        boolean a=false;
        boolean b=false;
        for (String s:listMain
        ) {
            if(s.contains("try")) a=true;
            if(s.contains("catch")) b=true;
        }
        Assert.assertTrue("err check try-catch block",a && b);
    }

    @Test
    public void checkSout(){
        Assert.assertTrue("",r.contains("java.lang.NullPointerException"));
    }

    @Test
    public void checkException(){
        boolean a=false;
        for (String s:listMain
        ) {
            if(s.contains("(Exception")) a=true;
            if(s.contains(" Exception")) a=true;
        }
        Assert.assertFalse("err check Exception",a);
    }


    @Test
    public void checkMainNotDelCode(){
        boolean a=false;
        boolean b=false;
        for (String s:listMain
        ) {
            if(s.contains("String s = null;")) a=true;
            if(s.contains("String m = s.toLowerCase()")) b=true;
        }
        Assert.assertTrue("don't delete rows in main",a&&b);
    }

}