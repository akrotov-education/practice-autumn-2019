package lesson05.part01;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import util.ReadFuncBodyUtil;
import util.SystemOutGatewayUtil;

import java.io.ByteArrayOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.*;

public class Task23Test {
    private static String fileName = "./src/main/java/lesson05/part01/Task23.java";
    int startLineMain;
    int startLinePair;
    List<String> listMain;
    List<String> listPair;
    String s[];
    String r;
    boolean f=false;
    int[] a=new int[]{3,4,5,8,-8};
    int[] c=new int[]{3,4,5,8,-8};
    Task23.Pair<Integer, Integer> result=Task23.getMinimumAndMaximum(a);

    public static List<String> collect;

    @Before
    public void before() throws Exception {
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            collect = stream.collect(Collectors.toList());
            for (int i=0;i<collect.size();i++
            ) {
                if(collect.get(i).contains("static void main(String[] args)")) startLineMain=i;
                if(collect.get(i).contains("static class Pair<X, Y>")) startLinePair=i;
                if(collect.get(i).contains("InputStream")) f=true;


            }
            listMain= ReadFuncBodyUtil.getFuncBody(collect,startLineMain);/*main*/
            listPair=ReadFuncBodyUtil.getFuncBody(collect,startLinePair);/*method1*/

            SystemOutGatewayUtil.setCustomOut();

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
    public void t1(){/*впишите свои числа */
        Assert.assertFalse(   "Не пройдено 1 условие",f      );
    }
    @Test
    public void t2(){/*впишите свои числа */
        Assert.assertTrue(   "Не пройдено 2 условие",
                listPair.get(0).equals("        public X x;")&&
                        listPair.get(1).equals("        public Y y;")&&
                        listPair.get(3).equals("        public Pair(X x, Y y) {")&&
                        listPair.get(4).equals("            this.x = x;")&&
                        listPair.get(5).equals("            this.y = y;")

                );
    }
    @Test
    public void t3(){/*впишите свои числа */
        Assert.assertTrue(   "Не пройдено 3 условие",
                listMain.get(0).contains("int[] data = new int[]{1, 2, 3, 5, -2, -8, 0, 77, 5, 5};")&&
                listMain.get(2).contains("Pair<Integer, Integer> result = getMinimumAndMaximum(data);")&&
                listMain.get(4).contains("System.out.println(\"The minimum is \" + result.x);") &&
                listMain.get(5).contains("System.out.println(\"The maximum is \" + result.y);"));
    }
    @Test
    public void t5(){/*впишите свои числа */
        Assert.assertTrue(   "Не пройдено 6 условие", result.x==-8 && result.y==8);
    }

    @Test
    public void t6(){/*впишите свои числа */
        Assert.assertTrue(   "Не пройдено 6 условие", Arrays.equals(a,c));
    }

}