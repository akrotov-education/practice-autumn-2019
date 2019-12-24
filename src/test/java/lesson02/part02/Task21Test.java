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
public class Task21Test {

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
  public void main_InputSameNames() throws Exception {
    // given
    String name = "Иван";
    String input = String.join(System.lineSeparator(), name, name);
    String expectedOut = "Имена идентичны";

    // when
    System.setIn(new ByteArrayInputStream(input.getBytes()));
    fakeOut.reset();
    Task21.main(null);
    String actual = fakeOut.toString().trim();

    // then
    assertEquals("Вывод программы не соответствует ожидаемому.",
        expectedOut, actual);
  }

  @Test
  public void main_DiffNamesWithSameLength() throws Exception {
    // given
    String name1 = "Иван";
    String name2 = "Олег";
    String input = String.join(System.lineSeparator(), name1, name2);
    String expectedOut = "Длины имен равны";

    // when
    System.setIn(new ByteArrayInputStream(input.getBytes()));
    fakeOut.reset();
    Task21.main(null);
    String actual = fakeOut.toString().trim();

    // then
    assertEquals("Вывод программы не соответствует ожидаемому.",
        expectedOut, actual);
  }

  @Test
  public void main_InputDiffNames() throws Exception {
    // given
    String name1 = "Иван";
    String name2 = "Сергей";
    String input = String.join(System.lineSeparator(), name1, name2);
    String expectedOut = "";

    // when
    System.setIn(new ByteArrayInputStream(input.getBytes()));
    fakeOut.reset();
    Task21.main(null);
    String actual = fakeOut.toString().trim();

    // then
    assertEquals("Вывод программы не соответствует ожидаемому.",
        expectedOut, actual);
  }
}