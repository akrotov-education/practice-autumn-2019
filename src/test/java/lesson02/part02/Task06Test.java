package lesson02.part02;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.lang.reflect.Field;
import lesson02.part02.Task06.Cat;
import org.junit.Test;

/**
 * @author Azamat_Abidokov Date: 09-Oct-19
 */
public class Task06Test {

  @Test
  public void setName() {
    try {
      // given
      String firstName = "FIRST";
      String lastName = "LAST";
      String expectedFullName = firstName + " " + lastName;
      Cat cat = new Cat();

      // when
      cat.setName(firstName, lastName);

      // then

      Field fullName = Cat.class.getDeclaredField("fullName");
      fullName.setAccessible(true);
      assertEquals(
          "Невыполнено условие: Метод setName класса Cat должен устанавливать значение глобальной переменной private String fullName равным локальной переменной fullName.",
          expectedFullName, fullName.get(cat));
    } catch (Exception e) {
      fail("Непредвиденная ошибка: " + e.getMessage());
    }
  }
}