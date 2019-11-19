package lesson02.part02;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Ввести с клавиатуры три числа, и вывести их в порядке убывания. Выведенные числа должны быть разделены пробелом.
 *
 *
 * Требования:
 * 1.	Программа должна считывать числа c клавиатуры.
 * 2.	Программа должна выводить числа на экран.
 * 3.	Программа должна выводить три числа разделенных пробелами.
 * 4.	Программа должна выводить числа в порядке убывания.
*/

public class Task20 {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        Scanner scanner = new Scanner(System.in);

        Integer[] values = new Integer[3];

        for (int i = 0; i < values.length; i++) {
            System.out.println("Value: ?");
            values[i] = scanner.nextInt();
        }

        Arrays.sort(values, Collections.reverseOrder());

        for (int value : values) {
            System.out.print(value + " ");
        }
    }
}
