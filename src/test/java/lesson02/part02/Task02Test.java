package lesson02.part02;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import util.SystemOutGatewayUtil;

import java.io.ByteArrayOutputStream;
import java.lang.reflect.Field;
import java.util.List;

import static org.junit.Assert.*;

public class Task02Test {
    @Before
    public void setUp() {
        SystemOutGatewayUtil.setCustomOut();
    }

    @After
    public void tearDown() {
        SystemOutGatewayUtil.clearOutput();
        SystemOutGatewayUtil.setOriginalOut();

        Task02.Apple.applesPrice = 0;
    }

    @Test
    public void checkOutput() {
        Task02.main(null);

        ByteArrayOutputStream output = SystemOutGatewayUtil.getOutputArray();
        Assert.assertTrue("The program must output text", output.toString().length() > 0);
    }

    @Test
    public void checkAdjustAgeOutput() {
        Task02.Apple.addPrice(50);

        ByteArrayOutputStream output = SystemOutGatewayUtil.getOutputArray();
        Assert.assertTrue("Method adjustAge must not output text", output.toString().length() == 0);
    }

    @Test
    public void checkClassField() {
        Assert.assertEquals("Field applePrice must be initialized with 0",
                0,
                Task02.Apple.applesPrice
        );

        Field field;
        try {
            field = Task02.Apple.class.getField("applesPrice");
            Assert.assertTrue("Field applesPrice must be int and static",
                    field.toString().contains("static int")
            );
        } catch (NoSuchFieldException e) {
            Assert.fail("Field applesPrice must be static and public");
        }
    }


    @Test
    public void checkAddPriceWork() {
        Task02.Apple.addPrice(50);
        Assert.assertEquals("Method addPrice must increase price by transmitted value",
                50,
                Task02.Apple.applesPrice
        );
    }
}