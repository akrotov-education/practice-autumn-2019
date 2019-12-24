package lesson03.part01;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import lesson03.part01.Task03.Cat;
import org.apache.commons.lang3.StringUtils;
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
@PrepareForTest(Task03.class)
public class Task03Test {

  @Test
  public void main_CreateThreeCats() {
    try {
      // given
      Cat cat = Mockito.mock(Cat.class);
      PowerMockito.whenNew(Cat.class)
          .withArguments(anyString(), anyInt(), anyInt(), anyInt())
          .thenReturn(cat);

      // when
      Task03.main(null);

      // then
      PowerMockito.verifyNew(Cat.class, times(3))
          .withArguments(anyString(), anyInt(), anyInt(), anyInt());
    } catch (Exception e) {
      fail("Невыполнено условие: Нужно создать три объекта типа Cat.");
    }
  }

  @Test
  public void Cat_NotChanges() {
    // given
    String expected = "publicstaticclassCat{privateStringname;privateintage;privateintweight;privateintstrength;publicCat(Stringname,intage,intweight,intstrength){this.name=name;this.age=age;this.weight=weight;this.strength=strength;}}";
    String taskPath = "./src/main/java/lesson03/part01/Task03.java";

    // when
    try {
      String content = Files.readString(Path.of(taskPath), StandardCharsets.UTF_8);
      String normalizeContent = StringUtils.deleteWhitespace(content);

      // then
      assertTrue("Нарушено условие задачи: Класс Cat нельзя изменять.",
          normalizeContent.contains(expected));
    } catch (IOException e) {
      fail("Ошибка при считывании файла");
    }
  }
}