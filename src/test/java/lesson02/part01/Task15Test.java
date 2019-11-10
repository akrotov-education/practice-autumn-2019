package lesson02.part01;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import util.SystemOutGatewayUtil;

import java.io.ByteArrayOutputStream;

public class Task15Test {
    public static String fileName = "./src/main/java/lesson02/part01/Task15.java";

    @Before
    public void before() {
        SystemOutGatewayUtil.setCustomOut();
    }

    @After
    public void after() {
        SystemOutGatewayUtil.clearOutput();
    }

    @Test
    public void test15OutputScreen() {
        Task15.main(null);
        SystemOutGatewayUtil.setOriginalOut();
        ByteArrayOutputStream outputArr = SystemOutGatewayUtil.getOutputArray();
        String s = outputArr.toString();

        Assert.assertTrue(
                "Программа должна выводить текст",
                !s.isEmpty()
        );
    }

    @Test
    public void test15TwoString() {
        Task15.main(null);
        SystemOutGatewayUtil.setOriginalOut();
        ByteArrayOutputStream outputArr = SystemOutGatewayUtil.getOutputArray();
        String s = outputArr.toString();

        int count = s.split("\n").length - 1;

        Assert.assertTrue(
                "Должно быть выведено две строки",
                count == 1
        );
    }

    @Test
    public void test15EqualsFirstString() {
        Task15.main(null);
        SystemOutGatewayUtil.setOriginalOut();
        ByteArrayOutputStream outputArr = SystemOutGatewayUtil.getOutputArray();
        String s = outputArr.toString();

        String str = s.split("\n")[0];

        Assert.assertTrue(
                "Текст первый строки должен быть: It's Windows path: \"C:\\Program Files\\Java\\jdk1.7.0\\bin\"",
                str.equals("It's Windows path: \"C:\\Program Files\\Java\\jdk1.7.0\\bin\"")
        );
    }

    @Test
    public void test15EqualsSecondString() {
        Task15.main(null);
        SystemOutGatewayUtil.setOriginalOut();
        ByteArrayOutputStream outputArr = SystemOutGatewayUtil.getOutputArray();
        String s = outputArr.toString();

        String str = s.split("\n")[1];

        Assert.assertTrue(
                "Текст второй строки должен быть: It's Java string: \\\"C:\\\\Program Files\\\\Java\\\\jdk1.7.0\\\\bin\\\"",
                str.equals("It's Java string: \\\"C:\\\\Program Files\\\\Java\\\\jdk1.7.0\\\\bin\\\"")
        );
    }
}
