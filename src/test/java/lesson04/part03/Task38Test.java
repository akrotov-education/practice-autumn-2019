package lesson04.part03;
//@FoLoKe
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import util.SystemOutGatewayUtil;

import java.io.ByteArrayOutputStream;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class Task38Test {
    /* 1.	Метод log должен выводить сообщение на экран.
     * 2.	Выведенное сообщение должно содержать имя класса, метод которого вызвал метод log.
     * 3.	Выведенное сообщение должно содержать имя метода, который вызвал метод log.
     * 4.	Выведенное сообщение должно содержать переданное сообщение.
     * 5.	Вывод должен соответствовать примеру из задания.
     */
    private static ByteArrayOutputStream out;
    private static String mainOutput;
    private static String[] mainOutputStrings;

    @BeforeClass
    public static void inti() {
        SystemOutGatewayUtil.setCustomOut();
        out = SystemOutGatewayUtil.getOutputArray();
        out.reset();

        Task38.main(null);

        mainOutput = out.toString().trim().replace("\r", "");
        mainOutputStrings = mainOutput.split("\n");
    }

    @Test
    public void test38main() {
        Assert.assertEquals("lesson04.part03.Task38: main: In main method", mainOutput);
    }

    @Test
    public void test3801() {
        out.reset();
        Task38.log("");
        Assert.assertFalse(out.toString().isEmpty());
    }

    @Test
    public void test3802() {
        out.reset();
        Task38.log("");
        Assert.assertTrue(out.toString().contains(this.getClass().getName()));
    }

    @Test
    public void test3803() {
        out.reset();
        Task38.log("");
        Assert.assertTrue(out.toString().contains("test3803"));
    }

    @Test
    public void test3804() {
        out.reset();
        Task38.log("die world");
        Assert.assertTrue(out.toString().contains("die world"));
    }
}