package lesson04.part03;

import java.util.ArrayList;

/**
 * Перехватить исключение (и вывести его на экран, указав его тип), возникающее при выполнении кода:
 * ArrayList<String> list = new ArrayList<String>();
 * String s = list.get(18);
 *
 * Требования:
 * 1.	Программа должна выводить сообщение на экран.
 * 2.	В программе должен быть блок try-catch.
 * 3.	Программа должна отлавливать исключения конкретного типа, а не все возможные (Exception).
 * 4.	Выведенное сообщение должно содержать тип возникшего исключения.
 * 5.	Имеющийся код в методе main не удалять.
 */

public class Task42 {

  public static void main(String[] args) {
    //напишите тут ваш код

    ArrayList<String> list = new ArrayList<String>();
    String s = list.get(18);

    //напишите тут ваш код
  }
}
