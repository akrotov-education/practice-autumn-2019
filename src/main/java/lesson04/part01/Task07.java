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

   public static void main(String[] args) throws Exception {
    ArrayList<String> strings = new ArrayList<>();
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    for (int i=0; i<5; i++) {
      strings.add(reader.readLine());
    }
    int max = 0;
    for (int i=1; i<strings.size(); i++) {
      if (strings.get(i-1).length()>strings.get(i).length()) {
        max = strings.get(i-1).length();
        strings.remove(i);
      } else if (strings.get(i-1).length()<strings.get(i).length()) {
        max = strings.get(i).length();
        strings.remove(i-1);
      }
    }
    for(int i=0; i<strings.size(); i++)
    {
      if (max == strings.get(i).length())
        System.out.println(strings.get(i));
    }
  }
}
