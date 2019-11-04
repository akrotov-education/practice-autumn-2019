package lesson04.part01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Создать массив на 20 чисел.
 * Заполнить его числами с клавиатуры.
 * Найти максимальное и минимальное числа в массиве.
 * Вывести на экран максимальное и минимальное числа через пробел.
 *
 * Требования:
 * 1.	Создай массив целых чисел (int[]) на 20 элементов.
 * 2.	Считай с клавиатуры 20 целых чисел и добавь их в массив.
 * 3.	Найди и выведи через пробел максимальное и минимальное числа.
 * 4.	Используй цикл for.
 */

public class Task17 {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    int[] nums = new int[20];
    int maximum = Integer.MIN_VALUE;
    int minimum = Integer.MAX_VALUE;
    for (int i = 0; i < 20; i++)  {
      int temp = Integer.parseInt(reader.readLine());
      nums[i] = temp;
      if (temp > maximum) maximum = temp;
      if (temp < minimum) minimum = temp;
    }
    System.out.print(maximum + " " + minimum);
  }
}
