package lesson04.part01;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;

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
    ArrayList<String> list = new ArrayList<String>();
    InputStream inputStream = System.in;
    Reader inputStreamReader = new InputStreamReader(inputStream);
    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

    for(int i=0;i<5;i++)
      list.add( bufferedReader.readLine());
    for(int i=0;i<13;i++)
    {
      String cs=list.get(4);
      list.remove(4);
      list.add(0,cs);
    }

    for(int i=0;i<5;i++)
      System.out.print(list.get(i)+"\n");

  }
}
