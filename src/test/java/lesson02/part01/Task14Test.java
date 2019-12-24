package lesson02.part01;

import static org.junit.Assert.fail;

import lesson02.part01.Task14.Blue;
import lesson02.part01.Task14.Green;
import lesson02.part01.Task14.Indigo;
import lesson02.part01.Task14.Orange;
import lesson02.part01.Task14.Red;
import lesson02.part01.Task14.Violet;
import lesson02.part01.Task14.Yellow;
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
@PrepareForTest(Task14.class)
public class Task14Test {

  @Test
  public void main_CreateRed() {
    try {
      // given
      Red red = Mockito.mock(Red.class);
      PowerMockito.whenNew(Red.class).withNoArguments().thenReturn(red);

      // when
      Task14.main(null);

      // then
      PowerMockito.verifyNew(Red.class).withNoArguments();
    } catch (Exception e) {
      fail("Невыполнено условие: В методе main создай объект Red.");
    }
  }

  @Test
  public void main_CreateOrange() {
    try {
      // given
      Orange orange = Mockito.mock(Orange.class);
      PowerMockito.whenNew(Orange.class).withNoArguments().thenReturn(orange);

      // when
      Task14.main(null);

      // then
      PowerMockito.verifyNew(Orange.class).withNoArguments();
    } catch (Exception e) {
      fail("Невыполнено условие: В методе main создай объект Orange.");
    }
  }

  @Test
  public void main_CreateYellow() {
    try {
      // given
      Yellow yellow = Mockito.mock(Yellow.class);
      PowerMockito.whenNew(Yellow.class).withNoArguments().thenReturn(yellow);

      // when
      Task14.main(null);

      // then
      PowerMockito.verifyNew(Yellow.class).withNoArguments();
    } catch (Exception e) {
      fail("Невыполнено условие: В методе main создай объект Yellow.");
    }
  }

  @Test
  public void main_CreateGreen() {
    try {
      // given
      Green green = Mockito.mock(Green.class);
      PowerMockito.whenNew(Green.class).withNoArguments().thenReturn(green);

      // when
      Task14.main(null);

      // then
      PowerMockito.verifyNew(Green.class).withNoArguments();
    } catch (Exception e) {
      fail("Невыполнено условие: В методе main создай объект Green.");
    }
  }

  @Test
  public void main_CreateBlue() {
    try {
      // given
      Blue Blue = Mockito.mock(Blue.class);
      PowerMockito.whenNew(Blue.class).withNoArguments().thenReturn(Blue);

      // when
      Task14.main(null);

      // then
      PowerMockito.verifyNew(Blue.class).withNoArguments();
    } catch (Exception e) {
      fail("Невыполнено условие: В методе main создай объект Blue.");
    }
  }

  @Test
  public void main_CreateIndigo() {
    try {
      // given
      Indigo Indigo = Mockito.mock(Indigo.class);
      PowerMockito.whenNew(Indigo.class).withNoArguments().thenReturn(Indigo);

      // when
      Task14.main(null);

      // then
      PowerMockito.verifyNew(Indigo.class).withNoArguments();
    } catch (Exception e) {
      fail("Невыполнено условие: В методе main создай объект Indigo.");
    }
  }

  @Test
  public void main_CreateViolet() {
    try {
      // given
      Violet Violet = Mockito.mock(Violet.class);
      PowerMockito.whenNew(Violet.class).withNoArguments().thenReturn(Violet);

      // when
      Task14.main(null);

      // then
      PowerMockito.verifyNew(Violet.class).withNoArguments();
    } catch (Exception e) {
      fail("Невыполнено условие: В методе main создай объект Violet.");
    }
  }
}