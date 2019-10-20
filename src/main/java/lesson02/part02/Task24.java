package lesson02.part02;
import java.util.Scanner;
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

import java.io.*;
import java.util.*;

public class Task24 {
    public static void main(String[] args) throws Exception {
        System.out.println("Введите три числа: ");
        Scanner str = new Scanner(System.in);
        int a = str.nextInt();
        int b = str.nextInt();
        int c = str.nextInt();
        if (a == b & a != c) System.out.println("3");
        if (b == c & b != a) System.out.println("1");
        if (c == a & c != b) System.out.println("2");
    }
}

