package lesson05.part01;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import util.ReadFuncBodyUtil;

import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.*;

public class Task21Test {




    @Test
    public void t1(){/*впишите свои числа */
        Assert.assertFalse(   "Не пройдено 1 условие",Task21.Airplane.class.isAssignableFrom(Task21.Pet.class ));
        Assert.assertFalse(   "Не пройдено 1 условие",Task21.Dog.class.isAssignableFrom(Task21.Pet.class ));
        Assert.assertFalse(   "Не пройдено 1 условие",Task21.Cat.class.isAssignableFrom(Task21.Pet.class ));
        Assert.assertFalse(   "Не пройдено 1 условие",Task21.House.class.isAssignableFrom(Task21.Pet.class ));
    }
    @Test
    public void t3(){/*впишите свои числа */
        Assert.assertTrue(   "Не пройдено 3 условие",Task21.Pet.class.isAssignableFrom(Task21.Dog.class ));
        Assert.assertFalse(   "Не пройдено 3 условие",Task21.Airplane.class.isAssignableFrom(Task21.Dog.class ));
        Assert.assertFalse(   "Не пройдено 3 условие",Task21.Cat.class.isAssignableFrom(Task21.Dog.class ));
        Assert.assertFalse(   "Не пройдено 3 условие",Task21.House.class.isAssignableFrom(Task21.Dog.class ));
    }
    @Test
    public void t2(){/*впишите свои числа */
        Assert.assertTrue(   "Не пройдено 2 условие",Task21.Pet.class.isAssignableFrom(Task21.Cat.class ));
        Assert.assertFalse(   "Не пройдено 2 условие",Task21.Dog.class.isAssignableFrom(Task21.Cat.class ));
        Assert.assertFalse(   "Не пройдено 2 условие",Task21.Airplane.class.isAssignableFrom(Task21.Cat.class ));
        Assert.assertFalse(   "Не пройдено 2 условие",Task21.House.class.isAssignableFrom(Task21.Cat.class ));
    }
    @Test
    public void t4(){/*впишите свои числа */
        Assert.assertFalse(   "Не пройдено 4 условие",Task21.Pet.class.isAssignableFrom(Task21.House.class ));
        Assert.assertFalse(   "Не пройдено 4 условие",Task21.Dog.class.isAssignableFrom(Task21.House.class ));
        Assert.assertFalse(   "Не пройдено 4 условие",Task21.Cat.class.isAssignableFrom(Task21.House.class ));
        Assert.assertFalse(   "Не пройдено 4 условие",Task21.Airplane.class.isAssignableFrom(Task21.House.class ));
    }
    @Test
    public void t5(){/*впишите свои числа */
        Assert.assertFalse(   "Не пройдено 5 условие",Task21.Pet.class.isAssignableFrom(Task21.Airplane.class ));
        Assert.assertFalse(   "Не пройдено 5 условие",Task21.Dog.class.isAssignableFrom(Task21.Airplane.class ));
        Assert.assertFalse(   "Не пройдено 5 условие",Task21.Cat.class.isAssignableFrom(Task21.Airplane.class ));
        Assert.assertFalse(   "Не пройдено 5 условие",Task21.House.class.isAssignableFrom(Task21.Airplane.class ));

    }
}