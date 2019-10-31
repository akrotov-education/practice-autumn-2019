package lesson02.part01;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import foloke.utils.DotJavaReader;
import util.SystemOutGatewayUtil;

import java.io.ByteArrayOutputStream;


@RunWith(JUnit4.class)
public class Task03Test {

    @Test
    public void test03() {
        //TODO: parse out calling conversion (can i use PowerMock ?????)
        SystemOutGatewayUtil.setCustomOut();
        ByteArrayOutputStream out = SystemOutGatewayUtil.getOutputArray();
        out.reset();

        DotJavaReader cl = DotJavaReader.openClass(Task03.class);
        String clLine;
        int count = 0;

        try {
            while ((clLine = cl.readLine()) != null) {
                if(clLine.contains("convertEurToUsd("))
                count++;
            }
        } catch (Exception e) {
            Assert.fail("что с вызовом конвертации?");
        }

        Assert.assertEquals(3, count);

        Task03.main(null);
        String[] output = out.toString().trim().split("\n");
        Assert.assertEquals(2, output.length);

        out.reset();
        Assert.assertEquals(2 * 1.11, Task03.convertEurToUsd(2, 1.11), 0);
        Assert.assertTrue(out.toString().isEmpty());

    }
}