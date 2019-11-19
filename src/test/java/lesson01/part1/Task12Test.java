package lesson01.part1;

import foloke.utils.DotJavaReader;
//@FoLoКe
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import util.SystemOutGatewayUtil;
import java.io.ByteArrayOutputStream;

@RunWith(JUnit4.class)
public class Task12Test {
    /* 1. Программа должна выводить текст.
     * 2. Нельзя изменять строки с объявлением переменных.
     * 3. Выводимый текст должен состоять из 2 строк.
     * 4. Программа должна выводить переменные, значения которых являются названиями фруктов.
     * 5. Программа не должна выводить переменные, значения которых не являются названиями фруктов.
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

        Task12.main(null);
        mainOutput = out.toString().trim();
        mainOutputStrings = mainOutput.split("\n");
    }

    @Test
    public void test1201()
    {
        Assert.assertFalse(mainOutput.isEmpty());
    }

    @Test
    public void test12main() {
        Assert.assertTrue(mainOutput.contains("Яблоко"));
        Assert.assertTrue(mainOutput.contains("Персик"));
    }

    @Test
    public void test1202() throws Exception{
        boolean foundPeach = false;
        boolean foundApple = false;
        boolean foundPorridge = false;
        boolean foundSausage = false;

        DotJavaReader jr = DotJavaReader.openClass(Task12.class);

        if(jr != null) {
            String jrOut;

            while ((jrOut = jr.readLine()) != null) {
                if (jrOut.contains("String apple = \"Яблоко\";"))
                    foundApple = true;
                else if (jrOut.contains("String porridge = \"Каша\";"))
                    foundPorridge = true;
                else if (jrOut.contains("String sausage = \"Колбаса\";"))
                    foundSausage = true;
                else if (jrOut.contains("String peach = \"Персик\";"))
                    foundPeach = true;
            }
        }

        Assert.assertTrue(foundApple);
        Assert.assertTrue(foundPeach);
        Assert.assertTrue(foundPorridge);
        Assert.assertTrue(foundSausage);
    }

    @Test
    public void test1203()
    {
        Assert.assertEquals(2, mainOutputStrings.length);
    }

    @Test
    public void test1204()
    {
        Assert.assertFalse(mainOutput.contains("Колбаса"));
        Assert.assertFalse(mainOutput.contains("Каша"));
    }
}