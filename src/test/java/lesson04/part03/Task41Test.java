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
public class Task41Test {
    /* 1.	Программа должна выводить сообщение на экран.
     * 2.	В программе должен быть блок try-catch.
     * 3.	Программа должна отлавливать исключения конкретного типа, а не все возможные (Exception).
     * 4.	Выведенное сообщение должно содержать тип возникшего исключения.
     * 5.	Имеющийся код в методе main не удалять.
     */
    private static ByteArrayOutputStream out;
    private static String mainOutput;
    private static String[] mainOutputStrings;

    @BeforeClass
    public static void inti() {
        SystemOutGatewayUtil.setCustomOut();
        out = SystemOutGatewayUtil.getOutputArray();
        out.reset();

        Task41.main(null);

        mainOutput = out.toString().trim().replace("\r", "");
        mainOutputStrings = mainOutput.split("\n");
    }

    @Test
    public void test41main() {
        Assert.assertFalse(mainOutput.isEmpty());
    }

    @Test
    public void test4101() throws Exception {
        DotJavaReader jr = DotJavaReader.openClass(Task41.class);
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
    public void test4102() throws Exception{
        //TODO: can be done with Mockito?
        DotJavaReader jr = DotJavaReader.openClass(Task41.class);
        boolean containsException = false;
        if(jr != null) {
            String classString;
            while ((classString = jr.readLine()) != null) {
                if (classString.contains("IndexOutOfBoundsException "))
                    containsException = true;
            }
        } else {
            Assert.fail("где класс?");
        }

        Assert.assertTrue(containsException);
    }

    @Test
    public void test4103() {
        Assert.assertTrue(mainOutput.contains("IndexOutOfBoundsException"));
    }

    @Test
    public void test4104() throws Exception {
        DotJavaReader jr = DotJavaReader.openClass(Task41.class);
        boolean containsFirstCode = false;
        boolean containsSecondCode = false;
        if(jr != null) {
            String classString;
            while ((classString = jr.readLine()) != null) {
                if (classString.matches("\\s*int\\[] m = new int\\[2];\\s*"))
                    containsFirstCode = true;
                if (classString.matches("\\s*m\\[8] = 5;\\s*"))
                    containsSecondCode = true;
            }
        } else {
            Assert.fail("где класс?");
        }

        Assert.assertTrue(containsFirstCode);
        Assert.assertTrue(containsSecondCode);
    }
}