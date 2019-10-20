package lesson02.part02;

import java.util.Scanner;

/**
 * Ввести с клавиатуры два целых числа, и вывести на экран минимальное из них. Если два числа равны между собой, необходимо вывести любое.
 * <p>
 * <p>
 * Требования:
 * 1.	Программа должна считывать числа c клавиатуры.
 * 2.	Программа должна выводить число на экран.
 * 3.	Программа должна выводить на экран минимальное из двух целых чисел.
 * 4.	Если два числа равны между собой, необходимо вывести любое.
 */

public class Task18 {
    public static void main(String[] args) throws Exception {
        System.out.println("Введите два числа: ");
        Scanner str = new Scanner(System.in);
        int a = str.nextInt();
        int b = str.nextInt();
        if (a < b) System.out.println(a);
        else System.out.println(b);
    }
}