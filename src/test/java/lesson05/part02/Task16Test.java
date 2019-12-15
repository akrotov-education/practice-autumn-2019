package lesson05.part02;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import util.SystemOutGatewayUtil;

import java.io.ByteArrayOutputStream;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.*;

public class Task16Test {





    @Test
    public void t1(){/*впишите свои числа */
        Class[] interfaces = Task16.class.getDeclaredClasses();
        boolean isContains = false;
        for (Class anInterface : interfaces) {
            if (anInterface.getSimpleName().equals("CanFly")) {

                    isContains = true;


                break;
            }
        }

        Assert.assertTrue("Не пройдено 1 условие",
                isContains);
    }

    @Test
    public void t2() {/*впишите свои числа */
        Assert.assertTrue("Не пройдено 2 условие", Modifier.toString(Task16.CanFly.class.getModifiers()).contains("public"));
    }

    @Test
    public void t3(){/*впишите свои числа */
        Method[] a=Task16.CanFly.class.getMethods();
        int r=0;
        for (Method c:a
        ) {if(c.toString().contains("Task16")) r++;

        }
        Assert.assertTrue(   "Не пройдено 2 условие",r==2);
    }
    @Test
    public void t4() {/*впишите свои числа */
        Class a=Task16.CanFly.class.getSuperclass();
        Assert.assertTrue("Не пройдено 4 условие", a==null);
    }
}