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
public class Task14Test {

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
    String expected = "20";

    // when
    Task14.main(null);

    // then
    assertEquals("Вывод программы не соответствует ожидаемому.",
        expected, fakeOut.toString().trim());
  }

  @Test
  public void main_VarChanges() {
    // given
    String expected = "publicstaticinta=1;publicstaticintb=3;publicstaticintc=9;publicstaticintd=27;";
    String taskPath = "./src/main/java/lesson01/part1/Task14.java";

    // when
    try {
      String content = Files.readString(Path.of(taskPath), StandardCharsets.UTF_8);
      String normalizeContent = StringUtils.deleteWhitespace(content);

      // then
      assertTrue("Нарушено условие задачи: Значения переменных: a, b, c, d не изменяй",
          normalizeContent.contains(expected));
    } catch (IOException e) {
      fail("Ошибка при считывании файла");
    }
  }

  @Test
  public void main_Changes() {
    // given
    String expected = "publicstaticvoidmain(String[]args){intresult=-a+b-c+d;System.out.println(result);}";
    String taskPath = "./src/main/java/lesson01/part1/Task14.java";

    // when
    try {
      String content = Files.readString(Path.of(taskPath), StandardCharsets.UTF_8);
      String normalizeContent = StringUtils.deleteWhitespace(content);

      // then
      assertTrue("Нарушено условие задачи: Порядок следования переменных в этой строке изменять нельзя.",
          normalizeContent.contains(expected));
    } catch (IOException e) {
      fail("Ошибка при считывании файла");
    }
  }
}