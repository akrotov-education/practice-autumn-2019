package lesson01.part1;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import org.apache.commons.lang3.StringUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Azamat_Abidokov Date: 07-Oct-19
 */
public class Task06Test {

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
    double pi = 3.14;
    int radius = 5;
    String output = String.valueOf(2 * pi * radius);

    // when
    Task06.main(null);

    // then
    assertEquals("Вывод программы не соответствует ожидаемому.",
        output, fakeOut.toString().trim());
  }

  @Test
  public void main_FileChanges() {
    // given
    String expected = "publicstaticvoidmain(String[]args){printCircleLength(5);}";
    String taskPath = "./src/main/java/lesson01/part1/Task06.java";

    // when
    try {
      String content = Files.readString(Path.of(taskPath), StandardCharsets.UTF_8);
      String normalizeContent = StringUtils.deleteWhitespace(content);

      // then
      assertTrue("Нарушено условие задачи: Метод main должен вызывать метод printCircleLength с параметром 5",
          normalizeContent.contains(expected));
    } catch (IOException e) {
      fail("Ошибка при считывании файла");
    }
  }
}