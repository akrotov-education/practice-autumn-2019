package lesson04.part03;

import java.util.HashMap;

/**
 * Перехватить исключение (и вывести его на экран), указав его тип, возникающее при выполнении кода:
 * HashMap map = new HashMap(null);
 * map.put(null, null);
 * map.remove(null);
 *
 * Требования:
 * 1.	Программа должна выводить сообщение на экран.
 * 2.	В программе должен быть блок try-catch.
 * 3.	Программа должна отлавливать исключения конкретного типа, а не все возможные (Exception).
 * 4.	Выведенное сообщение должно содержать тип возникшего исключения.
 * 5.	Имеющийся код в методе main не удалять.
 */

public class Task43 {

  public static void main(String[] args) {
    //напишите тут ваш код

    HashMap<String, String> map = new HashMap<String, String>(null);
    map.put(null, null);
    map.remove(null);

    //напишите тут ваш код
  }
}
