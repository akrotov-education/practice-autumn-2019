package lesson04.part03;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import util.ReadFuncBodyUtil;
import util.SystemOutGatewayUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task47Test {
    public static String fileName = "./src/main/java/lesson04/part03/Task47.java";
    public static List<String> collect;
    public static List<String> mainFunc;
    public static List<String> handleExceptionsFunc;

    static {
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

            collect = stream.collect(Collectors.toList());
            int numberHandleExceptionsFunc = 0;
            int numberHMainFunc = 0;

            for (int i = 0; i < collect.size(); i++) {
                if (collect.get(i).contains("public static void handleExceptions()")) {
                    numberHandleExceptionsFunc = i;
                }
            }

            for (int i = 0; i < collect.size(); i++) {
                if (collect.get(i).contains("public static void main(String[] args)")) {
                    numberHMainFunc = i;
                }
            }

            mainFunc = ReadFuncBodyUtil.getFuncBody(collect, numberHMainFunc);
            handleExceptionsFunc = ReadFuncBodyUtil.getFuncBody(collect, numberHandleExceptionsFunc);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Before
    public void before() {
        SystemOutGatewayUtil.setCustomOut();
    }

    @Test
    public void test47CheckMethod() {
        boolean isMethod = false;
        for (String s : handleExceptionsFunc) {
            if (s.contains("BEAN.methodThrowExceptions();"))
                isMethod = true;
        }
        Assert.assertTrue(
            "Метод handleExceptions должен вызывать метод BEAN.methodThrowExceptions",
            isMethod
        );
    }

    @Test
    public void test47FileSystemException() {
        boolean isFileSystemException = false;
        int num = 0;

        for (String s : handleExceptionsFunc) {
            if (num == 2 && s.contains("throw e;")) {
                isFileSystemException = true;
                num = 0;
            }

            if (num == 1 && s.contains("BEAN.log(e);")) {
                num++;
            }

            if (s.contains("catch") && s.contains("FileSystemException")) {
                num++;
            }
        }
        Assert.assertTrue(
            "Метод handleExceptions должен логировать исключение FileSystemException (вызвать метод BEAN.log), а затем пробросить его дальше",
            isFileSystemException
        );
    }

    @Test
    public void test47CharConversionException() {
        boolean isCharConversionException = false;
        int num = 0;

        for (String s : handleExceptionsFunc) {
            if (num == 2 && (s.contains("}") || s.contains("catch"))) {
                isCharConversionException = true;
            }

            if (num == 1 && s.contains("BEAN.log(e);")) {
                num++;
            }

            if (s.contains("catch") && s.contains("CharConversionException"))
                num++;
        }
        Assert.assertTrue(
            "Метод handleExceptions должен только логировать (вызвать метод BEAN.log) исключение CharConversionException",
            isCharConversionException
        );
    }

    @Test
    public void test47IOException() {
        boolean isIOException = false;
        int num = 0;

        for (String s : handleExceptionsFunc) {
            if (num == 2 && (s.contains("}") || s.contains("catch"))) {
                isIOException = true;
            }

            if (num == 1 && s.contains("BEAN.log(e);")) {
                num++;
            }

            if (s.contains("catch") && s.contains("IOException"))
                num++;
        }
        Assert.assertTrue(
            "Метод handleExceptions должен только логировать любое исключение IOException",
            isIOException
        );
    }

    @Test
    public void test47ThrowsFileSystemException() {
        boolean isThrowsFileSystemException = false;
        for (int i = 0; i < collect.size(); i++) {
            if (collect.get(i).contains("public static void handleExceptions()") && collect.get(i).contains(" throws FileSystemException")) {
                isThrowsFileSystemException = true;
            }
        }
        Assert.assertTrue(
            "Добавь в объявление метода handleExceptions класс исключения FileSystemException",
            isThrowsFileSystemException
        );
    }

    @Test
    public void test47MainTryCatch() {
        boolean isMainTryCatch = false;
        boolean checkTry = false;
        for (String s: mainFunc) {
            if (s.contains("try")) {
                checkTry = true;
            }

            if (s.contains("catch") && checkTry) {
                isMainTryCatch = true;
            }
        }

        Assert.assertTrue(
            "Метод main должен использовать try..catch",
            isMainTryCatch
        );
    }

    @Test
    public void test47MainCheckException() {
        boolean checkTry = false;
        boolean callHandleExceptions = false;
        boolean checkCatch = false;
        boolean checkLog = false;
        for (String s: mainFunc) {
            if (s.contains("try")) {
                checkTry = true;
            }
            if (s.contains("handleExceptions();") && checkTry) {
                callHandleExceptions = true;
            }
            if (s.contains("catch") && (s.contains("FileSystemException") || s.contains("Exception")) && callHandleExceptions) {
                checkCatch = true;
            }
            if (s.contains("BEAN.log(e);") && checkCatch) {
                checkLog = true;
            }
        }

        Assert.assertTrue(
                "Метод main должен логировать исключения, которые кидает метод handleExceptions",
                checkLog
        );
    }
}
