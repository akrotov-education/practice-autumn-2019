package lesson02.part01;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import util.SystemOutGatewayUtil;

import java.io.ByteArrayOutputStream;

import static org.junit.Assert.*;
@RunWith(JUnit4.class)

public class Task13Test {
    @Before
    public void setUp() throws Exception {
        SystemOutGatewayUtil.setCustomOut();

    }
    @After
    public void tearDown() throws Exception {
        SystemOutGatewayUtil.setOriginalOut();
    }
    @Test
    public void CheckOutput(){
        Task13.main(null);
        ByteArrayOutputStream s = SystemOutGatewayUtil.getOutputArray();
        String s2 = s.toString();
        Assert.assertEquals("1 2 3 4 5 6 7 8 9 10  \n" +
                "2 4 6 8 10 12 14 16 18 20  \n" +
                "3 6 9 12 15 18 21 24 27 30  \n" +
                "4 8 12 16 20 24 28 32 36 40  \n" +
                "5 10 15 20 25 30 35 40 45 50  \n" +
                "6 12 18 24 30 36 42 48 54 60  \n" +
                "7 14 21 28 35 42 49 56 63 70  \n" +
                "8 16 24 32 40 48 56 64 72 80  \n" +
                "9 18 27 36 45 54 63 72 81 90  \n" +
                "10 20 30 40 50 60 70 80 90 100  \n", s2);
    }
}