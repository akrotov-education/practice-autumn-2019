package lesson03.part01;

/**
 * Переставь один модификатор static, чтобы пример скомпилировался.
 * <p>
 * Требования:
 * 1. Раскомментируй строки.
 * 2.	Метод main менять нельзя.
 * 3.	Добавь модификатор static в нужное место.
 * 4.	Убери лишний модификатор static.
 * 5.	В программе должно быть только 2 модификатора static.
 */

public class Task24 {

  public static int A = 5;
  public int B = 2;
  public int C = A * B;

  public static void main(String[] args) {
    A = 15;
  }
}