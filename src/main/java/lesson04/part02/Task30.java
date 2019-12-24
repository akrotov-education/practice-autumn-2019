package lesson04.part02;

/**
 * Перехватить исключение (и вывести его на экран), указав его тип, возникающее при выполнении кода:
 * int num=Integer.parseInt("XYZ");
 * System.out.println(num);
 * <p>
 * Требования:
 * 1.	Программа должна выводить сообщение на экран.
 * 2.	В программе должен быть блок try-catch.
 * 3.	Программа должна отлавливать исключения конкретного типа, а не все возможные (Exception).
 * 4.	Выведенное сообщение должно содержать тип возникшего исключения.
 * 5.	Имеющийся код в методе main не удалять.
 */

public class Task30 {

  public static void main(String[] args) {
    try {
      int num = Integer.parseInt("XYZ");
      System.out.println(num);

    } catch (NumberFormatException e) {
      String s = e.getClass().getName();
      System.out.println(s);
    }
  }
}