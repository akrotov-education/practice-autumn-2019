package lesson04.part03;

import lesson04.part03.task46.Task46;

import java.io.FileNotFoundException;
import java.net.URISyntaxException;

/**
 * Есть метод, который выбрасывает два исключения, унаследованные от Exception, и два унаследованных от RuntimeException:
 * NullPointerException, ArithmeticException, FileNotFoundException, URISyntaxException.
 * <p>
 * Нужно перехватить NullPointerException и FileNotFoundException, но не перехватывать
 * ArithmeticException и URISyntaxException.
 * Как это сделать?
 * <p>
 * Требования:
 * 1.	Метод main должен вызывать метод method1.
 * 2.	Метод main должен перехватывать исключение NullPointerException.
 * 3.	Метод main должен перехватывать исключение FileNotFoundException.
 * 4.	Метод main не должен перехватывать исключение ArithmeticException.
 * 5.	Метод main не должен перехватывать исключение URISyntaxException.
 * 6.	Метод method1 не изменять.
 */

public class Task45 {

  public static void main(String[] args) throws Exception {
    try {
      method1();
    }
    catch (NullPointerException | FileNotFoundException e) {
    }

    }
  public static void method1()
          throws NullPointerException, ArithmeticException, FileNotFoundException, URISyntaxException {
    int i = (int) (Math.random() * 4);
    if (i == 0) {
      throw new NullPointerException();
    }
  }
}