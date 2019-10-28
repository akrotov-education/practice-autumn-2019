package lesson04.part01;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 1. Создать массив на 10 строк.
 * 2. Создать массив на 10 чисел.
 * 3. Ввести с клавиатуры 10 строк, заполнить ими массив строк.
 * 4. В каждую ячейку массива чисел записать длину строки из массива строк,
 * индекс/номер ячейки которой совпадает с текущим индексом из массива чисел.
 *
 * Вывести содержимое массива чисел на экран, каждое значение выводить с новой строки.
 *
 * Требования:
 * 1.	Программа должна создавать массив на 10 строк.
 * 2.	Программа должна создавать массив на 10 целых чисел.
 * 3.	Программа должна считывать строки для массива с клавиатуры.
 * 4. Программа должна в массив чисел записать длины строк из массива строк,
 * а затем их вывести на экран.
 */

public class Task03 {

  public static void main(String[] args) throws Exception {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String[] list = new String[10];

    for (int i = 0; i < list.length; i++)
    {
      list[i] = reader.readLine();
    }
    int[] list2 = new int[10];
    for (int i = 0; i < list.length; i++)
      list2[i] = list[i].length();

    for (int i = 0; i < list.length; i++)
      System.out.println(list2[i]);
  }
}
