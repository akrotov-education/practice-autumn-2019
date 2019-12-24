package lesson01.part2;

import static org.junit.Assert.fail;
import static org.mockito.Mockito.times;

import lesson01.part2.Task08.Cat;
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
@PrepareForTest(Task08.class)
public class Task08Test {

  @Test
  public void main_SpecialCase() {
    try {
      // given
      Cat cat = Mockito.mock(Task08.Cat.class);
      PowerMockito.whenNew(Task08.Cat.class)
          .withNoArguments()
          .thenReturn(cat);

      // when
      Task08.main(null);

      // then
      PowerMockito.verifyNew(Cat.class, times(8)).withNoArguments();
    } catch (Exception e) {
      fail("Невыполнено условие: В методе main 8 переменных должны быть проинициализированы.");
    }
  }
}