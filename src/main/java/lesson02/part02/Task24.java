package lesson02.part02;

/**
 * Ввести с клавиатуры три целых числа. Одно из чисел отлично от двух других, равных между собой.
 * Вывести на экран порядковый номер числа, отличного от остальных.
 * Пример для чисел 4 6 6:
 * 1
 * Пример для чисел 6 6 3:
 * 3
 * <p>
 * <p>
 * Требования:
 * 1.	Программа должна считывать числа c клавиатуры.
 * 2.	Программа должна использовать команды System.out.println() или System.out.print().
 * 3.	Программа должна выводить на экран порядковый номер числа, отличного от остальных.
 * 4.	Если все числа разные, ничего не выводить.
 */

import java.util.Scanner;

public class Task24 {
    public static void main(String[] args) throws Exception {

        Scanner input = new Scanner(System.in);
        System.out.println("Введите элементы массива");
        int array[] = new int[3];
        for (int i = 0; i < 3; i++) {
            array[i] = input.nextInt();
        }
        if (array[0] == array[1]) {
            System.out.println(3);
        } else if (array[0] == array[2]) {
            System.out.println(2);
        } else
            System.out.println(1);
    }

}