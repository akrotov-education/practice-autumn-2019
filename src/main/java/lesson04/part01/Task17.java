package lesson04.part01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.Integer.parseInt;

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
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    int maximum = 0;
    int minimum = 0;

    //напишите тут ваш код
    int[] mas = new int[20];
    for (int i = 0; i < mas.length; i++) {
      mas[i] = parseInt(in.readLine());
      maximum = Math.max(maximum, mas[i]);
      minimum = Math.min(minimum, mas[i]);
    }

    System.out.print(maximum + " " + minimum);
  }
}
