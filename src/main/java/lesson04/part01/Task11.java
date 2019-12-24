package lesson04.part01;

import java.util.Arrays;

/**
 * Написать пять методов, которые вызывают друг друга.
 * Каждый метод должен возвращать свой StackTrace.
 * <p>
 * Требования:
 * 1.	В классе должно быть 5 методов (метод main не учитывать).
 * 2.	Каждый метод должен вызывать следующий: main вызывать method1, method1 вызывать method2 и т.д.
 * 3.	Каждый метод должен возвращать свой StackTrace.
 * 4.	Для получения StackTrace воспользуйся Thread.currentThread().getStackTrace().
 */

public class Task11 {

  public static void main(String[] args) {
    method1();
    System.out.println(Arrays.toString(method1()));
  }

  public static StackTraceElement[] method1() {
    method2();
    StackTraceElement[] stackTraceElement = Thread.currentThread().getStackTrace();
    return stackTraceElement;
  }

  public static StackTraceElement[] method2() {
    method3();
    StackTraceElement[] stackTraceElement = Thread.currentThread().getStackTrace();
    return stackTraceElement;
  }

  public static StackTraceElement[] method3() {
    method4();
    StackTraceElement[] stackTraceElement = Thread.currentThread().getStackTrace();
    return stackTraceElement;
  }

  public static StackTraceElement[] method4() {
    method5();
    StackTraceElement[] stackTraceElement = Thread.currentThread().getStackTrace();
    return stackTraceElement;
  }

  public static StackTraceElement[] method5() {
    StackTraceElement[] stackTraceElement = Thread.currentThread().getStackTrace();
    return stackTraceElement;
  }
}