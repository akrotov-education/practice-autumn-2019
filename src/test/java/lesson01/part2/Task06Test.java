package lesson01.part2;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import util.SystemOutGatewayUtil;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task06Test {
    public static String fileName = "./src/main/java/lesson01/part2/Task06.java";

    @Before
    public void before() {
        SystemOutGatewayUtil.setCustomOut();
    }

    @After
    public void after() {
        SystemOutGatewayUtil.clearOutput();
    }

    @Test
    public void test06OutputScreen() {
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

            List<String> collect = stream.collect(Collectors.toList());

            Assert.assertTrue(
                    "Программа должна выводить текст на экран",
                    collect.get(18).contains("System.out.print")
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test06FindStartString() {
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

            List<String> collect = stream.collect(Collectors.toList());
            Task06.main(null);
            SystemOutGatewayUtil.setOriginalOut();
            ByteArrayOutputStream outputArr = SystemOutGatewayUtil.getOutputArray();
            String s = outputArr.toString();
            Pattern p = Pattern.compile("^[Будешь]");
            Matcher m = p.matcher(s);

            Assert.assertTrue(
                    "Текст должен начинаться с \"Будешь\"",
                    m.find()
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test06FindEndString() {
        Task06.main(null);
        SystemOutGatewayUtil.setOriginalOut();
        ByteArrayOutputStream outputArr = SystemOutGatewayUtil.getOutputArray();
        String s = outputArr.toString();
        Pattern p = Pattern.compile("[память]$");
        Matcher m = p.matcher(s);

        Assert.assertTrue(
                "Текст должен заканчиваться на \"память\"",
                m.find()
        );
    }

    @Test
    public void test06OutputNumberString() {
        Task06.main(null);
        SystemOutGatewayUtil.setOriginalOut();
        ByteArrayOutputStream outputArr = SystemOutGatewayUtil.getOutputArray();
        String s = outputArr.toString();


        Assert.assertTrue(
                "Текст должен состоять из 52 символов, включая пробелы и знаки препинания",
                s.length() == 53
        );
    }

    @Test
    public void test06StringContains() {
        Task06.main(null);
        SystemOutGatewayUtil.setOriginalOut();
        ByteArrayOutputStream outputArr = SystemOutGatewayUtil.getOutputArray();
        String s = outputArr.toString();


        Assert.assertTrue(
                "Выводимый текст должен соответствовать заданию",
                s.contains("Будешь плохо кодить, придет Java и съест твою память") ||
                        s.contains("Будешь плохо кодить, придет Java и съест твою память\n")
        );
    }
}
