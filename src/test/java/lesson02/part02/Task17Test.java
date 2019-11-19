package lesson02.part02;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import util.SystemOutGatewayUtil;

import java.io.ByteArrayOutputStream;
import java.util.List;

@RunWith(JUnit4.class)
public class Task17Test {
    @Before
    public void setUp() {
        SystemOutGatewayUtil.setCustomOut();
    }

    @After
    public void tearDown() {
        SystemOutGatewayUtil.setOriginalOut();
        SystemOutGatewayUtil.clearOutput();
    }

    @Test
    public void checkInput() {

        try {
            Task17.main(null);
        } catch (Exception e) {
            Assert.fail("The program should read numbers from keyboard");
        }
    }


    @Test
    public void checkTwoEquals() {
            try {
            Task17.main(null);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            Task17.main(null);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            Task17.main(null);
        } catch (Exception e) {
            e.printStackTrace();
        }

        ByteArrayOutputStream output = SystemOutGatewayUtil.getOutputArray();
        String[] outLines = output.toString().split("\n");
        Assert.assertEquals("The program should display two equal nums",
                "5 5",
                outLines[0]
        );

        Assert.assertEquals("The program should display two equal nums",
                "5 5",
                outLines[1]
        );

        Assert.assertEquals("The program should display two equal nums",
                "5 5",
                outLines[2]
        );
    }

    @Test
    public void checkThreeEquals() {
        try {
            Task17.main(null);
        } catch (Exception e) {
            e.printStackTrace();
        }

        ByteArrayOutputStream output = SystemOutGatewayUtil.getOutputArray();
        String[] outLines = output.toString().split("\n");
        Assert.assertEquals("The program should display three equal nums",
                "5 5 5",
                outLines[0]
        );
    }

    @Test
    public void checkNoEquals() {
        try {
            Task17.main(null);
        } catch (Exception e) {
            e.printStackTrace();
        }

        ByteArrayOutputStream output = SystemOutGatewayUtil.getOutputArray();
        Assert.assertTrue("The program shouldn't display anything",
                output.toString().length() == 0
        );
    }
}