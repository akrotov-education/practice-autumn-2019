package lesson02.part01;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Azamat_Abidokov Date: 09-Oct-19
 */
public class Task11Test {

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
  public void convertToSeconds_IsExist() {
    try {
      Task11.class.getDeclaredMethod("convertToSeconds", int.class);
    } catch (Exception e) {
      fail("Метод convertToSeconds не найден");
    }
  }

  @Test
  public void convertToSeconds_ValidateReturnType() {
    try {
      Method convertToSeconds = Task11.class.getDeclaredMethod("convertToSeconds", int.class);
      Class<?> returnType = convertToSeconds.getReturnType();
      assertEquals("Возвращаемый тип должен быть int", int.class, returnType);
    } catch (Exception ignored) {
    }
  }

  @Test
  public void convertToSeconds_ValidateModifiers() {
    try {
      Method convertToSeconds = Task11.class.getDeclaredMethod("convertToSeconds", int.class);
      int modifiers = convertToSeconds.getModifiers();
      assertTrue("Метод convertToSeconds должен быть static", Modifier.isStatic(modifiers));
      assertTrue("Метод convertToSeconds должен быть public", Modifier.isPublic(modifiers));
    } catch (Exception e) {
    }
  }

  @Test
  public void convertToSeconds_ValidateOutput() {
    try {
      Method convertToSeconds = Task11.class.getDeclaredMethod("convertToSeconds", int.class);
      int hours = 3;
      int expected = 10800;
      int actual = (int) convertToSeconds.invoke(null, hours);
      assertEquals("Метод convertToSeconds должен переводить переданные часы в секунды.",
          expected, actual);
    } catch (Exception e) {
    }
  }
}