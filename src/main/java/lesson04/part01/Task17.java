package lesson04.part01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

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

    int max = 0;
    int min = 0;

    //напишите тут ваш код
    ArrayList<Integer> list = new ArrayList<Integer>();

    list.add(Integer.parseInt(reader.readLine()));
    max = list.get(0);
    min = list.get(0);

    for(int i=0;i<20;i++) {
      list.add(Integer.parseInt(reader.readLine()));
      if (max < list.get(i))
        max = list.get(i);
      if (min > list.get(i))
        min = list.get(i);
    }
    System.out.print(max + " " + min);
  }
}
