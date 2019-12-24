package lesson04.part01;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Set;
import lesson04.part01.Task10.Cat;
import org.junit.Test;

/**
 * @author Azamat_Abidokov Date: 07-Oct-19
 */
public class Task10Test {

  @Test
  public void createCats() throws Exception {
    int expectedSize = 3;

    // when
    Set<Cat> actual = Task10.createCats();

    // then
    assertNotNull("Невыполнено условие: Метод createCats() должен возвращать множество (Set), содержащее 3 кота.",
        actual);
    assertEquals("Невыполнено условие: Метод createCats() должен возвращать множество (Set), содержащее 3 кота.",
        expectedSize, actual.size());
  }
}