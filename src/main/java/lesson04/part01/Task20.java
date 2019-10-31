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
    boolean isSorted = false;
    int buf;
    while(!isSorted) {
      isSorted = true;
      for (int i = 0; i < array.length-1; i++) {
        if(array[i] < array[i+1]){
          isSorted = false;

          buf = array[i];
          array[i] = array[i+1];
          array[i+1] = buf;
        }
      }
    }
  }
}
