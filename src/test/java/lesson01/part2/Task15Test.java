package lesson01.part2;

import static org.junit.Assert.fail;

import lesson01.part2.Task15.Man;
import lesson01.part2.Task15.Woman;
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
@PrepareForTest(Task15.class)
public class Task15Test {

  @Test
  public void main_CreateMan() {
    try {
      // given
      Man man = Mockito.mock(Man.class);
      PowerMockito.whenNew(Man.class).withNoArguments().thenReturn(man);

      // when
      Task15.main(null);

      // then
      PowerMockito.verifyNew(Man.class).withNoArguments();
    } catch (Exception e) {
      fail("Невыполнено условие: В методе main создай объект Man и сразу сохрани ссылку на него в переменную man.");
    }
  }

  @Test
  public void main_CreateWoman() {
    try {
      // given
      Woman woman = Mockito.mock(Woman.class);
      PowerMockito.whenNew(Woman.class).withNoArguments().thenReturn(woman);

      // when
      Task15.main(null);

      // then
      PowerMockito.verifyNew(Woman.class).withNoArguments();
    } catch (Exception e) {
      fail("Невыполнено условие: В методе main создай объект Woman и сразу сохрани ссылку на него в переменную woman.");
    }
  }
}