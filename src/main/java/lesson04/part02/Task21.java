package lesson04.part02;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Создать коллекцию Set (реализация HashSet) с типом элементов String.
 * Добавить в неё 10 строк:
 * арбуз
 * банан
 * вишня
 * груша
 * дыня
 * ежевика
 * женьшень
 * земляника
 * ирис
 * картофель
 *
 * Вывести содержимое коллекции на экран, каждый элемент с новой строки.
 * Посмотреть, как изменился порядок добавленных элементов.
 *
 * Требования:
 * 1.	Объяви переменную коллекции Set с типом элементов String и сразу проинициализируй ee.
 * 2.	Программа не должна считывать строки с клавиатуры.
 * 3.	Программа должна добавлять в коллекцию 10 строк, согласно условию.
 * 4.	Программа должна выводить 10 строк из коллекции на экран, каждую с новой строки.
 */

public class Task21 {
  public static void main(String[] args) {
    //напишите тут ваш код
    HashSet<String> mas = new HashSet<String>();
    mas.add("арбуз");
    mas.add("банан");
    mas.add("вишня");
    mas.add("груша");
    mas.add("дыня");
    mas.add("ежевика");
    mas.add("женьшень");
    mas.add("земляника");
    mas.add("ирис");
    mas.add("картофель");

    Iterator<String> iter = mas.iterator();
    //System.out.println(mas);
    while (iter.hasNext())
    {
      System.out.println(iter.next());
    }


  }
}
