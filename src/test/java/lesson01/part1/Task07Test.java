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
public class Task07Test {

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
    double expected = 105.8;

    // when
    double actual = Task07.convertCelsiusToFahrenheit(41);

    // then
    assertEquals("Вывод программы не соответствует ожидаемому.",
        expected, actual, 0.001);
  }

  @Test
  public void main_ArbitraryCases() {
    for (int parameter = 0; parameter < 100; parameter++) {
      // given
      double expected = (9.0 / 5) * parameter + 32;

      // when
      double actual = Task07.convertCelsiusToFahrenheit(parameter);

      // then
      assertEquals("Вывод программы не соответствует ожидаемому.",
          expected, actual, 0.001);
    }
  }
}