package lesson05.part03;

import lesson02.part01.Task17;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import util.ReadFuncBodyUtil;
import util.SystemInGatewayUtil;
import util.SystemOutGatewayUtil;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task18Test {
    public static String fileName = "./src/main/java/lesson05/part03/Task18.java";
    public static List<String> collect;
    public static List<String> mainFunc;

    static {
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

            collect = stream.collect(Collectors.toList());
            int numberMainFunc = -1;

            for (int i = 0; i < collect.size(); i++) {
                if (collect.get(i).contains("public static void main(String[] args)")) {
                    numberMainFunc = i;
                }
            }

            mainFunc = ReadFuncBodyUtil.getFuncBody(collect, numberMainFunc);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

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
    public void test18Sout() throws Exception {
        boolean isReadConsole = false;

        for (String list: mainFunc) {
            if (list.contains("readLine();")) {
                isReadConsole = true;
            }
        }

        Assert.assertTrue(
                "Программа должна считывать c консоли имя файла.",
                isReadConsole
        );
    }

    @Test
    public void test18FileOutput() throws Exception {
        String filenameForTest = "./src/main/java/lesson05/part03/task18.txt";
        new File(filenameForTest).createNewFile();
        BufferedWriter writer = new BufferedWriter(new FileWriter(filenameForTest));
        String str = "123";
        writer.write(str);
        writer.close();

        SystemInGatewayUtil.provideInput(filenameForTest);
        Task18.main(null);
        SystemOutGatewayUtil.setOriginalOut();
        ByteArrayOutputStream outputArr = SystemOutGatewayUtil.getOutputArray();
        String s = outputArr.toString();

        Assert.assertTrue(
                "Программа должна выводить на экран содержимое файла.",
                s.equals(str)
        );
    }

    @Test
    public void test18FileInputStreamClose() throws Exception {
        boolean isClosed = false;

        for (String list: mainFunc) {
            if (list.contains("input.close();")) {
                isClosed = true;
            }
        }

        Assert.assertTrue(
                "Поток чтения из файла (FileInputStream) должен быть закрыт.",
                isClosed
        );
    }

    @Test
    public void test18BufferedReaderClose() throws Exception {
        boolean isClosed = false;

        for (String list: mainFunc) {
            if (list.contains("reader.close();")) {
                isClosed = true;
            }
        }

        Assert.assertTrue(
                "BufferedReader также должен быть закрыт.",
                isClosed
        );
    }
}
