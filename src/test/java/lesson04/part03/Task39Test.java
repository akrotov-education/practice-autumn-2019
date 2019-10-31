package lesson04.part03;
//@FoLoKe
import foloke.utils.DotJavaReader;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import util.SystemOutGatewayUtil;

import java.io.ByteArrayOutputStream;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class Task39Test {
    /* 1.	Программа должна выводить сообщение на экран.
     * 2.	В программе должен быть блок try-catch.
     * 3.	Программа должна отлавливать исключения конкретного типа, а не все возможные (Exception).
     * 4.	Выведенное сообщение должно содержать тип возникшего исключения.
     * 5.	Имеющийся код в методе main не удалять.
     *
     */
    private static ByteArrayOutputStream out;
    private static String mainOutput;
    private static String[] mainOutputStrings;

    @BeforeClass
    public static void inti() {
        SystemOutGatewayUtil.setCustomOut();
        out = SystemOutGatewayUtil.getOutputArray();
        out.reset();

        Task39.main(null);

        mainOutput = out.toString().trim().replace("\r", "");
        mainOutputStrings = mainOutput.split("\n");
    }

    @Test
    public void test39main() {
        Assert.assertFalse(mainOutput.isEmpty());
    }

    @Test
    public void test3901() throws Exception {
        DotJavaReader jr = DotJavaReader.openClass(Task39.class);
        int foundTry = 0;
        int foundCatch = 0;
        if(jr != null) {
            String classString;
            while ((classString = jr.readLine()) != null) {
                if (classString.contains("try"))
                    foundTry++;
                if (classString.contains("catch"))
                    foundCatch++;
            }
        } else {
            Assert.fail("где класс?");
        }

        Assert.assertEquals(2, foundTry);
        Assert.assertEquals(2, foundCatch);
    }

    @Test
    public void test3902() throws Exception{
        //TODO: can be done with Mockito?
        DotJavaReader jr = DotJavaReader.openClass(Task39.class);
        boolean containsException = false;
        if(jr != null) {
            String classString;
            while ((classString = jr.readLine()) != null) {
                if (classString.contains("ArithmeticException "))
                    containsException = true;
            }
        } else {
            Assert.fail("где класс?");
        }

        Assert.assertTrue(containsException);
    }

    @Test
    public void test3903() {
        Assert.assertTrue(mainOutput.contains("ArithmeticException"));
    }

    @Test
    public void test3904() throws Exception {
        DotJavaReader jr = DotJavaReader.openClass(Task39.class);
        boolean containsCode = false;
        if(jr != null) {
            String classString;
            while ((classString = jr.readLine()) != null) {
                if (classString.matches("\\s*int a = 42 / 0;\\s*"))
                    containsCode = true;
            }
        } else {
            Assert.fail("где класс?");
        }

        Assert.assertTrue(containsCode);
    }
}