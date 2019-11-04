package lesson04.part01;

import java.io.IOException;
import java.util.Scanner;

/**
 * 1. Создать массив на 15 целых чисел.
 * 2. Ввести в него значения с клавиатуры.
 * 3. Пускай индекс элемента массива является номером дома, а значение - число жителей, проживающих в доме.
 * Дома с нечетными номерами расположены на одной стороне улицы, с четными - на другой.
 * Выяснить, на какой стороне улицы проживает больше жителей.
 * 4. Вывести на экран сообщение: "В домах с нечетными номерами проживает больше жителей."
 * или "В домах с четными номерами проживает больше жителей."
 * <p>
 * Примечание:
 * дом с порядковым номером 0 считать четным.
 * <p>
 * Требования:
 * 1.	Программа должна создавать массив на 15 целых чисел.
 * 2.	Программа должна считывать числа для массива с клавиатуры.
 * 3.	Программа должна вывести сообщение "В домах с нечетными номерами проживает больше жителей.",
 * если сумма нечетных элементов массива больше суммы четных.
 * 4.	Программа должна вывести сообщение "В домах с четными номерами проживает больше жителей.",
 * если сумма четных элементов массива больше суммы нечетных.
 */

public class Task05 {

  public static void main(String[] args) throws IOException {
    //напишите тут ваш код
    Scanner scanner = new Scanner(System.in);
    int[] h = new int[15];
    int m1 = 0;
    int m2 = 0;
    for (int i = 0; i < 15; i++){
      h[i] = scanner.nextInt();
      if (i%2 == 1){
        m1 += h[i];
      }
      else {
        m2 += h[i];
      }
    }
    if(m1>m2){
      System.out.println("В домах с нечетными номерами проживает больше жителей.");
    }
    if(m2>m1){
      System.out.println("В домах с четными номерами проживает больше жителей.");
    }
  }
}
