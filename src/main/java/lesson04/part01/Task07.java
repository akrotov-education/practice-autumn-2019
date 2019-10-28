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
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    strings = new ArrayList<String>();
    for(int i = 0; i < 5; i++){
      strings.add(reader.readLine());
    }

    int max = 0;
    for (int a = 0; a < 5; a++ ) {
      if (strings.get(a).length() > max) {
        max = strings.get(a).length();
      }
    }

    for(int b = 0; b < 5; b++ ){
      if (max == strings.get(b).length()){
        System.out.println(strings.get(b));
      }
    }
  }
}
