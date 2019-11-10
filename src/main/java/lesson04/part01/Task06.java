package lesson04.part01;

import java.io.IOException;
import java.util.ArrayList;

/**
 * 1. Создай список строк.
 * 2. Добавь в него 5 различных строк.
 * 3. Выведи его размер на экран.
 * 4. Используя цикл выведи его содержимое на экран, каждое значение с новой строки.
 *
 * Требования:
 * 1.	Программа не должна ничего считывать с клавиатуры.
 * 2.	Объяви переменную типа ArrayList<String> (список строк) и сразу проинициализируй ee.
 * 3.	Программа должна добавить 5 любых строк в список.
 * 4.	Программа должна вывести размер списка на экран.
 * 5.	Программа должна вывести содержимое списка на экран, каждое значение с новой строки.
 */

public class Task06 {

    public static void main(String[] args) throws IOException {
      ArrayList<String> list = new ArrayList<String>();
      list.add("as");
      list.add("zxc");
      list.add("123");
      list.add("vbn");
      list.add("tyu");

      System.out.println(list.size());

      for (int i = 0; i<5; i++){
        System.out.println(list.get(i));
      }
    }
}