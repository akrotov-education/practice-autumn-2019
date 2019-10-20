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
        System.out.println("Введите три числа: ");
        Scanner str = new Scanner(System.in);
        int a = str.nextInt();
        int b = str.nextInt();
        int c = str.nextInt();
        int med = 0;
        if (a == b & a == c) med = a;
        else if (a == b) med = a;
        else if (b == c) med = b;
        else if (a == c) med = a;
        else {
            if (a > b & a > c) {
                if (b > c) med = b;
                else med = c;
            }
             else if (b > a & b > c){
                 if (a > c) med = a;
                 else med = c;
            }
             else if (c > a & c > b){
                 if (a > b) med = a;
                 else med = b;
            }
        }
        System.out.println(med);
    }
}
