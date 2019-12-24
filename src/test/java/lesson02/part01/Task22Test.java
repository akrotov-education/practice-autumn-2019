package lesson02.part01;

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
public class Task22Test {

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
    String expectedIn = "50";
    String expectedOut = "Я буду зарабатывать $" + expectedIn + " в час";

    // when
    System.setIn(new ByteArrayInputStream(expectedIn.getBytes()));
    fakeOut.reset();
    Task22.main(null);
    String actual = fakeOut.toString().trim();

    // then
    assertEquals("Вывод программы не соответствует ожидаемому.",
        expectedOut, actual);
  }
}