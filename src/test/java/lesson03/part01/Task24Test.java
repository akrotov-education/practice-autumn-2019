package lesson03.part01;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

/**
 * @author Azamat_Abidokov Date: 07-Oct-19
 */
public class Task24Test {

  @Test
  public void Task24_CorrectStatic() {
    // given
    String expected = "publicclassTask24{publicstaticintA=5;publicintB=2;publicintC=A*B;publicstaticvoidmain(String[]args){A=15;}}";
    String taskPath = "./src/main/java/lesson03/part01/Task24.java";

    // when
    try {
      String content = Files.readString(Path.of(taskPath), StandardCharsets.UTF_8);
      String normalizeContent = StringUtils.deleteWhitespace(content);

      // then
      assertTrue("Нарушено условие задачи: Добавь модификатор static в нужное место",
          normalizeContent.contains(expected));
    } catch (IOException e) {
      fail("Ошибка при считывании файла");
    }
  }
}