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
public class Task04Test {
    /* Требования:
    * 1. Программа должна выводить на экран числа 12 и 2. //25 and 26 actually
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

        Task04.main(null);
        output = out.toString().trim();
        outputStrings = output.split("\n");
    }

    @Test
    public void test04main() {
        Assert.assertTrue("not 25" , output.contains("25"));
        Assert.assertTrue("not 26", output.contains("26"));
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