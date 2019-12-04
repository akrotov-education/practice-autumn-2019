package lesson04.part02;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import util.ReadFileUtil;
import util.ReadFuncBodyUtil;
import util.SystemOutGatewayUtil;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

@RunWith(JUnit4.class)
public class Task28Test {

    @Before
    public void setUp() throws Exception {
        SystemOutGatewayUtil.setCustomOut();
    }

    @After
    public void tearDown() throws Exception {
        SystemOutGatewayUtil.setOriginalOut();
        SystemOutGatewayUtil.clearOutput();
    }

    @Test
    public void checkNoOutput() {
        Task28.main(null);

        ByteArrayOutputStream output = SystemOutGatewayUtil.getOutputArray();
        Assert.assertTrue("Program mustn't display any text",
                output.size() == 0
        );
    }

    @Test
    public void checkMethodsCount() {
        Assert.assertEquals("Program must contains only 3 methods",
                5,
                Task28.class.getDeclaredMethods().length
        );
    }

    @Test
    public void checkInsert10000() {
        ArrayList arrayList = new ArrayList();
        Task28.insert10000(arrayList);

        Assert.assertEquals("Method insert10000 must insert 10000 elements in List",
                10000,
                arrayList.size()
        );
    }

    @Test
    public void checkGet10000() {
        List<String> fileLines = ReadFileUtil.readFileInList("./src/main/java/lesson04/part02/Task28.java");

        int methodLine = -1;
        for (int i = 0; i < fileLines.size(); i++) {
            String line = fileLines.get(i);
            if (line.matches(".*public static.*get10000.*")) {
                methodLine = i;
            }
        }

        List<String> methodBody = ReadFuncBodyUtil.getFuncBody(fileLines, methodLine);
        int loopLine = -1;
        for (int i = 0; i < methodBody.size(); i++) {
            String line = methodBody.get(i);
            if (line.matches(".*for\\s*(.*10000.*).*")) {
                loopLine = i;
                break;
            }
        }

        List<String> loopBody = ReadFuncBodyUtil.getFuncBody(methodBody, loopLine);
        boolean isOk = false;
        for (String line : loopBody) {
            if (line.contains(".get")) {
                isOk = true;
                break;
            }
        }

        Assert.assertTrue("Method get10000 must calls get 10000 times",
                isOk
        );
    }

    @Test
    public void checkSet10000() {
        List<String> fileLines = ReadFileUtil.readFileInList("./src/main/java/lesson04/part02/Task28.java");

        int methodLine = -1;
        for (int i = 0; i < fileLines.size(); i++) {
            String line = fileLines.get(i);
            if (line.matches(".*public static.*set10000.*")) {
                methodLine = i;
            }
        }

        List<String> methodBody = ReadFuncBodyUtil.getFuncBody(fileLines, methodLine);
        int loopLine = -1;
        for (int i = 0; i < methodBody.size(); i++) {
            String line = methodBody.get(i);
            if (line.matches(".*for\\s*(.*10000.*).*")) {
                loopLine = i;
                break;
            }
        }

        List<String> loopBody = ReadFuncBodyUtil.getFuncBody(methodBody, loopLine);
        boolean isOk = false;
        for (String line : loopBody) {
            if (line.contains(".set")) {
                isOk = true;
                break;
            }
        }

        Assert.assertTrue("Method set10000 must calls set 10000 times",
                isOk
        );
    }

    @Test
    public void checkRemove10000() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 10000; i++) {
            arrayList.add(0);
        }

        Task28.remove10000(arrayList);
        Assert.assertEquals("Method remove10000 must remove 10000 elements from List",
                0,
                arrayList.size()
        );
    }
}