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
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class Task07Test {
    @Before
    public void setUp() {
        SystemOutGatewayUtil.setCustomOut();
    }

    @After
    public void tearDown() {
        SystemOutGatewayUtil.clearOutput();
        SystemOutGatewayUtil.setOriginalOut();

        Task07.Cat.count = 0;
    }

    @Test
    public void checkOutput() {
        Task07.main(null);

        ByteArrayOutputStream output = SystemOutGatewayUtil.getOutputArray();
        Assert.assertTrue("The program must output text", output.toString().length() > 0);
    }

    @Test
    public void checkCatFields() {
        Field[] fields = Task07.Cat.class.getDeclaredFields();

        Assert.assertTrue("Class Cat must contain only one field 'count'",
                fields.length == 1 && fields[0].getName().contentEquals("count")
        );
    }

    @Test
    public void checkCountField() {
        try {
            Field field = Task07.Cat.class.getDeclaredField("count");
            String modifier = Modifier.toString(field.getModifiers());
            String type = field.getType().toString();

            Assert.assertEquals("Field count must be public and static",
                    "public static",
                    modifier
            );
            Assert.assertEquals("Field count must have int type",
                    "int",
                    type
            );

            Assert.assertEquals("Field catsCount must be initialized with value 0",
                    0,
                    Task07.Cat.count
            );
        } catch (NoSuchFieldException e) {
            Assert.fail("Class Cat doesn't contain catsCount field");
        }
    }

    @Test
    public void checkTwoCatInMain() {
        List<String> lines = ReadFileUtil.readFileInList("./src/main/java/lesson02/part02/Task07.java");

        int startLine = 0;
        for (int i = 0; i < lines.size(); i++) {
            if (lines.get(i).contains("public static void main")) {
                startLine = i;
                break;
            }
        }

        int catsCount = 0;
        for (int i = startLine; i < lines.size(); i++) {
            String line = lines.get(i);

            if (line.contains("}")) {
                break;
            }

            if (line.contains("new Cat()")) {
                catsCount++;
            }
        }

        Assert.assertTrue("Main should have only two Cat variables", catsCount == 2);
    }

    @Test
    public void checkRelevantCatsCount() {
        Task07.main(null);
        Assert.assertEquals("Field count must contain relevant value of Cat objects",
                2,
                Task07.Cat.count
        );
    }
}