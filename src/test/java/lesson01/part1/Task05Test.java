package lesson01.part1;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import util.ClassReader;
import util.SystemOutGatewayUtil;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class Task05Test {

    /* Закомментируй ненужные строки кода, чтобы на экран вывелась надпись:
            * 9 умножить на 3 равно 27
            * <p>
            * Требования:
            * 1. Программа должна выводить на экран надпись "9 умножить на 3 равно 27"
            * 2. Нужно раскомментировать одну строку.
            * 3. Нельзя изменять (добавлять, удалять) строки с кодом.
            */
    @Test
    public void main() {

        //TODO: parser
        SystemOutGatewayUtil.setCustomOut();
        Task05.main(null);
        ByteArrayOutputStream out = SystemOutGatewayUtil.getOutputArray();
        String output = out.toString();

        try
        {
            ClassReader reader = ClassReader.openClass(Task05.class);
            String classString;
            int rowsCount = 0;
            while((classString = reader.readLine()) != null)
            {
                rowsCount++;
            }

            reader.close();

            Assert.assertEquals(32, rowsCount);
        }
        catch (Exception e)
        {
            System.out.println(e.toString());
        }
        output = output.trim();
        Assert.assertEquals("9 умножить на 3 равно 27", output);

        out.reset();
    }
}