package lesson04.part02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * 1. Введи с клавиатуры 20 чисел, сохрани их в список и рассортируй по трём другим спискам:
 * Число нацело делится на 3 (x%3==0), нацело делится на 2 (x%2==0) и все остальные.
 * Числа, которые делятся на 3 и на 2 одновременно, например 6, попадают в оба списка.
 * Порядок объявления списков очень важен.
 * 2. Метод printList должен выводить на экран все элементы списка с новой строки.
 * 3. Используя метод printList выведи эти три списка на экран. Сначала тот, который для x%3, потом тот, который для x%2, потом последний.
 * <p>
 * Требования:
 * 1.	Объяви и сразу проинициализируй 4 переменных типа ArrayList<Integer> (список целых чисел). Первый список будет главным, а остальные - дополнительными.
 * 2.	Считать 20 чисел с клавиатуры и добавить их в главный список.
 * 3.	Добавить в первый дополнительный список все числа из главного, которые нацело делятся на 3.
 * 4.	Добавить во второй дополнительный список все числа из главного, которые нацело делятся на 2.
 * 5.	Добавить в третий дополнительный список все остальные числа из главного.
 * 6.	Метод printList должен выводить на экран все элементы переданного списка, каждый с новой строки.
 * 7.	Программа должна вывести три дополнительных списка, используя метод printList.
 */

public class Task07 {
  public static void main(String[] args) throws Exception {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    ArrayList<Integer> array_list = new ArrayList<>();
    ArrayList<Integer> list1 = new ArrayList<>();
    ArrayList<Integer> list2 = new ArrayList<>();
    ArrayList<Integer> list3 = new ArrayList<>();

    for (int i = 0; i < 8; i++) {
      System.out.println("Введите число: ");
      array_list.add(Integer.parseInt(reader.readLine()));
    }

    for (int i = 0; i < 8; i++) {
      if ((array_list.get(i) % 3) == 0) {
        list1.add(array_list.get(i));
      }
      if ((array_list.get(i) % 2) == 0) {
        list2.add(array_list.get(i));
      } else list3.add(array_list.get(i));
    }
    printList(list1);
    printList(list2);
    printList(list3);

  }

  public static void printList(ArrayList<Integer> list) {
    for (Integer lists : list) {
      System.out.println(lists);
    }
    System.out.println("");

  }
}
