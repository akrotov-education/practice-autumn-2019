package lesson04.part02;

/**
 * 1. Есть три исключения последовательно унаследованные от Exception:
 * 2. class Exception1 extends Exception
 * 3. class Exception2 extends Exception1
 * 4. class Exception3 extends Exception2
 * 5. Есть метод, который описан так:
 * public static void method1() throws Exception1, Exception2, Exception3
 * 6. Напиши catch, который перехватит все три Exception1, Exception2 и Exception3
 * <p>
 * Требования:
 * 1.	Метод main должен вызывать метод method1.
 * 2.	Метод main должен перехватывать исключение Exception1.
 * 3.	Метод main должен перехватывать исключение Exception2.
 * 4.	Метод main должен перехватывать исключение Exception3.
 * 5.	Метод method1 не изменять.
 */

public class Task31 {
  public static void main(String[] args) throws Exception {
    try {
      method1();
    } catch (Exception e) {
      System.out.println(e);
    }
  }
  public static void method1() throws Exception1, Exception2, Exception3 {
    int i = (int) (Math.random() * 3);
    if (i == 0) {
      throw new Exception1();
    } else if (i == 1) {
      throw new Exception2();
    } else if (i == 2) {
      throw new Exception3();
    }
  }
  static class Exception1 extends Exception {
  }
  static class Exception2 extends Exception1 {
  }
  static class Exception3 extends Exception2 {
  }
}