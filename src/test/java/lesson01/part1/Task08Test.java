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
public class Task08Test {

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
    int expected = 2;

    // when
    int actual = Task08.getMetreFromCentimetre(243);

    // then
    assertEquals("Вывод программы не соответствует ожидаемому.",
        expected, actual);
  }

  @Test
  public void main_ArbitraryCases() {
    for (int parameter = 1; parameter < 10000; parameter += 100) {
      // given
      int expected = parameter / 100;

      // when
      int actual = Task08.getMetreFromCentimetre(parameter);

      // then
      assertEquals("Вывод программы не соответствует ожидаемому.",
          expected, actual);
    }
  }
}