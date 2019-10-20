package lesson02.part01;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import util.SystemOutGatewayUtil;

import java.io.ByteArrayOutputStream;

import static org.junit.Assert.*;

public class Task13Test {
    @Test
    public void test1 () {
        Task13.main(null);
        ByteArrayOutputStream outputArray = SystemOutGatewayUtil.getOutputArray();
        String[] s = outputArray.toString().split("\n");
        Assert.assertTrue("Message", s.length == 10);
        for(int i = 0; i < s.length; i++) {
            String[] line = s[i].split(" ");
            Assert.assertTrue("Message", line.length == 10);
            try {
                for (int j = 0; j < line.length; j++) {
                    int res = Integer.parseInt(line[j].replaceAll("\\s", ""));
                    Assert.assertTrue("Message", res == (i+1) * (j+1));
                }
            }
            catch (Exception e) {
                Assert.assertTrue("Message", false);
            }
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