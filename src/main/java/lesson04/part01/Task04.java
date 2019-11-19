package lesson04.part01;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

/**
 * 1. Создать массив на 10 чисел.
 * 2. Ввести с клавиатуры 10 чисел и записать их в массив.
 * 3. Вывести на экран элементы массива в обратном порядке, каждое значение выводить с новой строки.
 * <p>
 * Требования:
 * 1.	Программа должна создавать массив на 10 целых чисел.
 * 2.	Программа должна считывать числа для массива с клавиатуры.
 * 3.	Программа должна выводить 10 строчек, каждую с новой строки.
 * 4.	Массив должен быть выведен на экран в обратном порядке.
 */

public class Task04 {

  public static void main(String[] args) throws Exception {
    //напишите тут ваш код
    int masStr[]= new int[10];
    InputStream inputStream = System.in;
    Reader inputStreamReader = new InputStreamReader(inputStream);
    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
    for(int i=0;i<10;i++)
    {
      String cS = bufferedReader.readLine();
      masStr[i] = Integer.parseInt(cS);
    }
    for(int i=9;i>=0;i--)
    {
      System.out.print(masStr[i]+"\n");
    }
  }
}
