package lesson02.part02;

import java.util.Scanner;

/**
 * Ввести с клавиатуры четыре числа, и вывести максимальное из них. Если числа равны между собой, необходимо вывести любое.
 * <p>
 * <p>
 * Требования:
 * 1.	Программа должна считывать числа c клавиатуры.
 * 2.	Программа должна выводить число на экран.
 * 3.	Программа должна выводить на экран максимальное из четырёх чисел.
 * 4.	Если максимальных чисел несколько, необходимо вывести любое из них.
 */

public class Task19 {
    public static void main(String[] args) throws Exception {
        System.out.println("Введите четыре числа: ");
        Scanner str = new Scanner(System.in);
        int a = str.nextInt();
        int b = str.nextInt();
        int c = str.nextInt();
        int d = str.nextInt();
        int max1;
        int max2;
        int max;
        if (a > b) max1 = a;
        else max1 = b;

        if (c > d) max2 = c;
        else max2 = d;

        if (max1 > max2) max = max1;
        else max = max2;

        System.out.println("Максимальное число: " + max);
    }
}
