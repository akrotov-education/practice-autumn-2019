package lesson02.part02;

import java.util.Scanner;

/**
 * Ввести с клавиатуры два целых числа, и вывести на экран минимальное из них. Если два числа равны между собой, необходимо вывести любое.
 * <p>
 * <p>
 * Требования:
 * 1.	Программа должна считывать числа c клавиатуры.
 * 2.	Программа должна выводить число на экран.
 * 3.	Программа должна выводить на экран минимальное из двух целых чисел.
 * 4.	Если два числа равны между собой, необходимо вывести любое.
 */

public class Task18 {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        Scanner scanner = new Scanner(System.in);

        System.out.println("First: ?");
        int first = scanner.nextInt();

        System.out.println("Second: ?");
        int second = scanner.nextInt();

        if(first > second)
            System.out.println(second);
        else if (second == first)
            System.out.println(first);
        else
            System.out.println(first);
    }
}