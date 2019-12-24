package lesson02.part02;

import java.util.Scanner;

/**
 * Ввести с клавиатуры три числа, и вывести их в порядке убывания. Выведенные числа должны быть разделены пробелом.
 * <p>
 * <p>
 * Требования: 1.	Программа должна считывать числа c клавиатуры. 2.	Программа должна выводить числа на экран.
 * 3.	Программа должна выводить три числа разделенных пробелами. 4.	Программа должна выводить числа в порядке убывания.
 */

public class Task20 {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите 1 число ");
        int a = sc.nextInt();
        System.out.println("Введите 2 число ");
        int b = sc.nextInt();
        System.out.println("Введите 3 число ");
        int c = sc.nextInt();

        int max = 0, mid=0, min=0;
        if (a > b && a > c) {
            max=a;
            if (b > c) {
                mid=b;
                min=c;
            } else {
                min=b;
                mid=c;
            }
        }
        if (c > a && c > b) {
            max=c;
            if (a > b) {
                mid=a;
                min=b;
            } else {
                mid=b;
                min=a;
            }
        }
        if (b > a && b > c) {
            max=b;
            if (a > c) {
                min=c;
                mid=a;
            } else {
                mid=c;
                min=a;
            }
        }
        System.out.println(max + " " + mid + " " + min);
    }
}