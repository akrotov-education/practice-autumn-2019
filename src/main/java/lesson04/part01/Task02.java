package lesson04.part01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

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

public class Task02 {

  public static void main(String[] args) throws Exception {
    String [] str = new String[10];
    int [] num = new int[10];
    BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    for (int i = 0; i < str.length; i++) {
      str[i] = r.readLine();
    }
    for(int i = 0;i < num.length;i++ ){
      num[i] = str[i].length();
    }
    System.out.println(Arrays.toString(num));
  }
}