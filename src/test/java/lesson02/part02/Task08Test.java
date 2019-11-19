package lesson02.part02;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import util.SystemOutGatewayUtil;

import java.io.ByteArrayOutputStream;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class Task08Test {
    @Before
    public void setUp() {
        SystemOutGatewayUtil.setCustomOut();
    }

    @After
    public void tearDown() {
        SystemOutGatewayUtil.clearOutput();
        SystemOutGatewayUtil.setOriginalOut();
    }

    @Test
    public void checkOutput() {
        Task08.main(null);

        ByteArrayOutputStream output = SystemOutGatewayUtil.getOutputArray();
        Assert.assertTrue("The program must output text", output.toString().length() > 0);
    }


    @Test
    public void checkCompareType() {
        try {
            String type = Task08.class.getMethod("compare", int.class).getReturnType().toString();
            Assert.assertEquals("Method 'compare' must return void",
                    "void",
                    type
            );
        } catch (NoSuchMethodException e) {
            Assert.fail("Task08 doesn't have method compare");
        }
    }

    @Test
    public void checkCompareWork() {
        Task08.compare(4);
        Task08.compare(6);
        Task08.compare(5);

        ByteArrayOutputStream output = SystemOutGatewayUtil.getOutputArray();
        String[] outLines = output.toString().split("\n");

        Assert.assertEquals("Method works incorrect",
                "Число меньше 5",
                outLines[0]
        );
        Assert.assertEquals("Method works incorrect",
                "Число больше 5",
                outLines[1]
        );
        Assert.assertEquals("Method works incorrect",
                "Число равно 5",
                outLines[2]
        );
    }
}