package lesson04.part01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

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

  public static void sort(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
        /*Предполагаем, что первый элемент (в каждом
           подмножестве элементов) является минимальным */
      int min = arr[i];
      int min_i = i;
        /*В оставшейся части подмножества ищем элемент,
           который меньше предположенного минимума*/
      for (int j = i+1; j < arr.length; j++) {
        //Если находим, запоминаем его индекс
        if (arr[j] > min) {
          min = arr[j];
          min_i = j;
        }
      }
        /*Если нашелся элемент, меньший, чем на текущей позиции,
          меняем их местами*/
      if (i != min_i) {
        int tmp = arr[i];
        arr[i] = arr[min_i];
        arr[min_i] = tmp;
      }
    }
  }
}
