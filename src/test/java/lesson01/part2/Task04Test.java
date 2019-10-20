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
        SystemOutGatewayUtil.setCustomOut();
        ByteArrayOutputStream out = SystemOutGatewayUtil.getOutputArray();
        out.reset();

        int a = 0;
        int b = 0;

        try
        {
            boolean foundA = false;
            boolean foundB = false;
            String clString = "";
            ClassReader reader = ClassReader.openClass(Task04.class);
            while((clString = reader.readLine()) != null)
            {
                if(clString.contains("int a"))
                {
                    if(!foundA) {
                        String aStr =  clString.trim().split("=")[1].replace(";", "").replace(" ", "");
                        a = Integer.parseInt(aStr);
                        foundA = true;
                    }
                    else
                        throw new Exception();
                }

                if(clString.contains("int b"))
                {
                    if(!foundB) {
                        String bStr =  clString.trim().split("=")[1].replace(";", "").replace(" ", "");
                        b = Integer.parseInt(bStr);
                        foundB = true;
                    }
                    else
                        throw new Exception();
                }
            }

            if(!foundA || !foundB)
            {
                throw new Exception();
            }
        }
        catch(Exception e)
        {
            Assert.fail("неправильные поля a и b");
        }



        Task04.main(null);
        String[] output = out.toString().trim().split("\n");

        Assert.assertEquals(2, output.length);
        Assert.assertEquals(a + b, Integer.parseInt(output[0].trim()));
        Assert.assertEquals(a * b, Integer.parseInt(output[1].trim()));

        /*try{
            ClassReader reader = ClassReader.openClass(Task04.class);
            //reader.getMethod(Task04.class.getDeclaredMethod("main", String[].class));
        }catch(Exception e){
            Assert.fail("неправильные поля a и b");
        }*/
    }
}