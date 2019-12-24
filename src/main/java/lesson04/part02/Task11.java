package lesson04.part02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Ввести с клавиатуры 2 числа N и M.
 * Ввести N строк и заполнить ими список.
 * Переставить M первых строк в конец списка.
 * Вывести список на экран, каждое значение с новой строки.
 * <p>
 * Примечание: запрещено создавать больше одного списка.
 * <p>
 * Требования:
 * 1.	Объяви переменную типа список строк и сразу проинициализируй ee.
 * 2.	Считай c клавиатуры числа N и M, считай N строк и добавь их в список.
 * 3.	Переставить M первых строк в конец списка.
 * 4. Выведи список на экран, каждое значение с новой строки.
 */

public class Task11 {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    ArrayList<String> list = new ArrayList<>();

    System.out.println("Введите число N");
    int n = Integer.parseInt(reader.readLine());
    System.out.println("Введите число M");
    int m = Integer.parseInt(reader.readLine());
    for (int i = 0; i < n; i++) {
      System.out.println("Введите строку: ");
      list.add(reader.readLine());
    }
    for (int i = 0; i < m; i++) {
      list.add(list.get(0));
      list.remove(0);
    }
    for (String s : list) {
      System.out.println(s);
    }
  }
}