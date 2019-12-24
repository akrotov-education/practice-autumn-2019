package lesson02.part02;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Ввести с клавиатуры три целых числа. Вывести на экран количество положительных чисел среди этих трех.
 * Примеры:
 * а) при вводе чисел
 * -4
 * 6
 * 6
 * получим вывод
 * 2
 * <p>
 * б) при вводе чисел
 * -6
 * -6
 * -3
 * получим вывод
 * 0
 * <p>
 * в) при вводе чисел
 * 0
 * 1
 * 2
 * получим вывод
 * 2
 * <p>
 * <p>
 * Требования:
 * 1.	Программа должна считывать числа c клавиатуры.
 * 2.	Программа должна выводить число на экран.
 * 3.	Программа должна выводить количество положительных чисел в исходном наборе.
 * 4.	Если положительных чисел нет, программа должна вывести "0".
 * 5.	Учти, что "0" не относится ни к положительным, ни к отрицательным числам.
 */

public class Task28 {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите число 1 ");
        int a = Integer.parseInt(reader.readLine());
        System.out.println("Введите число 2 ");
        int b = Integer.parseInt(reader.readLine());
        System.out.println("Введите число 3 ");
        int c = Integer.parseInt(reader.readLine());
        int p = 0;
        if (a > 0) {
            p++;
        }
        if (b > 0) {
            p++;
        }
        if (c > 0) {
            p++;
        }
        if (p>0){
            System.out.println(p);
        }
        else {
            System.out.println("0");
        }
    }
}
