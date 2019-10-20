package lesson02.part02;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import util.SystemOutGatewayUtil;

import java.io.ByteArrayOutputStream;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyObject;
import static org.mockito.internal.verification.VerificationModeFactory.times;

@RunWith(PowerMockRunner.class)
@PrepareForTest(Task09.class)
public class Task09Test {
    static int displayCalls;
    static int absCalls;
    @Test
    public void test09()
    {
        //HOW THE F*CK MOCK WORKS!!!!#!@##$$%@#
        SystemOutGatewayUtil.setCustomOut();
        ByteArrayOutputStream out = SystemOutGatewayUtil.getOutputArray();
        out.reset();

        try
        {
            PowerMockito.mockStatic(Task09.class);
            PowerMockito.when(Task09.abs(anyInt())).thenAnswer(new Answer<Object>() {
            @Override
            public Object answer(InvocationOnMock invocationOnMock) throws Throwable
            {
                absCalls++;
                return 1;
            }});

            Task09.displayClosestToTen(1, 2);
            Task09.main(null);

            //Assert.assertEquals("2", Task09.displayClosestToTen(1, 2));
            System.out.println(absCalls + " " + displayCalls);
        } catch (Exception e) {
            Assert.fail("methods fail");
        }
    }
}