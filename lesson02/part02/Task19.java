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
        int num1, num2, num3, num4;
        Scanner in = new Scanner(System.in);
        num1 = in.nextInt();
        num2 = in.nextInt();
        num3 = in.nextInt();
        num4 = in.nextInt();

        int res = min(min(num1, num2), min(num3, num4));
        System.out.println(res);
    }
    public static int min (int a, int b) {
        return ((a<=b)? a:b);
    }
}
