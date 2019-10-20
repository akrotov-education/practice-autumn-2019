package lesson01.part1;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import util.SystemOutGatewayUtil;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class Task04Test {

    @Before
    public void setUp() throws Exception {
        SystemOutGatewayUtil.setCustomOut();
    }

    @After
    public void tearDown() throws Exception {
        SystemOutGatewayUtil.setOriginalOut();
    }

    @Test
    public void checkNums() {
        Task04.main(null);

        ByteArrayOutputStream output = SystemOutGatewayUtil.getOutputArray();
        String[] nums = output.toString().split("\n");

        Assert.assertEquals(nums[0], "26");
        Assert.assertEquals(nums[1], "25");
    }
}