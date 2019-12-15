package lesson02.part02;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Ввести с клавиатуры три числа, вывести на экран среднее из них. Т.е. не самое большое и не самое маленькое.
 * Если все числа равны, вывести любое из них.
 * <p>
 * <p>
 * Требования:
 * 1.	Программа должна считывать числа c клавиатуры.
 * 2.	Программа должна выводить число на экран.
 * 3.	Программа должна выводить среднее из трех чисел.
 * 4.	Если все числа равны, вывести любое из них.
 * 5.	Если два числа из трех равны, вывести любое из двух.
 */

public class Task41 {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите число");
        String s = reader.readLine();
        int a = Integer.parseInt(s);
        System.out.println("Введите число");
        String d = reader.readLine();
        int b= Integer.parseInt(d);
        System.out.println("Введите число");
        String g = reader.readLine();
        int c = Integer.parseInt(g);
        if((b<=a&a<c||b<a&a<=c)||(c<=a&a<=b||c<a&a<=b)){
            System.out.println(a);
        }
        else  if ((a<=b&b<c||a<b&b<=c)||(c<=b&b<a||c<b&b<=a)){
            System.out.println(b);
        }
        else  if ((a<=c&c<b||a<c&c<=b)||(b<=c&c<a||b<c&c<=a)){
            System.out.println(c);
        }
        if(a==b&b==c)
        {
            System.out.println(b);
        }

    }

}
