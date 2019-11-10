package lesson04.part02;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import util.SystemOutGatewayUtil;

import java.io.ByteArrayOutputStream;

import static org.junit.Assert.*;

public class Task22Test {
    @Test
    public void test1 () {
        try {
            Task22.main(null);
            ByteArrayOutputStream outputArray = SystemOutGatewayUtil.getOutputArray();
            String s = outputArray.toString().trim();
            String[] result = {"арбуз - ягода", "банан - трава", "вишня - ягода", "груша - фрукт",
                    "дыня - овощ", "ежевика - куст", "жень-шень - корень", "земляника - ягода",
                    "ирис - цветок", "картофель - клубень"};
            for(int i = 0; i < result.length; i++) {
                Assert.assertTrue("Message", s.contains(result[i]));
            }
        } catch(Exception e) {
            System.out.println("Exception!");
            Assert.assertTrue("Message", false);
        }
    }

    @Before
    public void before() {
        SystemOutGatewayUtil.setCustomOut();
    }

    @After
    public void after() {
        SystemOutGatewayUtil.getOutputArray();
    }
}