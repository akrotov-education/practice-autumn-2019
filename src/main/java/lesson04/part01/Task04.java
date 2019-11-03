package lesson04.part01;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import static java.lang.Integer.parseInt;

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
    //напишите тут ваш код
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    int[] array = new int[10];
    for (int i = 0; i < array.length; i++) {
      array[i] = parseInt(in.readLine());
    }
    for (int i = array.length-1; i >= 0; i--) {
      System.out.println(array[i]);
    }
  }
}
