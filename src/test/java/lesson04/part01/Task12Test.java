package lesson04.part01;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.lang3.StringUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 * @author Azamat_Abidokov Date: 07-Oct-19
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(Task10.class)
public class Task12Test {

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
  public void main() throws Exception {
    // given
    String expectedType = "class java.lang.ArithmeticException";

    // when
    fakeOut.reset();
    Task12.main(null);
    String actual = fakeOut.toString().trim();

    // then
    assertEquals("Вывод программы не соответствует ожидаемому.",
        expectedType, actual);
  }

  @Test
  public void main_NotChanged() {
    // given
    String regex = "publicstaticvoidmain\\(String\\[]args\\)\\{.*?try\\{.*?inta=42/0;.*?}catch\\(ArithmeticException.*?\\)\\{.*?System.out.println\\(.*?\\);.*?}.*?}";
    Pattern pattern = Pattern.compile(regex);
    String taskPath = "./src/main/java/lesson04/part01/Task12.java";

    // when
    try {
      String content = Files.readString(Path.of(taskPath), StandardCharsets.UTF_8);
      String normalizeContent = StringUtils.deleteWhitespace(content);
      Matcher matcher = pattern.matcher(normalizeContent);

      // then
      assertTrue("Нарушено условие задачи: В программе должен быть блок try-catch.",
          matcher.find());
    } catch (IOException e) {
      fail("Ошибка при считывании файла");
    }
  }
}