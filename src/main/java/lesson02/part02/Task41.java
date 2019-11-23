package lesson02.part02;

import java.util.Scanner;

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
        Scanner scanner = new Scanner(System.in);
        int a,b,c;
        a=scanner.nextInt();
        b=scanner.nextInt();
        c=scanner.nextInt();
        if(a>b && a<c){
            System.out.println(a);
        }
        else if(b>a && b<c){
            System.out.println(b);
        }
        else if(c>a && c<b){
            System.out.println(c);
        }
        if (a==b && b==c && a==c) {
            System.out.println(a);
        }
        if (a==b & a!=c & b!=c){
            System.out.println(a);
        }
        if (b==c & b!=a & c!=a){
            System.out.println(b);
        }
        if (a==c & a!=b & c!=b){
            System.out.println(c);
        }
    }
}
