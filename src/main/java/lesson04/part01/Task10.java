package lesson04.part01;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Введи с клавиатуры 5 слов в список строк. Удали 3 - ий элемент списка,
 * и выведи оставшиеся элементы в обратном порядке.
 *
 * Требования:
 * 1.	Объяви переменную типа ArrayList<String> (список строк) и сразу проинициализируй ee.
 * 2.	Считай 5 строк с клавиатуры и добавь их в список.
 * 3.	Удали третий элемент списка.
 * 4.	Выведи элементы на экран, каждый с новой строки.
 * 5.	Порядок вывода должен быть обратный.
 */

public class Task10 {
  public static void main(String[] args) throws Exception {
    //напишите тут ваш код
    ArrayList<String> list = new ArrayList<>();
    Scanner in = new Scanner(System.in);
    for(int i = 0; i < 5; i++) {
      list.add(in.nextLine());
    }
    list.remove(2);
    for(int i = list.size() - 1; i >= 0; i--) {
      System.out.println(list.get(i));
    }
  }
}
