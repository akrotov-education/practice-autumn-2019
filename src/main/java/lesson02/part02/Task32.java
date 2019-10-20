package lesson02.part02;

import java.util.Scanner;

/**
 * Ввести с клавиатуры строку и число N больше 0.
 * Вывести на экран строку N раз используя цикл while. Каждое значение с новой строки.
 * Пример ввода:
 * абв
 * 2
 * Пример вывода:
 * абв
 * абв
 * <p>
 * <p>
 * Требования:
 * 1.	Программа должна считывать текст c клавиатуры.
 * 2.	Программа должна выводить текст на экран.
 * 3.	Каждое значение должно быть выведено с новой строки.
 * 4.	Программа должна выводить на экран строку N раз.
 * 5.	В программе должен использоваться цикл while.
 */

public class Task32 {
    public static void main(String[] args) throws Exception {
        System.out.println("Введите текст: ");
        Scanner str1 = new Scanner(System.in);
        String str = str1.nextLine();
        System.out.println("Введите  число: ");
        Scanner str2 = new Scanner(System.in);
        int num = str2.nextInt();
        do {
            System.out.println(str);
            num--;
        } while (num > 0);
    }
}
