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
        else if (a==b && b==c)
            System.out.println(a);
        System.out.println(mid);
    }
}
