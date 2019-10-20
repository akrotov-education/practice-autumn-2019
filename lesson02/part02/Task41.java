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
        //напишите тут ваш код
        System.out.println("Введите три числа:");
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();

        if (a==b|a==c){System.out.println(a);}
        else if (a==b|b==c){System.out.println(b);}
        else if (a>b&a<c|a<b&a>c){System.out.println(a);}
        else if (b>a&b<c|b<a&b>c){System.out.println(b);}
        else {System.out.println(c);}
    }
}
