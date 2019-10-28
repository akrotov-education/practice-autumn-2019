package lesson04.part01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * 1. Создай список слов, заполни его самостоятельно.
 * 2. Метод fix должен:
 * 2.1. удалять из списка строк все слова, содержащие букву "р"
 * 2.2. удваивать все слова содержащие букву "л".
 * 2.3. если слово содержит и букву "р" и букву "л", то оставить это слово без изменений.
 * 2.4. с другими словами ничего не делать.
 *
 * Пример:
 * роза
 * лира
 * лоза
 *
 * Выходные данные:
 * лира
 * лоза
 * лоза
 *
 * Требования:
 * 1.	Программа не должна считывать данные с клавиатуры.
 * 2.	Метод fix должен удалять из списка строк все слова, содержащие букву "р".
 * Исключение: слова содержащие и букву "р" и букву "л" - их нужно оставить.
 * 3.	Метод fix должен удваивать слова, содержащие букву "л" (добавлять еще один элемент с этим словом).
 * Исключение: слова содержащие и букву "л" и букву "р" - их не нужно удваивать.
 * 4.	Метод fix не должен ничего делать со словами, содержащими и букву "л" и букву "р".
 * 5.	Метод fix не должен ничего делать со словами, которые не содержат ни букву "л", ни букву "р".
 */

public class Task13 {
  public static void main(String[] args) throws Exception {
    BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));

    ArrayList<String> list = new ArrayList<String>();
    list.add("роза"); //0
    list.add("лоза"); //1
    list.add("лира"); //2
    list.add("мера");
    list.add("вола");
    list = fix(list);

    for (String s : list) {
      System.out.println(s);
    }
  }

  public static ArrayList<String> fix(ArrayList<String> list) {
    //напишите тут ваш код
    for (int i = 0; i < list.size(); i++) {
      String word = list.get(i);
      if (word.contains("р") && !word.contains("л")) {
        list.remove(i);
        i -= 1;
      }
      else if (word.contains("л") && !word.contains("р")) {
        String s = word;
        list.add(i + 1, s);
        i += 1;
      }
      else if (word.contains("р") && word.contains("л")) {
        continue;
      }
    }
    return list;
  }
}
