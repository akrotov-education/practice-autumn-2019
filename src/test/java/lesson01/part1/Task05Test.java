package lesson01.part1;
//@FoLoKe
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import foloke.utils.DotJavaReader;
import util.SystemOutGatewayUtil;
import java.io.ByteArrayOutputStream;

@RunWith(JUnit4.class)
public class Task05Test {

    /* 1. Программа должна выводить на экран надпись "9 умножить на 3 равно 27"
     * 2. Нужно раскомментировать одну строку.
     * 3. Нельзя изменять (добавлять, удалять) строки с кодом.
     */

    private static ByteArrayOutputStream out;
    private static String output;
    private static String[] outputStrings;

    @Before
    public void init()
    {
        SystemOutGatewayUtil.setCustomOut();
        out = SystemOutGatewayUtil.getOutputArray();
        out.reset();

        Task05.main(null);
        output = out.toString().trim();
        outputStrings = output.split("\n");
    }

    @Test
    public void test05main() {
        Assert.assertEquals("9 умножить на 3 равно 27", output);
    }

    @Test
    public void test0401()
    {
        int commentsCount = 0;
        try {
            DotJavaReader cr = DotJavaReader.openClass(Task04.class);
            String classLine;
            if(cr != null) {
                while ((classLine = cr.readLine()) != null) {
                    if (classLine.contains("//"))
                        commentsCount++;
                }

                cr.close();
            }
        }
        catch (Exception e)
        {
            System.out.println(e.toString());
        }
        Assert.assertEquals("расскоментируйте 1 строку", 6, commentsCount);

    }

    @Test
    public void test0402()
    {
        int rowsCount = 0;
        try {
            DotJavaReader cr = DotJavaReader.openClass(Task04.class);
            if(cr != null) {
                while (cr.readLine() != null) {
                    rowsCount++;
                }

                cr.close();
            }
        }
        catch (Exception e)
        {
            System.out.println(e.toString());
        }
        Assert.assertEquals("нельзя добавлять/удалять код", 33, rowsCount);
    }
}