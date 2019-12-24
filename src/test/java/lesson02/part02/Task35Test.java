package lesson02.part02;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Azamat_Abidokov Date: 07-Oct-19
 */
public class Task35Test {

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
  public void main_SpecialCase() throws Exception {
    // given
    String[] evenNumbers = {"2", "4", "6", "8", "10", "12", "14", "16", "18", "20", "22", "24", "26", "28", "30", "32",
        "34", "36", "38", "40", "42", "44", "46", "48", "50", "52", "54", "56", "58", "60", "62", "64", "66", "68",
        "70", "72", "74", "76", "78", "80", "82", "84", "86", "88", "90", "92", "94", "96", "98", "100"};
    String expectedOut = String.join(System.lineSeparator(), evenNumbers);

    // when
    fakeOut.reset();
    Task35.main(null);
    String actual = fakeOut.toString().trim();

    // then
    assertEquals("Вывод программы не соответствует ожидаемому.",
        expectedOut, actual);
  }
}