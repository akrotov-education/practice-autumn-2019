package lesson04.part01;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 1. Создай список строк.
 * 2. Добавь в него 5 строк с клавиатуры.
 * 3. Выполни 13 раз: удалить последнюю строку и вставить её в начало.
 * 4. Используя цикл выведи содержимое результирующего списка на экран, каждое значение с новой строки.
 * <p>
 * Требования:
 * 1.	Объяви переменную типа список строк и сразу проинициализируй ee.
 * 2.	Программа должна считывать 5 строк с клавиатуры.
 * 3.	Удали последнюю строку и вставь её в начало. Повторить 13 раз.
 * 4.	Программа должна выводить список на экран, каждое значение с новой строки.
 */

public class Task09 {

  public static void main(String[] args) throws Exception {
    //напишите тут ваш код
    ArrayList<String> list = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    for (int i = 0; i < 5; i++){
      list.add(scanner.nextLine());
    }
    String temp;
    for (int i = 0; i < 13; i++){
      temp = list.get(4);
      list.remove(4);
      list.add(0, temp);
    }
    String res = "";
    for (String s:list){
      res += s + '\n';
    }
    System.out.println(res.trim());
  }
}
