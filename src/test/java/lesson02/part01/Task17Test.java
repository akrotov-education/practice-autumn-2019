package lesson02.part01;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import util.SystemInGatewayUtil;
import util.SystemOutGatewayUtil;

import java.io.ByteArrayOutputStream;

public class Task17Test {
    public static String fileName = "./src/main/java/lesson02/part01/Task17.java";

    @Before
    public void before() {
        SystemOutGatewayUtil.setCustomOut();
    }

    @After
    public void after() {
        SystemInGatewayUtil.setOriginalIn();
        SystemOutGatewayUtil.clearOutput();
    }

    @Test
    public void test17OutputScreen() throws Exception {
        String name = "kek";
        int years = 12;
        SystemInGatewayUtil.provideInput(name + "\n" + years);
        Task17.main(null);
        SystemOutGatewayUtil.setOriginalOut();
        ByteArrayOutputStream outputArr = SystemOutGatewayUtil.getOutputArray();
        String s = outputArr.toString();

        Assert.assertTrue(
                "Программа должна выводить текст",
                !s.isEmpty()
        );
    }

    @Test
    public void test17ReadKeyboard() throws Exception {
        String name = "kek";
        int years = 12;
        SystemInGatewayUtil.provideInput(name + "\n" + years);
        Task17.main(null);
        SystemOutGatewayUtil.setOriginalOut();
        ByteArrayOutputStream outputArr = SystemOutGatewayUtil.getOutputArray();
        String s = outputArr.toString();

        Assert.assertTrue(
                "Программа должна считывать данные с клавиатуры",
                s.equals(name + " захватит мир через " + years + ". Му-ха-ха!\n") ||
                        s.equals(name + " захватит мир через " + years + ". Му-ха-ха!")
        );
    }

    @Test
    public void test17ContainsName() throws Exception {
        String name = "kek";
        int years = 12;
        SystemInGatewayUtil.provideInput(name + "\n" + years);
        Task17.main(null);
        SystemOutGatewayUtil.setOriginalOut();
        ByteArrayOutputStream outputArr = SystemOutGatewayUtil.getOutputArray();
        String s = outputArr.toString();

        Assert.assertTrue(
                "Выведенный текст должен содержать введенное имя",
                s.contains(name + " ")
        );
    }

    @Test
    public void test17ContainsNumber() throws Exception {
        String name = "kek";
        int years = 12;
        SystemInGatewayUtil.provideInput(name + "\n" + years);
        Task17.main(null);
        SystemOutGatewayUtil.setOriginalOut();
        ByteArrayOutputStream outputArr = SystemOutGatewayUtil.getOutputArray();
        String s = outputArr.toString();

        Assert.assertTrue(
                "Выведенный текст должен содержать введенное число",
                s.contains(" " + years + ".")
        );
    }
}
