package lesson04.part02;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

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
    Set<Integer> set = new HashSet<>(Arrays.asList(
            2, 15, 13, 75, 4, 9, 19, 24, 7, 3, 11, 27, 8, 14, 23, 6, 17, 1, 10, 12 ));
    return set;
  }

  public static Set<Integer> removeAllNumbersGreaterThan10(Set<Integer> set) {
    // напишите тут ваш код
    return set.stream()
            .filter(i -> i<10)
            .collect(Collectors.toSet());
  }

  public static void main(String[] args) {
    removeAllNumbersGreaterThan10(createSet());
  }
}
