package lesson04.part01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * 1. Создай список строк.
 * 2. Считай с клавиатуры 5 строк и добавь в список.
 * 3. Используя цикл, найди самую длинную строку в списке.
 * 4. Выведи найденную строку на экран. Если таких строк несколько, выведи каждую с новой строки.
 *
 * Требования:
 * 1.	В методе main инициализируй существующее поле strings новым ArrayList<>
 * 2.	Программа должна считывать 5 строк с клавиатуры и записывать их в поле strings.
 * 3.	Программа должна выводить самую длинную строку на экран.
 * 4.	Если есть несколько строк с длиной равной максимальной, то нужно вывести каждую из них
 * с новой строки.
 */

public class Task07 {

  private static ArrayList<String> strings;

  public static void main(String[] args) throws Exception {
    strings = new ArrayList<>();
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    int maxLen = 0;
    for (int i = 0; i < 5; i++) {
      String inp = reader.readLine();
      strings.add(inp);
      if (inp.length() > maxLen) {
        maxLen = inp.length();
      }
    }

    for (String str: strings) {
      if (str.length() != maxLen) {
        continue;
      }

      System.out.println(str);
    }
  }
}
