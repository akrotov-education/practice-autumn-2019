package lesson04.part01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Ввести с клавиатуры 2 числа N и M.
 * Ввести N строк и заполнить ими список.
 * Переставить M первых строк в конец списка.
 * Вывести список на экран, каждое значение с новой строки.
 *
 * Примечание: запрещено создавать больше одного списка.
 *
 * Требования:
 * 1.	Объяви переменную типа список строк и сразу проинициализируй ee.
 * 2.	Считай c клавиатуры числа N и M, считай N строк и добавь их в список.
 * 3.	Переставить M первых строк в конец списка.
 * 4. Выведи список на экран, каждое значение с новой строки.
 */

public class Task16 {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    ArrayList<String> a = new ArrayList<String>();
    int n = Integer.parseInt(reader.readLine());
    int m = Integer.parseInt(reader.readLine());

    for (int i = 0; i < n; i++){
      a.add(reader.readLine());
    }
    for (int i = 0; i < m; i++) {
      a.add(a.get(0));
      a.remove(0);
    }

    for (String s: a){
      System.out.println(s);
    }

  }
}
