package lesson04.part02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 1. Создай список строк.
 * 2. Считай с клавиатуры 5 строк и добавь в список.
 * 3. Используя цикл, найди самую длинную строку в списке.
 * 4. Выведи найденную строку на экран. Если таких строк несколько, выведи каждую с новой строки.
 * <p>
 * Требования:
 * 1.	В методе main инициализируй существующее поле strings новым ArrayList<>
 * 2.	Программа должна считывать 5 строк с клавиатуры и записывать их в поле strings.
 * 3.	Программа должна выводить самую длинную строку на экран.
 * 4.	Если есть несколько строк с длиной равной максимальной, то нужно вывести каждую из них
 * с новой строки.
 */

public class Task04 {

  private static List<String> strings;

  public static void main(String[] args) throws Exception {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    strings = new ArrayList<String>();

    for (int i = 0; i < 5; i++) {
      String name = reader.readLine();
      strings.add(name);
    }

    Integer[] lenghtOfList = new Integer[5];

    for (int i = 0; i < 5; i++) {
      int size = strings.get(i).length();
      lenghtOfList[i] = size;
    }

    Arrays.sort(lenghtOfList, Collections.reverseOrder());
    int max = lenghtOfList[0];

    for (int i = 0; i < 5; i++) {
      if (strings.get(i).length() == max) {
        System.out.println(strings.get(i));
      }
    }

  }
}