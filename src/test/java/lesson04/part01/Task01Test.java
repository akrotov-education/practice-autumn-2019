package lesson04.part01;
//@FoLoKe
import foloke.utils.DotJavaReader;
import foloke.utils.SystemInGatewayUtil;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import util.SystemOutGatewayUtil;

import java.io.ByteArrayOutputStream;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class Task01Test {

    /* Требования:
     * 1.	Метод initializeArray должен создавать массив из 20 целых чисел.
     * 2.	Метод initializeArray должен считать 20 чисел и вернуть их в виде массива.
     * 3.	Метод max должен возвращать максимальный элемент из переданного массива.
     * 4.	Метод main изменять нельзя.
     */

    private static ByteArrayOutputStream out;
    private static String output;

    @Before
    public void init() throws Exception
    {
        SystemOutGatewayUtil.setCustomOut();
        out = SystemOutGatewayUtil.getOutputArray();
        out.reset();

        for (int i = 0; i < 20; i++) {
            SystemInGatewayUtil.addCustomIn(Integer.toString(i));
        }
        SystemInGatewayUtil.setCustomIn();
    }

    @Test
    public void test01main() throws Exception{


        Task01.main(null);
        output = out.toString().trim();
        String[] outputLines = output.split("\n");

        Assert.assertEquals(1, outputLines.length);
        Assert.assertTrue(outputLines[0].matches("\\d*") );
    }

    @Test
    public void test0101() throws Exception {
        Assert.assertEquals(20, Task01.initializeArray().length);
    }

    @Test
    public void test0102() throws Exception {
        int[] array = Task01.initializeArray();

        for (int i = 0; i < 20; i++) {
            array[i] = i;
        }
    }

    @Test
    public void test0103() {
        Assert.assertEquals(3, Task01.max(new int[]{1, 2, 3}));
        Assert.assertEquals(3, Task01.max(new int[]{3, 2, 1}));
        Assert.assertEquals(4, Task01.max(new int[]{1, 4, 2}));
    }
}