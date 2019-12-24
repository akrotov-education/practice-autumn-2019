package lesson03.part01;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Azamat_Abidokov Date: 09-Oct-19
 */
public class Task14Test {

  private static final PrintStream originalOut = System.out;
  private static final ByteArrayOutputStream fakeOut = new ByteArrayOutputStream();

  @BeforeClass
  public static void setUp() {
    System.setOut(new PrintStream(fakeOut));
  }

  @AfterClass
  public static void restore() {
    System.setOut(originalOut);
  }

  @Test
  public void catConstructor_Count() {
    int expected = 5;
    int length = Task14.Cat.class.getConstructors().length;
    assertEquals(String.format("Класс Cat (кот) должен иметь %s конструкторов", expected),
        expected, length);
  }

  @Test
  public void catConstructor_Name() {
    try {
      Task14.Cat.class.getConstructor(String.class);
    } catch (Exception ignored) {
      fail("Невыполнено условие: У класса должен быть конструктор, принимающий в качестве параметра имя");
    }
  }

  @Test
  public void catConstructor_NameWeightAge() {
    try {
      Task14.Cat.class.getConstructor(String.class, int.class, int.class);
    } catch (Exception ignored) {
      fail(
          "Невыполнено условие: У класса должен быть конструктор, принимающий в качестве параметров имя, вес, возраст");
    }
  }

  @Test
  public void catConstructor_NameAge() {
    try {
      Task14.Cat.class.getConstructor(String.class, int.class);
    } catch (Exception ignored) {
      fail(
          "Невыполнено условие: У класса должен быть конструктор, принимающий в качестве параметров имя, возраст");
    }
  }

  @Test
  public void catConstructor_WeightColor() {
    try {
      Task14.Cat.class.getConstructor(int.class, String.class);
    } catch (Exception ignored) {
      fail(
          "Невыполнено условие: У класса должен быть конструктор, принимающий в качестве параметров вес, цвет");
    }
  }

  @Test
  public void catConstructor_WeightColorAddress() {
    try {
      Task14.Cat.class.getConstructor(int.class, String.class, String.class);
    } catch (Exception ignored) {
      fail(
          "Невыполнено условие: У класса должен быть конструктор, принимающий в качестве параметров вес, цвет, адрес");
    }
  }

  @Test
  public void main_VarValid() {
    try {
      Field name = Task14.Cat.class.getDeclaredField("name");
      Field age = Task14.Cat.class.getDeclaredField("age");
      Field weight = Task14.Cat.class.getDeclaredField("weight");
      Field address = Task14.Cat.class.getDeclaredField("address");
      Field color = Task14.Cat.class.getDeclaredField("color");
      assertEquals("Невыполенно условие: У класса Cat должна быть переменная name с типом String", String.class,
          name.getType());
      assertEquals("Невыполенно условие: У класса Cat должна быть переменная age с типом int", int.class,
          age.getType());
      assertEquals("Невыполенно условие: У класса Cat должна быть переменная weight с типом int", int.class,
          weight.getType());
      assertEquals("Невыполенно условие: У класса Cat должна быть переменная address с типом String", String.class,
          address.getType());
      assertEquals("Невыполенно условие: У класса Cat должна быть переменная color с типом String", String.class,
          color.getType());
    } catch (Exception e) {
      fail("Не найдена переменная класса Cat: " + e.getMessage());
    }
  }

}