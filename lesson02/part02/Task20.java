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
        //напишите тут ваш код
        System.out.println("Введите три числа:");
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();
        if (b<c){
            if (a<b)
            System.out.println(c + " " + b + " " + a);
            else if (a>c)
                System.out.println(a + " " + c + " " + b);
            else
                System.out.println(c + " " + a + " " + b);}
        else {
            if (c > a)
                System.out.println(b + " " + c + " " + a);
            else if (b > a)
                System.out.println(b + " " + a + " " + c);
            else
                System.out.println(a + " " + b + " " + c);
        }
    }
}
