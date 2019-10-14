package lesson02.part02;

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
        Scanner scanner = new Scanner(System.in);
        int n1 = scanner.nextInt();
        int n2 = scanner.nextInt();
        int n3 = scanner.nextInt();
        if (n1 <= n2 && n2 <= n3) System.out.print("\n" + n3 + " " + n2 + " " + n1);
        else if (n1 <= n3 && n3 <= n2) System.out.print("\n" + n2 + " " + n3 + " " + n1);
        else if (n2 <= n1 && n1 <= n3) System.out.print("\n" + n3 + " " + n1 + " " + n2);
        else if (n2 <= n3 && n3 <= n1) System.out.print("\n" + n1 + " " + n3 + " " + n2);
        else if (n3 <= n1 && n1 <= n2) System.out.print("\n" + n2 + " " + n1 + " " + n3);
        else if (n3 <= n2 && n2 <= n1)System.out.print("\n" + n1 + " " + n2 + " " + n3);
    }
}
