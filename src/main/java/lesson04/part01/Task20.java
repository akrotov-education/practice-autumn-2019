package lesson04.part01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

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
    for(int i = 0; i < array.length; ++i){
      for(int j = 0; j < array.length; ++j){
        if (array[i] > array[j]){
          int temp = array[i];
          array[i] = array[j];
          array[j] = temp;
        }
      }
    }
  }
}
