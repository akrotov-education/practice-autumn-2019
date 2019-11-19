package lesson01.part1;
//@FoLoKe
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import util.SystemOutGatewayUtil;

import java.io.ByteArrayOutputStream;

@RunWith(JUnit4.class)
public class Task06Test {

    /* 1. В методе printCircleLength нужно вывести длину окружности, рассчитанную по формуле: 2 * Pi * radius.
     * 2. Метод main должен вызывать метод printCircleLength с параметром 5.
     * 3. Метод main не должен вызывать команду вывода текста на экран.
     * 4. Программа должна выводить длину окружности с радиусом 5.
     */
    private static ByteArrayOutputStream out;
    private static String mainOutput;
    private static String[] mainOutputStrings;

    @Before
    public void init()
    {
        SystemOutGatewayUtil.setCustomOut();
        out = SystemOutGatewayUtil.getOutputArray();
        out.reset();

        Task05.main(null);
        mainOutput = out.toString().trim();
        mainOutputStrings = mainOutput.split("\n");
    }

    @Test
    public void test06main() {
        Assert.assertEquals(Double.toString(2 * 3.14 * 5), mainOutput);
    }

    @Test
    public void test0601()
    {
        out.reset();
        Task06.printCircleLength(5);
        Assert.assertEquals(Double.toString(2 * 3.14 * 5), out.toString().trim());
    }

    @Test
    public void test0102()
    {
        //TODO: not mocking println
    }

    @Test
    public void test0103()
    {
        //TODO: mocking printCircleLength
    }
}