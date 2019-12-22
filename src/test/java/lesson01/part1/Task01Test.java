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
public class Task01Test {

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
  public void main_ConsoleOutput() {
    // when
    Task01.main(null);

    // then
    assertEquals("Вывод программы не соответствует ожидаемому.",
        "Hello World!", fakeOut.toString().trim());
  }
}