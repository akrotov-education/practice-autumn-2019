package lesson02.part02;

import java.io.BufferedReader;
import java.io.InputStreamReader;

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
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите a: ");
        String a=reader.readLine();
        int b=Integer.parseInt(a);
        System.out.println("Введите b: ");
        String c=reader.readLine();
        int d=Integer.parseInt(c);
        System.out.println("Введите c: ");
        String e=reader.readLine();
        int f=Integer.parseInt(e);
        System.out.println("Введите d: ");
        String g=reader.readLine();
        int h= Integer.parseInt(g);
        if(b>d&b>f&b>h)System.out.println(b);
        else if (d>b&d>f&d>h)System.out.println(d);
        else if (f>b&f>d&f>h)System.out.println(f);
        else if (h>b&h>d&h>f)System.out.println(h);

    }
}
