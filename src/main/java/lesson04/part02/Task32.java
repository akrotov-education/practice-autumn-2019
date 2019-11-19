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
    // напишите тут ваш код
    Set<Integer> set = new HashSet<Integer>();
    for(int i=0;i<20;i++)
      set.add(i);
    return set;
  }

  public static Set<Integer> removeAllNumbersGreaterThan10(Set<Integer> set) {
    // напишите тут ваш код
    Iterator<Integer> iter = set.iterator();
    while(iter.hasNext())
    {
      if (10<iter.next())
        iter.remove();
    }
    return set;
  }

  public static void main(String[] args) {
    Set<Integer> set = createSet();
    //System.out.println(set);
    Set<Integer> res =removeAllNumbersGreaterThan10(set);
    //System.out.print(res);
  }
}
