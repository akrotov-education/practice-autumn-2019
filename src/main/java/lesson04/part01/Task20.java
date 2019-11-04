package lesson04.part01;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Задача: Написать программу, которая вводит с клавиатуры 20 чисел и выводит их в убывающем порядке.
 *
 * Требования:
 * 1.	Программа должна считывать 20 целых чисел с клавиатуры.
 * 2.	Программа должна выводить 20 чисел.
 * 3.	В классе должен быть метод public static void sort(int[] array).
 * 4.	Метод main должен вызывать метод sort.
 * 5.	Метод sort должен сортировать переданный массив по убыванию.
 */

public class Task20 {

  public static void main(String[] args) throws Exception {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    int[] array = new int[20];
    for (int i = 0; i < 20; i++) {
      array[i] = Integer.parseInt(reader.readLine());
    }

    sort(array);

    for (int x : array) {
      System.out.println(x);
    }
  }

  public static void sort(int[] array) {
    //напишите тут ваш код
    int n = array.length;
    int temp = 0;
    for(int i=0; i < n; i++) {
      for (int j = 1; j < (n - i); j++) {
        if (array[j - 1] < array[j]) {
          temp = array[j - 1];
          array[j - 1] = array[j];
          array[j] = temp;
        }

      }
    }
  }
}
