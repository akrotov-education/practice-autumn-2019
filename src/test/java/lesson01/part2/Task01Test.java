package lesson01.part2;

import lesson01.part1.Task03;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mockito;
import org.mockito.internal.verification.VerificationModeFactory;
import util.SystemOutGatewayUtil;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

@RunWith(JUnit4.class)

public class Task01Test {
    @Test
    public void testCreateFields(){

        PrintStream stream = Mockito.mock(PrintStream.class);
        //Inject the mock in the System class
        System.setOut(stream);

        Task01.main(null);

        //And now verify if the method is called with the right parameter
        Mockito.verify(stream, VerificationModeFactory.times(1))
                .println("name, age, weight, money");
    }
}