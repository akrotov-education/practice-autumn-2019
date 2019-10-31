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
public class Task03Test {
    /* 1.	Программа должна создавать массив на 10 строк.
     * 2.	Программа должна создавать массив на 10 целых чисел.
     * 3.	Программа должна считывать строки для массива с клавиатуры.
     * 4. Программа должна в массив чисел записать длины строк из массива строк,
     * а затем их вывести на экран.
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


        Task03.main(null);
        mainOutput = out.toString().trim().replace("\r", "");
        mainOutStrings = mainOutput.split("\n");
    }

    @Test
    public void test0301() {
        //TODO: test that String array has been created
    }

    @Test
    public void test0302() {
        //TODO: test that int array has been created
    }

    @Test
    public void test03Main() {
        Assert.assertEquals(10, mainOutStrings.length);
    }


    @Test
    public void test0303() {
        for (int i = 0; i < 9; i++) {
            SystemInGatewayUtil.addCustomIn(Integer.toString(i));
        }
        SystemInGatewayUtil.setCustomIn();

        try {
            Task03.main(null);
            Assert.fail("not 10");
        } catch (Exception e) {
            //OK
        }
    }

    @Test
    public void  test0304(){
        int i = 0;
        for (String s : test) {
            Assert.assertEquals(s.length(), Integer.parseInt(mainOutStrings[i]));
            i++;
        }
    }

}