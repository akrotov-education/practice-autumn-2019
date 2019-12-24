package lesson01.part1;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * @author Azamat_Abidokov Date: 07-Oct-19
 */
class Task05Test {

  private static final PrintStream originalOut = System.out;
  private static final ByteArrayOutputStream fakeOut = new ByteArrayOutputStream();

  @BeforeAll
  static void setUp() {
    System.setOut(new PrintStream(fakeOut));
  }

  @AfterAll
  static void restore() {
    System.setOut(originalOut);
  }

  @Test
  void main_ConsoleOutput() {
    // when
    Task05.main(null);

    // then
    assertEquals("9 умножить на 3 равно 27", fakeOut.toString());
  }
}