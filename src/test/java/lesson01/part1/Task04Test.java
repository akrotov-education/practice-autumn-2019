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
public class Task04Test {

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
    String expectedOutput = String.join(System.lineSeparator(), "26", "25");

    // when
    Task04.main(null);

    // then
    assertEquals("Вывод программы не соответствует ожидаемому.",
        expectedOutput, fakeOut.toString().trim());
  }

  @Test
  public void main_FileChanges() {
    // given
    String expected = "publicstaticvoidmain(String[]args){intx=27;inty=15;//y=x-y;//y=y-x;//y=y+x;//y=y+x;y=x/y;//y=y/x;//y=y*x;x=x-y;y=y-x;System.out.println(Math.abs(x));System.out.println(Math.abs(y));}";
    String taskPath = "./src/main/java/lesson01/part1/Task04.java";

    // when
    try {
      String content = Files.readString(Path.of(taskPath), StandardCharsets.UTF_8);
      String normalizeContent = StringUtils.deleteWhitespace(content);

      // then
      assertTrue("Нарушено условие задачи: Нельзя изменять (добавлять, удалять) строки с кодом",
          normalizeContent.contains(expected));
    } catch (IOException e) {
      fail("Ошибка при считывании файла");
    }
  }
}