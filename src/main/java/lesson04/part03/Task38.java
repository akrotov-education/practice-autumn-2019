package lesson04.part03;

/**
 * Реализовать метод log.
 * Он должен выводить на экран имя класса и имя метода (в котором вызывается метод log), а также переданное сообщение.
 * Имя класса, имя метода и сообщение разделить двоеточием с пробелом.
 *
 * Пример вывода:
 * lesson04.part01.Task38: main: In main method
 *
 * Требования:
 * 1.	Метод log должен выводить сообщение на экран.
 * 2.	Выведенное сообщение должно содержать имя класса, метод которого вызвал метод log.
 * 3.	Выведенное сообщение должно содержать имя метода, который вызвал метод log.
 * 4.	Выведенное сообщение должно содержать переданное сообщение.
 * 5.	Вывод должен соответствовать примеру из задания.
 */

public class Task38 {

  public static void main(String[] args) {
    log("In main method");
  }

  public static void log(String s) {
    StackTraceElement[] elements = Thread.currentThread().getStackTrace();
    System.out.println(elements[2].getClassName()+": "+elements[2].getMethodName()+": "+s);
  }
}
