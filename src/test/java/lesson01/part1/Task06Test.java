package lesson01.part1;


import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Azamat_Abidokov Date: 07-Oct-19
 */
public class Task06Test {

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
  public void main_SpecialCase() {
    // given
    String expected = String.valueOf(2 * 3.14 * 5);

    // when
    fakeOut.reset();
    Task06.printCircleLength(5);
    String actual = fakeOut.toString().trim();

    // then
    assertEquals("Вывод программы не соответствует ожидаемому.",
        expected, actual);
  }

  @Test
  public void main_ArbitraryCases() {
    for (int parameter = 0; parameter < 100; parameter++) {
      // given
      double pi = 3.14;
      String expected = String.valueOf(2 * pi * parameter);

      // when
      fakeOut.reset();
      Task06.printCircleLength(parameter);
      String actual = fakeOut.toString().trim();

      // then
      assertEquals("Вывод программы не соответствует ожидаемому.",
          expected, actual);
    }
  }
}