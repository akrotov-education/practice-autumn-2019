package lesson02.part02;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Azamat_Abidokov Date: 07-Oct-19
 */
public class Task13Test {

  private static final PrintStream originalOut = System.out;
  private static final InputStream originalIn = System.in;
  private static final ByteArrayOutputStream fakeOut = new ByteArrayOutputStream();

  @BeforeClass
  public static void setUp() {
    System.setOut(new PrintStream(fakeOut));
  }

  @AfterClass
  public static void restore() {
    System.setOut(originalOut);
    System.setIn(originalIn);
  }

  @Test
  public void main_SpecialCase() throws Exception {
    // given
    String notExistDay = "такого дня недели не существует";
    String[] days = {"понедельник", "вторник", "среда", "четверг", "пятница", "суббота", "воскресенье"};

    for (int i = 1; i < 10; i++) {
      // when
      System.setIn(new ByteArrayInputStream(String.valueOf(i).getBytes()));
      fakeOut.reset();
      Task13.main(null);
      String actual = fakeOut.toString().trim();

      // then
      String expectedOut = i <= days.length ? days[i - 1] : notExistDay;
      assertEquals("Вывод программы не соответствует ожидаемому.",
          expectedOut.toLowerCase(), actual.toLowerCase());
    }
  }
}