package lesson01.part1;
//@FoLoKe
import foloke.utils.DotJavaReader;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import util.SystemOutGatewayUtil;
import java.io.ByteArrayOutputStream;

@RunWith(JUnit4.class)
public class Task14Test {
    /* 1. Значения переменных: a, b, c, d не изменяй.
     * 2. Перед каждой из переменных: a, b, c, d в строке с объявлением переменной result должен стоять один знак плюс либо минус.
     * 3. В результате работы программы на экран нужно вывести число 20.
     * 4. Знаки плюс и минус должны быть расставлены правильно.
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

        Task14.main(null);
        mainOutput = out.toString().trim();
        mainOutputStrings = mainOutput.split("\n");
    }

    @Test
    public void test14main() {
        Assert.assertEquals("20", out.toString().trim());
    }

    @Test
    public void test1401() throws Exception
    {
        boolean foundA = false;
        boolean foundB = false;
        boolean foundC = false;
        boolean foundD = false;
        DotJavaReader jr = DotJavaReader.openClass(Task12.class);

        if(jr != null) {
            String jrOut;
            while((jrOut = jr.readLine()) != null)
            {
                if(jrOut.contains("public static int a = 1;"))
                    foundA = true;
                else if (jrOut.contains("public static int b = 3;"))
                    foundB = true;
                else if (jrOut.contains("public static int c = 9;"))
                    foundC = true;
                else if (jrOut.contains("public static int d = 27;"))
                    foundD = true;
            }
        }

        Assert.assertTrue(foundA);
        Assert.assertTrue(foundB);
        Assert.assertTrue(foundC);
        Assert.assertTrue(foundD);
    }

    @Test
    public void test1402() throws Exception
    {
        DotJavaReader jr = DotJavaReader.openClass(Task14.class);
        boolean test = false;
        if(jr != null) {
            String jrOut;
            while ((jrOut = jr.readLine()) != null) {
                if (jrOut.matches("\\s*int result\\s*=" +
                        "\\s*[-+]\\s*a\\s*" +
                        "\\s*[-+]\\s*b\\s*" +
                        "\\s*[-+]\\s*c\\s*" +
                        "\\s*[-+]\\s*d\\s*;\\s*")){
                    test = true;
                    break;
                }


            }
        }
        Assert.assertTrue("неправильно составлена строка", test);
    }

    @Test
    public void test1403() throws Exception
    {
        DotJavaReader jr = DotJavaReader.openClass(Task14.class);
        boolean test = false;
        if(jr != null) {
            String jrOut;
            while ((jrOut = jr.readLine()) != null) {
                if (jrOut.matches("\\s*int result\\s*=" +
                        "\\s*-\\s*a\\s*" +
                        "\\s*\\+\\s*b\\s*" +
                        "\\s*-\\s*c\\s*" +
                        "\\s*\\+\\s*d\\s*;\\s*")){
                    test = true;
                    break;
                }


            }
        }
        Assert.assertTrue("неправильно расставленны знаки", test);
    }
}