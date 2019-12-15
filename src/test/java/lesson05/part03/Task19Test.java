package lesson05.part03;

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

public class Task19Test {
    public static String fileName = "./src/main/java/lesson05/part03/Task19.java";
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
    public void test19Sout() {
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
    public void test19FileOutput() {
        boolean isBufferedWriter = false;

        for (String list: mainFunc) {
            if (list.contains("BufferedWriter") && list.contains("new BufferedReader(new InputStreamReader(System.in));")) {
                isBufferedWriter = true;
            }
        }

        Assert.assertFalse(
                "Создай и используй объект типа BufferedWriter.",
                isBufferedWriter
        );
    }

    @Test
    public void test19NoFileReader() {
        boolean isFileReader = true;

        for (String list: mainFunc) {
            if (list.contains("new FileReader")) {
                isFileReader = false;
            }
        }

        Assert.assertTrue(
                "Программа не должна ничего читать из файловой системы.",
                isFileReader
        );
    }

    @Test
    public void test19ReadSout() throws Exception {
        String filenameForTest = "./src/main/java/lesson05/part03/task19.txt";
        new File(filenameForTest).createNewFile();
        BufferedWriter writer = new BufferedWriter(new FileWriter(filenameForTest));
        String str = "123\nexit";
        writer.write(str);
        writer.close();

        SystemInGatewayUtil.provideInput(filenameForTest + "\n" + str);
        Task19.main(null);
        InputStream is = new FileInputStream(filenameForTest);
        BufferedReader buf = new BufferedReader(new InputStreamReader(is));
        String line = buf.readLine();
        StringBuilder sb = new StringBuilder();

        while(line != null) {
            sb.append(line).append("\n");
            line = buf.readLine();
        }

        String fileAsString = sb.toString();

        Assert.assertTrue(
                "Программа должна считывать строки с консоли, пока пользователь не введет строку \"exit\".",
                fileAsString.equals(str + "\n")
        );
    }

    @Test
    public void test19WriteToFile() throws Exception {
        String filenameForTest = "./src/main/java/lesson05/part03/task19.txt";
        new File(filenameForTest).createNewFile();
        BufferedWriter writer = new BufferedWriter(new FileWriter(filenameForTest));
        String str = "123\nexit";
        writer.write(str);
        writer.close();

        SystemInGatewayUtil.provideInput(filenameForTest + "\n" + str);
        Task19.main(null);
        InputStream is = new FileInputStream(filenameForTest);
        BufferedReader buf = new BufferedReader(new InputStreamReader(is));
        String line = buf.readLine();
        StringBuilder sb = new StringBuilder();

        while(line != null) {
            sb.append(line).append("\n");
            line = buf.readLine();
        }

        String fileAsString = sb.toString();

        Assert.assertTrue(
                "Программа должна записать абсолютно все введенные строки (включая \"exit\") в файл, каждую строчку с новой строки.",
                fileAsString.equals(str + "\n")
        );
    }

    @Test
    public void test19BufferedWriterClose() {
        boolean isClosed = false;

        for (String list: mainFunc) {
            if (list.contains("writer.close();")) {
                isClosed = true;
            }
        }

        Assert.assertTrue(
                "Метод main должен закрывать объект типа BufferedWriter после использования.",
                isClosed
        );
    }

    @Test
    public void test19MainNoSout() {
        boolean isSout = true;

        for (String list: mainFunc) {
            if (!list.contains("System.out.print")) {
                isSout = false;
            }
        }

        Assert.assertFalse(
                "Метод main не должен выводить данные на экран.",
                isSout
        );
    }
}
