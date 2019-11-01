package lesson01.part1;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import util.SystemOutGatewayUtil;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class Task05Test {
    public static String fileName = "./src/main/java/lesson01/part1/Task05.java";

    @Before
    public void before(){
        SystemOutGatewayUtil.setCustomOut();
    }

    @After
    public void after(){
        SystemOutGatewayUtil.setOriginalOut();
        SystemOutGatewayUtil.clearOutput();
    }

    @Test
    public void EqualsRightResult(){
        Task05.main(null);
        ByteArrayOutputStream stream = SystemOutGatewayUtil.getOutputArray();
        String result = stream.toString();
        Assert.assertEquals("Программа должна выводить \"9 умножить на 3 равно 27\"",
                "9 умножить на 3 равно 27", result);
    }

    @Test
    public void Commentline(){
        try {
            Stream<String> stream = Files.lines(Paths.get(fileName));
            List<String> line = stream.collect(Collectors.toList());
            String l0 = line.get(19);
            Assert.assertTrue("Строка 20 должна быть:  System.out.print(b);",
                    l0.contains("System.out.print(b);"));
            String l1 = line.get(20);
            Assert.assertTrue("Строка 21 должна быть: System.out.print(\" умножить \"); ",
                    l1.contains("System.out.print(\" умножить \");"));
            String l2 = line.get(21);
            Assert.assertTrue("Строка 22 должна быть:  System.out.print(\"на \");",
                    l2.contains("System.out.print(\"на \");"));
            String l3 = line.get(22);
            Assert.assertTrue("Строка 23 должна быть:   System.out.print(a);",
                    l3.contains("System.out.print(a);"));
            String l4 = line.get(26);
            Assert.assertTrue("Строка 27 должна быть:   System.out.print(\" равно \");",
                    l4.contains("ystem.out.print(\" равно \");"));
            String l5 = line.get(29);
            Assert.assertTrue("Строка 30 должна быть:  System.out.print((int) Math.pow(3, 3));",
                    l5.contains("System.out.print((int) Math.pow(3, 3));"));
        } catch (IOException e) {
        }
    }

}