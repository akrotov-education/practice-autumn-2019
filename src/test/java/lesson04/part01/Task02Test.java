package lesson04.part01;
//@FoLоKe
import foloke.utils.SystemInGatewayUtil;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import util.SystemOutGatewayUtil;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.*;
import static org.mockito.asm.tree.InsnList.check;

@RunWith(JUnit4.class)
public class Task02Test {
    /* 1.	Программа должна создавать массив на 10 строк.
     * 2.	Программа должна считывать 8 строк для массива с клавиатуры.
     * 3.	Программа должна выводить на экран 10 строк, каждую с новой строки.
     * 4.	Программа должна выводить на экран массив (10 элементов) в обратном порядке.
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

        for (int i = 0; i < 8; i++) {
            SystemInGatewayUtil.addCustomIn(Integer.toString(i));
            test.add(Integer.toString(i));
        }

        test.add("null");
        test.add("null");

        SystemInGatewayUtil.setCustomIn();


        Task02.main(null);
        mainOutput = out.toString().trim().replace("\r", "");
        mainOutStrings = mainOutput.split("\n");
    }


    @Test
    public void test0201() {
        //TODO: check that array has been created
    }

    @Test
    public void test02main() throws Exception {
        assertEquals(10, mainOutStrings.length);
    }

    @Test
    public void test0202() {
        for (int i = 0; i < 7; i++) {
            SystemInGatewayUtil.addCustomIn(Integer.toString(i));
        }
        SystemInGatewayUtil.setCustomIn();

        try {
            Task02.main(null);
            Assert.fail("not 8");
        } catch (Exception e) {
            //OK
        }
    }

    @Test
    public void test0203() {
        Collections.reverse(test);

        int i = 0;
        for(String s: test) {
            Assert.assertEquals(s, mainOutStrings[i]);
            i++;
        }
    }
}