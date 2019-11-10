package lesson04.part01;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 1. Создать массив на 10 чисел.
 * 2. Ввести с клавиатуры 10 чисел и записать их в массив.
 * 3. Вывести на экран элементы массива в обратном порядке, каждое значение выводить с новой строки.
 * <p>
 * Требования:
 * 1.	Программа должна создавать массив на 10 целых чисел.
 * 2.	Программа должна считывать числа для массива с клавиатуры.
 * 3.	Программа должна выводить 10 строчек, каждую с новой строки.
 * 4.	Массив должен быть выведен на экран в обратном порядке.
 */

public class Task04 {

  public static void main(String[] args) throws Exception {

    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    int[] arr = new int[10];

    for (int i = 0; i < 10; i++){
      arr[i] = Integer.parseInt(reader.readLine());
    }

    for (int i = 0; i < 10; i++){
      System.out.println(arr[arr.length-i-1]);
    }

  }
}
