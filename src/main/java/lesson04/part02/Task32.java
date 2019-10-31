package lesson04.part02;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Создать множество чисел(Set<Integer>), занести туда 20 различных чисел.
 * Удалить из множества все числа больше 10.
 *
 * Требования:
 * 1.	Программа не должна выводить текст на экран.
 * 2.	Программа не должна считывать значения с клавиатуры.
 * 3.	Класс должен содержать только три метода.
 * 4.	Метод createSet() должен создавать и возвращать множество Set состоящих из 20 различных чисел.
 * 5.	Метод removeAllNumbersGreaterThan10() должен удалять из множества все числа больше 10.
 */

public class Task32 {

  public static Set<Integer> createSet() {
    Set<Integer> list = new HashSet<Integer>();
    for (int i = 0; i < 20; i++)
      list.add(i);
    return list;
  }

  public static Set<Integer> removeAllNumbersGreaterThan10(Set<Integer> set) {
    Iterator<Integer> iterator = set.iterator();
    while(iterator.hasNext()) {
      Integer n = iterator.next();
      if (n > 10)
        iterator.remove();
    }
    return set;
  }

  public static void main(String[] args) {
    Set<Integer> set = new HashSet<Integer>();

    createSet();
    removeAllNumbersGreaterThan10(set);
  }
}
