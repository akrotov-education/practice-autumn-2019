package lesson02.part02;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import util.ReadFileUtil;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.List;

@RunWith(JUnit4.class)
public class Task06Test {
    @Test
    public void checkCatFields() {
        Field[] fields = Task06.Cat.class.getDeclaredFields();

        Assert.assertTrue("Class Cat must contain only one field 'fullName'",
                fields.length == 1 && fields[0].getName().contentEquals("fullName")
        );
    }

    @Test
    public void checkFullNameField() {
        try {
            Field field = Task06.Cat.class.getDeclaredField("fullName");
            String modifier = Modifier.toString(field.getModifiers());
            String type = field.getType().toString();

            Assert.assertEquals("Field fullName must be private",
                    "private",
                    modifier
            );
            Assert.assertTrue("Field fullName must have String type",
                    type.contains("String")
            );
        } catch (NoSuchFieldException e) {
            Assert.fail("Class Cat doesn't contain fullName field");
        }
    }

    @Test
    public void checkClassMethods() {
        Method[] methods = Task06.Cat.class.getDeclaredMethods();

        Assert.assertTrue("Class Cat must contain only one method setName",
                methods.length == 1 && methods[0].getName().contentEquals("setName")
        );
    }

    @Test
    public void checkLocalVar() {
        List<String> lines = ReadFileUtil.readFileInList("./src/main/java/lesson02/part02/Task06.java");

        int startLine = 0;
        for (int i = 0; i < lines.size(); i++) {
            if (lines.get(i).contains("public void setName")) {
                startLine = i;
                break;
            }
        }

        Boolean haveLocalVar = false;
        for (int i = startLine; i < lines.size(); i++) {
            String line = lines.get(i);

            if (line.contains("}")) {
                break;
            }

            if (line.contains("String fullName")) {
                haveLocalVar = true;
                break;
            }
        }

        Assert.assertTrue("Method setName should contain local variable fullName",
                haveLocalVar
        );
    }

    @Test
    public void checkSetNameWork() {
        Task06.Cat cat = new Task06.Cat();
        cat.setName("Kek", "Kekovich");

        try {
            Field field = cat.getClass().getDeclaredField("fullName");
            field.setAccessible(true);
            String val = (String) field.get(cat);

            Assert.assertEquals("Method setName should set value of local variable fullName to field fullName",
                    "Kek Kekovich",
                    val
            );
        } catch (NoSuchFieldException e) {
            Assert.fail("Class Cat doesn't contain fullName field");
        } catch (IllegalAccessException e) {
            Assert.fail("Can't get access to field");
        }
    }
}