package lesson04.part02;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Задача: Написать программу, которая вводит с клавиатуры 20 чисел и выводит их в убывающем порядке.
 * <p>
 * Требования:
 * 1.	Программа должна считывать 20 целых чисел с клавиатуры.
 * 2.	Программа должна выводить 20 чисел.
 * 3.	В классе должен быть метод public static void sort(int[] array).
 * 4.	Метод main должен вызывать метод sort.
 * 5.	Метод sort должен сортировать переданный массив по убыванию.
 */

public class Task15 {
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
    for (int i = 0; i < array.length; i++) {
      for (int j = 0; j < array.length; j++) {
        if (array[i] > array[j]) {
          int bubble = array[j];
          array[j] = array[i];
          array[i] = bubble; }
      }
    }
  }
}