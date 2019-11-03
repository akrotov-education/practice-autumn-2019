package lesson04.part01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

import static java.lang.Integer.parseInt;

/**
 * 1. Введи с клавиатуры 10 слов в список строк.
 * 2. Метод doubleValues должен удваивать слова по принципу:
 * "альфа", "бета", "гамма" -> "альфа", "альфа", "бета", "бета", "гамма", "гамма"
 * 3. Выведи результат на экран, каждое значение с новой строки.
 *
 * Требования:
 * 1.	Проинициализируй переменную типа список строк.
 * 2.	Считай 10 строк с клавиатуры и добавь их в список.
 * 3.	Метод doubleValues должен удваивать элементы списка
 * по принципу "альфа", "бета", "гамма" -> "альфа", "альфа", "бета", "бета", "гамма", "гамма".
 * 4.	Выведи получившийся список на экран, каждый элемент с новой строки.
 */

public class Task14 {
  public static void main(String[] args) throws Exception {
    // Считать строки с консоли и объявить ArrayList list тут
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    ArrayList<String> arrayList = new ArrayList<>();
    for (int i = 0; i < 10; i++) {
      arrayList.add(in.readLine());
    }
    ArrayList<String> result = doubleValues(arrayList);

    // Вывести на экран result
    for (String res:result) {
      System.out.println(res);
    }
  }

  public static ArrayList<String> doubleValues(ArrayList<String> list) {
    //напишите тут ваш код
    ArrayList<String> temp = new ArrayList<>();
    temp.addAll(list);
    for (String str : list) {
      temp.add(temp.indexOf(str) + 1,str);
    }
    return temp;
  }
}
