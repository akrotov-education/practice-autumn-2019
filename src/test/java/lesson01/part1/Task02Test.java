package lesson01.part1;


import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.apache.commons.lang3.StringUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Azamat_Abidokov Date: 07-Oct-19
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
  public void main_ConsoleOutput() {
    // given
    String output = "Hello World!" + System.lineSeparator();
    int count = 3;

    // when
    Task02.main(null);

    // then
    assertEquals("Вывод программы не соответствует ожидаемому.",
        output.repeat(count), fakeOut.toString());
  }
}