package lesson04.part01;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;

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
    ArrayList<String> list = new ArrayList<String>();
    InputStream inputStream = System.in;
    Reader inputStreamReader = new InputStreamReader(inputStream);
    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

    for(int i=0;i<5;i++)
      list.add( bufferedReader.readLine());

      list.remove(2);

    for(int i=3;i>=0;i--)
      System.out.print(list.get(i)+"\n");
  }
}
