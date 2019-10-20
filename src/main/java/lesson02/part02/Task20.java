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
        System.out.println("Введите три числа: ");
        Scanner str = new Scanner(System.in);
        int a = str.nextInt();
        int b = str.nextInt();
        int c = str.nextInt();
        int first = a;
        int second = a;
        int third = a;
        if (a > b & a > c) {
            first = a;
            if (b > c) {
                second = b;
                third = c;
            }
            else {
                second = c;
                third = b;
            }
        }
        if (b > a & b > c) {
            first = b;
            if (a > c) {
                second = a;
                third = c;
            }
            else {
                second = c;
                third = a;
            }
        }
        if (c > a & c > b) {
            first = c;
            if (a > b) {
                second = a;
                third = b;
            }
            else {
                second = b;
                third = a;
            }
        }
        System.out.println(first + " " + second + " " + third);
    }
}
