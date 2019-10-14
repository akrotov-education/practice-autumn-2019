package lesson02.part02;

import java.util.Scanner;

/**
 * Ввести с клавиатуры строку name.
 * Ввести с клавиатуры дату рождения (три числа): y, m, d.
 * Вывести на экран текст:
 * «Меня зовут name.
 * Я родился d.m.y»
 * <p>
 * Пример вывода:
 * Меня зовут Вася.
 * Я родился 15.2.1988
 * <p>
 * <p>
 * Требования:
 * 1.	Программа должна считывать строки c клавиатуры.
 * 2.	Программа должна выводить строки на экран.
 * 3.	Программа должна выводить текст, шаблон которого указан в задании.
 * 4.	Каждое предложение вывести с новой строки.
 */

public class Task43 {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        int y = scanner.nextInt();
        int m = scanner.nextInt();
        int d = scanner.nextInt();
        System.out.println("Меня зовут "+name+".");
        System.out.println("Я родился "+d+"."+m+"."+y);
    }
}
