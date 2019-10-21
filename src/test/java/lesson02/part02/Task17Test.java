package lesson02.part02;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import util.ReadFileUtil;
import util.SystemInGatewayUtil;
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
            Assert.fail("The program should read numbers from keyboard");
        }
    }

    @Test
    public void mainCallsPrint() {
        List<String> lines = ReadFileUtil.readFileInList("./src/main/java/lesson02/part02/Task17.java");

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

        Assert.assertTrue("Main should calls System.out.println() or System.out.print()", isCallingPrint);
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
        SystemInGatewayUtil.provideInput("5\n5\n5");
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
        SystemInGatewayUtil.provideInput("1\n2\n3");
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