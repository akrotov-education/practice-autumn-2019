package lesson04.part03;

/**
 * Написать пять методов, которые вызывают друг друга.
 * Каждый метод должен возвращать имя метода, вызвавшего его, полученное с помощью StackTrace.
 *
 * Требования:
 * 1.	В классе должно быть 5 методов (метод main не учитывать).
 * 2.	Каждый метод должен вызывать следующий: main вызывать method1, method1 вызывать method2 и т.д.
 * 3.	Каждый метод должен возвращать имя метода, вызвавшего его.
 * 4.	Для получения имени вызвавшего метода, используй метод getMethodName.
 */

public class Task36 {

  public static void main(String[] args) {
    method1();
  }

  public static String method1() {
    method2();
    //напишите тут ваш код
    return null;
  }

  public static String method2() {
    method3();
    //напишите тут ваш код
    return null;
  }

  public static String method3() {
    method4();
    //напишите тут ваш код
    return null;
  }

  public static String method4() {
    method5();
    //напишите тут ваш код
    return null;
  }

  public static String method5() {
    //напишите тут ваш код
    return null;
  }
}
