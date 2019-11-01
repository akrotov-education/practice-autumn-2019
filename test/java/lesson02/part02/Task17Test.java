package lesson02.part02;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import util.SystemInGatewayUtil;
import util.SystemOutGatewayUtil;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RunWith(JUnit4.class)
public class Task17Test {

    public static String fileName = "./src/main/java/lesson02/part02/Task17.java";
    @Before
    public void setUp() {
        SystemOutGatewayUtil.setCustomOut();
    }

    @After
    public void tearDown() {
        SystemInGatewayUtil.setOriginalIn();
        SystemOutGatewayUtil.setOriginalOut();
        SystemOutGatewayUtil.clearOutput();
    }

    @Test
    public void checkInput() {
        SystemInGatewayUtil.provideInput("1\n2\n3");

        try {
            Task17.main(null);
        } catch (Exception e) {
            Assert.fail("Программа должна считывать числа c клавиатуры");
        }
    }

    @Test
    public void mainCallsPrint() {
        try{
            Stream<String> stream = Files.lines(Paths.get(fileName));
            List<String> lines = stream.collect(Collectors.toList());

        int startLine = 0;
        for (int i = 0; i < lines.size(); i++) {
            if (lines.get(i).contains("public static void main")) {
                startLine = i;
                break;
            }
        }

        Boolean isCallingPrint = false;
        for (int i = startLine; i < lines.size(); i++) {
            String line = lines.get(i);

            if (line.contains("}")) {
                break;
            }

            if (line.contains("System.out.print")) {
                isCallingPrint = true;
                break;
            }
        }

        Assert.assertTrue("Программа должна содержать System.out.println() или System.out.print()", isCallingPrint);
        } catch (IOException e) {
        }
    }

    @Test
    public void checkTwoEquals() {
        SystemInGatewayUtil.provideInput("4\n5\n5");
        try {
            Task17.main(null);
        } catch (Exception e) {
            e.printStackTrace();
        }

        SystemInGatewayUtil.provideInput("5\n4\n5");
        try {
            Task17.main(null);
        } catch (Exception e) {
            e.printStackTrace();
        }

        SystemInGatewayUtil.provideInput("5\n5\n4");
        try {
            Task17.main(null);
        } catch (Exception e) {
            e.printStackTrace();
        }

        ByteArrayOutputStream output = SystemOutGatewayUtil.getOutputArray();
        String[] outLines = output.toString().split("\r\n");
        Assert.assertEquals("Если два числа равны между собой, необходимо вывести числа на экран",
                "5 5",
                outLines[0]
        );

        Assert.assertEquals("Если два числа равны между собой, необходимо вывести числа на экран",
                "5 5",
                outLines[1]
        );

        Assert.assertEquals("Если два числа равны между собой, необходимо вывести числа на экран",
                "5 5",
                outLines[2]
        );
    }

    @Test
    public void checkThreeEquals() {
        SystemInGatewayUtil.provideInput("5\n5\n5");
        try {
            Task17.main(null);
        } catch (Exception e) {
            e.printStackTrace();
        }

        ByteArrayOutputStream output = SystemOutGatewayUtil.getOutputArray();
        String[] outLines = output.toString().split("\r\n");
        Assert.assertEquals("Если все три числа равны между собой, необходимо вывести все три",
                "5 5 5",
                outLines[0]
        );
    }

    @Test
    public void checkNoEquals() {
        SystemInGatewayUtil.provideInput("1\n2\n3");
        try {
            Task17.main(null);
        } catch (Exception e) {
            e.printStackTrace();
        }

        ByteArrayOutputStream output = SystemOutGatewayUtil.getOutputArray();
        Assert.assertTrue("Если нет равных чисел, ничего не выводить",
                output.toString().length() == 0
        );
    }
}