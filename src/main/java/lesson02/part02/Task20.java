package lesson02.part02;

import java.io.BufferedReader;
import java.io.InputStreamReader;

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
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите a: ");
        String q=reader.readLine();
        int a=Integer.parseInt(q);
        System.out.println("Введите b: ");
        String w=reader.readLine();
        int b=Integer.parseInt(w);
        System.out.println("Введите c: ");
        String e=reader.readLine();
        int c=Integer.parseInt(e);
        if(a<=b&b<=c)System.out.println(c+" "+b+" "+a);
        else if(b<=c&c<=a)System.out.println(a+" "+c+" "+b);
        else if (c<=a&a<=b)System.out.println(b+" "+a+" "+c);
        else if(c<=b&b<=a)System.out.println(a+" "+b+" "+c);
        else if (b<=a&a<=c)System.out.println(c+" "+a+" "+b);
        else if(a<=c&c<=b)System.out.println(b+" "+c+" "+a);

    }
}
