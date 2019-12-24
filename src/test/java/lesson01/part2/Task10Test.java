package lesson01.part2;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Azamat_Abidokov Date: 07-Oct-19
 */
public class Task10Test {

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
    String expected = String.join(System.lineSeparator(), "12", "-20", "-20");

    // when
    fakeOut.reset();
    Task10.main(null);
    String actual = fakeOut.toString().trim();

    // then
    assertEquals("Вывод программы не соответствует ожидаемому.",
        expected, actual);
  }
}