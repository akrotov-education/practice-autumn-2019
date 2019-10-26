package lesson02.part02;
import javax.swing.*;
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
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();
        int c = scan.nextInt();
        int min =  Math.min(Math.min(a, b), c);
        int max = Math.max(Math.max(a, b), c);
        int mid = 0;
        if (c<b || c<a)
            mid = Math.max(Math.min(a, b), c);
        else if (c>b || c>a)
            mid = Math.min(Math.max(a, b), c);
        else if (c>a)
            mid = Math.max(Math.min(a, c), b);
        else if (c<a)
            mid = Math.min(Math.max(a, c), b);
        System.out.println(max + " " + mid + " " + min);
    }
}
