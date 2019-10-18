package lesson01.part1;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import util.ClassReader;
import util.SystemOutGatewayUtil;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class Task04Test {
            /* 2. Нужно раскомментировать одну строку.
            * 3. Нельзя изменять (добавлять, удалять) строки с кодом. */
    @Test
    public void main() {
        SystemOutGatewayUtil.setCustomOut();
        Task04.main(null);

        ByteArrayOutputStream out = SystemOutGatewayUtil.getOutputArray();

        int rowsCount = 0;
        int commentsCount = 0;
        try {
            ClassReader cr = ClassReader.openClass(Task04.class);
            String classLine;
            while ((classLine = cr.readLine()) != null) {
                rowsCount++;
                if(classLine.contains("//"))
                    commentsCount++;
            }

            cr.close();
        }
        catch (Exception e)
        {
            System.out.println("s");
        }
        String output = out.toString().trim();
        output = output.replace("\r","");
        Assert.assertEquals("расскоментируйте 1 строку", 6, commentsCount);
        Assert.assertEquals("нельзя добавлять/удалять код", 33, rowsCount);
        Assert.assertTrue("not 25" , output.contains("25"));
        Assert.assertTrue("not 26", output.contains("26"));

        out.reset();
    }
}