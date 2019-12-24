package lesson01.part2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lesson01.part2.Task01.Person;
import org.apache.commons.lang3.StringUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 * @author Azamat_Abidokov Date: 07-Oct-19
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(Task01.class)
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
  public void main_CreatePerson() {
    try {
      // given
      Person person = Mockito.mock(Person.class);
      PowerMockito.whenNew(Task01.Person.class)
          .withNoArguments()
          .thenReturn(person);

      // when
      Task01.main(null);

      // then
      PowerMockito.verifyNew(Task01.Person.class).withNoArguments();
    } catch (Exception e) {
      fail("Невыполнено условие: В методе main создай объект Person и сразу присвой ссылку на него переменной person");
    }
  }

  @Test
  public void main_VarChanges() {
    // given
    String expectedPattern = "publicstaticvoidmain\\(String\\[]args\\)\\{.*Personperson=newPerson\\(\\);.*?}";
    Pattern pattern = Pattern.compile(expectedPattern);
    String taskPath = "./src/main/java/lesson01/part2/Task01.java";

    // when
    try {
      String content = Files.readString(Path.of(taskPath), StandardCharsets.UTF_8);
      String normalizeContent = StringUtils.deleteWhitespace(content);
      Matcher matcher = pattern.matcher(normalizeContent);

      // then
      assertTrue("Невыполнено условие: В методе main создай объект Person и сразу присвой ссылку на него переменной person",
          matcher.find());
    } catch (IOException e) {
      fail("Ошибка при считывании файла");
    }
  }

  @Test
  public void main_Changes() {
    try {
      Field name = Task01.Person.class.getDeclaredField("name");
      Field age = Task01.Person.class.getDeclaredField("age");
      Field weight = Task01.Person.class.getDeclaredField("weight");
      Field money = Task01.Person.class.getDeclaredField("money");
      assertEquals("Невыполенно условие: В классе Person объяви переменную name типа String.", String.class, name.getType());
      assertEquals("Невыполенно условие: В классе Person объяви переменную age типа int", int.class, age.getType());
      assertEquals("Невыполенно условие: В классе Person объяви переменную weight типа int", int.class, weight.getType());
      assertEquals("Невыполенно условие: В классе Person объяви переменную money типа int", int.class, money.getType());
    } catch (Exception e) {
      fail("Не найдена переменная класса Person: " + e.getMessage());
    }
  }
}