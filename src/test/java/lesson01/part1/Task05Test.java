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
public class Task05Test {

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
    Task05.main(null);

    // then
    assertEquals("Вывод программы не соответствует ожидаемому.",
        "9 умножить на 3 равно 27", fakeOut.toString());
  }

  @Test
  public void main_FileChanges() {
    // given
    String expected = "publicstaticvoidmain(String[]args){inta=3;intb=9;//System.out.print(\"девять\");System.out.print(b);System.out.print(\"умножить\");System.out.print(\"на\");System.out.print(a);//System.out.print(\"три\");//System.out.print(\"не\");//System.out.print(\"будет\");System.out.print(\"равно\");//System.out.print(\"пятнадцать\");//System.out.print(21);System.out.print((int)Math.pow(3,3));}";
    String taskPath = "./src/main/java/lesson01/part1/Task05.java";

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