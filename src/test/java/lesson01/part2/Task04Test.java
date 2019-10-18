package lesson01.part2;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.internal.runners.JUnit45AndHigherRunnerImpl;
import util.ClassReader;
import util.SystemOutGatewayUtil;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.Field;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class Task04Test {

    @Test
    public void test04()
    {

        //TODO: parse out declaring
        SystemOutGatewayUtil.setCustomOut();
        ByteArrayOutputStream out = SystemOutGatewayUtil.getOutputArray();
        out.reset();

        try{
            ClassReader reader = ClassReader.openClass(Task04.class);
            reader.getMethod(Task04.class.getDeclaredMethod("main", String[].class));
        }catch(Exception e){
            Assert.fail("неправильные поля a и b");
        }
    }
}