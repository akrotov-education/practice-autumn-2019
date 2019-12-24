package lesson02.part02;

import java.util.Scanner;

/**
 * Ввести с клавиатуры четыре числа, и вывести максимальное из них. Если числа равны между собой, необходимо вывести
 * любое.
 * <p>
 * <p>
 * Требования: 1.	Программа должна считывать числа c клавиатуры. 2.	Программа должна выводить число на экран.
 * 3.	Программа должна выводить на экран максимальное из четырёх чисел. 4.	Если максимальных чисел несколько, необходимо
 * вывести любое из них.
 */

public class Task19 {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите 1 число ");
        int a = sc.nextInt();
        System.out.println("Введите 2 число ");
        int b = sc.nextInt();
        System.out.println("Введите 3 число ");
        int c = sc.nextInt();
        System.out.println("Введите 4 число ");
        int d = sc.nextInt();

        if (a==b && c==d && a==c){
            System.out.println(a);
        } else if(a<b && a<c && a<d){
            System.out.println(a);
        }else if (b<a && b<c && b<d){
            System.out.println(b);
        }else if(c<a && c<b && c<d){
            System.out.println(c);
        }else {
            System.out.println(d);
        }

    }
}