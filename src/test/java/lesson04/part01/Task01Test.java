package lesson04.part01;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Azamat_Abidokov Date: 07-Oct-19
 */
public class Task01Test {

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
    String[] numbers = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17",
        "18", "19", "20"};
    List<String> numbersList = Arrays.asList(numbers);
    Collections.shuffle(numbersList);
    String input = String.join(System.lineSeparator(), numbersList.toArray(new String[numbers.length]));
    String expectedOut = "20";

    // when
    System.setIn(new ByteArrayInputStream(input.getBytes()));
    fakeOut.reset();
    Task01.main(null);
    String actual = fakeOut.toString().trim();

    // then
    assertEquals("Вывод программы не соответствует ожидаемому.",
        expectedOut, actual);
  }

  @Test
  public void main_NotChanged() {
    // given
    String expected = "publicstaticvoidmain(String[]args)throwsException{int[]array=initializeArray();intmax=max(array);System.out.println(max);}";
    String taskPath = "./src/main/java/lesson04/part01/Task01.java";

    // when
    try {
      String content = Files.readString(Path.of(taskPath), StandardCharsets.UTF_8);
      String normalizeContent = StringUtils.deleteWhitespace(content);

      // then
      assertTrue("Нарушено условие задачи: Метод main изменять нельзя.",
          normalizeContent.contains(expected));
    } catch (IOException e) {
      fail("Ошибка при считывании файла");
    }
  }
}