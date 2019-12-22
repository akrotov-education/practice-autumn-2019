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
public class Task02Test {

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
  public void printString_IsExist() {
    try {
      Task02.class.getDeclaredMethod("printString", String.class);
    } catch (Exception e) {
      fail("Метод printString не найден");
    }
  }

  @Test
  public void printString_ValidateReturnType() {
    try {
      Method printString = Task02.class.getDeclaredMethod("printString", String.class);
      Class<?> returnType = printString.getReturnType();
      assertEquals("Возвращаемый тип должен быть void", void.class, returnType);
    } catch (Exception ignored) {}
  }

  @Test
  public void printString_ValidateModifiers() {
    try {
      Method printString = Task02.class.getDeclaredMethod("printString", String.class);
      int modifiers = printString.getModifiers();
      assertTrue("Метод printString должен быть static", Modifier.isStatic(modifiers));
      assertTrue("Метод printString должен быть public", Modifier.isPublic(modifiers));
    } catch (Exception e) {}
  }

  @Test
//  @DisplayName("Проверка модификаторов")
  public void printString_ValidateOutput() {
    try {
      Method printString = Task02.class.getDeclaredMethod("printString", String.class);
      String testText = "random$text";
      printString.invoke(null, testText);
      assertEquals(testText, fakeOut.toString().trim(),
          "Метод printString должен выводить переданный текст на экран.");
    } catch (Exception e) {}
  }

  @Test
//  @DisplayName("Проверка модификаторов")
  public void main() {
    try {
      Method main = Task02.class.getDeclaredMethod("main", String[].class);
      main.invoke(null, (Object[]) null);
      assertEquals("Hello, Amigo!", fakeOut.toString().trim(), "Программа должна вывести \"Hello, Amigo!\"");
    } catch (Exception e) {}
  }
}