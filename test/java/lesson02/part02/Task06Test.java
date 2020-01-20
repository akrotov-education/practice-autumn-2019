
package lesson02.part02;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RunWith(JUnit4.class)
public class Task06Test {

    public static String fileName = "./src/main/java/lesson02/part02/Task06.java";

    @Test
    public void checkCatFields() {
        Field[] fields = Task06.Cat.class.getDeclaredFields();

        Assert.assertTrue("Класс Cat должен содержать только одну переменную fullName",
                fields.length == 1 && fields[0].getName().contentEquals("fullName")
        );
    }

    @Test
    public void checkFullNameField() {
        try {
            Field field = Task06.Cat.class.getDeclaredField("fullName");
            String modifier = Modifier.toString(field.getModifiers());
            String type = field.getType().toString();

            Assert.assertEquals("Переменная fullName должна иметь модификатор доступа private",
                    "private",
                    modifier
            );
            Assert.assertTrue("Переменная fullName должна иметь тип String",
                    type.contains("String")
            );
        } catch (NoSuchFieldException e) {
        }
    }

    @Test
    public void checkClassMethods() {
        Method[] methods = Task06.Cat.class.getDeclaredMethods();

        Assert.assertTrue("Класс Cat должен содержать только два метода setName и main",
                methods.length == 1 && methods[0].getName().contentEquals("setName"));
    }

    @Test
    public void checkLocalVar() {
        try {
            Stream<String> stream = Files.lines(Paths.get(fileName));
            List<String> lines = stream.collect(Collectors.toList());
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

            Assert.assertTrue("Метод setName должен иметь локальную переменную fullName", haveLocalVar);
        } catch (IOException e) {
        }
    }

    @Test
    public void checkSetNameWork() {
        Task06.Cat cat = new Task06.Cat();
        cat.setName("Cat", "Catinski");

        try {
            Field field = cat.getClass().getDeclaredField("fullName");
            field.setAccessible(true);
            String val = (String) field.get(cat);

            Assert.assertEquals("Метод setName класса Cat должен устанавливать значение глобальной " +
                            "переменной private String fullName равным локальной переменной fullName",
                    "Cat Catinski", val);
        } catch (NoSuchFieldException e) {
        } catch (IllegalAccessException e) {
        }
    }
}