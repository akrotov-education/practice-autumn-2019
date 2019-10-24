package lesson02.part02;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import util.ReadFileUtil;
import util.SystemOutGatewayUtil;

import java.io.ByteArrayOutputStream;
import java.lang.reflect.Method;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class Task01Test {
    @Before
    public void setUp() {
        SystemOutGatewayUtil.setCustomOut();
    }

    @After
    public void tearDown() {
        SystemOutGatewayUtil.clearOutput();
        SystemOutGatewayUtil.setOriginalOut();
    }

    @Test
    public void checkOutput() {
        Task01.main(null);

        ByteArrayOutputStream output = SystemOutGatewayUtil.getOutputArray();
        Assert.assertTrue("The program must output text", output.toString().length() > 0);
    }

    @Test
    public void checkAdjustAgeOutput() {
        Task01.Person person = new Task01.Person();
        person.adjustAge(20);

        ByteArrayOutputStream output = SystemOutGatewayUtil.getOutputArray();
        Assert.assertTrue("Method adjustAge must output text", output.toString().length() > 0);
    }

    @Test
    public void checkAdjustAgeParams() {
        Method method;
        try {
            method = Task01.Person.class.getMethod("adjustAge", int.class);
            Assert.assertTrue("Method adjustAge must return void", method.toString().contains("void"));
        } catch (NoSuchMethodException e) {
            Assert.fail("Method adjustAge must contain one parameter type of int");
        }
    }

    @Test
    public void mainCallAdjustAgeOnce() {
        List<String> lines = ReadFileUtil.readFileInList("./src/main/java/lesson02/part02/Task01.java");

        int startLine = 0;
        for (int i = 0; i < lines.size(); i++) {
            if (lines.get(i).contains("public static void main")) {
                startLine = i;
                break;
            }
        }

        int callsCount = 0;
        for (int i = startLine; i < lines.size(); i++) {
            String line = lines.get(i);

            if (line.contains("}")) {
                break;
            }

            if (line.contains("adjustAge")) {
                callsCount++;
            }
        }

        Assert.assertTrue("Main should call method adjustAge only once", callsCount == 1);
    }

    @Test
    public void checkAdjusting() {
        Task01.Person person = new Task01.Person();
        person.adjustAge(20);

        Assert.assertEquals("Method adjustAge must adjust person age by 20",
                40,
                person.age
        );
    }
}