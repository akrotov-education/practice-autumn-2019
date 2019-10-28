package lesson04.part01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

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
    Scanner scanner = new Scanner(System.in);

    int [] list = new int[20];

    for (int i = 0; i < 20; i++) {
      list[i] = scanner.nextInt();
    }
    int maximum = list[0];
    int minimum = list[0];
    for (int i = 0; i < 20; i++) {
      if (list[i] > maximum){
        maximum = list[i];
      }
    }
    for (int i = 0; i < 20; i++) {
      if (list[i] < minimum){
        minimum = list[i];
      }
    }

    System.out.print(maximum + " " + minimum);
  }
}
