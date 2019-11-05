package lesson04.part01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

import static java.lang.Integer.parseInt;

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
    //напишите тут ваш код
    strings = new ArrayList<>();
    BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    int max = 0;
    for (int i = 0; i < 5; i++)
    {strings.add(r.readLine());
      if (strings.get(i).length() > max)
      {max = strings.get(i).length();
      }
    }
    for (int i = 0; i < strings.size(); i++)
    {
      if (strings.get(i).length()==max)
      {
        System.out.println(strings.get(i));
      }
    }
  }
}
