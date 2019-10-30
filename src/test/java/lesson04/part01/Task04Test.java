package lesson04.part01;

import foloke.utils.SystemInGatewayUtil;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import util.SystemOutGatewayUtil;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Collections;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class Task04Test {
    /* 1.	Программа должна создавать массив на 10 целых чисел.
     * 2.	Программа должна считывать числа для массива с клавиатуры.
     * 3.	Программа должна выводить 10 строчек, каждую с новой строки.
     * 4.	Массив должен быть выведен на экран в обратном порядке.
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

        for (int i = 0; i < 10; i++) {
            SystemInGatewayUtil.addCustomIn(Integer.toString(i * i));
            test.add(Integer.toString(i * i));
        }

        SystemInGatewayUtil.setCustomIn();


        Task04.main(null);
        mainOutput = out.toString().trim().replace("\r", "");
        mainOutStrings = mainOutput.split("\n");
    }

    @Test
    public void test0401() {
        //TODO: check that integer array has been created;
    }

    @Test
    public void test0303() {
        for (int i = 0; i < 9; i++) {
            SystemInGatewayUtil.addCustomIn(Integer.toString(i));
        }
        SystemInGatewayUtil.setCustomIn();

        try {
            Task04.main(null);
            Assert.fail("not 10");
        } catch (Exception e) {
            //OK
        }
    }

    @Test
    public void test04main() {
        Assert.assertEquals(10, mainOutStrings.length);
    }

    @Test
    public void test0403() {
        Collections.reverse(test);

        int i = 0;
        for(String s: test) {
            Assert.assertEquals(s, mainOutStrings[i]);
            i++;
        }
    }
}