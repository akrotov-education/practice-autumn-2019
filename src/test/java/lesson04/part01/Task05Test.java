package lesson04.part01;
//@FoLoKe
import foloke.utils.SystemInGatewayUtil;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import util.SystemOutGatewayUtil;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class Task05Test {
    /* 1.	Программа должна создавать массив на 15 целых чисел.
     * 2.	Программа должна считывать числа для массива с клавиатуры.
     * 3.	Программа должна вывести сообщение "В домах с нечетными номерами проживает больше жителей.",
     * если сумма нечетных элементов массива больше суммы четных.
     * 4.	Программа должна вывести сообщение "В домах с четными номерами проживает больше жителей.",
     * если сумма четных элементов массива больше суммы нечетных.
     */

    ArrayList<String> test = new ArrayList<>();
    private ByteArrayOutputStream out;
    private String mainOutput;
    private String[] mainOutStrings;

    @Before
    public void init() throws Exception
    {
        SystemOutGatewayUtil.setCustomOut();
        out = SystemOutGatewayUtil.getOutputArray();
        out.reset();

        for (int i = 0; i < 15; i++) {
            SystemInGatewayUtil.addCustomIn(Integer.toString(i * i));
            test.add(Integer.toString(i * i));
        }

        SystemInGatewayUtil.setCustomIn();


        Task05.main(null);
        mainOutput = out.toString().trim().replace("\r", "");
        mainOutStrings = mainOutput.split("\n");
    }

    @Test
    public void test0501() {
        //TODO: check that integer array has been created
    }

    @Test
    public void test0502() {
        for (int i = 0; i < 14; i++) {
            SystemInGatewayUtil.addCustomIn(Integer.toString(i));
        }
        SystemInGatewayUtil.setCustomIn();

        try {
            Task05.main(null);
            Assert.fail("not 15");
        } catch (Exception e) {
            //OK
        }
    }

    @Test
    public void test05main() {
        Assert.assertEquals("В домах с четными номерами проживает больше жителей.", mainOutput);
    }

    @Test
    public void test0503() throws Exception {
        for (int i = 0; i < 14; i++) {
            SystemInGatewayUtil.addCustomIn(Integer.toString(i * i));
        }
        SystemInGatewayUtil.addCustomIn(Integer.toString(0));

        SystemInGatewayUtil.setCustomIn();

        out.reset();
        Task05.main(null);

        Assert.assertEquals("В домах с нечетными номерами проживает больше жителей.", out.toString().trim());
    }
}