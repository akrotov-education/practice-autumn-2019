package lesson04.part02;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.util.Arrays;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Azamat_Abidokov Date: 07-Oct-19
 */
public class Task04Test {

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
    String[] numbers = {"раз", "два", "три", "четыре", "пять"};
    String input = String.join(System.lineSeparator(), numbers);
    String expectedOut = "четыре";

    // when
    System.setIn(new ByteArrayInputStream(input.getBytes()));
    fakeOut.reset();
    Task04.main(null);
    String actual = fakeOut.toString().trim();

    // then
    assertEquals("Вывод программы не соответствует ожидаемому.",
        expectedOut, actual);
    Field strings = Task04.class.getDeclaredField("strings");
    strings.setAccessible(true);
    assertEquals("Невыполнено условие: Программа должна считывать 5 строк с клавиатуры и записывать их в существующее поле strings.",
        Arrays.asList(numbers), strings.get(null));
  }
}