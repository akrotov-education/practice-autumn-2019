package lesson02.part02;

import com.sun.webkit.graphics.WCTextRun;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import util.SystemOutGatewayUtil;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import static org.junit.Assert.*;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;

@RunWith(PowerMockRunner.class)
public class Task02Test {
    static int callCount;
    @PrepareForTest(Task02.class)
    @Test
    public void test02()
    {
        try {
            Field f = Task02.Apple.class.getDeclaredField("applesPrice");
            Assert.assertTrue(Modifier.isStatic(f.getModifiers()));
            Assert.assertEquals(Integer.TYPE ,f.getType());
        }catch (Exception e)
        {
            Assert.fail("no field");
        }

        SystemOutGatewayUtil.setCustomOut();
        ByteArrayOutputStream out = SystemOutGatewayUtil.getOutputArray();
        out.reset();

        Task02.Apple.addPrice(1);
        Assert.assertTrue(out.toString().isEmpty());
        Task02.Apple.addPrice(2);
        Assert.assertEquals(3, Task02.Apple.applesPrice);

        try {
            PowerMockito.mockStatic(Task02.Apple.class);
            Task02.Apple apple = new Task02.Apple();
            PowerMockito.whenNew(Task02.Apple.class).withNoArguments().thenReturn(apple);

            PowerMockito.doAnswer(new Answer<Object>() {
                @Override
                public Void answer(InvocationOnMock invocationOnMock) throws Throwable {
                    callCount++;
                    return null;
                }
            }).when(Task02.Apple.class, "addPrice", anyInt());

            Task02.main(null);
            Assert.assertEquals(2, callCount);
        }
        catch (Exception e)
        {
            Assert.fail("main is bad" + e);
        }
    }
}